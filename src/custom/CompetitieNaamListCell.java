package custom;

import javafx.scene.control.ListCell;
import models.Competitie;

public class CompetitieNaamListCell extends ListCell<Competitie> {
    @Override
    protected void updateItem(Competitie item, boolean empty) {
        super.updateItem(item, empty);

        setText(empty ? "" : item.getNaam());
    }
}
