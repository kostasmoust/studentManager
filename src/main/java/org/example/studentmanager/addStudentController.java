package org.example.studentmanager;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addStudentController {

    @FXML
    private TextField studentCodeInput;
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField DOBInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField addressInput;
    @FXML
    private TextField cityInput;


    private Scene studentInfoScene;

    @FXML
    public void exitApp (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void minimizeApp (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void goToStudentInfoScene (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(studentInfoScene);
    }

    @FXML
    private void submitDataIntoFile(MouseEvent event){
        String studentCode = studentCodeInput.getText();
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String DOB = DOBInput.getText();
        String email = emailInput.getText();
        String address = addressInput.getText();
        String city = cityInput.getText();
        String newStudent = studentCode + ":" + firstName + ":" + lastName + ":" +
                DOB + ":" + email + ":" + address + ":" + city;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/classInfoFiles/data.txt", true))){
            writer.write(newStudent + "\n");
            System.out.println("Data saved");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        goToStudentInfoScene(event);

    }

    public void setStudentInfoScene(Scene scene) {
        this.studentInfoScene = scene;
    }
}
