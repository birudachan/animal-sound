package app.twentyhours.animalsound.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Constructor;

import app.twentyhours.animalsound.R;
import app.twentyhours.animalsound.view.fragment.BaseFragment;
import app.twentyhours.animalsound.view.fragment.M000SplashFragment;

public class MainActivity extends AppCompatActivity implements OnMainCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
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
            transaction.replace(R.id.nav_host_fragment, fragment, tag);
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
