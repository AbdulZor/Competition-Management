package controllers;

import helpers.StateManager;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Team;
import models.Wedstrijd;
import views.*;

import java.time.LocalDate;

/**
 * Logica van het hoofdscherm
 *
 * @author HvA HBO-ICT
 */
public class MainController extends BaseController{
    private Stage stage;
    private BorderPane borderPane;

    private MenuItem laadMenuItem;
    private MenuItem bewaarMenuItem;
    private MenuItem afsluitenMenuItem;
    private MenuItem maakCompetitieMenuItem;
    private MenuItem maakWedstrijdMenuItem;
    private MenuItem maakTeamMenuItem;
    private MenuItem gebruikTeamMenuItem;
    private MenuItem toonWedstrijdenMenuItem;
    private MenuItem toonCompetitieStandMenuItem;
    private MenuItem overMenuItem;
    private Label melding;

    private AboutView aboutView;

    /**
     * Wanneer deze methode wordt aangeroepen, is het veilig om bijv. de menu-items aan te passen.
     */
    public void initialize() {
        AboutController aboutController = new AboutController();

        afsluitenMenuItem.setOnAction(t -> {
            System.out.println("Afsluiten aangeroepen.");

            //melding.setText("Afsluiten aangeroepen.");

            System.exit(0);
        });

        overMenuItem.setOnAction(t -> {
            System.out.println("Over aangeroepen.");

            //melding.setText("Over aangeroepen.");

            AboutView aboutView = new AboutView(aboutController);
            aboutView.show();
        });

        laadMenuItem.setOnAction(t -> {
            laden();
        });

        bewaarMenuItem.setOnAction(t -> {
            bewaren();
        });

        maakCompetitieMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_COMPETITIE_MAKEN);
        });
        maakTeamMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_MAAK_TEAM);
        });
        gebruikTeamMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_GEBRUIK_TEAM);
        });

        maakWedstrijdMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_WEDSTRIJD_UITSLAG);
        });

        toonWedstrijdenMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_TOON_WEDSTRIJD);
        });

        toonCompetitieStandMenuItem.setOnAction(t -> {
            StateManager.schakelScherm(StateManager.VIEW_COMPETITIE_STAND);
        });

        StateManager.initialize(this);
    }

    public void laden(){
        StateManager.getCompetitieRepository().load();
    }

    public void bewaren(){
        StateManager.getCompetitieRepository().save();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Wedstrijd genereerWedstrijden(LocalDate datum, Team team1, Team team2, int teamThuisScore, int teamUitScore) {
        return new Wedstrijd(team1, team2, teamThuisScore, teamUitScore, datum);
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public void schakelScherm(Parent root) {
        borderPane.setBottom(root);
    }


    public void setLaadMenuItem(MenuItem laadMenuItem) {
        this.laadMenuItem = laadMenuItem;
    }

    public void setBewaarMenuItem(MenuItem bewaarMenuItem) {
        this.bewaarMenuItem = bewaarMenuItem;
    }

    public void setAfsluitenMenuItem(MenuItem afsluitenMenuItem) {
        this.afsluitenMenuItem = afsluitenMenuItem;
    }

    public void setMaakCompetitieMenuItem(MenuItem maakCompetitieMenuItem) {
        this.maakCompetitieMenuItem = maakCompetitieMenuItem;
    }

    public void setMaakWedstrijdMenuItem(MenuItem maakWedstrijdMenuItem) {
        this.maakWedstrijdMenuItem = maakWedstrijdMenuItem;
    }

    public void setMaakTeamMenuItem(MenuItem maakTeamMenuItem) {
        this.maakTeamMenuItem = maakTeamMenuItem;
    }

    public void setGebruikTeamMenuItem(MenuItem gebruikTeamMenuItem) {
        this.gebruikTeamMenuItem = gebruikTeamMenuItem;
    }

    public void setToonWedstrijdenMenuItem(MenuItem toonWedstrijdenMenuItem) {
        this.toonWedstrijdenMenuItem = toonWedstrijdenMenuItem;
    }

    public void setToonCompetitieStandMenuItem(MenuItem toonCompetitieStandMenuItem) {
        this.toonCompetitieStandMenuItem = toonCompetitieStandMenuItem;
    }

    public void setOverMenuItem(MenuItem overMenuItem) {
        this.overMenuItem = overMenuItem;
    }

    public void setMelding(Label melding) {
        this.melding = melding;
    }

}
