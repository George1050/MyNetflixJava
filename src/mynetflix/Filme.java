/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;

/**
 *
 * @author george
 */
public class Filme {
    private int cod_filme;
    private String nome;
    private int genero;
    private String duracao;
    private String sinopse;

    public Filme(String nome, int genero, String duracao, String sinopse) {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
    }

    public Filme(int cod_filme, String nome, int genero, String duracao, String sinopse) {
        this.cod_filme = cod_filme;
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
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

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "Filme{" + "cod_filme=" + cod_filme + ", nome=" + nome + ", genero=" + genero + ", duracao=" + duracao + ", sinopse=" + sinopse + '}';
    }
    
    
}
