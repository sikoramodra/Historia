package com.example.historyproj;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<DbHelper.Post> postList;

    public PostAdapter(List<DbHelper.Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        DbHelper.Post post = postList.get(position);
        Log.d("PostAdapter", "Name: " + post.getName());

        // Zaktualizuj pola w holderze na podstawie informacji z posta
        holder.postNameTextView.setText("Name: " + post.getName());
        holder.postPlaceTextView.setText("Place: " + post.getPlace());
        holder.postInfoTextView.setText("Info: " + post.getInfo());

        // Dodaj onClickListener do przycisku edycji
        holder.editPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Przekazanie informacji o poście do EditPostActivity
                Intent editIntent = new Intent(view.getContext(), EditPostActivity.class);
                editIntent.putExtra("POST_ID", post.getId());
                editIntent.putExtra("POST_NAME", post.getName());
                editIntent.putExtra("POST_PLACE", post.getPlace());
                editIntent.putExtra("POST_INFO", post.getInfo());
                view.getContext().startActivity(editIntent);
            }
        });

        // Dodaj onClickListener do przycisku usuwania
        holder.deletePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Usunięcie postu z bazy danych
                DbHelper dbHelper = new DbHelper(view.getContext());
                dbHelper.deletePost(post.getId());

                // Zaktualizuj widok RecyclerView
                postList.remove(post);
                notifyDataSetChanged();

                // Możesz również wyświetlić komunikat potwierdzający usunięcie
                Toast.makeText(view.getContext(), "Post deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView postNameTextView;
        public TextView postPlaceTextView;
        public TextView postInfoTextView;
        public Button editPostButton;  // Deklaracja przycisku edycji
        public Button deletePostButton;  // Deklaracja przycisku usuwania

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postNameTextView = itemView.findViewById(R.id.postNameTextView);
            postPlaceTextView = itemView.findViewById(R.id.postPlaceTextView);
            postInfoTextView = itemView.findViewById(R.id.postInfoTextView);
            editPostButton = itemView.findViewById(R.id.edit_post);  // Inicjalizacja przycisku edycji
            deletePostButton = itemView.findViewById(R.id.delete_post);  // Inicjalizacja przycisku usuwania
        }
    }
}
