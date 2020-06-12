package desafiocriptografiajuliocesar;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;
import desafiocriptografiajuliocesar.model.DesafioCriptografiaJulioCesar;

import java.io.IOException;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        CodeNationApiClient codeNationApiClient = new CodeNationApiClient();
        DesafioCriptografiaJulioCesar desafioCriptografiaJulioCesar =
                DesafioCriptografiaJulioCesar.create(codeNationApiClient);
        desafioCriptografiaJulioCesar.salvarDesafioArquivoJSON();
    }

}
