package models;

import java.io.Serializable;
import java.util.Collections;

/**
 * Deze klasse maakt een team aan
 *
 * @author Abdul Vahip Zor
 */
public class Team implements Comparable<Team> , Serializable {
    private String naam;
    private int punten;

    /**
     * Constructor om een Team aan te maken
     * @param naam de naam van het team
     */
    public Team(String naam) {
        this.naam = naam;
    }

    /**
     * @param punten de punten dat de team heeft in de competitie
     */
    public void setPunten(int punten) {
        this.punten = punten;
    }

    /**
     * @return de punten die de team heeft in de rankingslijst
     */
    public int getPunten() {
        return punten;
    }

    /**
     * @param naam de nieuwe naam voor de team
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return de naam van het team
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param team2 is het andere object waarmee vergeleken wordt
     * @return -1,0,1 op basis van het aantal punten in rankingslijst van een competitie
     */
    @Override
    public int compareTo(Team team2) {
        if (this.punten < team2.punten){
            return 1;
        }else if (this.punten > team2.punten){
            return -1;
        }else
            return 0;
    }

    /**
     * @return de naam en punten van het team
     */
    @Override
    public String toString() {
        return naam;
    }
}
