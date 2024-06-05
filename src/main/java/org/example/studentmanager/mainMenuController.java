package org.example.studentmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class mainMenuController {
    @FXML
    Button exitButton;
    @FXML
    Button minimizeButton;
    @FXML
    Button maximizeButton;

    @FXML
    public void exitApp(MouseEvent event) {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minimizeApp(MouseEvent event) {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void maximizeApp(MouseEvent event) {

        Stage stage = (Stage) maximizeButton.getScene().getWindow();
        if (stage.isMaximized() == true) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }

    }
}
