package repositories;

import models.Competitie;

import java.io.*;
import java.util.ArrayList;

public class TextCompetitieRepository implements CompetitieRepository {
    private CompetitieRepository competitieRepository;
    private final int AANTAL_COMPETITIES = 10;
    private ArrayList<Competitie> competities;
    private Competitie competitie;

    public TextCompetitieRepository() {
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
        // niet van toepassing
    }

    @Override
    public void remove(Competitie competitie) {
        competities.remove(competitie);
    }

    @Override
    public boolean load() {
        try {
            File file = new File("out/data.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String competitieNaam;
            while ((competitieNaam = bufferedReader.readLine()) != null) {
                Competitie competitie;
                competitie = new Competitie(competitieNaam);
                competities.add(competitie);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Het bestand is niet gevonden, zie error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Je hebt een error, namelijk: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean save() {
        try {
            File file = new File("out/data.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println(competities.size());

            for (int i = 0; i < competities.size(); i++) {
                bufferedWriter.write(competities.get(i).getNaam() + "\r\n");
                System.out.println(competities.get(i).getNaam());
                if (competities.get(i).getTeams().size() != 0) {
                    System.out.println(competities.get(i).getTeams());
                    bufferedWriter.write(competities.get(i).getTeam(0).getNaam());
                    bufferedWriter.write(competities.get(i).getTeam(0).getPunten());
                    bufferedWriter.write(competities.get(i).getTeam(1).getNaam());
                    bufferedWriter.write(competities.get(i).getTeam(1).getPunten());
                }
                if (competities.get(i).getWedstrijden() != null) {
                    for (int j = 0; j < competities.get(i).getWedstrijden().size(); j++) {
                        bufferedWriter.write(competities.get(i).getWedstrijd(i).getSpeelDatum().toString() + "\r\n");
                        bufferedWriter.write(competities.get(i).getWedstrijd(i).getTeamThuis().getNaam() + "\r\n");
                        bufferedWriter.write(competities.get(i).getWedstrijd(i).getTeamUit().getNaam() + "\r\n");
                        bufferedWriter.write(competities.get(i).getWedstrijd(i).getTeamThuisScore() + "\r\n");
                        bufferedWriter.write(competities.get(i).getWedstrijd(i).getTeamUitScore() + "\r\n");
                    }
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Het bestand is niet gevonden, zie error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Je hebt een error, namelijk: " + ex.getMessage());
        }
        return true;
    }
}
