package helpers;

import controllers.*;
import models.Competitie;
import models.Team;
import models.Wedstrijd;
import repositories.CompetitieRepository;
import repositories.SerializedCompetitieRepository;
import repositories.SimulatedCompetitieRepository;
import repositories.TextCompetitieRepository;
import views.*;

import java.util.ArrayList;

public class StateManager {
    private static MainController mainController;
    private static final String STANDAARD_VIEW = "Main";
    public static String VIEW_COMPETITIE_MAKEN = "CompetitieMaken";
    public static final String VIEW_COMPETITIE_STAND = "CompetitieOverzicht";
    public static final String VIEW_GEBRUIK_TEAM = "GebruikTeam";
    public static final String VIEW_MAAK_TEAM = "MaakTeam";
    public static final String VIEW_TOON_WEDSTRIJD = "ToonWedstrijd";
    public static final String VIEW_WEDSTRIJD_UITSLAG = "WedstrijdUitslag";

    private static CompetitieRepository competitieRepository;

    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<Wedstrijd> wedstrijden = new ArrayList<>();
    private static Competitie huidigeCompetitie;
    private static Team huidigeTeamThuis;
    private static Team huidigeTeamUit;
    private static Wedstrijd huidigeWedstrijd;


    public static void initialize(MainController mainController) {
        StateManager.mainController = mainController;
        competitieRepository = new SerializedCompetitieRepository();
        //competitieRepository = new TextCompetitieRepository();
        //StateManager.schakelScherm(StateManager.STANDAARD_VIEW);
    }

    public static void schakelScherm(String naam) {
        switch (naam) {
            case ("Main"):
                break;
            case ("CompetitieMaken"):
                CompetitieMakenController competitieMakenController = new CompetitieMakenController();
                CompetitieMakenView competitieMakenView = new CompetitieMakenView(competitieMakenController);

                mainController.schakelScherm(competitieMakenView.getRoot());
                break;
            case ("CompetitieOverzicht"):
                CompetitieStandController competitieStandController = new CompetitieStandController();
                CompetitieStandView competitieStandView = new CompetitieStandView(competitieStandController);

                mainController.schakelScherm(competitieStandView.getRoot());
                break;
            case ("GebruikTeam"):
                GebruikTeamController gebruikTeamController = new GebruikTeamController();
                GebruikTeamView gebruikTeamView = new GebruikTeamView(gebruikTeamController);

                mainController.schakelScherm(gebruikTeamView.getRoot());
                break;
            case ("MaakTeam"):
                TeamMakenController teamMakenController = new TeamMakenController();
                TeamMakenView teamMakenView = new TeamMakenView(teamMakenController);

                mainController.schakelScherm(teamMakenView.getRoot());
                break;
            case ("ToonWedstrijd"):
                ToonWedstrijdenController toonWedstrijdenController = new ToonWedstrijdenController();
                ToonWedstrijdenView toonWedstrijdenView = new ToonWedstrijdenView(toonWedstrijdenController);

                mainController.schakelScherm(toonWedstrijdenView.getRoot());
                break;
            case ("WedstrijdUitslag"):
                WedstrijdUitslagController wedstrijdUitslagController = new WedstrijdUitslagController();
                WedstrijdUitslagView wedstrijdUitslagView = new WedstrijdUitslagView(wedstrijdUitslagController);

                mainController.schakelScherm(wedstrijdUitslagView.getRoot());
                break;
        }
    }

    public static void competitieMaken(Competitie competitie){
        competitieRepository.add(competitie);
    }

    public static void teamMaken(Team team){
        teams.add(team);
    }

    public static void setHuidigeCompetitie(Competitie huidigeCompetitie) {
        StateManager.huidigeCompetitie = huidigeCompetitie;
    }

    public static CompetitieRepository getCompetitieRepository() {
        return competitieRepository;
    }

    public static void setHuidigeTeamThuis(Team huidigeTeam) {
        StateManager.huidigeTeamThuis = huidigeTeam;
    }

    public static void setHuidigeTeamUit(Team huidigeTeamUit) {
        StateManager.huidigeTeamUit = huidigeTeamUit;
    }

    public static void setHuidigeWedstrijd(Wedstrijd huidigeWedstrijd) {
        StateManager.huidigeWedstrijd = huidigeWedstrijd;
    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static Competitie getHuidigeCompetitie() {
        return huidigeCompetitie;
    }
}