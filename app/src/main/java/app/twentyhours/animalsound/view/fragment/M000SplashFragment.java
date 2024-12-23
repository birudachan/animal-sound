package app.twentyhours.animalsound.view.fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import app.twentyhours.animalsound.R;
import app.twentyhours.animalsound.databinding.FragmentM000SplashBinding;

public class M000SplashFragment extends BaseFragment<FragmentM000SplashBinding> {
    public static final String TAG = M000SplashFragment.class.getName();

    @Override
    protected FragmentM000SplashBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentM000SplashBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        // Hide status bar
        requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set animation
        binding.flLogo.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
        binding.tvAppName.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));

        new Handler().postDelayed(this::goToMainScreen, 2500);
    }

    private void goToMainScreen() {
        callback.showFragment(M001MainFragment.TAG, null, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
