package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão" , 1970);
        meuFilme.avalia(8);
        meuFilme.avalia(10);

        Filme interestelar = new Filme("Interestelar", 2016);
        interestelar.avalia(10);
        interestelar.avalia(10);

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(8);
        outroFilme.avalia(5);


        Serie lost = new Serie("Lost", 2000);
        lost.avalia(5);
        lost.avalia(8);

        ArrayList<Titulo> lista = new ArrayList();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(interestelar);
        lista.add(lost);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        Collections.sort(lista, Comparator.comparing(Titulo::getAnoDeLancamento));
        /*Collections.sort(lista);*/
       /* System.out.println(lista);*/

        for (Titulo t : lista) {
            System.out.println("Nome: " + t.getNome());
           /* System.out.println("Classificação: "+ t.getClassificacao());*/
        }

       /* ArrayList<String> buscaPorArtistas = new ArrayList();
        buscaPorArtistas.add("Henry Cavil");
        buscaPorArtistas.add("Tom Welling");
        buscaPorArtistas.add("Chris Hemsworth");
        buscaPorArtistas.add("Chris Evens");
        buscaPorArtistas.add("Tom Hanks");

        Collections.sort(buscaPorArtistas);
        for(String st : buscaPorArtistas){
            System.out.println(st);
        }*/

    }
}
