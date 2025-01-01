package app.twentyhours.animalsound.view.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;

import app.twentyhours.animalsound.databinding.FragmentM001MainBinding;
import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.view.adapter.MainGridAdapter;

public class M001MainFragment
        extends BaseFragment<FragmentM001MainBinding>
        implements OnMainFragmentItemClickListener {

    public static final String TAG = M001MainFragment.class.getName();

    @Override
    protected FragmentM001MainBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM001MainBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        final MainGridAdapter adapter =
                new MainGridAdapter(Animal.ANIMALS_BY_TYPE.get(Animal.AnimalType.SAVANNA));
        adapter.setOnClickListener(this);
        binding.rvAnimals.setAdapter(adapter);
        binding.rvAnimals.setLayoutManager(new GridLayoutManager(context, 3));
    }

    @Override
    public void onClick(Animal animal) {
        Log.i(TAG, "onClick: " + animal.getName());
        callback.showFragment(M002DetailFragment.TAG, animal, true);
    }
}
