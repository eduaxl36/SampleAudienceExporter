/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Eduardo.Fernando
 */
public class MetUtil {

    private static final String RegexSepDom = "Z.*\r\nD.*\r\nW.*";

    public static String[] incluiPontosInterrupcao(File MetFile) throws FileNotFoundException, IOException {


        String Content = FileUtils.readFileToString(MetFile, "UTF-8");

        String DadosMet[] = Content.replaceAll("\t", "\n").replaceAll("I", "F I").split("F ");

        return DadosMet;
       

    }

    
   
    
    
    public static void main(String[] args) throws IOException {
        
        
        
        System.out.println(incluiPontosInterrupcao(new File("c:\\teste\\teste.MET")));
    }
    
    
}
