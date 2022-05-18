/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.io;

import br.com.kantar.enums.PAISES;
import br.com.kantar.enums.SAIDAS;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class IOHandle {
   
    
    public File retornaArquivoMet(String DataProducao,PAISES Pais){
        
    File ArquivoMetProducao=null;  
    
    switch(Pais)
    {
    
        case ARGENTINA_GBA:
            ArquivoMetProducao = new File("\\\\kimbrspp565\\ProducaoLatam\\AR\\1.Telepanel\\database\\GBA TSV\\out\\gba tsv\\"+DataProducao+".MET");
        case ARGENTINA_INT:
            ArquivoMetProducao = new File("\\\\kimbrspp565\\ProducaoLatam\\AR\\1.Telepanel\\database\\INT TSV\\out\\int tsv\\"+DataProducao+".MET");            
    
    }
       
    return ArquivoMetProducao;
     
   
    }
    
     public File retornaArquivoCadastro(String DataProducao,PAISES Pais){
    
    
     File ArquivoCadastroProducao =null;
    
    
    switch(Pais)
    {
    
        case ARGENTINA_GBA:
            ArquivoCadastroProducao = new File("\\\\kimbrspp565\\ProducaoLatam\\AR\\1.Telepanel\\database\\GBA TSV\\in\\gba tsv\\2022\\"+DataProducao+".txt");
            break;
        case ARGENTINA_INT:
            ArquivoCadastroProducao = new File("\\\\kimbrspp565\\ProducaoLatam\\AR\\1.Telepanel\\database\\INT TSV\\in\\int tsv\\2022\\"+DataProducao+".txt");            
           break;
    
    }

     return ArquivoCadastroProducao;
     
   
    }
     
     
     public File retornaArquivoSaida(SAIDAS Saida){
     
     File arquivoSaida=null;    
         
         switch(Saida)
    {
    
        case CADASTRODOMICILIAR:
            arquivoSaida = new File("tempOutFiles/DomCadatro.csv");
        case CADASTROINDIVIDUAL:
            arquivoSaida = new File("tempOutFiles/IndividuoCadatro.csv");            
        case METINDIVIDUAL:
            arquivoSaida = new File("tempOutFiles/IndividuoMet.csv");    
        case METDOMICILIAR:
            arquivoSaida = new File("tempOutFiles/DomicilioMet.csv");     
    }
     
     return arquivoSaida;
     
     }
     
     
}
