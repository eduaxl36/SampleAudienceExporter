/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model;

import java.util.Objects;

/**
 *
 * @author eduax
 */
public class Regiao {
    
   private int CodRegiao;
   private String Descricao;

    public Regiao() {
    }

    public Regiao(int CodRegiao, String Descricao) {
        this.CodRegiao = CodRegiao;
        this.Descricao = Descricao;
    }

    public int getCodRegiao() {
        return CodRegiao;
    }

    public void setCodRegiao(int CodRegiao) {
        this.CodRegiao = CodRegiao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return "Regiao{" + "CodRegiao=" + CodRegiao + ", Descricao=" + Descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.CodRegiao;
        hash = 47 * hash + Objects.hashCode(this.Descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Regiao other = (Regiao) obj;
        return true;
    }
   
    
   
   
    
}
