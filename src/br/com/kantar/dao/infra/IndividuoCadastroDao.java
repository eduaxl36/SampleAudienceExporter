/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.infra;

import br.com.kantar.model.infra.DomicilioCadastro;
import br.com.kantar.model.infra.IndividuoCadastro;
import br.com.kantar.enums.PAISES;
import br.com.kantar.model.infra.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import static br.com.kantar.util.CadastroUtil.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author eduax
 */
public class IndividuoCadastroDao {

    private File ArquivoCadastro;
    private PAISES Pais;

    public IndividuoCadastroDao() {
    }

    public IndividuoCadastroDao(File ArquivoCadastro, PAISES Pais) {
     
        
        this.ArquivoCadastro = ArquivoCadastro;
        this.Pais = Pais;
    }

    private IndividuoCadastro retornaObjetoIndividuoCadastro(String[] PrimeiraLinha, String[] LinhasSubjacentes, LocalDate DataArquivo, boolean isJefe) {

        DomicilioCadastro DomCadastro = new DomicilioCadastro(Integer.parseInt(PrimeiraLinha[0]), DataArquivo, new Regiao(Pais.getCodigo(), Pais.getDescricaoPais()));
        IndividuoCadastro IndCadastro
                = new IndividuoCadastro(
                        Integer.parseInt(LinhasSubjacentes[38]),
                        Integer.parseInt(LinhasSubjacentes[37]),
                        isJefe,
                        Integer.parseInt(LinhasSubjacentes[35]),
                        DomCadastro
                );
        return IndCadastro;
    }

    public List<IndividuoCadastro> ObterInformacoesCadastraisIndividuais() throws IOException {

        
        List<IndividuoCadastro> ValoresIndividuos = new ArrayList();

        LocalDate DataArquivo = recuperarDataArquivo(this.ArquivoCadastro);

        StringBuilder CadastroModificado = incluiPontosInterrupcao(this.ArquivoCadastro);

        String[] ValoresCadastroAgregados = efetuaDivisaoPorDom(CadastroModificado);

        for (int a = 1; a < ValoresCadastroAgregados.length; a++) {

            String[] ValoresCadastroLinha = ValoresCadastroAgregados[a].split("\n");

            ///Trabalhar dados primeira linha
            String[] ValoresDentroDaLinhaPrimeiraLinha = ValoresCadastroLinha[0].split(",");

            for (int b = 0; b < ValoresCadastroLinha.length; ++b) {

                ///Ignora cabeçalhos para trabalhar demais linhas'
                if (b != 0) {

                    String[] ValoresDentroDaLinhaSubjacentes = ValoresCadastroLinha[b].split(",");

                    if (ValoresDentroDaLinhaSubjacentes.length > 10) {

                        if (ValoresDentroDaLinhaSubjacentes[38].matches("\\d{1,}.*")) {

                            boolean isjefe = false;

                            if (ValoresDentroDaLinhaSubjacentes[36].equals("1")) {

                                isjefe = true;

                            }
                            ValoresIndividuos.add(retornaObjetoIndividuoCadastro(ValoresDentroDaLinhaPrimeiraLinha, ValoresDentroDaLinhaSubjacentes, DataArquivo, isjefe));

                        }

                    }

                }

            }

        }
        return ValoresIndividuos;
    }

    public void printData() throws IOException {

        List<IndividuoCadastro> Individuos = new IndividuoCadastroDao(this.ArquivoCadastro,this.Pais).ObterInformacoesCadastraisIndividuais();
        try (PrintWriter Gravador = new PrintWriter("tempOutFiles/IndividuoCadastro.csv")) {
            Individuos.forEach(x -> {
                
                Gravador.println(
                        x.getDomilicio().getData() + ";"
                                + x.getDomilicio().getRegiao().getCodRegiao() + ";"
                                + x.getDomilicio().getId() + ";"
                                + x.getIndividuoId() + ";"
                                + x.getIndividuoIdade() + ";"
                                + x.getIndividuoSexo() + ";"
                                + x.isValidaSeChefe()
                );
                
            });
        }

    }

    public static void main(String[] args) throws IOException {

      IndividuoCadastroDao d = new IndividuoCadastroDao(new File("in/20220514.txt"),PAISES.ARGENTINA_GBA);

       d.printData();

    }

}
