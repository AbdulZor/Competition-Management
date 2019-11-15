package comparators;

import models.Wedstrijd;

import java.util.Comparator;

/**
 * Deze klasse sorteert wedstrijden op speeldatum
 *
 * @author Abdul Vahip Zor
 */

public class wedstrijdDatumSorteren implements Comparator<Wedstrijd> {
    @Override
    public int compare(Wedstrijd wedstrijd1, Wedstrijd wedstrijd2) {
        return wedstrijd1.compareTo(wedstrijd2);
    }

    @Override
    public String toString() {
        return "wedstrijdDatumSorteren";
    }
}