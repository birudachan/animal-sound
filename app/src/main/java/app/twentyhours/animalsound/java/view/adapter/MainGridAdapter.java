package app.twentyhours.animalsound.java.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.twentyhours.animalsound.R;
import app.twentyhours.animalsound.java.model.Animal;

public class MainGridAdapter extends RecyclerView.Adapter<MainGridAdapter.MyViewHolder> {
    private final List<Animal> animals;

    public MainGridAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_animal);
        }

        public void bind(Animal animal) {
            imageView.setBackgroundResource(animal.getPhotoId());
        }
    }

    @NonNull
    @Override
    public MainGridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemAnimalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new MyViewHolder(itemAnimalView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainGridAdapter.MyViewHolder holder, int position) {
        Animal animal = getItem(position);
        holder.bind(animal);
    }

    private Animal getItem(int position) {
        return animals.get(position);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
