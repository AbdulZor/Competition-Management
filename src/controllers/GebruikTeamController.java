package controllers;

import helpers.StateManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Competitie;
import models.Team;
import repositories.CompetitieRepository;

/**
 * Logica van het "gebruikTeam"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class GebruikTeamController extends BaseController{
    private Label teamToevoegenLabel;
    private Label competitieNaamLabel;
    private Label teamNaamLabel;
    private ComboBox<Competitie> competitieComboBox;
    private ComboBox<Team> teamComboBox;
    private Button teamToevoegen;

    private Scene scene;
    private Stage stage;

    private CompetitieRepository competitieRepository;

    public void initialize(){
        competitieRepository = StateManager.getCompetitieRepository();
        System.out.println(competitieRepository + " \t \t \t " + competitieRepository.getAll());

        if (competitieRepository.getAll().size() != 0) {
            for (int i = 0; i < competitieRepository.getAll().size(); i++) {
                competitieComboBox.getItems().add(competitieRepository.getAll().get(i));
            }
            competitieComboBox.getSelectionModel().selectFirst();

            for (int i = 0; i < StateManager.getTeams().size(); i++) {
                teamComboBox.getItems().add(StateManager.getTeams().get(i));
            }
            teamComboBox.getSelectionModel().selectFirst();

            if (competitieComboBox.getItems().isEmpty()) {
                competitieComboBox.setPromptText("Geen competities");
            }
            if (teamComboBox.getItems().isEmpty()) {
                teamComboBox.setPromptText("Geen teams");
            }
        }

        teamToevoegen.setOnAction(t -> {
            if (competitieComboBox.getValue() == null || teamComboBox.getValue() == null) {
                if (competitieComboBox.getValue() == null) {
                    competitieComboBox.setStyle("-fx-border-color: red");
                }
                if (teamComboBox.getValue() == null) {
                    teamComboBox.setStyle("-fx-border-color: red");
                }
            }else {
                competitieComboBox.getValue().setTeam(teamComboBox.getValue());
                teamToevoegen.setStyle("-fx-border-color: green");
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

    public void setTeamToevoegenLabel(Label teamToevoegenLabel) {
        this.teamToevoegenLabel = teamToevoegenLabel;
    }

    public void setCompetitieNaamLabel(Label competitieNaamLabel) {
        this.competitieNaamLabel = competitieNaamLabel;
    }

    public void setTeamNaamLabel(Label teamNaamLabel) {
        this.teamNaamLabel = teamNaamLabel;
    }

    public void setCompetitieComboBox(ComboBox<Competitie> competitieComboBox) {
        this.competitieComboBox = competitieComboBox;
    }

    public void setTeamComboBox(ComboBox<Team> teamComboBox) {
        this.teamComboBox = teamComboBox;
    }

    public void setTeamToevoegen(Button teamToevoegen) {
        this.teamToevoegen = teamToevoegen;
    }
}
