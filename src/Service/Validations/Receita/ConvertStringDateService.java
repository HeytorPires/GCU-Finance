/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Validations.Receita;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author heyto
 */
public class ConvertStringDateService {
    public static String converterDataParaMySQL(String texto) {
        String regex = "\\b(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-(\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        
        if (matcher.find()) {
            String dataMySQL = matcher.group(3) + "-" + matcher.group(2) + "-" + matcher.group(1);
            return dataMySQL;
        } else {
            return null; // Retorna null se não encontrar uma data no formato especificado
        }
    }
}
