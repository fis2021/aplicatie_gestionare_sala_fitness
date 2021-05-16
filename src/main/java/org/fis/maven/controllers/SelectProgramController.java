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
import org.fis.maven.model.GymProgram;
import org.fis.maven.model.User;
import org.fis.maven.services.GymProgramService;
import org.fis.maven.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class SelectProgramController {
    @FXML
    private Button BackButton;
    @FXML
    private TextField nume;
    @FXML
    private Button SearchButton;
    @FXML
    private TextArea ListaPrograme;
    @FXML
    private TextArea ListaProgram;


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
        ArrayList<GymProgram> programe= GymProgramService.getPrograms();
        String s="Antrenament          Ziua           Ora        Descriere\n ";
        for(GymProgram gym:programe){
            s=s+gym.getAntrenament()+"     "+gym.getZiua()+"     "+gym.getOra()+"     "+gym.getDescriere()+"\n";

        }
        ListaPrograme.setText(s);


    }

    @FXML
    public void write (){
        ArrayList<GymProgram> programe= GymProgramService.getPrograms();
        String s="Antrenament          Ziua           Ora        Descriere\n ";
        for(GymProgram gym:programe){
            if (nume.getText().equals(gym.getAntrenament())) {
                s=s+gym.getAntrenament()+"     "+gym.getZiua()+"     "+gym.getOra()+"     "+gym.getDescriere()+"\n";
            }
        }
        ListaProgram.setText(s);
    }
}