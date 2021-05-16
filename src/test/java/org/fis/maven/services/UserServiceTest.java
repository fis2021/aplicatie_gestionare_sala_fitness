package org.fis.maven.services;

import org.apache.commons.io.FileUtils;
import org.fis.maven.exceptions.UsernameAlreadyExistsException;
import org.fis.maven.exceptions.WrongPasswordException;
import org.fis.maven.model.User;
import org.junit.jupiter.api.*;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceTest {

    public static final String ADMIN = "admin";



   @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }


    @AfterEach
    void tearDown() {
        UserService.getDatabase().close();
    }


    @Test
    @DisplayName("Database is initialized and there are no users")

    void testDatabaseIsInitialized()
    {

        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is successfully persisted to database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException
    {

        UserService.addUser(ADMIN, ADMIN, ADMIN,ADMIN,ADMIN,ADMIN);
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(ADMIN);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN,ADMIN));
        assertThat(user.getRole()).isEqualTo(ADMIN);
        assertThat(user.getname()).isEqualTo(ADMIN);
        assertThat(user.geteMail()).isEqualTo(ADMIN);
        assertThat(user.getphoneNumber()).isEqualTo(ADMIN);
    }



    @Test
    @DisplayName("Check password")
    void testCheckPassword() {
        assertThrows(WrongPasswordException.class,()->{
            UserService.addUser(ADMIN, ADMIN, ADMIN,ADMIN,ADMIN,ADMIN);
            UserService.checkPassword("aaa",ADMIN);
        });
    }

    @Test
    @DisplayName("Password encoding")
    public void testPasswordEncoding() {
        assertNotEquals("testPass1", UserService.encodePassword("username", "testPass1"));
    }




}