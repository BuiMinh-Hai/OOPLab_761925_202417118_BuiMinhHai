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
    void drawingAreaMouseDragged(MouseEvent event) {
        // Default color for pen
        Color color = Color.BLACK;
        
        // TODO: Update this later for the Eraser logic if needed
        if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() &&
            event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}
