package desafiocriptografiajuliocesar.model;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;
import desafiocriptografiajuliocesar.http.payload.CriptografiaJulioCesarPayload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DesafioCriptografiaJulioCesar {

    private final CodeNationApiClient codeNationApiClient;

    private final CriptografiaJulioCesarPayload criptografiaJulioCesarPayload;

    private DesafioCriptografiaJulioCesar() throws IOException, InterruptedException {
        codeNationApiClient = new CodeNationApiClient();
        this.criptografiaJulioCesarPayload = codeNationApiClient.recebeDesafio();
    }

    public static DesafioCriptografiaJulioCesar create() throws IOException, InterruptedException {
        return new DesafioCriptografiaJulioCesar();
    }

    public void salvarDesafioArquivoJSON() throws IOException {
        Files.write(Paths.get("json/answer.json"),
                criptografiaJulioCesarPayload.retonarFormatoJson().getBytes());
    }

    @Override
    public String toString() {
        return "DesafioCriptografiaJulioCesar{" +
                "criptografiaJulioCesarPayload=" + criptografiaJulioCesarPayload +
                '}';
    }
}
