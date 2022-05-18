/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.infra;

/**
 *
 * @author eduax
 */
public class IndividuoCadastro extends Individuo {
    
    private int IndividuoIdade;
    private int IndividuoSexo;
    private boolean ValidaSeChefe;

    public IndividuoCadastro() {
    }

    public IndividuoCadastro(int IndividuoIdade, int IndividuoSexo, boolean ValidaSeChefe) {
        this.IndividuoIdade = IndividuoIdade;
        this.IndividuoSexo = IndividuoSexo;
        this.ValidaSeChefe = ValidaSeChefe;
    }

    public IndividuoCadastro(int IndividuoIdade, int IndividuoSexo, boolean ValidaSeChefe, int IndividuoId, Domicilio Domilicio) {
        super(IndividuoId, Domilicio);
        this.IndividuoIdade = IndividuoIdade;
        this.IndividuoSexo = IndividuoSexo;
        this.ValidaSeChefe = ValidaSeChefe;
    }

    public int getIndividuoIdade() {
        return IndividuoIdade;
    }

    public void setIndividuoIdade(int IndividuoIdade) {
        this.IndividuoIdade = IndividuoIdade;
    }

    public int getIndividuoSexo() {
        return IndividuoSexo;
    }

    public void setIndividuoSexo(int IndividuoSexo) {
        this.IndividuoSexo = IndividuoSexo;
    }

    public boolean isValidaSeChefe() {
        return ValidaSeChefe;
    }

    public void setValidaSeChefe(boolean ValidaSeChefe) {
        this.ValidaSeChefe = ValidaSeChefe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.IndividuoIdade;
        hash = 89 * hash + this.IndividuoSexo;
        hash = 89 * hash + (this.ValidaSeChefe ? 1 : 0);
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
        final IndividuoCadastro other = (IndividuoCadastro) obj;
        if (this.IndividuoIdade != other.IndividuoIdade) {
            return false;
        }
        if (this.IndividuoSexo != other.IndividuoSexo) {
            return false;
        }
        return this.ValidaSeChefe == other.ValidaSeChefe;
    }

    @Override
    public String toString() {
        return "IndividuoCadastro{" + "IndividuoIdade=" + IndividuoIdade + ", IndividuoSexo=" + IndividuoSexo + ", ValidaSeChefe=" + ValidaSeChefe + '}';
    }


 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
