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
import org.fis.maven.model.GymProgram;
import org.fis.maven.services.GymProgramService;
import java.io.IOException;
import java.util.ArrayList;
public class EditProgramController {
    @FXML
    TextField Antrenament;
    @FXML
    TextField Ziua;
    @FXML
    TextField Ora;
    @FXML
    TextField Descriere;
    @FXML
    private Button AddButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button BackButton;
    @FXML
    private TextArea ListaPrograme;
    @FXML
    private Text text;

    public void goBack(javafx.event.ActionEvent register) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("trainerPage.fxml"));
        Parent viewRegister = Loader.load();
        Scene RegisterScene = new Scene(viewRegister, 650, 450);
        Stage window = (Stage) ((Node) register.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
    public void handleAdd() {
        try {
            GymProgramService.addGymProgram(Antrenament.getText(), Ziua.getText(), Ora.getText(), Descriere.getText());
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
            GymProgramService.deleteGymProgram(Antrenament.getText(), Ziua.getText(), Ora.getText(), Descriere.getText());
            initialize();
            text.setText("Stergere Reusita!");
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            text.setText("Stergere Nereusita");
        }
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