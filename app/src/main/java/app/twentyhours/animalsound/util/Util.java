package app.twentyhours.animalsound.util;

import android.content.Context;
import android.media.MediaPlayer;

public final class Util {
    public static final String TAG = Util.class.getName();

    private Util() {}

    public static void playSound(Context context, int soundId) {
        MediaPlayer player = MediaPlayer.create(context, soundId);
        player.start();
    }
}
