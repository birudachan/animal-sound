package app.twentyhours.animalsound.view.fragment;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

import app.twentyhours.animalsound.databinding.FragmentM002DetailBinding;
import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.util.Event;
import app.twentyhours.animalsound.util.Util;
import app.twentyhours.animalsound.viewmodel.M002DetailViewModel;

public class M002DetailFragment extends BaseFragment<FragmentM002DetailBinding> {

    public static final String TAG = M002DetailFragment.class.getName();
    private M002DetailViewModel viewModel;
    private TextToSpeech tts;

    @Override
    protected FragmentM002DetailBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM002DetailBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.UK);
            }
        });

        viewModel = new ViewModelProvider(this).get(M002DetailViewModel.class);
        viewModel.setAnimal((Animal) mData);

        binding.setDetailViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getAnimal().observe(getViewLifecycleOwner(), this::onChangeAnimal);
        viewModel.getNavigateEvent().observe(getViewLifecycleOwner(), this::navigateTo);
        viewModel.getActionEvent().observe(getViewLifecycleOwner(), this::onAction);
    }

    @SuppressWarnings("ConstantConditions")  // Because animal won't be null
    private void onAction(Event<M002DetailViewModel.Action> actionEvent) {
        M002DetailViewModel.Action action = actionEvent.getContentIfNotHandled();
        if (action != null) {
            switch (action) {
                case PLAY:
                    Util.playSound(context, viewModel.getAnimal().getValue().getSoundId());
                    break;
                case SEARCH:
                    Util.searchImage(context, viewModel.getAnimal().getValue().getName());
                    break;
            }
        }
    }

    private void navigateTo(Event<String> event) {
        String destination = event.getContentIfNotHandled();
        if (destination != null && destination.equals(M001MainFragment.TAG)) {
            requireActivity().onBackPressed(); // TODO: Replace this deprecated method
        }
    }

    private void onChangeAnimal(Animal animal) {
        Log.d(TAG, "onChangeAnimal: " + animal.getName());
        tts.speak(animal.getName(), TextToSpeech.QUEUE_FLUSH, null, null); // TODO: Check why it doesn't speak the first time enter this fragment
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
