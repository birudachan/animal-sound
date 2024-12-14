package app.twentyhours.animalsound.java.view.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.twentyhours.animalsound.databinding.FragmentM001MainBinding;
import app.twentyhours.animalsound.java.model.Animal;
import app.twentyhours.animalsound.java.view.adapter.MainGridAdapter;

public class M001MainFragment extends BaseFragment<FragmentM001MainBinding> {
    public static final String TAG = M001MainFragment.class.getName();

    @Override
    protected FragmentM001MainBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM001MainBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        RecyclerView rvAnimals = binding.rvAnimals;
        rvAnimals.setLayoutManager(new GridLayoutManager(context, 3));
        MainGridAdapter gridAdapter = new MainGridAdapter(Animal.ANIMALS);
        rvAnimals.setAdapter(gridAdapter);
    }
}
