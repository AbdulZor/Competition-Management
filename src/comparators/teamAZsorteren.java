package comparators;

import models.Team;

import java.util.Comparator;

/**
 * Deze klasse sorteert teams op naam van A-Z
 *
 * @author Abdul Vahip Zor
 */

public class teamAZsorteren implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {
        return team1.getNaam().compareTo(team2.getNaam());
    }

    @Override
    public String toString() {
        return "teamAZsorteren";
    }
}
