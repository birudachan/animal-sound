package app.twentyhours.animalsound.java.model;

import java.util.List;

import app.twentyhours.animalsound.R;

public class Animal {
    private final int photoId;
    private final String name;

    public Animal(int photoId, String name) {
        this.photoId = photoId;
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public static final List<Animal> ANIMALS = List.of(
            new Animal(R.drawable.ic_elephant, "Elephant"),
            new Animal(R.drawable.ic_zebra, "Zebra"),
            new Animal(R.drawable.ic_lion, "Lion"),
            new Animal(R.drawable.ic_hippo, "Hippo"),
            new Animal(R.drawable.ic_camel, "Camel"),
            new Animal(R.drawable.ic_rhino, "Rhino"),
            new Animal(R.drawable.ic_tiger, "Tiger"),
            new Animal(R.drawable.ic_crocodile, "Crocodile"),
            new Animal(R.drawable.ic_dolphin, "Dolphin")
    );
}
