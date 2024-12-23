package app.twentyhours.animalsound.view.activity;

public interface OnMainCallback {
    void showFragment(String tag, Object data, boolean addToBackStack);
    void backToPreviousFragment();
}
