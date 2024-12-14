package app.twentyhours.animalsound.java.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Constructor;

import app.twentyhours.animalsound.databinding.ActivityMainBinding;
import app.twentyhours.animalsound.java.view.OnMainCallback;
import app.twentyhours.animalsound.java.view.fragment.BaseFragment;
import app.twentyhours.animalsound.java.view.fragment.M000SplashFragment;

public class MainActivity extends AppCompatActivity implements OnMainCallback {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        showFragment(M000SplashFragment.TAG, null, false);
    }

    @Override
    public void showFragment(String tag, Object data, boolean addToBackStack) {
        try {
            Class<?> clazz = Class.forName(tag);
            Constructor<?> constructor = clazz.getConstructor();
            BaseFragment<?> fragment = (BaseFragment<?>) constructor.newInstance();
            fragment.setData(data);
            fragment.setCallback(this);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (addToBackStack) {
                transaction.addToBackStack(null);
            }
            transaction.replace(binding.main.getId(), fragment, tag);
            transaction.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void backToPreviousFragment() {
        onBackPressed();
    }
}
