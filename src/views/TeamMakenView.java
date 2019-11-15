package views;

import controllers.TeamMakenController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * UI van het "teamMaken"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class TeamMakenView extends BaseView<TeamMakenController>{
    private Label maakTeamLabel;
    private Label naamLabel;
    private TextField teamNaam;
    private Button teamNaamButton;

    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public TeamMakenView(TeamMakenController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        VBox competitieAanmaken = new VBox();
        competitieAanmaken.setAlignment(Pos.CENTER);


        teamNaam = new TextField();
        teamNaamButton = new Button();
        maakTeamLabel = new Label("Maak team");
        naamLabel = new Label("Teamnaam");

        maakTeamLabel.setId("titelLabel");
        naamLabel.setId("naamLabel");

        teamNaam.setPromptText("bijv. Duitsland");
        teamNaam.setMaxHeight(20);
        teamNaam.setMaxWidth(200);

        naamLabel.setPrefWidth(200);

        teamNaamButton = new Button("Aanmaken");
        teamNaamButton.setCursor(Cursor.HAND);

        competitieAanmaken.setSpacing(20);
        competitieAanmaken.setMargin(naamLabel, new Insets(10, 0, -20, 0));

        competitieAanmaken.getChildren().addAll(maakTeamLabel, naamLabel, teamNaam, teamNaamButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setMargin(competitieAanmaken, new Insets(40));
        borderPane.setCenter(competitieAanmaken);
        borderPane.setStyle("-fx-background-color: #e6e6e6;");

        return borderPane;
    }

    protected void setupController() {
        controller.setTeamNaam(teamNaam);
        controller.setTeamNaamButton(teamNaamButton);
        controller.setMaakTeamLabel(maakTeamLabel);
        controller.setNaamLabel(naamLabel);

        controller.initialize();
    }
}
