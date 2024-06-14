package org.example.studentmanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class mainMenuController {
    @FXML
    Button exitButton;
    @FXML
    Button minimizeButton;
    @FXML
    Button maximizeButton;

    public Scene studentInfoScene;
    public Scene mainMenuScene;

    @FXML
    public void exitApp(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minimizeApp(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void maximizeApp(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (stage.isMaximized() == true) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }

    }

    //TODO find a way to make the sceneChange work that doesnt brake one or the other.

    @FXML
    public void changeScene(MouseEvent event) throws IOException{

        // Student Info Scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentInfo.fxml"));
        Parent classRoot = loader.load();
        Scene scene = new Scene(classRoot);
        mainMenuController mainController = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setMainMenuScene(Scene scene) {
        this.mainMenuScene = scene;
    }


}
