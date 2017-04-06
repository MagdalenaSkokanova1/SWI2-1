/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author pompi20
 */
public class ElearningServiceException extends RuntimeException{    
    
    public ElearningServiceException() {
        super();
    }

    public ElearningServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElearningServiceException(String message) {
        super(message);
    }
    
}
