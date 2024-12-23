package app.twentyhours.animalsound.model;

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
