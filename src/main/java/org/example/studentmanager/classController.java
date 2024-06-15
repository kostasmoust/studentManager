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
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


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
    private Scene addStudentScene;

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

    @FXML
    private void refreshTableView (MouseEvent event) {
        data.clear();
        initialize();
    }

    @FXML
    private void deleteSelectedRows() {
        ObservableList<Student> selectedRows = tableView.getSelectionModel().getSelectedItems();

        data.removeAll(selectedRows);

        removeDataFromFile(selectedRows);

        tableView.getSelectionModel().clearSelection();
    }

    private void removeDataFromFile(ObservableList<Student> studentsToRemove) {
        ObservableList<Student> allStudents = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/classInfoFiles/data.txt"))) {
            readDataFile(br, allStudents);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/classInfoFiles/data.txt"))) {
            for (Student student : allStudents) {
                if (!studentsToRemove.contains(student)) {
                    writer.write(student.getStudentCode() + ":" + student.getFirstName() + ":" + student.getLastName() + ":" +
                            student.getDOB() + ":" + student.getEmail() + ":" + student.getAddress() + ":" + student.getCity() + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }
    }

    private void readDataFile(BufferedReader br, ObservableList list) throws IOException {
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
                list.add(new Student(studentCode, firstName, lastName, DOB, email,
                        address, city));
            }
        }
    }

    private void loadDataFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            readDataFile(br, data);
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
    public void goToMainMenu (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainMenuScene);
    }

    public void setMainMenuScene (Scene scene) {
        this.mainMenuScene = scene;
    }

    public void setAddStudentScene (Scene scene) {
        this.addStudentScene = scene;
    }

    @FXML
    private void goToAddStudentScene(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addStudentScene);
    }



}