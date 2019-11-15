package comparators;

import models.Team;

import java.util.Comparator;

/**
 * Deze klasse sorteert teams op punten van veel naar weinig
 *
 * @author Abdul Vahip Zor
 */

public class teamPuntensorteren implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {
        if (team1.compareTo(team2) == 0){
            System.out.println("Ik ben in compate van puntensorteren");
            return team1.getNaam().compareTo(team2.getNaam());
        }
        return team1.compareTo(team2);
    }

    @Override
    public String toString() {
        return "teamPuntensorteren";
    }
}
