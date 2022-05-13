/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao;

import br.com.kantar.model.DomicilioMet;
import br.com.kantar.model.PAISES;
import br.com.kantar.model.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import br.com.kantar.util.MetUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Eduardo.Fernando
 */
public class DomicilioMetDao {
    
    private File ArquivoMet;
    private DomicilioMet Dom;
    private PAISES Pais;
    
    
    public DomicilioMetDao(File ArquivoMet,PAISES Pais) {

    this.ArquivoMet = ArquivoMet;
    this.Pais = Pais;
    
    }
    
      public long obterDomicilio(String ExpressaoIndividual){
    
    
           Matcher RegexPegarDomicilio = Pattern.compile("I.*").matcher(ExpressaoIndividual);
           if(RegexPegarDomicilio.find())
           {
               
           return Long.parseLong(RegexPegarDomicilio.group().substring(1,9));
           
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
            
    
    public StringBuilder angariarDadosDomiciliares() throws IOException {

        StringBuilder Acumulador = new StringBuilder();
        String[] DadosDomiciliares = MetUtil.incluiPontosInterrupcao(ArquivoMet);

        for (String Dom : DadosDomiciliares) {

            Matcher RegexPegarIndividuo = Pattern.compile("I\\d{1,}.*\r\n.*\r\n.*").matcher(Dom);

            while (RegexPegarIndividuo.find()) {

                Acumulador.append(RegexPegarIndividuo.group() + "\n" + "_\n");

            }

        }

        return Acumulador;
    }
    
    
    
       public DomicilioMet obterDadoDomiciliar(String ExpressaoIndividual){
       
       

                       Dom = new DomicilioMet(
                               
                               obterPeso(ExpressaoIndividual),
                               obterDemografica(ExpressaoIndividual),
                               obterDomicilio(ExpressaoIndividual),
                               recuperarDataArquivo(this.ArquivoMet),
                               new Regiao(Pais.getCodigo(),Pais.getDescricaoPais())
                               
                                );
                       
              
           return Dom;
 
       }
       
       
       
       
       
       
         public List<DomicilioMet>ObterInformacoesMetDomiciliares() throws IOException{
    
            
        List<DomicilioMet>Dons = new ArrayList();  
            
        String[]DomiciliaresAngariados = angariarDadosDomiciliares().toString().split("_");
    
        
        for(String Dom:DomiciliaresAngariados){
        
         if(!Dom.contains("0.00")){
         
         
               Dons.add(obterDadoDomiciliar(Dom));
         
         }
        
        }
        
        
    
    return Dons;
    
    }
         
         
     
         
    
    
    public static void main(String[] args) throws IOException {
        
        
       List<DomicilioMet>d=   new DomicilioMetDao(new File("c:/teste/20220512.MET"),PAISES.ARGENTINA_GBA).ObterInformacoesMetDomiciliares();
       
       d.removeIf(x->x.getVariaveis()==null);
       
       for(DomicilioMet x:d){
       
       
           System.out.println(x.getData()+";"+x.getRegiao().getCodRegiao()+";"+x.getId()+";"+x.getPeso()+";"+x.getVariaveis());
       
       }
       

       
    }
    
  
    
}
