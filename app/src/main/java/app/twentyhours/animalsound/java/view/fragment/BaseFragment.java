package app.twentyhours.animalsound.java.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import app.twentyhours.animalsound.java.view.OnMainCallback;

public abstract class BaseFragment<T extends ViewBinding> extends Fragment {
    protected Context context;
    protected T binding;
    protected OnMainCallback callback;
    protected Object mData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = getViewBinding(inflater, container);
        initViews();
        return binding.getRoot();
    }

    public final void setCallback(OnMainCallback callback) {
        this.callback = callback;
    }

    public final void setData(Object data) {
        mData = data;
    }

    protected abstract T getViewBinding(LayoutInflater inflater, ViewGroup container);

    protected abstract void initViews();
}
