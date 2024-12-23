package app.twentyhours.animalsound.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.twentyhours.animalsound.R;
import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.view.fragment.OnMainFragmentItemClickListener;

public class MainGridAdapter extends RecyclerView.Adapter<MainGridAdapter.MyViewHolder> {
    private static final String TAG = MainGridAdapter.class.getName();

    private final List<Animal> animals;
    private OnMainFragmentItemClickListener listener;

    public MainGridAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    public void setOnClickListener(OnMainFragmentItemClickListener listener) {
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final CardView cardView;
        private final OnMainFragmentItemClickListener listener;

        public MyViewHolder(@NonNull View itemView, OnMainFragmentItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_animal);
            cardView = itemView.findViewById(R.id.cv_animal);
            this.listener = listener;
        }

        public void bind(Animal animal) {
            imageView.setBackgroundResource(animal.getPhotoId());
            cardView.setOnClickListener(v -> {
                if (listener == null) {
                    Log.d(TAG, "bind: Item clicked but no listener attached");
                    return;
                }
                listener.onClick(animal);
            });
        }
    }

    @NonNull
    @Override
    public MainGridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemAnimalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new MyViewHolder(itemAnimalView, listener);
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
