
package org.fis.maven.controllers;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
        import org.apache.commons.io.FileUtils;
        import org.fis.maven.services.FileSystemService;
        import org.fis.maven.services.GymProgramService;
        import org.fis.maven.services.UserService;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.testfx.api.FxRobot;
        import org.testfx.framework.junit5.ApplicationExtension;
        import org.testfx.framework.junit5.Start;

        import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)

class AdminControllerTest {
    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        GymProgramService.initDatabase();
        GymProgramService.addGymProgram("cardio","Marti","11","Se ard multe calorii");
        UserService.addUser("Ana","1213","Client","Ana","ana@gmail.com","076656253");
        UserService.addUser("Ion","321","Antrenor","Ion","ion@gmail.com","076652233");
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
        robot.write("admin");
        robot.clickOn("#password");
        robot.write("admin1234");
        robot.clickOn("#role");
        robot.clickOn("Manager");
        robot.clickOn("#registerButton");
        robot.clickOn("#name");
        robot.write("admin");
        robot.clickOn("#eMail");
        robot.write("admin@gmail.com");
        robot.clickOn("#phoneNumber");
        robot.write("0785643124");
        robot.clickOn("#key");
        robot.write("1234");
        robot.clickOn("#saveButton");
        robot.clickOn("#editProgram");
        robot.clickOn("#antrenament");
        robot.write("yoga");
        robot.clickOn("#ziua");
        robot.write("Joi");
        robot.clickOn("#ora");
        robot.write("17");
        robot.clickOn("#descriere");
        robot.write("Antrenament Relaxant");
        robot.clickOn("#add");
        robot.clickOn("#delete");
        robot.clickOn("#back");
        robot.clickOn("#addParticipants");
        robot.clickOn("#nume");
        robot.write("pop maria");
        robot.clickOn("#email");
        robot.write("popmaria@gmail.com");
        robot.clickOn("#tel");
        robot.write("0765341298");
        robot.clickOn("#add");
        robot.clickOn("#delete");
        robot.clickOn("#back");
        robot.clickOn("#editTrainers");
        robot.clickOn("#nume");
        robot.write("pop maria");
        robot.clickOn("#email");
        robot.write("popmaria@gmail.com");
        robot.clickOn("#tel");
        robot.write("0765341298");
        robot.clickOn("#add");
        robot.clickOn("#delete");
        robot.clickOn("#back");
        robot.clickOn("#log");


    }


}