package app.twentyhours.animalsound.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import app.twentyhours.animalsound.model.Animal;

public class M001MainViewModel extends ViewModel {
    private final MutableLiveData<Animal.AnimalType> animalType =
            new MutableLiveData<>(Animal.getAnimalTypes().get(0));

    public LiveData<Animal.AnimalType> getAnimalType() {
        return animalType;
    }

    public void nextAnimalType() {
        List<Animal.AnimalType> types = Animal.getAnimalTypes();
        int index = types.indexOf(animalType.getValue());
        if (index == types.size() - 1) {
            animalType.setValue(types.get(0));
        } else {
            animalType.setValue(types.get(index + 1));
        }
    }

    public void previousAnimalType() {
        List<Animal.AnimalType> types = Animal.getAnimalTypes();
        int index = types.indexOf(animalType.getValue());
        if (index == 0) {
            animalType.setValue(types.get(types.size() - 1));
        } else {
            animalType.setValue(types.get(index - 1));
        }
    }

    public List<Animal> getListAnimalsByType(Animal.AnimalType animalType) {
        return Animal.getAnimalsByType(animalType);
    }
}
