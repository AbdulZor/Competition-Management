import models.Team;
import models.Wedstrijd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Deze klasse test de model klasse Wedstrijd
 *
 * @author Abdul Vahip Zor
 */

public class WedstrijdTest {
    private LocalDate speelDatum;
    private LocalDate speelDatum2;
    private Team teamThuis;
    private Team teamUit;
    private int teamThuisScore;
    private int teamUitScore;
    private Wedstrijd wedstrijd;
    private Wedstrijd wedstrijd2;

    @Before
    public void setUp() throws Exception {
        speelDatum = LocalDate.of(2019, 8, 30);
        speelDatum2 = LocalDate.of(2019, 8, 31);
        teamThuis = new Team("AZ");
        teamUit = new Team("AJAX");
        teamThuisScore = 2;
        teamUitScore = 3;

        wedstrijd = new Wedstrijd(teamThuis, teamUit, teamThuisScore, teamUitScore, speelDatum);
        wedstrijd2 = new Wedstrijd(teamThuis, teamUit, teamThuisScore, teamUitScore, speelDatum2);
    }

    @After
    public void tearDown() throws Exception {
        speelDatum = null;
        teamThuis = null;
        teamUit = null;
        teamThuisScore = 0;
        teamUitScore = 0;
        wedstrijd = null;
    }

    @Test
    public void getSpeelDatum() {
        assertEquals(speelDatum, wedstrijd.getSpeelDatum());
        System.out.println("De speeldatum is: " + wedstrijd.getSpeelDatum());
    }
    @Test
    public void setTeams() {
        wedstrijd.setTeams(teamThuis, teamUit);
        System.out.println("Team thuis: " + wedstrijd.getTeamThuis() + "\tTeam uit: " + wedstrijd.getTeamUit());
    }

    @Test
    public void getTeamThuis() {
        System.out.println("Team thuis: " + wedstrijd.getTeamThuis());
    }

    @Test
    public void getTeamUit() {
        System.out.println("Team uit: " + wedstrijd.getTeamUit());
    }

    @Test
    public void getTeamUitScore() {
        System.out.println("UitTeam score: " + wedstrijd.getTeamUitScore());
    }

    @Test
    public void setTeamUitScore() {
        wedstrijd.setTeamUitScore(6);
        System.out.println("ThuisTeam score is gereset op: " + wedstrijd.getTeamUitScore());
        assertEquals(wedstrijd.getTeamUitScore(), 6);
    }

    @Test
    public void getTeamThuisScore() {
        System.out.println("ThuisTeam score: " + wedstrijd.getTeamThuisScore());
    }

    @Test
    public void setTeamThuisScore() {
        wedstrijd.setTeamThuisScore(1);
        System.out.println("UitTeam score is gereset op: " + wedstrijd.getTeamThuisScore());
        assertEquals(wedstrijd.getTeamThuisScore(), 1);
    }

    @Test
    public void compareTo() {
        System.out.println("Compare wedstrijd en wedstrijd 2: " + wedstrijd.compareTo(wedstrijd2));
    }
}