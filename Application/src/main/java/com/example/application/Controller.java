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

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addNewUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    void initialize() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have successfully entered the main menu!  Click OK to continue!");
        alert.showAndWait();
        System.out.println("Main menu");

        addNewUserButton.setOnAction(actionEvent -> {
            addNewUserButton.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("addUser.fxml"));
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("addUser.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}
