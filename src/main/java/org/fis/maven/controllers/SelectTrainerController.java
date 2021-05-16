package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.model.CustomerEvolution;
import org.fis.maven.model.User;
import org.fis.maven.services.CustomerEvolutionService;
import org.fis.maven.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class SelectTrainerController {
    @FXML
    private Button BackButton;

    @FXML
    private TextField nume;
    @FXML
    private Button SearchButton;
    @FXML
    private TextArea ListaAntrenori;
    @FXML
    private TextArea ListaAntrenor;


    @FXML
    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("customerPage.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 610, 440);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }


    @FXML
    public void initialize(){
        ArrayList<User> antrenori= UserService.getAntrenori();
        String s="Nume          E-mail           Nr.Telefon    \n ";
        for(User antrenor:antrenori){
            s=s+antrenor.getname()+"     "+antrenor.geteMail()+"     "+antrenor.getphoneNumber()+"\n";

        }
        ListaAntrenori.setText(s);


    }

    @FXML
    public void write (){
        ArrayList<User> antrenori = UserService.getAntrenori();
        String s="Nume          E-mail              Nr. Telefon        \n";
        for(User c:antrenori ) {
            if (nume.getText().equals(c.getname())) {
                s = s + c.getname() + "          " + c.geteMail() + "       " + c.getphoneNumber() + "\n";
            }
        }
        ListaAntrenor.setText(s);
    }
}