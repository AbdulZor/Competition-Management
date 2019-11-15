package repositories;

import models.Competitie;

import java.util.ArrayList;

public interface CompetitieRepository {
    ArrayList<Competitie> getAll();
    void add(Competitie competitie);
    void update(Competitie competitie);
    void remove(Competitie competitie);
    boolean load();
    boolean save();
}
