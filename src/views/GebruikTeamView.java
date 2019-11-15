package views;

import controllers.GebruikTeamController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import models.Competitie;
import models.Team;

/**
 * UI van het "gebruikTeam"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class GebruikTeamView extends BaseView<GebruikTeamController>{

    private Label teamToevoegenLabel;
    private Label competitieNaamLabel;
    private Label teamNaamLabel;
    private ComboBox<Competitie> competitieComboBox;
    private ComboBox<Team> teamComboBox;
    private Button teamToevoegen;

    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public GebruikTeamView(GebruikTeamController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        VBox gebruikTeam = new VBox();
        gebruikTeam.setAlignment(Pos.CENTER);

        teamToevoegenLabel = new Label("Voeg team toe aan Competitie");
        teamToevoegenLabel.setId("teamToevoegenLabel");

        competitieNaamLabel = new Label("Competitie");
        competitieNaamLabel.setId("subTitel");


        competitieComboBox = new ComboBox<>();
        competitieComboBox.setCursor(Cursor.HAND);


        teamNaamLabel = new Label("Team");
        teamNaamLabel.setId("subTitel");


        teamComboBox = new ComboBox<>();
        teamComboBox.setCursor(Cursor.HAND);

        teamToevoegen = new Button("Toevoegen");
        teamToevoegen.setCursor(Cursor.HAND);

        gebruikTeam.setSpacing(10);
        gebruikTeam.setMargin(competitieNaamLabel, new Insets(10, 0, -7, 0));
        gebruikTeam.setMargin(teamNaamLabel, new Insets(10, 0, -7, 0));

        gebruikTeam.getChildren().addAll(teamToevoegenLabel, competitieNaamLabel, competitieComboBox, teamNaamLabel, teamComboBox, teamToevoegen);

        BorderPane borderPane = new BorderPane();
        borderPane.setMargin(gebruikTeam, new Insets(40));
        borderPane.setCenter(gebruikTeam);
        borderPane.setStyle("-fx-background-color: #e6e6e6;");

        return borderPane;
    }

    protected void setupController() {
        controller.setTeamToevoegenLabel(teamToevoegenLabel);
        controller.setCompetitieNaamLabel(competitieNaamLabel);
        controller.setTeamNaamLabel(teamNaamLabel);
        controller.setCompetitieComboBox(competitieComboBox);
        controller.setTeamComboBox(teamComboBox);
        controller.setTeamToevoegen(teamToevoegen);

        controller.initialize();
    }
}
