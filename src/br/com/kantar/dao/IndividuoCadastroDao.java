/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao;

import br.com.kantar.model.DomicilioCadastro;
import br.com.kantar.model.IndividuoCadastro;
import br.com.kantar.model.Regiao;
import static br.com.kantar.util.BothUtil.recuperarDataArquivo;
import static br.com.kantar.util.CadastroUtil.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduax
 */
public class IndividuoCadastroDao {

    private IndividuoCadastro retornaObjetoIndividuoCadastro(String[] PrimeiraLinha, String[] LinhasSubjacentes, LocalDate DataArquivo, boolean isJefe) {

        DomicilioCadastro DomCadastro = new DomicilioCadastro(Integer.parseInt(PrimeiraLinha[0]), DataArquivo, new Regiao(1, "ARGENTINA GBA"));
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

    public List<IndividuoCadastro> ObterInformacoesCadastraisIndividuais(File ArquivoCadastro) throws IOException {

        List<IndividuoCadastro> ValoresIndividuos = new ArrayList();

        LocalDate DataArquivo = recuperarDataArquivo(ArquivoCadastro);

        StringBuilder CadastroModificado = incluiPontosInterrupcao(ArquivoCadastro);

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
    
    
    public static void main(String[] args) throws IOException {
        
 
        List<IndividuoCadastro> vals = new IndividuoCadastroDao().ObterInformacoesCadastraisIndividuais(new File("c:/teste/20220511.txt"));

        
        vals.forEach(x->{
        
 System.out.println
        
        (
         
         x.getDomilicio().getData()+";"
        +x.getDomilicio().getRegiao().getCodRegiao()+";"
        +x.getDomilicio().getId()+";"
        +x.getIndividuoId()+";"
        +x.getIndividuoIdade()+";"
        +x.getIndividuoSexo()+";"
        +x.isValidaSeChefe()
        
 
       );
          
        
        });
        
        
        
                
    }
    
    
}
