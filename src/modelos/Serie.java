/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author george
 */
public class Serie extends Movie{
    private int num_epi;

    public Serie(int codigo, String nome, int genero, String sinopse, int num_epi) {
        super(codigo, nome, genero, sinopse);
        this.num_epi = num_epi;
    }
    
    public Serie(String nome, int genero, String sinopse, int num_epi) {
        super(nome, genero, sinopse);
        this.num_epi = num_epi;
    }

    public int getNum_epi() {
        return num_epi;
    }

    public void setNum_epi(int num_epi) {
        this.num_epi = num_epi;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumero de episodios: " + num_epi;
    }
    
}
