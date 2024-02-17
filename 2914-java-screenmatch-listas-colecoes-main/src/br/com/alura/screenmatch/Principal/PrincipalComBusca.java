package br.com.alura.screenmatch.Principal;
import br.com.alura.screenmatch.excecao.ErroDeConversao;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Qual filme deseja buscar? ");
        var busca = leitura.nextLine();
        String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=b3a7700b";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            /* System.out.println(json);*/

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo Convertido");
            System.out.println(meuTitulo);

        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Aconteceu um erro de argumento no momento da busca: " + e.getMessage());
        }catch (ErroDeConversao e){
            System.out.println(e.getMessage());
        }
    }
}
