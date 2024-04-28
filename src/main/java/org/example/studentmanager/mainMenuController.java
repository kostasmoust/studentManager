package org.example.studentmanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainMenuController {
    @FXML private Button maximizeButton;
    @FXML private Button minimizeButton;
    @FXML private Button classButtonA;
    @FXML private Button classButtonB;
    @FXML private Button classButtonC;
    @FXML private Button classButtonD;
    @FXML private Button classButtonE;
    @FXML private Button classButtonF;

    public void closeApp(MouseEvent event) {

        Platform.exit();

    }

    public void maximizeApp(MouseEvent event) {

        Stage stage = (Stage) maximizeButton.getScene().getWindow();
        stage.setMaximized(true);

    }

    public void minimizeApp(MouseEvent event) {

        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    private void changeToClassAScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonA.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classA-View.fxml"));
        Scene classAScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classAScene);

    }

    @FXML
    private void changeToClassBScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonB.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classB-View.fxml"));
        Scene classBScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classBScene);

    }

    @FXML
    private void changeToClassCScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonC.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classC-View.fxml"));
        Scene classCScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classCScene);

    }

    @FXML
    private void changeToClassDScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonD.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classD-View.fxml"));
        Scene classDScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classDScene);

    }

    @FXML
    private void changeToClassEScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonE.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classE-View.fxml"));
        Scene classEScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classEScene);

    }

    @FXML
    private void changeToClassFScene(MouseEvent event) throws IOException {

        Stage stage = (Stage) classButtonF.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(mainMenu.class.getResource("classF-View.fxml"));
        Scene classFScene = new Scene(loader.load(), 900, 500);
        stage.setScene(classFScene);

    }

}