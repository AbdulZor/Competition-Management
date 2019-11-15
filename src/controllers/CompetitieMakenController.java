package controllers;

import helpers.StateManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Competitie;
import repositories.CompetitieRepository;

/**
 * Logica van het "competitieMaken"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class CompetitieMakenController extends BaseController{

    private TextField competitieNaam;
    private Button competitieNaamButton;
    private Scene scene;
    private Stage stage;
    private Competitie competitie;

    private CompetitieRepository competitieRepository;

    public void initialize() {
        competitieRepository = StateManager.getCompetitieRepository();

        competitieNaamButton.setOnAction(t -> {
            if (!competitieNaam.getText().isEmpty()) {
                    competitie = new Competitie(competitieNaam.getText());
                    StateManager.competitieMaken(competitie);
                    competitieNaam.setText("");
            }else {
                competitieNaam.setStyle("-fx-border-color: red;");
                competitieNaam.setPromptText("VUL IN!");
            }
        });
    }

    public Competitie getCompetitie() {
        return competitie;
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

    public void setCompetitieNaam(TextField competitieNaam) {
        this.competitieNaam = competitieNaam;
    }

    public void setCompetitieNaamButton(Button competitieNaamButton) {
        this.competitieNaamButton = competitieNaamButton;
    }

}
