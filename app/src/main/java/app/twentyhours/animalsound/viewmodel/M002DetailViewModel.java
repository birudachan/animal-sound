package app.twentyhours.animalsound.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import app.twentyhours.animalsound.model.Animal;
import app.twentyhours.animalsound.util.Event;
import app.twentyhours.animalsound.view.fragment.M001MainFragment;

public class M002DetailViewModel extends ViewModel {
    private final MutableLiveData<Animal> animal = new MutableLiveData<>();
    private final MutableLiveData<Event<String>> navigateEvent = new MutableLiveData<>();
    private final MutableLiveData<Event<Action>> actionEvent = new MutableLiveData<>();

    public enum Action {
        PLAY, SEARCH
    }

    public LiveData<Animal> getAnimal() {
        return animal;
    }

    public LiveData<Event<String>> getNavigateEvent() {
        return navigateEvent;
    }

    public LiveData<Event<Action>> getActionEvent() {
        return actionEvent;
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

    public void navigateToMainFragment() {
        navigateEvent.setValue(new Event<>(M001MainFragment.TAG));
    }

    public void playSound() {
        actionEvent.setValue(new Event<>(Action.PLAY));
    }

    public void searchAnimal() {
        actionEvent.setValue(new Event<>(Action.SEARCH));
    }
}
