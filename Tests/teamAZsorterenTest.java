import comparators.teamAZsorteren;
import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Deze klasse test de Comparator klasse teamAZsorteren
 *
 * @author Abdul Vahip Zor
 */

public class teamAZsorterenTest {
    private List<Team> teams;
    private Team team1;
    private Team team2;
    private Team team3;

    @Before
    public void setUp() throws Exception {
        teams = new ArrayList<>();
        team1 = new Team("Houten");
        team2 = new Team("Hellas");
        team3 = new Team("Arnhem");

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
    }

    @After
    public void tearDown() throws Exception {
        team1 = null;
        team2 = null;
        team3 = null;
        teams = null;
    }

    @Test
    public void compare() {
        Collections.sort(teams, new teamAZsorteren());
        assertEquals("Arnhem", teams.get(0).getNaam());
        assertEquals("Hellas", teams.get(1).getNaam());
        assertEquals("Houten", teams.get(2).getNaam());

        for (Team team : teams) {
            System.out.println(team);
        }
    }
}