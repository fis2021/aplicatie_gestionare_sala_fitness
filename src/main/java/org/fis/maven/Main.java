package org.fis.maven;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis.maven.services.CustomerEvolutionService;
import org.fis.maven.services.FileSystemService;
import org.fis.maven.services.GymProgramService;
import org.fis.maven.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        GymProgramService.initDatabase();
        CustomerEvolutionService.initDatabase();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Aplicatie Gestionare Sala de Fitness");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}