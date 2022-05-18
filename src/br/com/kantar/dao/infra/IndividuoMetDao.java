/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.infra;

import br.com.kantar.dao.variaveis.VariaveisIndividuaisDao;
import br.com.kantar.model.infra.DomicilioMet;
import br.com.kantar.model.infra.IndividuoMet;
import br.com.kantar.enums.PAISES;
import br.com.kantar.model.infra.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import br.com.kantar.util.MetUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Eduardo.Fernando
 */
public class IndividuoMetDao {

    private File ArquivoMet;
    private IndividuoMet Individuo;
    private PAISES Pais;
    private VariaveisIndividuaisDao VariavelIndividual;

    
    public IndividuoMetDao(File ArquivoMet, PAISES Pais) {
        this.ArquivoMet = ArquivoMet;
        this.Pais = Pais;
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
      
   public String converteObjetoVariavelToString(String Variaveis){
   
   VariavelIndividual = new VariaveisIndividuaisDao(Variaveis);
   

   String H_PROVINCIA = ""+VariavelIndividual.ObterVariveisIndividuais().getH_PROVINCIA();
   String H_CIUDAD = ""+VariavelIndividual.ObterVariveisIndividuais().getH_CIUDAD();
   String H_PARTIDO = ""+VariavelIndividual.ObterVariveisIndividuais().getH_PARTIDO();        
   String H_PLAZA = ""+VariavelIndividual.ObterVariveisIndividuais().getH_PLAZA();        
   String I_NSE_AGRUP = ""+VariavelIndividual.ObterVariveisIndividuais().getI_NSE_AGRUP();        
   String I_NSE_DESAGREG = ""+VariavelIndividual.ObterVariveisIndividuais().getI_NSE_DESAGREG();        
   String I_CABLE = ""+VariavelIndividual.ObterVariveisIndividuais().getI_CABLE();        
   String H_NSE_INT = ""+VariavelIndividual.ObterVariveisIndividuais().getH_NSE_INT();        
   String I_COD_IND = ""+VariavelIndividual.ObterVariveisIndividuais().getI_COD_IND();        
   String I_SEXO = ""+VariavelIndividual.ObterVariveisIndividuais().getI_SEXO();
   String I_EDAD = ""+VariavelIndividual.ObterVariveisIndividuais().getI_EDAD();
   String I_EDAD_DESAGR = ""+VariavelIndividual.ObterVariveisIndividuais().getI_EDAD_DESAGR();
   String I_JEFE = ""+VariavelIndividual.ObterVariveisIndividuais().getI_JEFE();
   String I_AMA = ""+VariavelIndividual.ObterVariveisIndividuais().getI_AMA();
   String I_POS_FAMIL = ""+VariavelIndividual.ObterVariveisIndividuais().getI_POS_FAMIL();
   String I_AMA_C_NIÑOS_0_2 = ""+VariavelIndividual.ObterVariveisIndividuais().getI_AMA_C_NIÑOS_0_2();
   String I_AMA_C_NIÑOS_3_5 = ""+VariavelIndividual.ObterVariveisIndividuais().getI_AMA_C_NIÑOS_3_5();
   String I_EDAD_INT = ""+VariavelIndividual.ObterVariveisIndividuais().getI_EDAD_INT();
   String I_EDAD_GRILLA_2 = ""+VariavelIndividual.ObterVariveisIndividuais().getI_EDAD_GRILLA_2();

   
   return 
           
   H_PROVINCIA+";"+
   H_CIUDAD+";"+      
   H_PARTIDO+";"+
   H_PLAZA+";"+
   I_NSE_AGRUP+";"+        
   I_NSE_DESAGREG+";"+
   I_CABLE+";"+         
   H_NSE_INT+";"+         
   I_COD_IND+";"+        
   I_SEXO+";"+        
   I_EDAD+";"+        
   I_EDAD_DESAGR+";"+        
   I_JEFE+";"+
   I_AMA+";"+        
   I_POS_FAMIL+";"+        
   I_AMA_C_NIÑOS_0_2+";"+         
   I_AMA_C_NIÑOS_3_5+";"+        
   I_EDAD_INT+";"+
   I_EDAD_GRILLA_2        ;
   
   }         
            
            
            
      
    public String obterDemografica(String ExpressaoIndividual){
    
           
           Matcher RegexPegarDemografica = Pattern.compile("D.*").matcher(ExpressaoIndividual);
           
           if(RegexPegarDemografica.find())    
           {
           VariavelIndividual = new VariaveisIndividuaisDao("");
               return converteObjetoVariavelToString(RegexPegarDemografica.group().replaceAll("D,", "").replaceAll("\\,", ";"));


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
    
     
    
        public List<IndividuoMet>ObterInformacoesMetIndividuais() throws IOException{
    
            
        List<IndividuoMet>Individuos = new ArrayList();  
            
        String[]IndividuosAngariados = angariarDadosIndividuais().toString().split("_");
    
        
        for(String Individuo:IndividuosAngariados){
        
         if(!Individuo.contains("W0.00")){
         
     
    
               
               Individuos.add(obterDadoIndividual(Individuo,recuperarDataArquivo(this.ArquivoMet)));
               
           
           
         
         }
        
        }
        
        
    Individuos.remove(Individuos.size()-1);
    return Individuos;
    
    }
    
    
   public void printData() throws FileNotFoundException, IOException{
   
   
       List<IndividuoMet> Individuos= new IndividuoMetDao(this.ArquivoMet,this.Pais).ObterInformacoesMetIndividuais();
        
        try (PrintWriter Gravador = new PrintWriter("tempOutFiles/IndividuoMet.csv")) {
            for(IndividuoMet Individuo:Individuos){
                
                
                Gravador.println(
                        
                        
                        Individuo.getDomilicio().getData()+";"+
                                Individuo.getDomilicio().getRegiao().getCodRegiao()+";"+
                                Individuo.getDomilicio().getId()+";"+
                                Individuo.getIndividuoId()+";"+
                                Individuo.getIndividuoPeso()+";"+
                                Individuo.getIndividuoVariaveis()
                        
                        
                        
                );
                
                
            }
        }
   
   
   } 
        
        
        
    public static void main(String[] args) throws IOException {
        
        new IndividuoMetDao(new File("in/20220514.MET"),PAISES.ARGENTINA_GBA).printData();
      
        
    }
            
    
}
