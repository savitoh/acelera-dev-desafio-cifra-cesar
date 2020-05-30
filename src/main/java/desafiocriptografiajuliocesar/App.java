package desafiocriptografiajuliocesar;

import desafiocriptografiajuliocesar.model.DesafioCriptografiaJulioCesar;

import java.io.IOException;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        DesafioCriptografiaJulioCesar desafioCriptografiaJulioCesar = DesafioCriptografiaJulioCesar.create();
        desafioCriptografiaJulioCesar.salvarDesafioArquivoJSON();
        LOGGER.info("Desafio: " + desafioCriptografiaJulioCesar);
    }

}
