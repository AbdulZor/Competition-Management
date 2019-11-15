package views;

import controllers.WedstrijdUitslagController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.Competitie;
import models.Team;

/**
 * UI van het "wedstrijdUitslag"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class WedstrijdUitslagView extends BaseView<WedstrijdUitslagController>{
    private Label wedstrijdUitslagTitel;
    private Label competitieLabel;
    private ComboBox<Competitie> competitie;
    private Label datePickerLabel;
    private DatePicker datePicker;
    private Label thuisTeamLabel;
    private ComboBox<Team> thuisTeam;
    private Label uitTeamLabel;
    private ComboBox<Team> uitTeam;
    private Label scoreThuisLabel;
    private TextField scoreThuis;
    private Label scoreUitLabel;
    private TextField scoreUit;
    private Button uitslagAanmaken;


    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public WedstrijdUitslagView(WedstrijdUitslagController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        wedstrijdUitslagTitel = new Label("Wedstrijduitslag");
        wedstrijdUitslagTitel.setId("wedstrijdUitslagLabel");

        competitieLabel = new Label("Competitie");
        competitieLabel.setId("subTitel");

        competitie = new ComboBox<>();
        competitie.setCursor(Cursor.HAND);
        competitie.getItems().addAll();
        competitie.getSelectionModel().selectFirst();

        datePickerLabel = new Label("Datum");
        datePickerLabel.setId("subTitel");

        datePicker = new DatePicker();
        datePicker.setMaxWidth(100);
        datePicker.setMinHeight(competitie.getHeight());
        datePicker.setCursor(Cursor.HAND);

        thuisTeamLabel = new Label("Thuis team");
        thuisTeamLabel.setId("subTitel");

        thuisTeam = new ComboBox<>();
        thuisTeam.setCursor(Cursor.HAND);
        thuisTeam.getItems().addAll();
        thuisTeam.getSelectionModel().selectFirst();

        scoreThuisLabel = new Label("Score");
        scoreThuisLabel.setId("subTitel");

        scoreThuis = new TextField();
        scoreThuis.setPromptText("0");
        scoreThuis.setMaxWidth(35);

        uitTeamLabel = new Label("Uit team");
        uitTeamLabel.setId("subTitel");

        uitTeam = new ComboBox<>();
        uitTeam.setCursor(Cursor.HAND);
        uitTeam.getItems().addAll();
        uitTeam.getSelectionModel().selectFirst();

        scoreUitLabel = new Label("Score");
        scoreUitLabel.setId("subTitel");

        scoreUit = new TextField();
        scoreUit.setPromptText("0");
        scoreUit.setMaxWidth(35);

        uitslagAanmaken = new Button("Aanmaken");
        uitslagAanmaken.setCursor(Cursor.HAND);



        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefWidth(500);
        gridPane.setGridLinesVisible(false);
        gridPane.setStyle("-fx-background-color: #e6e6e6;");
        gridPane.setHgap(50);
        gridPane.setVgap(10);

        gridPane.add(wedstrijdUitslagTitel, 0,0, 2, 1);
        gridPane.add(competitieLabel, 0, 1);
        gridPane.add(competitie, 0, 2);
        gridPane.add(datePickerLabel, 1, 1);
        gridPane.add(datePicker, 1, 2);
        gridPane.add(thuisTeamLabel, 0, 3);
        gridPane.add(scoreThuisLabel, 1, 3);
        gridPane.add(thuisTeam, 0, 4);
        gridPane.add(scoreThuis, 1, 4);
        gridPane.add(uitTeamLabel, 0, 5);
        gridPane.add(scoreUitLabel, 1, 5);
        gridPane.add(uitTeam, 0, 6);
        gridPane.add(scoreUit, 1, 6);
        gridPane.add(uitslagAanmaken, 0, 7, 2, 1);

        GridPane.setHalignment(wedstrijdUitslagTitel, HPos.CENTER);
        GridPane.setHalignment(uitslagAanmaken, HPos.CENTER);

        gridPane.setMargin(wedstrijdUitslagTitel, new Insets(0, 0, 15, 0));
        gridPane.setMargin(competitieLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(competitie, new Insets(0, 0, 14, 0));
        gridPane.setMargin(datePickerLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(datePicker, new Insets(0, 0, 14, 0));
        gridPane.setMargin(thuisTeamLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(scoreThuisLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(uitTeamLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(scoreUitLabel, new Insets(0, 0, -8, 0));
        gridPane.setMargin(uitslagAanmaken, new Insets(15, 0, 0, 0));
        return gridPane;
    }

    protected void setupController() {
        controller.setWedstrijdUitslagTitel(wedstrijdUitslagTitel);
        controller.setThuisTeam(thuisTeam);
        controller.setUitTeam(uitTeam);
        controller.setScoreThuis(scoreThuis);
        controller.setScoreUit(scoreUit);
        controller.setUitslagAanmaken(uitslagAanmaken);
        controller.setCompetitieLabel(competitieLabel);
        controller.setCompetitie(competitie);
        controller.setDatePicker(datePicker);
        controller.setDatePickerLabel(datePickerLabel);
        controller.setThuisTeamLabel(thuisTeamLabel);
        controller.setUitTeamLabel(uitTeamLabel);
        controller.setScoreThuisLabel(scoreThuisLabel);
        controller.setScoreUitLabel(scoreUitLabel);

        controller.initialize();
    }
}
