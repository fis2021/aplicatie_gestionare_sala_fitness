package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class GymDetailsController {

    @FXML
    private Button gymProgramButton;
    @FXML
    private Button trainersButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button backButton;

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
    public void handleViewGymDetails(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("viewGymProgramCustomer.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 690, 490);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    @FXML
    public void handleViewTrainers(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("viewTrainersCustomer.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 662, 497);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("customerPage.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 610, 440);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
}
