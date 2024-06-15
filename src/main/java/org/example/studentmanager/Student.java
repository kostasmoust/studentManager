package org.example.studentmanager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty studentCode;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty DOB;
    private final StringProperty email;
    private final StringProperty address;
    private final StringProperty city;

    public Student(String studentCode, String firstName, String lastName,
            String DOB, String email, String address, String city) {
        this.studentCode = new SimpleStringProperty(studentCode);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.DOB = new SimpleStringProperty(DOB);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);

    }

    public String getStudentCode() {return studentCode.get();}
    public StringProperty studentCodeProperty() {return studentCode;}

    public String getFirstName() {return firstName.get();}
    public StringProperty firstNameProperty() {return firstName;}

    public String getLastName() {return lastName.get();}
    public StringProperty lastNameProperty() {return lastName;}

    public String getDOB() {return DOB.get();}
    public StringProperty DOBProperty() {return DOB;}

    public String getEmail() {return email.get();}
    public StringProperty emailProperty() {return email;}

    public String getAddress() {return address.get();}
    public StringProperty addressProperty() {return address;}

    public String getCity() {return city.get();}
    public StringProperty cityProperty() {return city;}

}
