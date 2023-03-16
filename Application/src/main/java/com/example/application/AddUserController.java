package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirmAddUserButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField email_field;

    @FXML
    private Button getInfoButton;

    @FXML
    private Button hideInfoButton;

    @FXML
    private Button goBackButton;

    @FXML
    private TextField name_field;

    @FXML
    private TextField personalID_field;

    @FXML
    private TextField phoneNumber_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextArea user1Area;

    @FXML
    private TextArea user2Area;

    @FXML
    private TextArea user3Area;

    @FXML
    private TextArea user4Area;

    @FXML
    private TextField userNRtoDelete;

    @FXML
    void initialize() {

        ArrayList<CreateNewUser> users = new ArrayList<>();
        CreateNewUser user = new CreateNewUser();
        CreateNewUser user1 = new CreateNewUser(
                "John",
                "Doe",
                "180378-21951",
                "john.doe@gmail.com",
                "958185819124"
        );

        CreateNewUser user2 = new CreateNewUser(
                "Alex",
                "McCalister",
                "210991-12951",
                "alex.mccalister@gmail.com",
                "554645863456"
        );
        CreateNewUser user3 = new CreateNewUser(
                "Steve",
                "Harlow",
                "180190-192954",
                "steve.harlow@gmail.com",
                "412812414232"
        );

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have successfully entered the user adding menu! Click OK to continue!");
        alert.showAndWait();
        System.out.println("User adding menu");

        confirmAddUserButton.setOnAction(actionEvent -> {

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "You have successfully added one user! Click OK to continue!");
            alert1.showAndWait();
            System.out.println("User added");

        });

        getInfoButton.setOnAction(actionEvent -> {

            String nameText = name_field.getText().trim();
            String surnameText = surname_field.getText().trim();
            String personalIDText = personalID_field.getText().trim();
            String emailText = email_field.getText().trim();
            String phoneNumberText = phoneNumber_field.getText();

            user.setName(nameText);
            user.setSurname(surnameText);
            user.setPersonalID(personalIDText);
            user.setEmail(emailText);
            user.setPhoneNumber(phoneNumberText);

            name_field.clear();
            surname_field.clear();
            personalID_field.clear();
            email_field.clear();
            phoneNumber_field.clear();

            String textArea1 = user1Area.getText();
            String textArea2 = user2Area.getText();
            String textArea3 = user3Area.getText();
            String textArea4 = user4Area.getText();

            if (textArea1 == null) {
                user1Area.setText(" ");
            } else {
                user1Area.setText(user.getUserInfo());
            }

            if (textArea2 == null) {
                user2Area.setText(" ");
            } else {
                user2Area.setText(user1.getUserInfo());
            }

            if (textArea3 == null) {
                user3Area.setText(" ");
            } else {
                user3Area.setText(user2.getUserInfo());
            }

            if (textArea4 == null) {
                user4Area.setText(" ");
            } else {
                user4Area.setText(user3.getUserInfo());
            }

        });

        hideInfoButton.setOnAction(actionEvent -> {
            user1Area.setText(" ");
            user2Area.setText(" ");
            user3Area.setText(" ");
            user4Area.setText(" ");
        });

        goBackButton.setOnAction(actionEvent -> {
            goBackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "You have successfully entered the main menu! Click OK to continue!");
            alert2.showAndWait();
            System.out.println("Main menu");
        });


        deleteButton.setOnAction(actionEvent -> {
            String IDtoDelete = userNRtoDelete.getText().trim();

            if (IDtoDelete.equals("1")) {
                user.deleteUserInfo();
                user1Area.setText(" ");
                System.out.println("User 1 has been deleted");
                user.equals(null);
            } else if (IDtoDelete.equals("2")) {
                user1.deleteUserInfo();
                user2Area.setText(" ");
                System.out.println("User 2 has been deleted");
                user1.equals(null);
            } else if (IDtoDelete.equals("3")) {
                user2.deleteUserInfo();
                user3Area.setText(" ");
                System.out.println("User 3 has been deleted");
                user2.equals(null);
            } else if (IDtoDelete.equals("4")) {
                user3.deleteUserInfo();
                user4Area.setText(" ");
                System.out.println("User 4 has been deleted");
                user3.equals(null);
            } else {
                Alert alert6 = new Alert(Alert.AlertType.INFORMATION, "There is no user with entered number! Click OK to try again!");
                alert6.showAndWait();
            }

        });
    }

}

