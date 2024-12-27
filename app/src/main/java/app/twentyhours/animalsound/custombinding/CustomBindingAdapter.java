package app.twentyhours.animalsound.custombinding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class CustomBindingAdapter {
    @BindingAdapter("imageSrc")
    public static void setImageSrc(ImageView view, Integer resourceId) {
        if (resourceId != null) {
            view.setImageResource(resourceId);
        }
    }
}
