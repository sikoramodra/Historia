package com.example.historyproj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private static List<Person> people;

    public PersonAdapter(List<Person> people) {
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = people.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView postothernames;
        private TextView postcodenames;
        private ImageButton deleteButton;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.postNameTextView);
            postothernames = itemView.findViewById(R.id.postOtherNamesTextView);
            postcodenames = itemView.findViewById(R.id.postCodeNamesTextView);
            deleteButton = itemView.findViewById(R.id.delete_post);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Get the person object at this position
                        Person person = people.get(position);
                        // Call a method to delete this person from the database
                        showDeleteConfirmationDialog(person.getId(), person.getName(), position);
                    }
                }
            });
        }

        public void bind(Person person) {
            // Usuń znaki "[" i "]" z każdego pola tekstowego
            String name = removeBrackets(person.getName());
            String birthPlace = removeBrackets(person.getBirthPlace());
            String otherNames = removeBrackets(person.getOtherNames().toString());
            String codeNames = removeBrackets(person.getCodeNames().toString());
            String birthDate = removeBrackets(person.getBirthDate());
            String deathDate = removeBrackets(person.getDeathDate());
            String burialPlace = removeBrackets(person.getBurialPlace());
            String description = removeBrackets(person.getDescription());
            String sources = removeBrackets(person.getSources());

            nameTextView.setText("Name: " + name.toString());
            postothernames.setText("Other Names: " + otherNames);
            postcodenames.setText("Code Names: " + codeNames);
        }

        // Metoda pomocnicza do usuwania znaków "[" i "]" z tekstu
        private String removeBrackets(String text) {
            if (text != null && text.startsWith("[") && text.endsWith("]")) {
                return text.substring(1, text.length() - 1);
            }
            return text;
        }

        private void deletePerson(int personId, final int position) {
            // Assuming you have a Retrofit API service method to delete a person
            ApiService apiService = ApiClient.getClient().create(ApiService.class);
            Call<Void> call = apiService.deletePerson(personId);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        // Remove the person from the RecyclerView
                        people.remove(position);
                        notifyItemRemoved(position);
                    } else {
                        // Handle unsuccessful response
                        Toast.makeText(itemView.getContext(), "Failed to delete person", Toast.LENGTH_SHORT).show();
                    }
                }


                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    // Handle failure
                    Toast.makeText(itemView.getContext(), "Failed to delete person: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        private void showDeleteConfirmationDialog(final int personId, final String personName, final int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            SpannableString spannableString = new SpannableString("Do you really want to delete " + personName + "?");
            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setMessage(spannableString)

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // User confirmed deletion, proceed with deletion
                            deletePerson(personId, position);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // User canceled deletion, do nothing
                        }
                    })
                    .show();
        }
    }
}