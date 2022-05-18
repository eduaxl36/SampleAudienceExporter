/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.infra;

import br.com.kantar.dao.variaveis.VariaveisDomiciliaresDao;
import br.com.kantar.dao.variaveis.VariaveisIndividuaisDao;
import br.com.kantar.model.infra.DomicilioMet;
import br.com.kantar.enums.PAISES;
import br.com.kantar.model.infra.Regiao;
import br.com.kantar.model.variaveis.VariaveisDomiciliares;
import br.com.kantar.model.variaveis.VariaveisIndividuais;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import br.com.kantar.util.MetUtil;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Eduardo.Fernando
 */
public class DomicilioMetDao {

    private final File ArquivoMet;
    
    private DomicilioMet Dom;
    private final PAISES Pais;

    private final String RegexDom = "I.*";
    private final String RegexPeso = "W.*";
    
    private VariaveisDomiciliaresDao VariavelDomiciliar;
    

    

    public DomicilioMetDao(File ArquivoMet, PAISES Pais) {

        this.ArquivoMet = ArquivoMet;
        this.Pais = Pais;

    }

    public long obterDomicilio(String ExpressaoIndividual) {

        Matcher RegexPegarDomicilio = Pattern.compile(RegexDom).matcher(ExpressaoIndividual);
        if (RegexPegarDomicilio.find()) {

            return Long.parseLong(RegexPegarDomicilio.group().substring(1, 9));

        }

        return 0;

    }

    public float obterPeso(String ExpressaoIndividual) {

        Matcher RegexPegarPeso = Pattern.compile(RegexPeso).matcher(ExpressaoIndividual);
        if (RegexPegarPeso.find()) {

            return Float.parseFloat(RegexPegarPeso.group().replaceAll("W", ""));

        }

        return 0;

    }

    

     public String converteObjetoVariavelToString(String Variaveis){
   
   VariavelDomiciliar = new VariaveisDomiciliaresDao(Variaveis);
   

   String H_PROVINCIA = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_PROVINCIA();
   String H_CIUDAD = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getCIUDAD();
   String H_PARTIDO = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_PARTIDO();        
   String H_PLAZA = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getPLAZA();        
   String H_NSE_AGR = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NSE_AGR();        
   String H_NSE_CAT = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NSE_CAT();        
   String H_NSE_DES = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NSE_DES();        
   String H_CABLE = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_CABLE();        
   String H_CANT_IND = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_CANT_IND();        
   String H_CANT_TVS = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_CANT_TVS();
   String H_TELEFONO = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_TELEFONO();
   String H_VCR = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_VCR();
   String H_INTERNET = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_INTERNET();
   String H_GRUPO_FLIAR = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_GRUPO_FLIAR();
   String H_EDAD_AMA_40 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_EDAD_AMA_40();
   String H_NIÑOS_0_12 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NINOS_0_12();
   String H_NIÑOS_4_11 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NINOS_4_11();
   String H_ADOL_13_19 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_ADOL_13_19();
   String H_ADOL_12_17 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_ADOL_12_17();
   String H_NIÑOS_0 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_0();        
   String H_NIÑOS_1 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_1();        
   String H_NIÑOS_2 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_2();        
   String H_NIÑOS_3 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_3();        
   String H_NIÑOS_4 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_4();
   String H_NIÑOS_5 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_5();
   String H_NIÑOS_6 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_6();
   String H_NIÑOS_7 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_7();
   String H_NIÑOS_8 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_8();
   String H_NIÑOS_9 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_9();
   String H_NIÑOS_10 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_10();
   String H_NIÑOS_11= ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_11();
   String H_NIÑOS_12 = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NIÑOS_12();
   String H_PVC_AGR = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_PVC_AGR();
   String H_PVC_DES = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_PVC_DES();
   String H_NSE_INT = ""+VariavelDomiciliar.ObterVariveisDomiciliares().getH_NSE_INT();
   
   
   
   return 
           
   H_PROVINCIA+";"+
   H_CIUDAD+";"+      
   H_PARTIDO+";"+
   H_PLAZA+";"+
   H_NSE_AGR+";"+        
   H_NSE_CAT+";"+
   H_NSE_DES+";"+              
   H_CABLE+";"+        
   H_CANT_IND+";"+        
   H_CANT_TVS+";"+        
   H_TELEFONO+";"+        
   H_VCR+";"+
   H_INTERNET+";"+        
   H_GRUPO_FLIAR+";"+        
   H_EDAD_AMA_40+";"+         
   H_NIÑOS_0_12+";"+        
   H_NIÑOS_4_11+";"+
   H_ADOL_13_19+";"+
   H_ADOL_12_17+";"+        
   H_NIÑOS_0+";"+
   H_NIÑOS_1+";"+
   H_NIÑOS_2+";"+
   H_NIÑOS_3+";"+
   H_NIÑOS_4+";"+
   H_NIÑOS_5+";"+
   H_NIÑOS_6+";"+
   H_NIÑOS_7+";" +
   H_NIÑOS_8+";" +  
   H_NIÑOS_9+";" +  
   H_NIÑOS_10+";" +  
   H_NIÑOS_11+";" +
   H_NIÑOS_12+";"+
   H_PVC_AGR+";" +  
   H_PVC_DES+";"+
   H_NSE_INT;
   
   }
    
    
    public String obterDemografica(String ExpressaoIndividual) {

        Matcher RegexPegarDemografica = Pattern.compile("D.*").matcher(ExpressaoIndividual);

        if (RegexPegarDemografica.find()) {

            return converteObjetoVariavelToString(RegexPegarDemografica.group().replaceAll("D,", "").replaceAll("\\,", ";"));

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

    public DomicilioMet obterDadoDomiciliar(String ExpressaoIndividual) {

        Dom = new DomicilioMet(
                obterPeso(ExpressaoIndividual),
                obterDemografica(ExpressaoIndividual),
                obterDomicilio(ExpressaoIndividual),
                recuperarDataArquivo(this.ArquivoMet),
                new Regiao(Pais.getCodigo(), Pais.getDescricaoPais())
        );

        return Dom;

    }

    public List<DomicilioMet> ObterInformacoesMetDomiciliares() throws IOException {

        List<DomicilioMet> Dons = new ArrayList();

        String[] DomiciliaresAngariados = angariarDadosDomiciliares().toString().split("_");

        for (String Dom : DomiciliaresAngariados) {

            if (!Dom.contains("0.00")) {

                Dons.add(obterDadoDomiciliar(Dom));

            }

        }

        return Dons;

    }

    public void printData() throws IOException {

        List<DomicilioMet> Domicilios = new DomicilioMetDao(this.ArquivoMet, this.Pais).ObterInformacoesMetDomiciliares();

        Domicilios.removeIf(Dom -> Dom.getVariaveis() == null);

        try ( PrintWriter Gravador = new PrintWriter("tempOutFiles/DomicilioMet.csv")) {
            for (DomicilioMet Dom : Domicilios) {

                Gravador.println(Dom.getData() 
                         + ";" + Dom.getRegiao().getCodRegiao() 
                         + ";" + Dom.getId() + ";" 
                         + Dom.getPeso() + ";" 
                         + Dom.getVariaveis());

            }
        }

    }

    
    public static void main(String[] args) throws IOException {
        
        new DomicilioMetDao(new File("in/20220514.MET"), PAISES.ARGENTINA_GBA).printData();
        
        
    }
    
    
}
