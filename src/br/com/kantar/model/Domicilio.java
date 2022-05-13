/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public abstract class Domicilio {
    
    private long Id;
    private LocalDate Data;
    private Regiao Regiao;

    public Domicilio() {
    }

    public Domicilio(long Id, LocalDate Data, Regiao Regiao) {
        this.Id = Id;
        this.Data = Data;
        this.Regiao = Regiao;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
    }

    public Regiao getRegiao() {
        return Regiao;
    }

    public void setRegiao(Regiao Regiao) {
        this.Regiao = Regiao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.Id ^ (this.Id >>> 32));
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
        final Domicilio other = (Domicilio) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Domicilio{" + "Id=" + Id + ", Data=" + Data + ", Regiao=" + Regiao + '}';
    }

    
    
   
}
