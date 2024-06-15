package org.example.studentmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class mainMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Main Menu Scene

        FXMLLoader mainLoader = new FXMLLoader(mainMenu.class.getResource("mainMenuView.fxml"));
        Parent mainMenuRoot = mainLoader.load();
        Scene mainMenuScene = new Scene(mainMenuRoot, 900, 500);
        mainMenuScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        // StudentInfo Scene

        FXMLLoader classLoader = new FXMLLoader(mainMenu.class.getResource("studentInfo.fxml"));
        Parent studentInfoRoot = classLoader.load();
        Scene studentInfoScene = new Scene(studentInfoRoot, 900, 700);
        studentInfoScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        // Gives access to certain things to controllers

        mainMenuController mainController = mainLoader.getController();
        classController studentInfoController = classLoader.getController();
        mainController.setStudentInfoScene(studentInfoScene);
        studentInfoController.setMainMenuScene(mainMenuScene);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setWidth(900);
        stage.setHeight(500);
        stage.setScene(mainMenuScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}