package app.twentyhours.animalsound.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.model.AnimalType;
import app.twentyhours.animalsound.model.Scene;

public class M001MainViewModel extends ViewModel {
    private final MutableLiveData<Scene> scene = new MutableLiveData<>(new Scene(Animal.getAnimalTypes().get(0)));

    public LiveData<Scene> getScene() {
        return scene;
    }

    public void nextScene() {
        List<AnimalType> types = Animal.getAnimalTypes();
        int index = types.indexOf(scene.getValue().getAnimalType());
        if (index == types.size() - 1) {
            scene.setValue(new Scene(types.get(0)));
        } else {
            scene.setValue(new Scene(types.get(index + 1)));
        }
    }

    public void previousScene() {
        List<AnimalType> types = Animal.getAnimalTypes();
        int index = types.indexOf(scene.getValue().getAnimalType());
        if (index == 0) {
            scene.setValue(new Scene(types.get(types.size() - 1)));
        } else {
            scene.setValue(new Scene(types.get(index - 1)));
        }
    }

    public List<Animal> getListAnimalsByType(AnimalType animalType) {
        return Animal.getAnimalsByType(animalType);
    }
}
