package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Change color based on selected tool
        Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;
        
        // Ensure drawing is within bounds
        if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() &&
            event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}
