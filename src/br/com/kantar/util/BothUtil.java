/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.util;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Eduardo.Fernando
 */
public class BothUtil {
    
        public static LocalDate recuperarDataArquivo(File ArquivoCadastro) {

        DateTimeFormatter Formatador = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(ArquivoCadastro.getName().substring(0, 8), Formatador);

    }
}
