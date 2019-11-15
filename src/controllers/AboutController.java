package controllers;

import javafx.scene.control.TextArea;

/**
 * Logica van het "over"-scherm
 *
 * @author HvA HBO-ICT
 */
public class AboutController extends BaseController {

    private TextArea melding;

    /**
     * Wanneer deze methode wordt aangeroepen, is het veilig om bijv. "melding" aan te passen.
     */
    public void initialize() {
        melding.setText("Deze applicatie is gemaakt door <Abdul Vahip Zor>, <500799742>, <IS-105>!");
    }

    public void setMelding(TextArea melding) {
        this.melding = melding;
    }
}
