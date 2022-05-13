/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model;

import java.time.LocalDate;

/**
 *
 * @author eduax
 */
public class DomicilioCadastro extends Domicilio{


private int Nse;
private boolean Cable;
private int QuantidadeTelevisores;
private int QuantidadeIndivudos;
private int IdadeChefe;
private boolean TemCrianca;
private boolean FaixaIdadeCrianca4_11;
private boolean FaixaIdadeCrianca12_17;
private int CaboOperador;

    public DomicilioCadastro() {
    }

    public DomicilioCadastro(int Nse, boolean Cable, int QuantidadeTelevisores, int QuantidadeIndivudos, int IdadeChefe, boolean TemCrianca, boolean FaixaIdadeCrianca4_11, boolean FaixaIdadeCrianca12_17, int CaboOperador) {
        this.Nse = Nse;
        this.Cable = Cable;
        this.QuantidadeTelevisores = QuantidadeTelevisores;
        this.QuantidadeIndivudos = QuantidadeIndivudos;
        this.IdadeChefe = IdadeChefe;
        this.TemCrianca = TemCrianca;
        this.FaixaIdadeCrianca4_11 = FaixaIdadeCrianca4_11;
        this.FaixaIdadeCrianca12_17 = FaixaIdadeCrianca12_17;
        this.CaboOperador = CaboOperador;
    }

    public DomicilioCadastro(int Nse, boolean Cable, int QuantidadeTelevisores, int QuantidadeIndivudos, int IdadeChefe, boolean TemCrianca, boolean FaixaIdadeCrianca4_11, boolean FaixaIdadeCrianca12_17, int CaboOperador, long Id, LocalDate Data, br.com.kantar.model.Regiao Regiao) {
        super(Id, Data, Regiao);
        this.Nse = Nse;
        this.Cable = Cable;
        this.QuantidadeTelevisores = QuantidadeTelevisores;
        this.QuantidadeIndivudos = QuantidadeIndivudos;
        this.IdadeChefe = IdadeChefe;
        this.TemCrianca = TemCrianca;
        this.FaixaIdadeCrianca4_11 = FaixaIdadeCrianca4_11;
        this.FaixaIdadeCrianca12_17 = FaixaIdadeCrianca12_17;
        this.CaboOperador = CaboOperador;
    }

    public DomicilioCadastro(long Id, LocalDate Data, br.com.kantar.model.Regiao Regiao) {
        super(Id, Data, Regiao);
    }


    public int getNse() {
        return Nse;
    }

    public void setNse(int Nse) {
        this.Nse = Nse;
    }

    public boolean isCable() {
        return Cable;
    }

    public void setCable(boolean Cable) {
        this.Cable = Cable;
    }

    public int getQuantidadeTelevisores() {
        return QuantidadeTelevisores;
    }

    public void setQuantidadeTelevisores(int QuantidadeTelevisores) {
        this.QuantidadeTelevisores = QuantidadeTelevisores;
    }

    public int getQuantidadeIndivudos() {
        return QuantidadeIndivudos;
    }

    public void setQuantidadeIndivudos(int QuantidadeIndivudos) {
        this.QuantidadeIndivudos = QuantidadeIndivudos;
    }

    public int getIdadeChefe() {
        return IdadeChefe;
    }

    public void setIdadeChefe(int IdadeChefe) {
        this.IdadeChefe = IdadeChefe;
    }

    public boolean isTemCrianca() {
        return TemCrianca;
    }

    public void setTemCrianca(boolean TemCrianca) {
        this.TemCrianca = TemCrianca;
    }

    public boolean isFaixaIdadeCrianca4_11() {
        return FaixaIdadeCrianca4_11;
    }

    public void setFaixaIdadeCrianca4_11(boolean FaixaIdadeCrianca4_11) {
        this.FaixaIdadeCrianca4_11 = FaixaIdadeCrianca4_11;
    }

    public boolean isFaixaIdadeCrianca12_17() {
        return FaixaIdadeCrianca12_17;
    }

    public void setFaixaIdadeCrianca12_17(boolean FaixaIdadeCrianca12_17) {
        this.FaixaIdadeCrianca12_17 = FaixaIdadeCrianca12_17;
    }

    public int getCaboOperador() {
        return CaboOperador;
    }

    public void setCaboOperador(int CaboOperador) {
        this.CaboOperador = CaboOperador;
    }

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomicilioCadastro{");
        sb.append("Nse=").append(Nse);
        sb.append(", Cable=").append(Cable);
        sb.append(", QuantidadeTelevisores=").append(QuantidadeTelevisores);
        sb.append(", QuantidadeIndivudos=").append(QuantidadeIndivudos);
        sb.append(", IdadeChefe=").append(IdadeChefe);
        sb.append(", TemCrianca=").append(TemCrianca);
        sb.append(", FaixaIdadeCrianca4_11=").append(FaixaIdadeCrianca4_11);
        sb.append(", FaixaIdadeCrianca12_17=").append(FaixaIdadeCrianca12_17);
        sb.append(", CaboOperador=").append(CaboOperador);
        sb.append('}');
        return sb.toString();
    }



}
