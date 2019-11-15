package comparators;

import models.Competitie;

import java.util.Comparator;

/**
 * Deze klasse sorteert competities op naam van A-Z
 *
 * @author Abdul Vahip Zor
 */

public class competitieAZsorteren implements Comparator<Competitie> {

    @Override
    public int compare(Competitie o1, Competitie o2) {
        return o1.getNaam().compareTo(o2.getNaam());
    }

    @Override
    public String toString() {
        return "competitieAZsorteren{}";
    }
}
