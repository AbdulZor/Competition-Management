package views;

import controllers.CompetitieStandController;
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
import models.Team;
import java.util.Comparator;

/**
 * UI van het "competitieStand"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class CompetitieStandView extends BaseView<CompetitieStandController>{
    private Label competitieStandLabel;
    private Label competitieLabel;
    private Label sorterenLabel;
    private ComboBox<Competitie> competitieBox;
    private ComboBox<Comparator> sorterenBox;
    private TableView<Team> competitieStandTabel;
    private ObservableList<Team> teams;
    private TableColumn<Team, String> teamNaam;
    private TableColumn<Team, Integer> teamPunten;

    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public CompetitieStandView(CompetitieStandController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        VBox competitieStand = new VBox();
        competitieStand.setAlignment(Pos.CENTER);

        competitieStandLabel = new Label("Competitiestand");
        competitieStandLabel.setId("titelLabel");

        competitieLabel = new Label("Competitie");
        competitieLabel.setId("naamLabel");

        competitieBox = new ComboBox<>();
        competitieBox.setCursor(Cursor.HAND);
        competitieBox.getSelectionModel().selectFirst();

        sorterenLabel = new Label("Sorteer");
        sorterenLabel.setId("naamLabel");

        sorterenBox = new ComboBox<>();
        sorterenBox.setCursor(Cursor.HAND);

        teams = FXCollections.observableArrayList();

        teamNaam = new TableColumn<>("Team");
        teamNaam.setMinWidth(60);
        teamNaam.setCellValueFactory(new PropertyValueFactory<>("naam"));

        teamPunten = new TableColumn<>("Punten");
        teamPunten.setCellValueFactory(new PropertyValueFactory<>("punten"));

        competitieStandTabel = new TableView<>();
        competitieStandTabel.setMaxWidth(200);
        competitieStandTabel.getColumns().addAll(teamNaam, teamPunten);
        competitieStandTabel.sort();
        competitieStandTabel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        competitieStandTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        competitieStandTabel.setItems(teams);


        competitieStand.setSpacing(20);
        competitieStand.setMargin(competitieLabel, new Insets(0, 0, -18, 0));
        competitieStand.setMargin(sorterenLabel, new Insets(4, 0, -18, 0));
        competitieStand.getChildren().addAll(competitieStandLabel, competitieLabel, competitieBox, sorterenLabel, sorterenBox, competitieStandTabel);

        BorderPane borderPane = new BorderPane();
        borderPane.setMargin(competitieStand, new Insets(40));
        borderPane.setCenter(competitieStand);
        borderPane.setStyle("-fx-background-color: #e6e6e6;");


        return borderPane;
    }

    protected void setupController() {
        controller.setCompetitieStandLabel(competitieStandLabel);
        controller.setCompetitieLabel(competitieLabel);
        controller.setCompetitieBox(competitieBox);
        controller.setCompetitieStandTabel(competitieStandTabel);
        controller.setTeamNaam(teamNaam);
        controller.setTeamPunten(teamPunten);
        controller.setTeams(teams);
        controller.setSorterenBox(sorterenBox);


        controller.initialize();
    }
}
