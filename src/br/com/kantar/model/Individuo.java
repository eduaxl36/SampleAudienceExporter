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
public abstract class Individuo {
    
    private int IndividuoId;
    private Domicilio Domilicio;

    public Individuo() {
    }

    public Individuo(int IndividuoId, Domicilio Domilicio) {
        this.IndividuoId = IndividuoId;
        this.Domilicio = Domilicio;
    }

    public int getIndividuoId() {
        return IndividuoId;
    }

    public void setIndividuoId(int IndividuoId) {
        this.IndividuoId = IndividuoId;
    }

    public Domicilio getDomilicio() {
        return Domilicio;
    }

    public void setDomilicio(Domicilio Domilicio) {
        this.Domilicio = Domilicio;
    }

    @Override
    public String toString() {
        return "Individuo{" + "IndividuoId=" + IndividuoId + ", Domilicio=" + Domilicio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.IndividuoId;
        hash = 67 * hash + Objects.hashCode(this.Domilicio);
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
        final Individuo other = (Individuo) obj;
        if (this.IndividuoId != other.IndividuoId) {
            return false;
        }
        return Objects.equals(this.Domilicio, other.Domilicio);
    }

    
    
    
}
