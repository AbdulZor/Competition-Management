package views;

import controllers.ToonWedstrijdenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import models.Competitie;
import models.Wedstrijd;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * UI van het "toonWedstrijden"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class ToonWedstrijdenView extends BaseView<ToonWedstrijdenController>{
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

    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public ToonWedstrijdenView(ToonWedstrijdenController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        VBox toonWedstrijd = new VBox();
        toonWedstrijd.setAlignment(Pos.CENTER);

        toonWedstrijdenLabel = new Label("Gespeelde wedstrijden");
        toonWedstrijdenLabel.setId("titelLabel");

        competitieLabel = new Label("Competitie");
        competitieLabel.setId("naamLabel");

        competitieBox = new ComboBox<>();
        competitieBox.setCursor(Cursor.HAND);
        competitieBox.getSelectionModel().selectFirst();

        sorterenLabel = new Label("Sorteer");
        sorterenLabel.setId("naamLabel");

        sorterenBox = new ComboBox<>();
        sorterenBox.setCursor(Cursor.HAND);

        wedstrijden = FXCollections.observableArrayList();

        datumColumn = new TableColumn<>("Datum");
        datumColumn.setMinWidth(50);
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("speelDatum"));

        teamThuisColumn = new TableColumn<>("Thuis");
        teamThuisColumn.setMinWidth(60);
        teamThuisColumn.setCellValueFactory(new PropertyValueFactory<>("teamThuis"));

        teamUitColumn = new TableColumn<>("Uit");
        teamUitColumn.setMinWidth(60);
        teamUitColumn.setCellValueFactory(new PropertyValueFactory<>("teamUit"));

        teamThuisScoreColumn = new TableColumn<>("Punten Thuis");
        teamThuisScoreColumn.setMinWidth(30);
        teamThuisScoreColumn.setCellValueFactory(new PropertyValueFactory<>("teamThuisScore"));

        teamUitScoreColumn = new TableColumn<>("Punten Uit");
        teamUitScoreColumn.setMinWidth(30);
        teamUitScoreColumn.setCellValueFactory(new PropertyValueFactory<>("teamUitScore"));

        wedstrijdTable = new TableView<>();
        wedstrijdTable.setMaxWidth(600);
        wedstrijdTable.setMaxHeight(100);
        wedstrijdTable.sort();
        wedstrijdTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        wedstrijdTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        wedstrijdTable.setItems(wedstrijden);
        wedstrijdTable.getColumns().addAll(datumColumn, teamThuisColumn, teamUitColumn, teamThuisScoreColumn, teamUitScoreColumn);

        toonWedstrijd.getChildren().addAll(toonWedstrijdenLabel, competitieLabel, competitieBox, sorterenLabel, sorterenBox, wedstrijdTable);
        toonWedstrijd.setSpacing(20);
        toonWedstrijd.setMargin(competitieLabel, new Insets(20, 0, -18, 0));
        toonWedstrijd.setMargin(sorterenLabel, new Insets(4, 0, -18, 0));

        BorderPane borderPane = new BorderPane();
        borderPane.setMargin(toonWedstrijd, new Insets(40));
        borderPane.setCenter(toonWedstrijd);
        borderPane.setStyle("-fx-background-color: #e6e6e6;");

        return borderPane;
    }

    protected void setupController() {
        controller.setToonWedstrijdenLabel(toonWedstrijdenLabel);
        controller.setCompetitieLabel(competitieLabel);
        controller.setCompetitieBox(competitieBox);
        controller.setWedstrijdTable(wedstrijdTable);
        controller.setWedstrijden(wedstrijden);
        controller.setDatumColumn(datumColumn);
        controller.setTeamThuisColumn(teamThuisColumn);
        controller.setTeamUitColumn(teamUitColumn);
        controller.setTeamThuisScoreColumn(teamThuisScoreColumn);
        controller.setTeamUitScoreColumn(teamUitScoreColumn);
        controller.setSorterenBox(sorterenBox);


        controller.initialize();
    }
}
