package app.twentyhours.animalsound.model;

import java.util.List;

public class Scene {
    private final int backgroundId;
    private final List<Animal> animals;
    private final AnimalType animalType;

    public Scene(int backgroundId, List<Animal> animals, AnimalType animalType) {
        this.backgroundId = backgroundId;
        this.animals = animals;
        this.animalType = animalType;
    }

    public Scene(AnimalType animalType) {
        this.animalType = animalType;
        this.backgroundId = Animal.getBackgroundByType(animalType);
        this.animals = Animal.getAnimalsByType(animalType);
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public static final List<Scene> SCENES = Animal.getAnimalTypes().stream().map(Scene::new).toList();
}
