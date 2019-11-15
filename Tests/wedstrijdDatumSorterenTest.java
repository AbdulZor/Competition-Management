import comparators.wedstrijdDatumSorteren;
import models.Wedstrijd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Deze klasse test de Comparator klasse wedstrijdDatumSorteren
 *
 * @author Abdul Vahip Zor
 */

public class wedstrijdDatumSorterenTest {
    List<Wedstrijd> wedstrijds;
    Wedstrijd wedstrijd1;
    Wedstrijd wedstrijd2;
    Wedstrijd wedstrijd3;

    @Before
    public void setUp() throws Exception {
        wedstrijds = new ArrayList<>();
        wedstrijd1 = new Wedstrijd(LocalDate.of(2019, 3, 17));
        wedstrijd2 = new Wedstrijd(LocalDate.of(2019, 3, 16));
        wedstrijd3 = new Wedstrijd(LocalDate.of(2019, 3, 18));

        wedstrijds.add(wedstrijd1);
        wedstrijds.add(wedstrijd2);
        wedstrijds.add(wedstrijd3);
    }

    @After
    public void tearDown() throws Exception {
        wedstrijd1 = null;
        wedstrijd2 = null;
        wedstrijd3 = null;
        wedstrijds = null;
    }

    @Test
    public void compare() {
        Collections.sort(wedstrijds, new wedstrijdDatumSorteren());
        assertEquals(wedstrijd2.getSpeelDatum(), wedstrijds.get(0).getSpeelDatum());
        assertEquals(wedstrijd1.getSpeelDatum(), wedstrijds.get(1).getSpeelDatum());
        assertEquals(wedstrijd3.getSpeelDatum(), wedstrijds.get(2).getSpeelDatum());

        for (Wedstrijd wedstrijd : wedstrijds) {
            System.out.println(wedstrijd.getSpeelDatum());
        }
    }
}