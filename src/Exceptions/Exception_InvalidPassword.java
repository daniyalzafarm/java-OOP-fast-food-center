/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author DANIYAL ZAFAR
 */
public class Exception_InvalidPassword extends Exception{

    public Exception_InvalidPassword()  {
    super("Invalid Username or Password");
    }
    
}
