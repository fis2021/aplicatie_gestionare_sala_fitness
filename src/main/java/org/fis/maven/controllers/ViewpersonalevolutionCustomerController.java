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
import org.fis.maven.model.CustomerEvolution;
import org.fis.maven.services.CustomerEvolutionService;

import java.io.IOException;
import java.util.ArrayList;

public class ViewpersonalevolutionCustomerController {
    @FXML
    private Button BackButton;
    @FXML
    private TextArea ListaEvolutie;
    @FXML
    private TextField nume;
    @FXML
    private Button SearchButton;
    @FXML
    private Text text;

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
    public void write (){
        ArrayList<CustomerEvolution> evolutii = CustomerEvolutionService.getevolutii();
        String s="Nume          Kilograme         Inaltime          CentimetriiTaliei    \n";
        for(CustomerEvolution c:evolutii ) {
            if (nume.getText().equals(c.getname())) {
                s = s + c.getname() + "          " + c.getKg() + "       " + c.getInaltimea() + "       " + c.getCentimetriiTaliei() + "\n";
            }
        }
        ListaEvolutie.setText(s);
    }
}
