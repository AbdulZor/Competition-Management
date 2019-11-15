import comparators.teamPuntensorteren;
import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Deze klasse test de Comparator klasse teamPuntensorteren
 *
 * @author Abdul Vahip Zor
 */

public class teamPuntensorterenTest {
    private List<Team> teams;
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;

    @Before
    public void setUp() throws Exception {
        teams = new ArrayList<>();
        team1 = new Team("Houten");
        team1.setPunten(45);
        team2 = new Team("Hellas");
        team2.setPunten(32);
        team3 = new Team("Arnhem");
        team3.setPunten(40);
        team4 = new Team("Aalsmeer");
        team4.setPunten(40);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
    }

    @After
    public void tearDown() throws Exception {
        team1 = null;
        team2 = null;
        team3 = null;
        team4 = null;
        teams = null;
    }

    @Test
    public void compare() {
        Collections.sort(teams, new teamPuntensorteren());
        assertEquals("Houten", teams.get(0).getNaam());
        assertEquals("Aalsmeer", teams.get(1).getNaam());
        assertEquals("Arnhem", teams.get(2).getNaam());
        assertEquals("Hellas", teams.get(3).getNaam());

        for (Team team : teams) {
            System.out.println(team);
        }
    }
}