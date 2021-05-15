package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.maven.exceptions.IncorrectPasswordException;
import org.fis.maven.exceptions.UsernameAlreadyExistsException;
import org.fis.maven.services.UserService;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Text message;
    @FXML
    private Button registerButton;


    @FXML
    public void initialize() {
        role.getItems().addAll("Client","Antrenor","Manager");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            Stage stage = new Stage();

            boolean test = UserService.checkUserDoesAlreadyExist(usernameField.getText());
            Stage primaryStage = (Stage) registerButton.getScene().getWindow();
            primaryStage.close();
            if (test) {
                if (((String) role.getValue()).equals("Client")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("customerPage.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                } else if (((String) role.getValue()).equals("Manager")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("administratorPage.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                } else if (((String) role.getValue()).equals("Antrenor")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("customerPage.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            }

            if (!test) {
                if (((String) role.getValue()).equals("Client")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("registerCustomer.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    RegisterCustomerController reg = loader.getController();
                    reg.setUsernameField(usernameField);
                    reg.setPasswordField(passwordField);
                    reg.setRole(role);
                } else if (((String) role.getValue()).equals("Manager")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("registerAdministrator.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    RegisterAdministratorController reg = loader.getController();
                    reg.setUsernameField(usernameField);
                    reg.setPasswordField(passwordField);
                    reg.setRole(role);
                } else if (((String) role.getValue()).equals("Antrenor")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("registerTrainer.fxml"));
                    Parent root = (Parent) loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    RegisterTrainerController reg = loader.getController();
                    reg.setUsernameField(usernameField);
                    reg.setPasswordField(passwordField);
                    reg.setRole(role);
                }
            }
        } catch (UsernameAlreadyExistsException e) {
            message.setText(e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare!!");
        }
    }

    public void goToLogin(javafx.event.ActionEvent login) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("register.fxml"));
        Parent viewLogin = Loader.load();
        Scene LoginScene = new Scene(viewLogin, 650, 450);
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }
}
