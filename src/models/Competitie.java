package models;
/**
 * Deze klasse maakt een competitie aan
 *
 * @author Abdul Vahip Zor
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Competitie implements Serializable {
    private String naam;
    private ArrayList<Wedstrijd> wedstrijden;
    private ArrayList<Team> teams;

    /**
     * @param naam de naam van de competitie
     */
    public Competitie(String naam) {
        this.naam = naam;
        wedstrijden = new ArrayList<>();
        teams = new ArrayList<>();
    }

    /**
     * @return de naam van de competitie
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam de nieuwe naam van de competitie
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    // Wedstrijden

    /**
     * haal een wedstrijd op en voeg die in de wedstrijden
     *
     * @param wedstrijd een wedstrijd
     */
    public void setWedstrijd(Wedstrijd wedstrijd) {
        wedstrijden.add(wedstrijd);
    }

    /**
     * @return de ArrayList waar de wedstrijden in zitten
     */
    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    /**
     * @param index de index van welke wedstrijd gevraagd wordt uit de ArrayList
     * @return de wedstrijd
     */
    public Wedstrijd getWedstrijd(int index) {
        return wedstrijden.get(index);
    }

    // Teams

    /**
     * haal een team op en voeg die in de teams
     *
     * @param team het team object dat toegevoegd moet worden
     */
    public void setTeam(Team team) {
        teams.add(team);
    }

    /**
     * @return de teams in de competitie
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * @param index de index van welke team gevraagd wordt uit de ArrayList
     * @return het team object
     */
    public Team getTeam(int index) {
        return teams.get(index);
    }

    /**
     * @return alle wedstrijden met hun info
     */
    @Override
    public String toString() {
        return naam;
    }

    /**
     * @return alle gespeelde wedstrijden in de competitie
     */
    public String toonWedstrijden() {
        StringBuilder competitieInfo = new StringBuilder(naam + ":\n");


        for (int i = 0; i < wedstrijden.size(); i++) {
            Collections.sort(wedstrijden);
            competitieInfo.append(wedstrijden.get(i) + "\n");
        }
        return competitieInfo + "\n";
    }

    /**
     * Toon de competitiestand van de competitie
     */
    public void toonCompetitiestand() {
        StringBuilder competitieStand = new StringBuilder();
        Collections.sort(teams);
        for (int i = 0; i < teams.size(); i++) {
            competitieStand.append(String.format("%-9s %s", i + 1, teams.get(i)) + "\n");
        }
        System.out.printf("%-10s%-10s %s\n", "Plaats", "Team", "Punten");
        System.out.println(competitieStand);
    }
}
