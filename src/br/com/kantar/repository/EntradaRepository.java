/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.repository;

import br.com.kantar.dao.DomicilioCadastroDao;
import br.com.kantar.dao.DomicilioMetDao;
import br.com.kantar.dao.IOHandle;
import br.com.kantar.dao.IndividuoCadastroDao;
import br.com.kantar.dao.IndividuoMetDao;
import br.com.kantar.enums.PAISES;
import java.io.IOException;

/**
 *
 * @author Eduardo.Fernando
 */
public class EntradaRepository {
 
    private DomicilioMetDao DomicilioMet;
    private DomicilioCadastroDao DomicilioCadastro;
    private IndividuoCadastroDao IndividuoCadastro;
    private IndividuoMetDao IndividuoMet;
    private PAISES Pais;
    private String DataProducaoFormatada;
  
    
    public EntradaRepository(PAISES Pais, String DataProducaoFormatada) {
        this.Pais = Pais;
        this.DataProducaoFormatada = DataProducaoFormatada;
    }

    
    public void gerarDomicilioMet() throws IOException{
    
    DomicilioMet = new DomicilioMetDao(new IOHandle().retornaArquivoMet(DataProducaoFormatada, this.Pais),this.Pais);
    DomicilioMet.printData();
    
    }
    
    
    public void gerarIndividuoMet() throws IOException{
    
    IndividuoMet = new IndividuoMetDao(new IOHandle().retornaArquivoMet(DataProducaoFormatada, this.Pais),this.Pais);
    IndividuoMet.printData();
    
    }  
 
    
    public void gerarIndividuoCadastro() throws IOException{
    
    IndividuoCadastro = new IndividuoCadastroDao(new IOHandle().retornaArquivoCadastro(DataProducaoFormatada, this.Pais),this.Pais);
    IndividuoCadastro.printData();
    
    }        
      
    
    public void gerarDomicilioCadastro() throws IOException{
    
    DomicilioCadastro = new DomicilioCadastroDao(this.Pais,new IOHandle().retornaArquivoCadastro(DataProducaoFormatada, this.Pais));
    DomicilioCadastro.printData();
    
    }         
      
      
    public static void main(String[] args) throws IOException {
                
    new EntradaRepository(PAISES.ARGENTINA_GBA, "20220517").gerarDomicilioMet();
    new EntradaRepository(PAISES.ARGENTINA_GBA, "20220517").gerarIndividuoMet();
    new EntradaRepository(PAISES.ARGENTINA_GBA, "20220517").gerarIndividuoCadastro(); 
    new EntradaRepository(PAISES.ARGENTINA_GBA, "20220517").gerarDomicilioCadastro();
    }
    
    
}
