package views;

import controllers.BaseController;
import javafx.scene.Parent;

/**
 * BaseView voor alle View klassen
 * @author Abdul Vahip Zor
 */

public abstract class BaseView<E extends BaseController> {
    protected E controller;
    protected Parent root;

    public BaseView(E contoller) {
        this.controller = contoller;
    }

    protected abstract Parent createRoot();
    protected abstract void setupController();

    public Parent getRoot() {
        return root;
    }
}
