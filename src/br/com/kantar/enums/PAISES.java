/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.enums;

/**
 *
 * @author Eduardo.Fernando
 */
public enum PAISES {
    
    ARGENTINA_GBA(1,"Argentina GBA"),
    ARGENTINA_INT(2,"Argentina GBA");
    
    private int Codigo;
    private String DescricaoPais;

    private PAISES(int Codigo, String DescricaoPais) {
        this.Codigo = Codigo;
        this.DescricaoPais = DescricaoPais;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricaoPais() {
        return DescricaoPais;
    }

    public void setDescricaoPais(String DescricaoPais) {
        this.DescricaoPais = DescricaoPais;
    }
    
    
 
}
