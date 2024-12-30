package app.twentyhours.animalsound.model;

import java.util.List;

import app.twentyhours.animalsound.R;

public class Animal {
    private final int photoId;
    private final int soundId;
    private final String name;

    public Animal(int photoId, int soundId, String name) {
        this.photoId = photoId;
        this.soundId = soundId;
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public int getSoundId() {
        return soundId;
    }

    public Animal getNext() {
        int index = ANIMALS.indexOf(this);
        if (index == ANIMALS.size() - 1) {
            return ANIMALS.get(0);
        }
        return ANIMALS.get(index + 1);
    }

    public Animal getPrevious() {
        int index = ANIMALS.indexOf(this);
        if (index == 0) {
            return ANIMALS.get(ANIMALS.size() - 1);
        }
        return ANIMALS.get(index - 1);
    }

    public static final List<Animal> ANIMALS = List.of(
            new Animal(R.drawable.ic_elephant, R.raw.elephant, "Elephant"),
            new Animal(R.drawable.ic_zebra, R.raw.zebra, "Zebra"),
            new Animal(R.drawable.ic_lion, R.raw.lion, "Lion"),
            new Animal(R.drawable.ic_hippo, R.raw.hippo, "Hippo"),
            new Animal(R.drawable.ic_camel, R.raw.camel, "Camel"),
            new Animal(R.drawable.ic_rhino, R.raw.rhino, "Rhino"),
            new Animal(R.drawable.ic_tiger, R.raw.tiger, "Tiger"),
            new Animal(R.drawable.ic_crocodile, R.raw.crocodile, "Crocodile"),
            new Animal(R.drawable.ic_dolphin, R.raw.dolphin, "Dolphin")
    );
}
