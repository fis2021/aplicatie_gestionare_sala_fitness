package org.fis.maven.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.fis.maven.model.GymProgram;
import org.fis.maven.services.GymProgramService;

import java.io.IOException;
import java.util.ArrayList;

public class viewGymProgramCustomerController {

    @FXML
    private Button backButton;
    @FXML
    private TextArea ListaPrograme;

    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("gymDetails.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 695, 535);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }

    @FXML
    public void initialize(){
        ArrayList<GymProgram> programe= GymProgramService.getPrograms();
        String s="Antrenament         Ziua        Ora          Descriere       \n ";
        for(GymProgram gym:programe){
            s=s+" "+gym.getAntrenament()+"      "+gym.getZiua()+"      "+gym.getOra()+"     "+gym.getDescriere()+"\n";

        }
        ListaPrograme.setText(s);


    }
}
