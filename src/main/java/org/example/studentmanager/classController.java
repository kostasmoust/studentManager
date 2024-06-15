//TODO change file output from button click
//Todo Add Student from file Functionality
//Todo Delete Student from file functionality

package org.example.studentmanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class classController {
    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student, String> studentCodeColumn;
    @FXML private TableColumn<Student, String> firstNameColumn;
    @FXML private TableColumn<Student, String> lastNameColumn;
    @FXML private TableColumn<Student, String> DOBColumn;
    @FXML private TableColumn<Student, String> emailColumn;
    @FXML private TableColumn<Student, String> addressColumn;
    @FXML private TableColumn<Student, String> cityColumn;

    private final ObservableList<Student> data = FXCollections.observableArrayList();
    private Scene mainMenuScene;

    @FXML
    private void initialize() {
        studentCodeColumn.setCellValueFactory(cellData -> cellData.getValue().studentCodeProperty());
        firstNameColumn.setCellValueFactory((cellData -> cellData.getValue().firstNameProperty()));
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        DOBColumn.setCellValueFactory(cellData -> cellData.getValue().DOBProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        loadDataFromFile("src/main/resources/classInfoFiles/data.txt");
    }

    private void loadDataFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 7) {
                    String studentCode = parts[0].trim();
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    String DOB = parts[3].trim();
                    String email = parts[4].trim();
                    String address = parts[5].trim();
                    String city = parts[6].trim();
                    data.add(new Student(studentCode, firstName, lastName, DOB, email,
                            address, city));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableView.setItems(data);
    }

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
    public void maxmimizeApp (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (stage.isMaximized() == true) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }

    @FXML
    public void goToMainMenu (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainMenuScene);
    }

    public void setMainMenuScene (Scene scene) {
        this.mainMenuScene = scene;
    }

    @FXML
    private void addStudentButton(MouseEvent event) {
        Stage popUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader(classController.class.getResource("addStudent.fxml"));
        Parent addStudentRoot = loader.getController();
        Scene addStudentScene = new Scene(addStudentRoot, 400, 600);
        popUpStage.setTitle("Add Student");
        popUpStage.showAndWait();
    }

}