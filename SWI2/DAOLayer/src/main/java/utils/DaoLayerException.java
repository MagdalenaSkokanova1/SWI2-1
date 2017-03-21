/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.springframework.dao.DataAccessException;
/**
 *
 * @author pompi20
 */
public class DaoLayerException extends DataAccessException {

    public DaoLayerException(String msg) {
        super(msg);
    }

    public DaoLayerException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
    

