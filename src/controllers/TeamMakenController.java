package controllers;

import helpers.StateManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Team;

/**
 * Logica van het "teamMaken"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class TeamMakenController extends BaseController {
    private Label maakTeamLabel;
    private Label naamLabel;
    private TextField teamNaam;
    private Button teamNaamButton;
    private Scene scene;
    private Stage stage;
    private Team team;

    public void initialize() {
        teamNaamButton.setOnAction(t -> {
            if (!teamNaam.getText().isEmpty()) {
                team = new Team(teamNaam.getText());
                StateManager.teamMaken(team);
                teamNaam.setText("");
            } else {
                teamNaam.setStyle("-fx-border-color: red;");
                teamNaam.setPromptText("VUL IN!");
            }
        });

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTeamNaam(TextField teamNaam) {
        this.teamNaam = teamNaam;
    }

    public void setTeamNaamButton(Button teamNaamButton) {
        this.teamNaamButton = teamNaamButton;
    }

    public void setMaakTeamLabel(Label maakTeamLabel) {
        this.maakTeamLabel = maakTeamLabel;
    }

    public void setNaamLabel(Label naamLabel) {
        this.naamLabel = naamLabel;
    }
}
