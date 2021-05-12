package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerPageController {

    @FXML
    private Button gymdetailsButton;
    @FXML
    private Button selecttrainerButton;
    @FXML
    private Button personalevolutionButton;
    @FXML
    private Button selectprogramButton;
    @FXML
    private Button logoutButton;

    @FXML
    public void handleLogout(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("login.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 650, 450);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    @FXML
    public void showGymDetails(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("gymDetails.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 695, 535);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }
}
