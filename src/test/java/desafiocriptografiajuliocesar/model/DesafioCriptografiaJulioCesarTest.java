package desafiocriptografiajuliocesar.model;

import desafiocriptografiajuliocesar.http.CodeNationApiClient;
import desafiocriptografiajuliocesar.http.payload.CriptografiaJulioCesarPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DesafioCriptografiaJulioCesarTest {

    private CodeNationApiClient codeNationApiClientMock;

    private DesafioCriptografiaJulioCesar desafioCriptografiaJulioCesar;

    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        codeNationApiClientMock = Mockito.mock(CodeNationApiClient.class);
    }

    @Test
    public void deve_decifrar_texto() throws IOException, InterruptedException {
        final short numeroCasasMock = 3;
        final String tokenMock = "ABC";
        final String cifradoMock = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
        final String decifradoMock = "";
        final String resumoCriptografadoMock = "";
        CriptografiaJulioCesarPayload criptografiaJulioCesarPayloadMock =
                new CriptografiaJulioCesarPayload(numeroCasasMock, tokenMock, cifradoMock, decifradoMock, resumoCriptografadoMock);

        Mockito.when(codeNationApiClientMock.recebeDesafio()).thenReturn(criptografiaJulioCesarPayloadMock);
        desafioCriptografiaJulioCesar = DesafioCriptografiaJulioCesar.create(codeNationApiClientMock);


        final String decifrado = desafioCriptografiaJulioCesar.decifrar();


        assertNotNull(decifrado);
        assertEquals("a ligeira raposa marrom saltou sobre o cachorro cansado", decifrado);
    }

    @Test
    public void deve_decifrar_texto_com_caracter_especial() throws IOException, InterruptedException {
        final short numeroCasasMock = 3;
        final String tokenMock = "ABC";
        final String cifradoMock = "1d.d";
        final String decifradoMock = "";
        final String resumoCriptografadoMock = "";
        CriptografiaJulioCesarPayload criptografiaJulioCesarPayloadMock =
                new CriptografiaJulioCesarPayload(numeroCasasMock, tokenMock, cifradoMock, decifradoMock, resumoCriptografadoMock);

        Mockito.when(codeNationApiClientMock.recebeDesafio()).thenReturn(criptografiaJulioCesarPayloadMock);
        desafioCriptografiaJulioCesar = DesafioCriptografiaJulioCesar.create(codeNationApiClientMock);


        final String decifrado = desafioCriptografiaJulioCesar.decifrar();


        assertNotNull(decifrado);
        assertEquals("1a.a", decifrado);
    }
}
