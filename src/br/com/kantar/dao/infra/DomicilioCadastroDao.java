/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.infra;

import br.com.kantar.model.infra.DomicilioCadastro;
import br.com.kantar.enums.PAISES;
import br.com.kantar.model.infra.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import static br.com.kantar.util.CadastroUtil.efetuaDivisaoPorDom;
import static br.com.kantar.util.CadastroUtil.incluiPontosInterrupcao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author eduax
 */
public class DomicilioCadastroDao {

    DomicilioCadastro DomCadastro;
    Set ConjuntoDons = new HashSet();
    PAISES Pais;
    private final File ArquivoCadastro;
    private final Connection ConexaoBaseDeDados;

    public DomicilioCadastroDao(PAISES Pais, File ArquivoCadastro) throws Exception {
        
        this.Pais = Pais;
        this.ArquivoCadastro = ArquivoCadastro;
        ConexaoBaseDeDados = new br.com.kantar.connectionFactory.Connection().getConnection();
        
    }


    public boolean checarPermissividadeInsercao() throws SQLException{
    
        
        
        
        PreparedStatement ps = this.ConexaoBaseDeDados.prepareStatement("select * from \"domicilioCadastro\" where codregion=? and fecha=?");
        
        java.sql.Date DataProdSQLConverted = java.sql.Date.valueOf( recuperarDataArquivo(this.ArquivoCadastro) );
        
        ps.setInt(1, this.Pais.getCodigo());
        ps.setDate(2,DataProdSQLConverted);
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()){
        
            return true;
        
        }
        
        return false;
        
    }
    
    
    public void gravarDadosMassivos() throws SQLException{

        
        if(checarPermissividadeInsercao()){
        
        PreparedStatement PreparacaoConexao=  
        this.ConexaoBaseDeDados.prepareStatement
        ("copy \"domicilioCadastro\" "
     + "(fecha,codregion,hogarid,\"personaCounter\",\"tvCounter\",\"edadJefe\",nse,\"cableOperator\",nino12_17,nino_4_11,tienenino) "
      + "FROM 'c:\\temp\\DomCadastro.csv' DELIMITER ';' CSV;");
        PreparacaoConexao.executeUpdate(); 
        
        }

         

    
    }
    
    
    private boolean valida4_11(String[] PrimeiraLinha) {

        if (PrimeiraLinha[13].equals("1")) {

            return true;

        }

        return false;
    }

    private boolean valida12_17(String[] PrimeiraLinha) {

        if (PrimeiraLinha[15].equals("1")) {

            return true;

        }

        return false;
    }

    private boolean validaCabo(String[] PrimeiraLinha) {

        if (PrimeiraLinha[7].equals("1")) {

            return true;

        }

        return false;
    }

    private boolean validaSeTemCrianca(String[] PrimeiraLinha) {

        return PrimeiraLinha[13].equals("1") || PrimeiraLinha[15].equals("1");
    }

    private DomicilioCadastro retornaObjetoDomicilioCadastro(
            String[] PrimeiraLinha, String[] LinhasSubjacentes, LocalDate DataArquivo) {

        if (LinhasSubjacentes.length > 10) {

            if (LinhasSubjacentes[36].equals("1")) {

                DomCadastro
                        = new DomicilioCadastro(
                                Integer.parseInt(PrimeiraLinha[4]),
                                validaCabo(PrimeiraLinha),
                                Integer.parseInt(PrimeiraLinha[33]),
                                Integer.parseInt(PrimeiraLinha[32]),
                                Integer.parseInt(LinhasSubjacentes[38]),
                                validaSeTemCrianca(PrimeiraLinha),
                                valida4_11(PrimeiraLinha),
                                valida12_17(PrimeiraLinha),
                                Integer.parseInt(PrimeiraLinha[31]),
                                Integer.parseInt(PrimeiraLinha[0]), DataArquivo, new Regiao(PAISES.ARGENTINA_GBA.getCodigo(), PAISES.ARGENTINA_GBA.getDescricaoPais())
                        );

            }

        }

        return DomCadastro;
    }

    public Set<DomicilioCadastro> ObterInformacoesCadastraisIndividuais() throws IOException {

        Set<DomicilioCadastro> ValoresDons = new LinkedHashSet();

        LocalDate DataArquivo = recuperarDataArquivo(this.ArquivoCadastro);

        StringBuilder CadastroModificado = incluiPontosInterrupcao(ArquivoCadastro);

        String[] ValoresCadastroAgregados = efetuaDivisaoPorDom(CadastroModificado);

        for (int a = 1; a < ValoresCadastroAgregados.length; a++) {

            String[] ValoresCadastroLinha = ValoresCadastroAgregados[a].split("\n");

            ///Trabalhar dados primeira linha
            String[] ValoresDentroDaLinhaPrimeiraLinha = ValoresCadastroLinha[0].split(",");

            for (int i = 1; i < ValoresCadastroLinha.length; i++) {

                String[] ValoresDentroDaLinhaSegundoLinha = ValoresCadastroLinha[i].split(",");

                if (ValoresDentroDaLinhaSegundoLinha.length > 10) {

                    ValoresDons.add(retornaObjetoDomicilioCadastro(ValoresDentroDaLinhaPrimeiraLinha, ValoresDentroDaLinhaSegundoLinha, DataArquivo));

                }

            }

        }

        return ValoresDons;
    }

    public void printData() throws IOException, Exception{
    
        Set<DomicilioCadastro> x = new DomicilioCadastroDao(this.Pais,this.ArquivoCadastro).ObterInformacoesCadastraisIndividuais();
        try (PrintWriter Gravador = new PrintWriter("tempOutFiles/DomCadastro.csv")) {
            for (DomicilioCadastro d : x) {
                
                Gravador.println(
                        d.getData()
                                + ";" + d.getRegiao().getCodRegiao()
                                + ";" + d.getId() + ";"
                                + d.getQuantidadeIndivudos() + ";"
                                + d.getQuantidadeTelevisores() + ";"
                                + d.getIdadeChefe() + ";"
                                + d.getNse() + ";"
                                + d.getCaboOperador() + ";"
                                + d.isFaixaIdadeCrianca12_17() + ";"
                                + d.isFaixaIdadeCrianca4_11() + ";"
                                + d.isTemCrianca()
                                + d.isCable() + ";"
                );
                
            }
        }
    
    
    }
    
    
    
    public static void main(String[] args) throws IOException, Exception {

      
        DomicilioCadastroDao d = new DomicilioCadastroDao(PAISES.ARGENTINA_GBA,new File("in/20220517.txt"));
       // d.printData();

        d.gravarDadosMassivos();

    }

}
