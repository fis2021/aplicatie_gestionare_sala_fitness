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
import org.fis.maven.model.User;
import org.fis.maven.services.GymProgramService;
import org.fis.maven.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class viewTrainersCustomerController {

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
        ArrayList<User> antrenori= UserService.getAntrenori();
        String s="Antrenorii disponibili sunt: \n ";
        for(User antrenor:antrenori){
            s=s+antrenor.getname()+"     "+antrenor.geteMail()+"     "+antrenor.getphoneNumber()+"\n";

        }
        ListaPrograme.setText(s);


    }
}
