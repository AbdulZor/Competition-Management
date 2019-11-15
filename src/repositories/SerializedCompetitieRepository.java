package repositories;

import models.Competitie;

import java.io.*;
import java.util.ArrayList;

public class SerializedCompetitieRepository implements CompetitieRepository {
    private CompetitieRepository competitieRepository;
    private ArrayList<Competitie> competities;

    public SerializedCompetitieRepository() {
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

    }

    @Override
    public void remove(Competitie competitie) {
        competities.remove(competitie);
    }

    @Override
    public boolean load() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("out/data.ser"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

//            Competitie competitie = (Competitie) objectInputStream.readObject();
            for (Competitie competitie: competities) {
                competities.add((Competitie) objectInputStream.readObject());
            }
        } catch (Exception ex) {
            System.out.println("Je hebt een ERROR, namelijk: " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean save() {
        final String FILE = "out/data.ser";
        File file = new File(FILE);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (int i = 0; i < competities.size(); i++) {
                objectOutputStream.writeObject(competities.get(i));
            }
            objectOutputStream.flush();
        } catch (Exception ex) {
            System.out.println("ERROR tijdens schrijven van objecten: " + ex.getMessage());
            return false;
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
