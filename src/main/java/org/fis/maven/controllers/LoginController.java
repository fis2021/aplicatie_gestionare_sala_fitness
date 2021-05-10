package org.fis.maven.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.exceptions.WrongPasswordException;
import org.fis.maven.model.User;
import org.fis.maven.services.UserService;
import java.io.IOException;
import java.util.Objects;
import static org.fis.maven.services.UserService.getUsers;
public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    private static String loggedUsername;
    @FXML
    private static String loggedRole;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client","Antrenor","Manager");
    }
    @FXML
    public void handleLoginAction(javafx.event.ActionEvent homepage) throws IOException {
        try {
            UserService.loginUser(username.getText(), password.getText());
            for (User user : getUsers().find()) {
                if(Objects.equals(username.getText(), user.getUsername())) {
                    this.loggedUsername = user.getUsername();
                    this.loggedRole = user.getRole();
                }
            }
            if(loggedRole.equals("Customer")) {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("customerPage.fxml"));
                Parent viewCustomerPage = Loader.load();
                Scene customerPageScene = new Scene(viewCustomerPage, 650, 450);
                Stage window = (Stage) ((Node) homepage.getSource()).getScene().getWindow();
                window.setScene(customerPageScene);
                window.show();
            }
            if (loggedRole.equals("Administrator")) {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("administratorPage.fxml"));
                Parent viewAdministratorPage = Loader.load();
                Scene administratorPageScene = new Scene(viewAdministratorPage, 650, 450);
                Stage window = (Stage) ((Node) homepage.getSource()).getScene().getWindow();
                window.setScene(administratorPageScene);
                window.show();
            }
        } catch (WrongPasswordException e) {
            password.clear();
        }
    }
    public void goToRegistration(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("register.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 650, 450);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
    public static String getLoggedUsername() { return loggedUsername;}
}
