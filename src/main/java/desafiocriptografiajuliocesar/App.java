package desafiocriptografiajuliocesar;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        CodeNationApiClient codeNationApiClient = new CodeNationApiClient();

        codeNationApiClient.recebeDesafio();
    }

}
