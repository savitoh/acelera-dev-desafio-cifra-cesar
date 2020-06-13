package desafiocriptografiajuliocesar;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;
import desafiocriptografiajuliocesar.model.DesafioCriptografiaJulioCesar;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException {
        CodeNationApiClient codeNationApiClient = new CodeNationApiClient();
        DesafioCriptografiaJulioCesar desafioCriptografiaJulioCesar =
                DesafioCriptografiaJulioCesar.create(codeNationApiClient);
        desafioCriptografiaJulioCesar.salvarDesafioArquivoJSON();
        desafioCriptografiaJulioCesar.decifrar();
        desafioCriptografiaJulioCesar.gerarResumoDecifrado();
        desafioCriptografiaJulioCesar.salvarDesafioArquivoJSON();
        desafioCriptografiaJulioCesar.enviarDesafio();
    }

}
