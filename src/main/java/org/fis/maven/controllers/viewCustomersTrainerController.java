package org.fis.maven.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.fis.maven.model.User;
import org.fis.maven.services.UserService;
import java.io.IOException;
import java.util.ArrayList;
public class viewCustomersTrainerController {
    @FXML
    private Button backButton;
    @FXML
    private TextArea ListaClienti;
    @FXML
    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("trainerPage.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 647, 454);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
    @FXML
    public void initialize(){
        ArrayList<User> clienti= UserService.getClienti();
        String s="Clientii disponibili sunt: \n ";
        for(User client:clienti){
            s=s+client.getname()+"     "+client.geteMail()+"     "+client.getphoneNumber()+"\n";
        }
        ListaClienti.setText(s);

    }
}