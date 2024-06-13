/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Usuario
 */
public class ValidationService {
     public static boolean validEmailUser(String email) {
        if (email == null) {
            return false;
        }
        return email.endsWith("@gmail.com");
    }
}
