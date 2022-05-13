/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author eduax
 */
public class CadastroUtil {

    private static final String REGEXDOM = "\\d{5,6}.*";

    public static StringBuilder incluiPontosInterrupcao(File Cadastro) throws FileNotFoundException, IOException {

        BufferedReader Leitor = new BufferedReader(new FileReader(Cadastro));
        String LinhaArquivo = Leitor.readLine();
        StringBuilder Acumulador = new StringBuilder();

        while (LinhaArquivo != null) {

            if (LinhaArquivo.matches(REGEXDOM)) {

                Acumulador.append("@").append(LinhaArquivo).append("\n");

            } else {

                Acumulador.append(LinhaArquivo).append("\n");

            }

            LinhaArquivo = Leitor.readLine();
        }

        return Acumulador;

    }

    public static String[] efetuaDivisaoPorDom(StringBuilder RegistroAcumulado) {

        return RegistroAcumulado.toString().split("@");

    }



}
