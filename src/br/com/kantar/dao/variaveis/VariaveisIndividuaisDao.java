/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import br.com.kantar.model.variaveis.VariaveisDomiciliares;
import br.com.kantar.model.variaveis.VariaveisIndividuais;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class VariaveisIndividuaisDao {
    
 private String RawVariaveis;
 private VariaveisIndividuais VariaveisIndividuais;

    public VariaveisIndividuaisDao(String RawVariaveis) {
        this.RawVariaveis = RawVariaveis;
    }
 
 
    public VariaveisIndividuais ObterVariveisIndividuais()
    {
    
    String [] Variaveis = this.RawVariaveis.split(";");
    
    
    
    VariaveisIndividuais = new VariaveisIndividuais
    (
    
          
    Integer.parseInt(Variaveis[0]),//H_PROVINCIA
    Integer.parseInt(Variaveis[1]),//H_CIUDAD
    Integer.parseInt(Variaveis[2]),//H_PARTIDO
    Integer.parseInt(Variaveis[3]),//H_PLAZA
    Integer.parseInt(Variaveis[4]),//I_NSE_AGRUP
    Integer.parseInt(Variaveis[5]),//I_NSE_DESAGREG
    Integer.parseInt(Variaveis[6]),//I_CABLE
    Integer.parseInt(Variaveis[7]),//H_NSE_INT
    Integer.parseInt(Variaveis[8]), //I_COD_IND       
    Integer.parseInt(Variaveis[9]),//I_SEXO
    Integer.parseInt(Variaveis[10]),//I_EDAD
    Integer.parseInt(Variaveis[11]),//I_EDAD_DESAGR.
    Integer.parseInt(Variaveis[12]),//I_JEFE
    Integer.parseInt(Variaveis[13]),//I_AMA
    Integer.parseInt(Variaveis[14]),//I_POS_FAMIL
    Integer.parseInt(Variaveis[15]),//I_AMA_C_NIÑOS_0-2
    Integer.parseInt(Variaveis[16]),//I_AMA_C_NIÑOS_3-5
    Integer.parseInt(Variaveis[17]),//I_EDAD_INT
    Integer.parseInt(Variaveis[18])//I_EDAD_GRILLA 2
                  
            
    );
    
    

    return VariaveisIndividuais;
    
    }
 
    
    public static void main(String[] args) {
        
    }
 
 
}
