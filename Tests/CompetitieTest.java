import models.Competitie;
import models.Team;
import models.Wedstrijd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Deze klasse test de model klasse Competitie
 *
 * @author Abdul Vahip Zor
 */

public class CompetitieTest {
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Wedstrijd wedstrijd1;
    private Wedstrijd wedstrijd2;
    private Competitie competitie1;

    @Before
    public void setUp(){
        team1 = new Team("Ajax");
        team2 = new Team("AZ");
        team3 = new Team("PSV");
        team4 = new Team("Feyenoord");

        team1.setPunten(2);
        team2.setPunten(1);
        team3.setPunten(4);
        team4.setPunten(3);


        wedstrijd1 = new Wedstrijd(team1, team2, 34, 30, LocalDate.of(2019, 9, 12));
        wedstrijd2 = null;

        competitie1 = new Competitie("A-Groep");
    }

    @After
    public void tearDown(){
        team1 = null;
        team2 = null;
        team3 = null;
        team4 = null;
        wedstrijd1 = null;
        competitie1 = null;

    }

    @Test
    public void setTeam(){
        competitie1.setTeam(team1);
    }

    @Test
    public void setWedstrijd(){
        try {
            competitie1.setWedstrijd(wedstrijd1);
            System.out.println(competitie1.toString());

            System.out.println("En nu de competentiestanden:\n");
            competitie1.toonCompetitiestand();
        }catch (NullPointerException e){
            System.out.println("Je hebt geen object ingevoerd : " + e);
        }

        try {
            competitie1.setWedstrijd(wedstrijd2);
            System.out.println(competitie1.toString());
        }catch (NullPointerException e){
            System.out.println("Je hebt geen object ingevoerd : " + e);
        }catch (Exception e){
            System.out.println("Je error is" + e);
        }
    }


    @Test
    public void toonCompetitiestand(){
        competitie1.setTeam(team3);
        competitie1.setTeam(team4);
        competitie1.toonCompetitiestand();
    }

    @Test
    public void getNaam() {
        System.out.println(competitie1.getNaam());
    }

    @Test
    public void setNaam() {
        competitie1.setNaam("Nieuwe naam");
        System.out.println(competitie1.getNaam());
    }

    @Test
    public void getWedstrijden() {
        System.out.println(competitie1.getWedstrijden());
    }

    @Test
    public void getWedstrijd() {
        competitie1.setWedstrijd(wedstrijd1);
        System.out.println(competitie1.getWedstrijd(0));
    }

    @Test
    public void getTeams() {
        System.out.println(competitie1.getTeams());
    }

    @Test
    public void getTeam() {
        competitie1.setTeam(team1);
        System.out.println(competitie1.getTeam(0));
    }

    @Test
    public void toonWedstrijden() {
        competitie1.setWedstrijd(wedstrijd1);
        System.out.println(competitie1.getWedstrijden());
        competitie1.toonWedstrijden();
    }
}