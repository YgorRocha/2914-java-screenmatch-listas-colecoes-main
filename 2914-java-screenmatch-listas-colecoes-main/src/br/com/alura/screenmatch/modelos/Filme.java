package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

import java.util.ArrayList;

public class Filme extends Titulo {
    private String diretor;

    //CONSTRUCTOR
    public Filme(String nome,int anoDeLancamento){
        super(nome, anoDeLancamento);
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
    }

    //GETTER AND SETTER
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }



    /*@Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }*/

    @Override
    public String toString() {
        return "Filmes: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
