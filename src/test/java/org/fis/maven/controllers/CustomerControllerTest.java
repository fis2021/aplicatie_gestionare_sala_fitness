package org.fis.maven.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis.maven.services.CustomerEvolutionService;
import org.fis.maven.services.FileSystemService;
import org.fis.maven.services.GymProgramService;
import org.fis.maven.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)

class CustomerControllerTest {

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        GymProgramService.initDatabase();
        CustomerEvolutionService.initDatabase();
        GymProgramService.addGymProgram("cardio","Marti","11","Se ard multe calorii");
        UserService.addUser("Ana","1213","Client","Ana","ana@gmail.com","076656253");
        UserService.addUser("Ion","321","Antrenor","Ion","ion@gmail.com","076652233");
        CustomerEvolutionService.addCustomerEvolution("client","70","187","49");
    }
    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Aplicatie Gestionare Sala de Fitness");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }
    @Test
    void testRegistration(FxRobot robot){
        robot.clickOn("#username");
        robot.write("client");
        robot.clickOn("#password");
        robot.write("client1234");
        robot.clickOn("#role");
        robot.clickOn("Client");
        robot.clickOn("#registerButton");
        robot.clickOn("#name");
        robot.write("client");
        robot.clickOn("#eMail");
        robot.write("client@gmail.com");
        robot.clickOn("#phoneNumber");
        robot.write("0785643124");
        robot.clickOn("#saveButton");
        robot.clickOn("#details");
        robot.clickOn("#program");
        robot.clickOn("#back");
        robot.clickOn("#trainer");
        robot.clickOn("#back");
        robot.clickOn("#back");
        robot.clickOn("#selectTrainer");
        robot.clickOn("#nume");
        robot.write("Ion");
        robot.clickOn("#search");
        robot.clickOn("#back");
        robot.clickOn("#personal");
        robot.clickOn("#nume");
        robot.write("client");
        robot.clickOn("#search");
        robot.clickOn("#back");
        robot.clickOn("#selectprog");
        robot.clickOn("#nume");
        robot.write("cardio");
        robot.clickOn("#search");
        robot.clickOn("#back");
        robot.clickOn("#logout");



    }

}