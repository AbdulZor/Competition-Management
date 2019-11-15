package models;
/**
 * Deze klasse maakt een wedstrijd aan met teams
 *
 * @author Abdul Vahip Zor
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Wedstrijd implements Comparable<Wedstrijd>, Serializable    {
    private LocalDate speelDatum;
    private Team teamThuis;
    private Team teamUit;
    private int teamThuisScore;
    private int teamUitScore;
    private final int PUNTEN_BIJ_WINST = 2;
    private final int PUNTEN_BIJ_GELIJKSPEL = 1;

    /**
     * Constructor dat een wedstrijd aanmaakt zonder teams en alleen datum
     *
     * @param speelDatum de datum van de wedstrijd
     */
    public Wedstrijd(LocalDate speelDatum) {
        this.speelDatum = speelDatum;
    }

    /**
     * Constructor dat wedstrijd aanmaakt met teams en datum
     *
     * @param teamThuis      de eerste team
     * @param teamUit        de tweede team
     * @param speelDatum de datum van de wedstrijd
     */
    public Wedstrijd(Team teamThuis, Team teamUit, int teamThuisScore, int teamUitScore, LocalDate speelDatum) {
        this.teamThuis = teamThuis;
        this.teamUit = teamUit;
        this.teamThuisScore = teamThuisScore;
        this.teamUitScore = teamUitScore;
        this.speelDatum = speelDatum;
//        puntenverdelingTeam(teamThuisScore, teamThuisScore);
        if (teamThuisScore > teamUitScore){
            teamThuis.setPunten(teamThuis.getPunten() + PUNTEN_BIJ_WINST);
        }else if (teamThuisScore == teamUitScore){
            teamThuis.setPunten(teamThuis.getPunten() + PUNTEN_BIJ_GELIJKSPEL);
            teamUit.setPunten(teamUit.getPunten() + PUNTEN_BIJ_GELIJKSPEL);
        }else
            teamUit.setPunten(teamUit.getPunten() + PUNTEN_BIJ_WINST);
    }

    public Wedstrijd(Team teamThuis, Team teamUit, LocalDate speelDatum) {
        this.teamThuis = teamThuis;
        this.teamUit = teamUit;
        this.speelDatum = speelDatum;
    }

    /**
     * @return de speeldatum
     */
    public LocalDate getSpeelDatum() {
        return speelDatum;
    }

    /**
     * ????????????????????????????????????? VERWIJDER ALS CONSTRUCTOR WORDT GOEDGEKEURD  ??????????????????????
     *
     * @param team1 de eerste team van de wedstrijd
     * @param team2 de tweede team van de wedstrijd
     */
    public void setTeams(Team team1, Team team2) {
        this.teamThuis = team1;
        this.teamUit = team2;
    }

    /**
     * Deze methode verdeeld de punten aan de teams met behulp van de gescoorde punten in de wedstrijd
     * @param teamThuisScore de score die het thuisteam heeft gemaakt
     * @param teamUitScore de score die het uitteam heeft gemaakt
     */
    private void puntenverdelingTeam(int teamThuisScore, int teamUitScore){
        if (teamThuisScore > teamUitScore){
            teamThuis.setPunten(teamThuis.getPunten() + PUNTEN_BIJ_WINST);
        }else if (teamThuisScore == teamUitScore){
            teamThuis.setPunten(teamThuis.getPunten() + PUNTEN_BIJ_GELIJKSPEL);
            teamUit.setPunten(teamUit.getPunten() + PUNTEN_BIJ_GELIJKSPEL);
        }else
            teamUit.setPunten(teamUit.getPunten() + PUNTEN_BIJ_WINST);
    }

    /**
     * @return de teamThuis van de wedstrijd
     */
    public Team getTeamThuis() {
        return teamThuis;
    }

    /**
     * @return de teamUit van de wedstrijd
     */
    public Team getTeamUit() {
        return teamUit;
    }

    /**
     * @return de teamUit score
     */
    public int getTeamUitScore() {
        return teamUitScore;
    }

    /**
     * @param teamUitScore de nieuwe teamUit score
     */
    public void setTeamUitScore(int teamUitScore) {
        this.teamUitScore = teamUitScore;
    }

    /**
     * @return de teamThuis score
     */
    public int getTeamThuisScore() {
        return teamThuisScore;
    }

    /**
     * @param teamThuisScore de nieuwe teamThuis score
     */
    public void setTeamThuisScore(int teamThuisScore) {
        this.teamThuisScore = teamThuisScore;
    }

        @Override
        public int compareTo(Wedstrijd o) {
            return speelDatum.compareTo(o.getSpeelDatum());
        }

    /**
     * @return de speeldatum en de bijbehorende teams
     */
    @Override
    public String toString() {
        return speelDatum + "\n\tTeam1: " + teamThuis + "\n\tTeam2: " + teamUit;
    }
}
