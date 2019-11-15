package controllers;

import helpers.StateManager;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Competitie;
import models.Team;
import models.Wedstrijd;
import repositories.CompetitieRepository;

/**
 * Logica van het "wedstrijdUitslag"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class WedstrijdUitslagController extends BaseController {
    private Label wedstrijdUitslagTitel;
    private Label competitieLabel;
    private ComboBox<Competitie> competitie;
    private DatePicker datePicker;
    private Label datePickerLabel;
    private Label thuisTeamLabel;
    private ComboBox<Team> thuisTeam;
    private Label uitTeamLabel;
    private ComboBox<Team> uitTeam;
    private Label scoreThuisLabel;
    private TextField scoreThuis;
    private Label scoreUitLabel;
    private TextField scoreUit;
    private Button uitslagAanmaken;
    private Wedstrijd wedstrijd;

    private CompetitieRepository competitieRepository;

    private Scene scene;
    private Stage stage;

    public void initialize() {
        competitieRepository = StateManager.getCompetitieRepository();

        for (int i = 0; i < competitieRepository.getAll().size(); i++) {
            competitie.getItems().add(competitieRepository.getAll().get(i));
        }
        competitie.getSelectionModel().selectFirst();

        if (competitieRepository.getAll().size() != 0) {
            StateManager.setHuidigeCompetitie(competitie.getValue());

            for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                if (StateManager.getHuidigeCompetitie().getTeam(i) != uitTeam.getValue()) {
                    thuisTeam.getItems().add(StateManager.getHuidigeCompetitie().getTeam(i));
                }
            }

            for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                if (StateManager.getHuidigeCompetitie().getTeam(i) != thuisTeam.getValue()) {
                    uitTeam.getItems().add(StateManager.getHuidigeCompetitie().getTeam(i));
                }
            }

            StateManager.setHuidigeTeamThuis(thuisTeam.getValue());
            StateManager.setHuidigeTeamUit(uitTeam.getValue());

        }

        competitie.setOnAction(t -> {
            if (competitieRepository.getAll().size() != 0) {
                StateManager.setHuidigeCompetitie(competitie.getValue());
                System.out.println(StateManager.getHuidigeCompetitie());
                thuisTeam.getItems().clear();
                uitTeam.getItems().clear();

                for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                    thuisTeam.getItems().add(StateManager.getHuidigeCompetitie().getTeam(i));
                    if (thuisTeam.getValue() == uitTeam.getValue()) {
                        thuisTeam.getItems().remove(thuisTeam.getValue());
                    }
                }
                for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                    if (StateManager.getHuidigeCompetitie().getTeam(i) != thuisTeam.getValue()) {
                        uitTeam.getItems().add(StateManager.getHuidigeCompetitie().getTeam(i));
                        uitTeam.getSelectionModel().selectFirst();
                    }
                }
                StateManager.setHuidigeTeamThuis(thuisTeam.getValue());
                StateManager.setHuidigeTeamUit(uitTeam.getValue());
            }
        });

        thuisTeam.getSelectionModel().selectFirst();
        uitTeam.getSelectionModel().selectFirst();

        uitslagAanmaken.setOnAction(t -> {

            if (competitie.getValue() == null || thuisTeam.getValue() == null || uitTeam.getValue() == null || datePicker.getValue() == null || scoreThuis.getText().isEmpty() || scoreUit.getText().isEmpty()) {
                System.out.println("Error : Niet alle velden zijn ingevuld");
            } else {
                if (datePicker.getValue() == null) {
                    datePicker.setStyle("-fx-border-color: red");
                }
                if (scoreThuis.getText().isEmpty()) {
                    scoreThuis.setStyle("-fx-border-color: red");
                }
                if (scoreUit.getText().isEmpty()) {
                    scoreUit.setStyle("-fx-border-color: red");
                } else {
                    wedstrijd = new Wedstrijd(thuisTeam.getValue(), uitTeam.getValue(), Integer.parseInt(scoreThuis.getText()), Integer.parseInt(scoreUit.getText()), datePicker.getValue());
                    StateManager.getHuidigeCompetitie().setWedstrijd(wedstrijd);
                    System.out.println(StateManager.getHuidigeCompetitie().getWedstrijden());
                }
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

    public void setWedstrijdUitslagTitel(Label wedstrijdUitslagTitel) {
        this.wedstrijdUitslagTitel = wedstrijdUitslagTitel;
    }

    public void setThuisTeam(ComboBox<Team> thuisTeam) {
        this.thuisTeam = thuisTeam;
    }

    public void setUitTeam(ComboBox<Team> uitTeam) {
        this.uitTeam = uitTeam;
    }

    public void setScoreThuis(TextField scoreThuis) {
        this.scoreThuis = scoreThuis;
    }

    public void setScoreUit(TextField scoreUit) {
        this.scoreUit = scoreUit;
    }

    public void setUitslagAanmaken(Button uitslagAanmaken) {
        this.uitslagAanmaken = uitslagAanmaken;
    }

    public void setCompetitieLabel(Label competitieLabel) {
        this.competitieLabel = competitieLabel;
    }

    public void setCompetitie(ComboBox<Competitie> competitie) {
        this.competitie = competitie;
    }

    public void setThuisTeamLabel(Label thuisTeamLabel) {
        this.thuisTeamLabel = thuisTeamLabel;
    }

    public void setUitTeamLabel(Label uitTeamLabel) {
        this.uitTeamLabel = uitTeamLabel;
    }

    public void setScoreThuisLabel(Label scoreThuisLabel) {
        this.scoreThuisLabel = scoreThuisLabel;
    }

    public void setScoreUitLabel(Label scoreUitLabel) {
        this.scoreUitLabel = scoreUitLabel;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public void setDatePickerLabel(Label datePickerLabel) {
        this.datePickerLabel = datePickerLabel;
    }
}