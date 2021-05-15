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
        robot.write("Antrenor");
        robot.clickOn("#registerButton");

    }


}