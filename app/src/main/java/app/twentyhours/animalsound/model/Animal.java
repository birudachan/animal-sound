package app.twentyhours.animalsound.model;

import java.util.List;
import java.util.Map;

import app.twentyhours.animalsound.R;

public class Animal {
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

    public static Integer getBackgroundByType(AnimalType type) {
        return BACKGROUND_BY_TYPE.get(type);
    }

    public static List<AnimalType> getAnimalTypes() {
        return List.of(AnimalType.values());
    }

    private static final List<Animal> SAVANNAH_ANIMALS = List.of(
            new Animal(R.drawable.ic_elephant, R.raw.elephant, "Elephant", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_zebra, R.raw.zebra, "Zebra", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_lion, R.raw.lion, "Lion", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_hippo, R.raw.hippo, "Hippo", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_camel, R.raw.camel, "Camel", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_rhino, R.raw.rhino, "Rhino", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_tiger, R.raw.tiger, "Tiger", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_crocodile, R.raw.crocodile, "Crocodile", AnimalType.SAVANNAH),
            new Animal(R.drawable.ic_dolphin, R.raw.dolphin, "Dolphin", AnimalType.SAVANNAH)
    );

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

    private static final List<Animal> FARM2_ANIMALS = List.of(
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

    private static final List<Animal> FOREST_ANIMALS = List.of(
            new Animal(R.drawable.ic_squirrel, R.raw.squirrel, "Squirrel", AnimalType.FOREST),
            new Animal(R.drawable.ic_gorilla, R.raw.gorilla, "Gorilla", AnimalType.FOREST),
            new Animal(R.drawable.ic_koala, R.raw.koala, "Koala", AnimalType.FOREST),
            new Animal(R.drawable.ic_snake, R.raw.snake, "Snake", AnimalType.FOREST),
            new Animal(R.drawable.ic_bear, R.raw.bear, "Bear", AnimalType.FOREST),
            new Animal(R.drawable.ic_elk, R.raw.elk, "Elk", AnimalType.FOREST),
            new Animal(R.drawable.ic_monkey, R.raw.monkey, "Monkey", AnimalType.FOREST),
            new Animal(R.drawable.ic_raccoon, R.raw.raccoon, "Raccoon", AnimalType.FOREST),
            new Animal(R.drawable.ic_panda, R.raw.panda, "Panda", AnimalType.FOREST)
    );

    private static final Map<AnimalType, List<Animal>> ANIMALS_BY_TYPE = Map.of(
            AnimalType.SAVANNAH, SAVANNAH_ANIMALS,
            AnimalType.FARM, FARM_ANIMALS,
            AnimalType.FARM2, FARM2_ANIMALS,
            AnimalType.FOREST, FOREST_ANIMALS
    );

    private static final Map<AnimalType, Integer> BACKGROUND_BY_TYPE = Map.of(
            AnimalType.SAVANNAH, R.drawable.bg_savanna,
            AnimalType.FARM, R.drawable.bg_farm,
            AnimalType.FARM2, R.drawable.bg_farm_2,
            AnimalType.FOREST, R.drawable.bg_forest
    );
}
