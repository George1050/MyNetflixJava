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
public class Serie {
    private int cod_serie;
    private String nome;
    private int genero;
    private int num_epi;
    private String sinopse;

    public Serie(String nome, int genero, int num_epi, String sinopse) {
        this.nome = nome;
        this.genero = genero;
        this.num_epi = num_epi;
        this.sinopse = sinopse;
    }

    public Serie(int cod_serie, String nome, int genero, int num_epi, String sinopse) {
        this.cod_serie = cod_serie;
        this.nome = nome;
        this.genero = genero;
        this.num_epi = num_epi;
        this.sinopse = sinopse;
    }

    public int getCod_serie() {
        return cod_serie;
    }

    public void setCod_serie(int cod_serie) {
        this.cod_serie = cod_serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getNum_epi() {
        return num_epi;
    }

    public void setNum_epi(int num_epi) {
        this.num_epi = num_epi;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "Serie{" + "cod_serie=" + cod_serie + ", nome=" + nome + ", genero=" + genero + ", num_epi=" + num_epi + ", sinopse=" + sinopse + '}';
    }
    
    
}
