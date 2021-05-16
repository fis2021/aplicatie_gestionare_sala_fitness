package org.fis.maven;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis.maven.services.FileSystemService;
import org.fis.maven.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)

class RegistrationTest {
    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
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
        robot.write("user1");
        robot.clickOn("#password");
        robot.write("password1");
        robot.clickOn("#role");
        robot.clickOn("Antrenor");
        robot.clickOn("#registerButton");
        robot.clickOn("#name");
        robot.write("user1");
        robot.clickOn("#eMail");
        robot.write("user1@gmail.com");
        robot.clickOn("#phoneNumber");
        robot.write("0785643124");
        robot.clickOn("#saveButton");
        robot.clickOn("#viewClients");
        robot.clickOn("#goBack");
        robot.clickOn("#addClients");
        robot.clickOn("#nameField");
        robot.write("Pop Vasile");
        robot.clickOn("#kilograms");
        robot.write("63");
        robot.clickOn("#hight");
        robot.write("178");
        robot.clickOn("#waist");
        robot.write("50cm");
        robot.clickOn("#save");
        robot.clickOn("#back");

    }


}