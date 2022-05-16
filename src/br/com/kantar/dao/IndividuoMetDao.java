/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao;

import br.com.kantar.model.DomicilioMet;
import br.com.kantar.model.IndividuoMet;
import br.com.kantar.model.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import br.com.kantar.util.MetUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class IndividuoMetDao {

    private File ArquivoMet;
    private IndividuoMet Individuo;
    
    
    public IndividuoMetDao(File ArquivoMet) {
    
        this.ArquivoMet = ArquivoMet;
        
    }
  
    
    public long obterDomicilio(String ExpressaoIndividual){
    
    
           Matcher RegexPegarDomicilio = Pattern.compile("Z.*").matcher(ExpressaoIndividual);
           if(RegexPegarDomicilio.find())
           {
               
           return Long.parseLong(RegexPegarDomicilio.group().substring(1,9));
           
           }
    
    return 0;
    
    }
   
    
      public int obterIndividuo(String ExpressaoIndividual){
    
    
           Matcher RegexPegarIndividuo = Pattern.compile("Z.*").matcher(ExpressaoIndividual);
           if(RegexPegarIndividuo.find())
           {
               
           return Integer.parseInt(RegexPegarIndividuo.group().substring(RegexPegarIndividuo.group().length()-3,RegexPegarIndividuo.group().length()));
           
           }
    
    return 0;
    
    }  
    
      
            public float obterPeso(String ExpressaoIndividual){
    
    
           Matcher RegexPegarPeso = Pattern.compile("W.*").matcher(ExpressaoIndividual);
           if(RegexPegarPeso.find())    
           {
           
                return Float.parseFloat(RegexPegarPeso.group().replaceAll("W", ""));
           
           }
                 
    
    return 0;
    
    }  
      
      
    public String obterDemografica(String ExpressaoIndividual){
    
    
           Matcher RegexPegarDemografica = Pattern.compile("D.*").matcher(ExpressaoIndividual);
           
           if(RegexPegarDemografica.find())    
           {
           
               return RegexPegarDemografica.group().replaceAll("D,", "").replaceAll("\\,", ";");


           }
    return null;
    }        
            
    
    public StringBuilder angariarDadosIndividuais() throws IOException {

        StringBuilder Acumulador = new StringBuilder();
        String[] DadosIndividuais = MetUtil.incluiPontosInterrupcao(ArquivoMet);

        for (String Individuos : DadosIndividuais) {

            Matcher RegexPegarIndividuo = Pattern.compile("Z.*\r\nD.*\r\nW.*").matcher(Individuos);

            while (RegexPegarIndividuo.find()) {

                Acumulador.append(RegexPegarIndividuo.group() + "\n" + "_\n");

            }

        }

        return Acumulador;
    }
    
    
       public IndividuoMet obterDadoIndividual(String ExpressaoIndividual,LocalDate DataArquivo){
       
       
           Matcher RegexIndividuo = Pattern.compile("Z.*").matcher(ExpressaoIndividual);
           if(RegexIndividuo.find())
           {
                      

                       Individuo = new IndividuoMet(
                       obterPeso(ExpressaoIndividual), 
                       obterDemografica(ExpressaoIndividual), 
                       obterIndividuo(ExpressaoIndividual),
                       new DomicilioMet(obterDomicilio(ExpressaoIndividual),DataArquivo,new Regiao(1,"Argentina GBA"))
                              
                       
               );

           
           }
       
           return Individuo;
 
       }
    
     
    
        public Set<IndividuoMet>ObterInformacoesMetIndividuais() throws IOException{
    
            
        Set<IndividuoMet>Individuos = new LinkedHashSet();  
            
        String[]IndividuosAngariados = angariarDadosIndividuais().toString().split("_");
    
        
        for(String Individuo:IndividuosAngariados){
        
         if(!Individuo.contains("W0.00")){
         
     
    
               
               Individuos.add(obterDadoIndividual(Individuo,recuperarDataArquivo(this.ArquivoMet)));
               
           
           
         
         }
        
        }
        
        
    
    return Individuos;
    
    }
    
    
        
    public void printData() throws FileNotFoundException, IOException{
    
       Set<IndividuoMet> Individuos= new IndividuoMetDao(this.ArquivoMet).ObterInformacoesMetIndividuais();
        try (PrintWriter Gravador = new PrintWriter("tempOutFiles/IndividuoMet.csv")) {
            Individuos.forEach(Individuo -> {
                Gravador.println(
                        
                        
                        Individuo.getDomilicio().getData()+";"+
                                Individuo.getDomilicio().getRegiao().getCodRegiao()+";"+
                                Individuo.getDomilicio().getId()+";"+
                                Individuo.getIndividuoId()+";"+
                                Individuo.getIndividuoPeso()+";"+
                                Individuo.getIndividuoVariaveis()
                        
                        
                        
                );
            });
        }
       
    }    
        
    
    public static void main(String[] args) throws IOException {
        
       new IndividuoMetDao(new File("in/20220515.MET")).printData();
        
      
        
    }
            
    
}
