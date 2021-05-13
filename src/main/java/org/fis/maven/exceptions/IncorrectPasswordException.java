package org.fis.maven.exceptions;

public class IncorrectPasswordException extends Exception{
    private String password;
    public IncorrectPasswordException (String password) {
        super(String.format("Username-ul exista deja sau parola introdusa este incorecta!"));
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
