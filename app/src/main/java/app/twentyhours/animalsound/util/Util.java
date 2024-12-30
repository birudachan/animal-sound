package app.twentyhours.animalsound.util;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class Util {
    public static final String TAG = Util.class.getName();

    private Util() {}

    public static void playSound(Context context, int soundId) {
        MediaPlayer player = MediaPlayer.create(context, soundId);
        player.start();
    }

    public static void searchImage(Context context, String name) {
        String word;
        try {
            word = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "searchImage: ", e);
            return;
        }
        String url = "https://www.google.com/search?q=" + word + "&tbm=isch";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }
}
