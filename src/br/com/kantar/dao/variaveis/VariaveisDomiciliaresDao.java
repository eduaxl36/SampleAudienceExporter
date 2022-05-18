/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import br.com.kantar.model.variaveis.VariaveisDomiciliares;

/**
 *
 * @author Eduardo.Fernando
 */
public class VariaveisDomiciliaresDao {
    
 private String RawVariaveis;
 private VariaveisDomiciliares VariaveisDomiciliares;

    public VariaveisDomiciliaresDao(String RawVariaveis) {
        this.RawVariaveis = RawVariaveis;
    }
 
 
    public VariaveisDomiciliares ObterVariveisDomiciliares()
    {
    
    String [] Variaveis = this.RawVariaveis.split(";");
    
    VariaveisDomiciliares  = new VariaveisDomiciliares(
            
    Integer.parseInt(Variaveis[0]),//H_PROVINCIA
    Integer.parseInt(Variaveis[1]),//H_CIUDAD
    Integer.parseInt(Variaveis[2]),//H_PARTIDO
    Integer.parseInt(Variaveis[3]),//H_PLAZA
    Integer.parseInt(Variaveis[4]),//I_NSE_AGRUP
    Integer.parseInt(Variaveis[5]),//H_NSE_CAT
    Integer.parseInt(Variaveis[6]),//H_NSE_DES.
    Integer.parseInt(Variaveis[7]),//H_CABLE
    Integer.parseInt(Variaveis[8]), //H_CANT_IND       
    Integer.parseInt(Variaveis[9]), //H_CANT_TVS
    Integer.parseInt(Variaveis[10]),//H_TELEFONO
    Integer.parseInt(Variaveis[11]),//H_VCR.
    Integer.parseInt(Variaveis[12]),//H_INTERNET
    Integer.parseInt(Variaveis[13]),//H_GRUPO_FLIAR
    Integer.parseInt(Variaveis[14]),//H_EDAD_AMA_40
    Integer.parseInt(Variaveis[15]),//H_NIÑOS_0-12
    Integer.parseInt(Variaveis[16]),//H_NIÑOS_4-11
    Integer.parseInt(Variaveis[17]),//H_ADOL_13-19
    Integer.parseInt(Variaveis[18]),//H_ADOL_12-17
    Integer.parseInt(Variaveis[19]),//H_NIÑOS_0
    Integer.parseInt(Variaveis[20]),//H_NIÑOS_1
    Integer.parseInt(Variaveis[21]),//H_NIÑOS_2
    Integer.parseInt(Variaveis[22]),//H_NIÑOS_3
    Integer.parseInt(Variaveis[23]),//H_NIÑOS_4
    Integer.parseInt(Variaveis[24]),//H_NIÑOS_5
    Integer.parseInt(Variaveis[25]),//H_NIÑOS_6
    Integer.parseInt(Variaveis[26]),//H_NIÑOS_7
    Integer.parseInt(Variaveis[27]), //H_NIÑOS_8      
    Integer.parseInt(Variaveis[28]),//H_NIÑOS_9
    Integer.parseInt(Variaveis[29]),//H_NIÑOS_10
    Integer.parseInt(Variaveis[30]),//H_NIÑOS_11
    Integer.parseInt(Variaveis[31]),//H_NIÑOS_12
    Integer.parseInt(Variaveis[32]),//H_PVC_AGR
    Integer.parseInt(Variaveis[33]),//H_PVC_DES
    Integer.parseInt(Variaveis[34])//H_NSE_INT
       

            
    );
    
        
    
    return VariaveisDomiciliares;
    
    }
 
    
    public static void main(String[] args) {
        
    }
 
 
}
