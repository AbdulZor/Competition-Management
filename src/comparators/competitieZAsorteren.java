package comparators;

import models.Competitie;

import java.util.Comparator;

/**
 * Deze klasse sorteert competities op naam van Z-A
 *
 * @author Abdul Vahip Zor
 */

public class competitieZAsorteren implements Comparator<Competitie> {

    @Override
    public int compare(Competitie competitie1, Competitie competitie2) {
        if (competitie1.getNaam().compareTo(competitie2.getNaam()) == 1){
            return -1;
        }else if (competitie1.getNaam().compareTo(competitie2.getNaam()) == -1){
            return 1;
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "competitieZAsorteren";
    }
}