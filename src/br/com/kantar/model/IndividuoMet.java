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
public class IndividuoMet extends Individuo {
    
    private float IndividuoPeso;
    private String IndividuoVariaveis;

    public IndividuoMet() {
    }


    public IndividuoMet(float IndividuoPeso, String IndividuoVariaveis, int IndividuoId, DomicilioMet Domilicio) {
        super(IndividuoId, Domilicio);
        this.IndividuoPeso = IndividuoPeso;
        this.IndividuoVariaveis = IndividuoVariaveis;
    }

    public float getIndividuoPeso() {
        return IndividuoPeso;
    }

    public void setIndividuoPeso(float IndividuoPeso) {
        this.IndividuoPeso = IndividuoPeso;
    }

    public String getIndividuoVariaveis() {
        return IndividuoVariaveis;
    }

    public void setIndividuoVariaveis(String IndividuoVariaveis) {
        this.IndividuoVariaveis = IndividuoVariaveis;
    }

    @Override
    public String toString() {
        return "IndividuoMet{" + "IndividuoPeso=" + IndividuoPeso + ", IndividuoVariaveis=" + IndividuoVariaveis + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Float.floatToIntBits(this.IndividuoPeso);
        hash = 67 * hash + Objects.hashCode(this.IndividuoVariaveis);
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
        final IndividuoMet other = (IndividuoMet) obj;
        if (Float.floatToIntBits(this.IndividuoPeso) != Float.floatToIntBits(other.IndividuoPeso)) {
            return false;
        }
        return Objects.equals(this.IndividuoVariaveis, other.IndividuoVariaveis);
    }
    
    
    
}
