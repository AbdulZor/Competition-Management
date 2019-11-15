package repositories;

import models.Competitie;
import models.Team;
import models.Wedstrijd;

import java.time.LocalDate;
import java.util.ArrayList;

public class SimulatedCompetitieRepository implements CompetitieRepository {
    private static CompetitieRepository competitieRepository;
    private static SerializedCompetitieRepository serializedCompetitieRepository;
    private final int AANTAL_COMPETITIES = 10;
    private ArrayList<Competitie> competities;
    private Competitie competitie;

    public SimulatedCompetitieRepository() {
        competities = new ArrayList<>();
        load();
    }
    @Override
    public ArrayList<Competitie> getAll() {
        return competities;
    }
    @Override
    public void add(Competitie competitie) {
        competities.add(competitie);
    }
    @Override
    public void update(Competitie competitie) {
        //Niet van toepassing vanwege referenties
    }
    @Override
    public void remove(Competitie competitie) {
        competities.remove(competitie);
    }

    @Override
    public boolean load() {
        //laad eerst alle competitie objecten en voeg ze toe aan de arraylist competities
        serializedCompetitieRepository = new SerializedCompetitieRepository();
        for(int i = 0; i < AANTAL_COMPETITIES; i++) {
//            try {
//                competitieRepository.add();
//                competities.add(serializedCompetitieRepository.writAndReadData());
//            }catch (Exception ex){
//                System.out.println("Je ERROR is " + ex);
//            }
            Competitie competitie = competitieMaken();
            competities.add(competitie);
            simuleerCompetitie(competitie);
            //printEindstandCompetitie(competitie);
        }
        return true;
    }
    @Override
    public boolean save() {
        //Niet van toepassing in deze repository
        return false;
    }
    public static Competitie competitieMaken(){
        return new Competitie("Competitie");
    }
    public void simuleerCompetitie(Competitie competitie) {
        Team team1 = new Team("Ajax");
        Team team2 = new Team("AZ");
        Team team3 = new Team("PSV");

        // Gelijkspel is 1 punt en winst is 2 punten in Poule
        competitie.setTeam(team1);
        competitie.setTeam(team2);
        competitie.setTeam(team3);
    }
    public void printEindstandCompetitie(Competitie competitie) {
        //TODO: Je eigen code van week 2
    }
}