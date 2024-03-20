package com.example.historyproj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.historyproj.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> people;

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

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView placeTextView;
        private TextView infoTextView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.postNameTextView);
            placeTextView = itemView.findViewById(R.id.postPlaceTextView);
            infoTextView = itemView.findViewById(R.id.postInfoTextView);
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

            nameTextView.setText(name);
            placeTextView.setText(birthPlace);
            infoTextView.setText("Other Names: " + otherNames + "\n" +
                    "Code Names: " + codeNames + "\n" +
                    "Birth Date: " + birthDate + "\n" +
                    "Death Date: " + deathDate + "\n" +
                    "Burial Place: " + burialPlace + "\n" +
                    "Description: " + description + "\n" +
                    "Sources: " + sources);
        }

        // Metoda pomocnicza do usuwania znaków "[" i "]" z tekstu
        private String removeBrackets(String text) {
            if (text != null && text.startsWith("[") && text.endsWith("]")) {
                return text.substring(1, text.length() - 1);
            }
            return text;
        }
    }
}
