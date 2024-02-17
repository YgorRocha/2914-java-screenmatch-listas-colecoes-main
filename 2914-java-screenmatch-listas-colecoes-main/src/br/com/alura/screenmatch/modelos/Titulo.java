package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;
import br.com.alura.screenmatch.excecao.ErroDeConversao;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.Comparator;

public class Titulo implements Classificavel, Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    // CONSTRUCTOR

    public Titulo(String nome, int anoDeLancamento) {
        if(nome == null || nome.trim().isEmpty() ){
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        this.nome = nome;

        if(anoDeLancamento <=0 || anoDeLancamento >=2100){
            throw new IllegalArgumentException("Ano de lançamento invalido");
        }
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversao("Não conseguiu converter o ano, por que tem mais de 4 caractere");
        }
        this.anoDeLancamento = Integer.parseInt(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }



    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;}

    @Override
    public int compareTo(Titulo outroTitulo) {
        // Comparação com base no nome
        return this.nome.compareTo(outroTitulo.nome);
    }

    @Override
    public String toString() {
        return "Nome ='" + nome + '\'' +
                ", anoDeLancamento = " + anoDeLancamento + "," +" Duração = " + duracaoEmMinutos + "min";}

}
