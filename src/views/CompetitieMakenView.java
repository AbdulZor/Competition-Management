package views;

import controllers.CompetitieMakenController;
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
 * UI van het "competitieMaken"-scherm
 *
 * @author Abdul Vahip Zor
 */

public class CompetitieMakenView extends BaseView<CompetitieMakenController>{
    private Label maakCompetitieLabel;
    private Label naamLabel;
    private TextField competitieNaam;
    private Button competitieNaamButton;

    /**
     * Maakt een instantie van de UI van het hoofdscherm
     *
     * @param controller Een instantie van de controller die nodig is om het hoofdscherm aan te sturen
     */
    public CompetitieMakenView(CompetitieMakenController controller) {
        super(controller);

        root = createRoot();

        setupController();
    }

    protected Parent createRoot() {
        VBox competitieAanmaken = new VBox();
        competitieAanmaken.setAlignment(Pos.CENTER);



        competitieNaam = new TextField();
        competitieNaamButton = new Button();
        maakCompetitieLabel = new Label("Maak competitie");
        naamLabel = new Label("Naam");

        maakCompetitieLabel.setId("titelLabel");
        naamLabel.setId("naamLabel");

        competitieNaam.setPromptText("bijv. EK vrouwen");
        competitieNaam.setMaxHeight(20);
        competitieNaam.setMaxWidth(200);

        naamLabel.setPrefWidth(200);

        competitieNaamButton = new Button("Aanmaken");
        competitieNaamButton.setCursor(Cursor.HAND);

        competitieAanmaken.setSpacing(20);
        competitieAanmaken.setMargin(naamLabel, new Insets(10, 0, -20, 0));

        competitieAanmaken.getChildren().addAll(maakCompetitieLabel, naamLabel, competitieNaam, competitieNaamButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setMargin(competitieAanmaken, new Insets(40));
        borderPane.setCenter(competitieAanmaken);
        borderPane.setStyle("-fx-background-color: #e6e6e6;");

        return borderPane;
    }

    protected void setupController() {
        super.controller.setCompetitieNaam(competitieNaam);
        super.controller.setCompetitieNaamButton(competitieNaamButton);

        super.controller.initialize();
    }


}
