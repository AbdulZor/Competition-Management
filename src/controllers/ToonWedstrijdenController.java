package controllers;

import comparators.wedstrijdDatumSorteren;
import helpers.StateManager;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Competitie;
import models.Wedstrijd;
import repositories.CompetitieRepository;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * Logica van het "toonWedstrijden"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class ToonWedstrijdenController extends BaseController{
    private Label toonWedstrijdenLabel;
    private Label competitieLabel;
    private Label sorterenLabel;
    private ComboBox<Competitie> competitieBox;
    private ComboBox<Comparator> sorterenBox;
    private TableView<Wedstrijd> wedstrijdTable;
    private ObservableList<Wedstrijd> wedstrijden;
    private TableColumn<Wedstrijd, LocalDate> datumColumn;
    private TableColumn<Wedstrijd, String> teamThuisColumn;
    private TableColumn<Wedstrijd, String> teamUitColumn;
    private TableColumn<Wedstrijd, Integer> teamThuisScoreColumn;
    private TableColumn<Wedstrijd, Integer> teamUitScoreColumn;

    private CompetitieRepository competitieRepository;

    private Scene scene;
    private Stage stage;

    public void initialize() {
        competitieRepository = StateManager.getCompetitieRepository();

        for (int i = 0; i < competitieRepository.getAll().size(); i++) {
            competitieBox.getItems().add(competitieRepository.getAll().get(i));
        }
        competitieBox.getSelectionModel().selectFirst();
        StateManager.setHuidigeCompetitie(competitieBox.getValue());
        System.out.println(StateManager.getHuidigeCompetitie());

        if (competitieBox.getValue() != null) {
            for (int i = 0; i < competitieBox.getValue().getWedstrijden().size(); i++) {
                System.out.println(wedstrijden);
                wedstrijden.add(competitieBox.getValue().getWedstrijd(i));
            }
        }

        competitieBox.setOnAction(t -> {
            wedstrijden.clear();
            StateManager.setHuidigeCompetitie(competitieBox.getValue());
            System.out.println(StateManager.getHuidigeCompetitie());

            if (competitieBox.getValue() != null) {
                for (int i = 0; i < competitieBox.getValue().getWedstrijden().size(); i++) {
                    System.out.println(wedstrijden);
                    wedstrijden.add(competitieBox.getValue().getWedstrijd(i));
                }
            }
        });

        sorterenBox.getItems().add(new wedstrijdDatumSorteren());
        sorterenBox.getSelectionModel().selectFirst();

        if (sorterenBox.getValue() != null){
            wedstrijden.sort(sorterenBox.getValue());
        }
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

    public void setToonWedstrijdenLabel(Label toonWedstrijdenLabel) {
        this.toonWedstrijdenLabel = toonWedstrijdenLabel;
    }

    public void setCompetitieLabel(Label competitieLabel) {
        this.competitieLabel = competitieLabel;
    }

    public void setCompetitieBox(ComboBox<Competitie> competitieBox) {
        this.competitieBox = competitieBox;
    }

    public void setWedstrijdTable(TableView<Wedstrijd> wedstrijdTable) {
        this.wedstrijdTable = wedstrijdTable;
    }

    public void setWedstrijden(ObservableList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

    public void setDatumColumn(TableColumn<Wedstrijd, LocalDate> datumColumn) {
        this.datumColumn = datumColumn;
    }

    public void setTeamThuisColumn(TableColumn<Wedstrijd, String> teamThuisColumn) {
        this.teamThuisColumn = teamThuisColumn;
    }

    public void setTeamUitColumn(TableColumn<Wedstrijd, String> teamUitColumn) {
        this.teamUitColumn = teamUitColumn;
    }

    public void setTeamThuisScoreColumn(TableColumn<Wedstrijd, Integer> teamThuisScoreColumn) {
        this.teamThuisScoreColumn = teamThuisScoreColumn;
    }

    public void setTeamUitScoreColumn(TableColumn<Wedstrijd, Integer> teamUitScoreColumn) {
        this.teamUitScoreColumn = teamUitScoreColumn;
    }

    public void setSorterenBox(ComboBox<Comparator> sorterenBox) {
        this.sorterenBox = sorterenBox;
    }
}
