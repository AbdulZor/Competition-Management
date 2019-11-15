import comparators.competitieZAsorteren;
import models.Competitie;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deze klasse test de Comparator klasse competitieZAsorteren
 *
 * @author Abdul Vahip Zor
 */

public class competitieZAsorterenTest {
    private List<Competitie> competities;
    private Competitie competitie1;
    private Competitie competitie2;
    private Competitie competitie3;

    @Before
    public void setUp() throws Exception {
        competitie1 = new Competitie("EK vrouwen");
        competitie2 = new Competitie("EK mannen");
        competitie3 = new Competitie("Eredivisie");
        competities = new ArrayList<>();
        competities.add(competitie1);
        competities.add(competitie2);
        competities.add(competitie3);
    }

    @After
    public void tearDown() throws Exception {
        competitie1 = null;
        competitie2 = null;
        competitie3 = null;
        competities = null;
    }

    @Test
    public void compare() {
        Collections.sort(competities, new competitieZAsorteren());
        assertEquals("EK vrouwen", competities.get(0).getNaam());
        assertEquals("EK mannen", competities.get(1).getNaam());
        assertEquals("Eredivisie", competities.get(2).getNaam());

        for (Competitie competitie : competities) {
            System.out.println(competitie);
        }
    }
}