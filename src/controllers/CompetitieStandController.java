package controllers;

import comparators.competitieAZsorteren;
import comparators.competitieZAsorteren;
import comparators.teamAZsorteren;
import comparators.teamPuntensorteren;
import helpers.StateManager;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Competitie;
import models.Team;
import repositories.CompetitieRepository;

import java.util.Comparator;

/**
 * Logica van het "competitieStand"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class CompetitieStandController extends BaseController {
    private Label competitieStandLabel;
    private Label competitieLabel;
    private Label sorterenLabel;
    private ComboBox<Competitie> competitieBox;
    private ComboBox<Comparator> sorterenBox;
    private TableView<Team> competitieStandTabel;
    private ObservableList<Team> teams;
    private TableColumn<Team, String> teamNaam;
    private TableColumn<Team, Integer> teamPunten;

    private CompetitieRepository competitieRepository;

    private Scene scene;
    private Stage stage;

    public void initialize() {
        competitieRepository = StateManager.getCompetitieRepository();

        for (int i = 0; i < competitieRepository.getAll().size(); i++) {
            competitieBox.getItems().add(competitieRepository.getAll().get(i));
        }
        competitieBox.getSelectionModel().selectFirst();
        if (competitieRepository.getAll().size() != 0) {
            StateManager.setHuidigeCompetitie(competitieBox.getValue());
            for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                teams.add(competitieBox.getValue().getTeam(i));
            }
        }

        competitieBox.setOnAction(t -> {
            if (competitieRepository.getAll().size() != 0) {
                StateManager.setHuidigeCompetitie(competitieBox.getValue());
                teams.clear();
                for (int i = 0; i < StateManager.getHuidigeCompetitie().getTeams().size(); i++) {
                    teams.add(competitieBox.getValue().getTeam(i));
                }
            }
        });

        sorterenBox.getItems().add(new teamAZsorteren());
        sorterenBox.getItems().add(new teamPuntensorteren());
        sorterenBox.getSelectionModel().selectFirst();

        if (sorterenBox.getValue() != null) {
            teams.sort(sorterenBox.getValue());
        }

        sorterenBox.setOnAction(t -> {
            teams.sort(sorterenBox.getValue());
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

    public void setCompetitieStandLabel(Label competitieStandLabel) {
        this.competitieStandLabel = competitieStandLabel;
    }

    public void setCompetitieLabel(Label competitieLabel) {
        this.competitieLabel = competitieLabel;
    }

    public void setCompetitieBox(ComboBox<Competitie> competitieBox) {
        this.competitieBox = competitieBox;
    }

    public void setCompetitieStandTabel(TableView<Team> competitieStandTabel) {
        this.competitieStandTabel = competitieStandTabel;
    }

    public void setTeamNaam(TableColumn teamNaam) {
        this.teamNaam = teamNaam;
    }

    public void setTeamPunten(TableColumn teamPunten) {
        this.teamPunten = teamPunten;
    }

    public void setTeams(ObservableList<Team> teams) {
        this.teams = teams;
    }

    public void setSorterenBox(ComboBox<Comparator> sorterenBox) {
        this.sorterenBox = sorterenBox;
    }
}
