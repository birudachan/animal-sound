package app.twentyhours.animalsound.view.fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

import app.twentyhours.animalsound.databinding.FragmentM002DetailBinding;
import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.viewmodel.M002DetailViewModel;

public class M002DetailFragment
        extends BaseFragment<FragmentM002DetailBinding> {

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
        viewModel.getAnimal().observe(getViewLifecycleOwner(), this::onChangeAnimal);

        binding.setDetailViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    private void onChangeAnimal(Animal animal) {
        tts.speak(animal.getName(), TextToSpeech.QUEUE_FLUSH, null, null); // TODO: Ask Mr. Thanh why tts doesn't speak the first time enter this fragment
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
