package app.twentyhours.animalsound.java.view.fragment;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.Locale;

import app.twentyhours.animalsound.databinding.FragmentM001MainBinding;
import app.twentyhours.animalsound.java.model.Animal;
import app.twentyhours.animalsound.java.view.adapter.MainGridAdapter;

public class M001MainFragment
        extends BaseFragment<FragmentM001MainBinding>
        implements OnMainFragmentItemClickListener {

    public static final String TAG = M001MainFragment.class.getName();

    private TextToSpeech tts;

    @Override
    protected FragmentM001MainBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM001MainBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        final MainGridAdapter adapter = new MainGridAdapter(Animal.ANIMALS);
        adapter.setOnClickListener(this);
        binding.rvAnimals.setAdapter(adapter);
        binding.rvAnimals.setLayoutManager(new GridLayoutManager(context, 3));

        tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.UK);
            }
        });
    }

    @Override
    public void onClick(Animal animal) {
        Log.i(TAG, "onClick: " + animal.getName());
        tts.speak(animal.getName(), TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (tts != null) {
            tts.stop();
        }
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
