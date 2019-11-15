import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {
    private Team team1;
    private Team team2;
    private Team team3;

    @Before
    public void setUp() throws Exception {
        team1 = new Team("Houten");
        team2 = new Team("Hellas");
        team3 = new Team("Aalsmeer");
    }

    @After
    public void tearDown() throws Exception {
        team1 = null;
        team2 = null;
        team3 = null;
    }

    @Test
    public void setPunten() {
        team1.setPunten(4);
        assertEquals(4, team1.getPunten());
    }

    @Test
    public void getPunten() {
        team1.setPunten(12);
        int result = team1.getPunten();
        assertEquals(12, result);
    }

    public void setNaam(){
        team1.setNaam("Graven");
        String result = team1.getNaam();
        assertEquals("Graven", result);
    }

    @Test
    public void getNaam() {
        team1.setNaam("Aristos");
        String result = team1.getNaam();
        assertEquals("Aristos", result);
    }

    @Test
    public void compareTo() {
        ArrayList<Team> teams = new ArrayList<>();
        team1.setPunten(10);
        team2.setPunten(12);
        team3.setPunten(10);
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        assertEquals(-1, team2.compareTo(team3));
        assertEquals(1, team1.compareTo(team2));
        assertEquals(0, team1.compareTo(team3));

    }

    @Test
    public void toStringTesten() {
        Team team1 = new Team("Hellas");
        assertEquals("Hellas", team1.toString());
        System.out.println("toString = TRUE; Result: Hellas");
    }
}