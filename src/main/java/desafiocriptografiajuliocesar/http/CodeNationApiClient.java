package desafiocriptografiajuliocesar.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafiocriptografiajuliocesar.http.payload.CriptografiaJulioCesarPayload;
import desafiocriptografiajuliocesar.http.urisuporte.URIApiCodeNation;
import desafiocriptografiajuliocesar.http.urisuporte.URIApiCodeNationRecebeDesafio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class CodeNationApiClient {

    private URIApiCodeNation uriApiCodeNation;

    private final ObjectMapper objectMapper;

    public CodeNationApiClient() {
        this.objectMapper = new ObjectMapper();
    }

    public CriptografiaJulioCesarPayload recebeDesafio() throws IOException, InterruptedException {
        uriApiCodeNation = new URIApiCodeNationRecebeDesafio();
        final String uriRecebeTextoCriptografado = uriApiCodeNation.getURI();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uriRecebeTextoCriptografado))
                .build();
        HttpResponse<String> response = ClientHttpFactory.of().send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        final String resquestBody = response.body();
        return objectMapper.readValue(resquestBody, CriptografiaJulioCesarPayload.class);
    }
}
