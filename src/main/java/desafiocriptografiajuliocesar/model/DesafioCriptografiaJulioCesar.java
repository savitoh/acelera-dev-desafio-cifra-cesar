package desafiocriptografiajuliocesar.model;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;
import desafiocriptografiajuliocesar.http.payload.CriptografiaJulioCesarPayload;
import desafiocriptografiajuliocesar.security.utils.SHA1Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.stream.Collectors;

public class DesafioCriptografiaJulioCesar {

    private final CriptografiaJulioCesarPayload criptografiaJulioCesarPayload;

    private DesafioCriptografiaJulioCesar(CodeNationApiClient codeNationApiClient)
            throws IOException, InterruptedException {
        this.criptografiaJulioCesarPayload = codeNationApiClient.recebeDesafio();
    }

    public static DesafioCriptografiaJulioCesar create(CodeNationApiClient codeNationApiClient)
            throws IOException, InterruptedException {
        return new DesafioCriptografiaJulioCesar(codeNationApiClient);
    }

    public void salvarDesafioArquivoJSON() throws IOException {
        Files.write(Paths.get("json/answer.json"),
                criptografiaJulioCesarPayload.retonarFormatoJson().getBytes());
    }

    public String decifrar() {
        final String cifrado = criptografiaJulioCesarPayload.getCifrado();
        final String decifrado = cifrado.chars()
                .mapToObj(item -> {
                    char character = (char) item;
                    Optional<Integer> posicaoCharacter = Alfabeto.getPosicao(character);
                    if(posicaoCharacter.isPresent()) {
                        Integer posicaoCifrada = posicaoCharacter.get();
                        Integer posicaoDecifrada = getPosicaoDecifrada(posicaoCifrada);
                        char caracterDecifrado = Alfabeto.getCharacter(posicaoDecifrada.shortValue());
                        return String.valueOf(caracterDecifrado);
                    }
                    return String.valueOf(character);
                })
                .collect(Collectors.joining());
        criptografiaJulioCesarPayload.setDecifrado(decifrado);
        return decifrado;
    }

    private Integer getPosicaoDecifrada(Integer posicaoCifrada) {
        final short numeroCasas = criptografiaJulioCesarPayload.getNumeroCasas();
        final int posicaoDecifrada = ((posicaoCifrada - numeroCasas) % Alfabeto.ULTIMA_POSICAO);
        if(posicaoDecifrada < 0)
            return Alfabeto.ULTIMA_POSICAO + posicaoDecifrada;
        return posicaoDecifrada;
    }

    public String gerarResumoDecifrado() throws NoSuchAlgorithmException {
        var hashSha1 = SHA1Util.genarateHash(criptografiaJulioCesarPayload.getDecifrado());
        criptografiaJulioCesarPayload.setResumoCriptografado(hashSha1);
        return hashSha1;
    }
}
