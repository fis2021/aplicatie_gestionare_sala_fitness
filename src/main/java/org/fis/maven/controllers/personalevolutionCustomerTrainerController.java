package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.maven.model.User;
import org.fis.maven.services.CustomerEvolutionService;

import org.fis.maven.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class personalevolutionCustomerTrainerController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField  kilograms;
    @FXML
    private TextField hightCentimeters;
    @FXML
    private TextField waistCentimeters;
    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;
    @FXML
    private TextArea ListaClienti;
    @FXML
    private Text text;

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

    public void handleAdd() {
        try {
            CustomerEvolutionService.addCustomerEvolution(nameField.getText(), kilograms.getText(), hightCentimeters.getText(), waistCentimeters.getText());
            text.setText("Adaugare Reusita!");
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            text.setText("Adaugare Nereusita");
        }
    }

}