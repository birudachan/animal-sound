package app.twentyhours.animalsound.java.view;

public interface OnMainCallback {
    void showFragment(String tag, Object data, boolean addToBackStack);
    void backToPreviousFragment();
}
