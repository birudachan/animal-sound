package app.twentyhours.animalsound.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import app.twentyhours.animalsound.model.Animal;

public class M002DetailViewModel extends ViewModel {
    private final MutableLiveData<Animal> animal = new MutableLiveData<>();

    public LiveData<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal.setValue(animal);
    }

    public void nextAnimal() {
        if (animal.getValue() != null) {
            animal.setValue(animal.getValue().getNext());
        }
    }

    public void previousAnimal() {
        if (animal.getValue() != null) {
            animal.setValue(animal.getValue().getPrevious());
        }
    }
}
