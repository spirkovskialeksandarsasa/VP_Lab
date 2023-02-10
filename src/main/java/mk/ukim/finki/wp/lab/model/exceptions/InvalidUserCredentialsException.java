package mk.ukim.finki.wp.lab.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException(){
        super("Invalid User Credentials");
    }
}
