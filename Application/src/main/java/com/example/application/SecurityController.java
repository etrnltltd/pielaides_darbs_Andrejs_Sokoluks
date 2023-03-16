package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SecurityController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signinButton;

    @FXML
    private TextField username_field;

    private final String username = "admin1";
    private final String password = "admin1";

    @FXML
    void initialize() {

        signinButton.setOnAction(actionEvent -> {
            String usernameText = username_field.getText().trim();
            String passwordText = password_field.getText().trim();

            if(passwordText.equals(password) && usernameText.equals(username)) {
                signinButton.getScene().getWindow().hide();
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
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong username or password!  Click OK to try again!");
                alert.showAndWait();
                System.out.println("Wrong username or password");
                username_field.clear();
                password_field.clear();
            }
        });

    }

}
