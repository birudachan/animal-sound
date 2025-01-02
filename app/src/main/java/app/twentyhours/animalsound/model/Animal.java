package app.twentyhours.animalsound.model;

import java.util.List;
import java.util.Map;

import app.twentyhours.animalsound.R;

public class Animal {
    public enum AnimalType {
        SAVANNA, FOREST, FARM
    }

    private final int photoId;
    private final int soundId;
    private final String name;
    private final AnimalType type;

    public Animal(int photoId, int soundId, String name, AnimalType type) {
        this.photoId = photoId;
        this.soundId = soundId;
        this.name = name;
        this.type = type;
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

    public AnimalType getType() {
        return type;
    }

    public Animal getNext() {
        List<Animal> currentList = getAnimalsByType(type);
        int index = currentList.indexOf(this);
        if (index == currentList.size() - 1) {
            return currentList.get(0);
        }
        return currentList.get(index + 1);
    }

    public Animal getPrevious() {
        List<Animal> currentList = getAnimalsByType(type);
        int index = currentList.indexOf(this);
        if (index == 0) {
            return currentList.get(currentList.size() - 1);
        }
        return currentList.get(index - 1);
    }

    public static List<Animal> getAnimalsByType(AnimalType type) {
        return ANIMALS_BY_TYPE.get(type);
    }

    public static List<AnimalType> getAnimalTypes() {
        return List.of(AnimalType.values());
    }

    private static final List<Animal> FARM_ANIMALS = List.of(
            new Animal(R.drawable.ic_duck, R.raw.duck, "Duck", AnimalType.FARM),
            new Animal(R.drawable.ic_dog, R.raw.dog, "Dog", AnimalType.FARM),
            new Animal(R.drawable.ic_hen, R.raw.hen, "Hen", AnimalType.FARM),
            new Animal(R.drawable.ic_cat, R.raw.cat, "Cat", AnimalType.FARM),
            new Animal(R.drawable.ic_cow, R.raw.cow, "Cow", AnimalType.FARM),
            new Animal(R.drawable.ic_horse, R.raw.horse, "Horse", AnimalType.FARM),
            new Animal(R.drawable.ic_sheep, R.raw.sheep, "Sheep", AnimalType.FARM),
            new Animal(R.drawable.ic_mouse, R.raw.mouse, "Mouse", AnimalType.FARM),
            new Animal(R.drawable.ic_pig, R.raw.pig, "Pig", AnimalType.FARM)
    );

    private static final List<Animal> SAVANNA_ANIMALS = List.of(
            new Animal(R.drawable.ic_elephant, R.raw.elephant, "Elephant", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_zebra, R.raw.zebra, "Zebra", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_lion, R.raw.lion, "Lion", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_hippo, R.raw.hippo, "Hippo", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_camel, R.raw.camel, "Camel", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_rhino, R.raw.rhino, "Rhino", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_tiger, R.raw.tiger, "Tiger", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_crocodile, R.raw.crocodile, "Crocodile", AnimalType.SAVANNA),
            new Animal(R.drawable.ic_dolphin, R.raw.dolphin, "Dolphin", AnimalType.SAVANNA)
    );

    private static final List<Animal> FOREST_ANIMALS = List.of(
            new Animal(R.drawable.ic_chick, R.raw.chick, "Chick", AnimalType.FOREST),
            new Animal(R.drawable.ic_bird, R.raw.bird, "Bird", AnimalType.FOREST),
            new Animal(R.drawable.ic_frog, R.raw.frog, "Frog", AnimalType.FOREST),
            new Animal(R.drawable.ic_goose, R.raw.goose, "Goose", AnimalType.FOREST),
            new Animal(R.drawable.ic_rabbit, R.raw.rabbit, "Rabbit", AnimalType.FOREST),
            new Animal(R.drawable.ic_woodpecker, R.raw.woodpecker, "Woodpecker", AnimalType.FOREST),
            new Animal(R.drawable.ic_bee, R.raw.bee, "Bee", AnimalType.FOREST),
            new Animal(R.drawable.ic_peacock, R.raw.peacock, "Peacock", AnimalType.FOREST),
            new Animal(R.drawable.ic_owl, R.raw.owl, "Owl", AnimalType.FOREST)
    );

    private static final Map<AnimalType, List<Animal>> ANIMALS_BY_TYPE = Map.of(
            AnimalType.FARM, FARM_ANIMALS,
            AnimalType.SAVANNA, SAVANNA_ANIMALS,
            AnimalType.FOREST, FOREST_ANIMALS
    );
}
