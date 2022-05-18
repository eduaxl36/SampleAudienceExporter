/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.infra;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public class DomicilioMet extends Domicilio {

    private float Peso;
    private String Variaveis;

    public DomicilioMet() {
    }

    public DomicilioMet(long Id, LocalDate Data, br.com.kantar.model.infra.Regiao Regiao) {
        super(Id, Data, Regiao);
    }

    
    
    public DomicilioMet(float Peso, String Variaveis) {
        this.Peso = Peso;
        this.Variaveis = Variaveis;
    }

    public DomicilioMet(float Peso, String Variaveis, long Id, LocalDate Data, br.com.kantar.model.infra.Regiao Regiao) {
        super(Id, Data, Regiao);
        this.Peso = Peso;
        this.Variaveis = Variaveis;
    }

   
    public float getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public String getVariaveis() {
        return Variaveis;
    }

    public void setVariaveis(String Variaveis) {
        this.Variaveis = Variaveis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomicilioMet{");
        sb.append("Peso=").append(Peso);
        sb.append(", Variaveis=").append(Variaveis);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits(this.Peso);
        hash = 97 * hash + Objects.hashCode(this.Variaveis);
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
        final DomicilioMet other = (DomicilioMet) obj;
        if (Float.floatToIntBits(this.Peso) != Float.floatToIntBits(other.Peso)) {
            return false;
        }
        return Objects.equals(this.Variaveis, other.Variaveis);
    }
    
    
    
}
