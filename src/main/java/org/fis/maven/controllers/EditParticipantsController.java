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
import org.fis.maven.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class EditParticipantsController {

    @FXML
    TextField Nume;
    @FXML
    TextField Email;
    @FXML
    TextField Telefon;
    @FXML
    private Button AddButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button BackButton;
    @FXML
    private TextArea ListaParticipanti;
    @FXML
    private Text text;

    @FXML
    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("administratorPage.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 651, 450);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }


    @FXML
    public void initialize(){
        ArrayList<User> participanti = UserService.getClienti();
        String s="Nume          E-mail           Nr.Telefon    \n ";
        for(User participant:participanti){
            s=s+participant.getname()+"     "+participant.geteMail()+"     "+participant.getphoneNumber()+"\n";

        }
        ListaParticipanti.setText(s);


    }

    @FXML
    public void handleAdd() {
        try {
            UserService.addUser(Nume.getText(),"ParolaClient","Client",Nume.getText(), Email.getText(), Telefon.getText());
            text.setText("Adaugare Reusita!");
            initialize();
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            text.setText("Adaugare Nereusita");
        }
    }

    public void handleDelete() {
        try {
            UserService.deleteTrainer_User(Nume.getText(), Email.getText(), Telefon.getText());
            initialize();
            text.setText("Stergere Reusita!");
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            text.setText("Stergere Nereusita");
        }
    }
}
