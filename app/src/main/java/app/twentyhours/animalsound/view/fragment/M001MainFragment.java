package app.twentyhours.animalsound.view.fragment;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import app.twentyhours.animalsound.databinding.FragmentM001MainBinding;
import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.view.adapter.MainGridAdapter;
import app.twentyhours.animalsound.viewmodel.M001MainViewModel;

public class M001MainFragment extends BaseFragment<FragmentM001MainBinding>
        implements OnMainFragmentItemClickListener {

    public static final String TAG = M001MainFragment.class.getName();

    private MainGridAdapter adapter;
    private M001MainViewModel viewModel;

    @Override
    protected FragmentM001MainBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM001MainBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        viewModel = new ViewModelProvider(this).get(M001MainViewModel.class);
        binding.setMainViewModel(viewModel);
        binding.setLifecycleOwner(this);

        adapter = new MainGridAdapter();
        adapter.setOnClickListener(this);
        binding.rvAnimals.setAdapter(adapter);
        binding.rvAnimals.setLayoutManager(new GridLayoutManager(context, 3));

        viewModel.getAnimalType().observe(getViewLifecycleOwner(), this::onChangeAnimalType);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void onChangeAnimalType(Animal.AnimalType animalType) {
        adapter.setAnimals(viewModel.getListAnimalsByType(animalType));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(Animal animal) {
        Log.i(TAG, "onClick: " + animal.getName());
        callback.showFragment(M002DetailFragment.TAG, animal, true);
    }
}
