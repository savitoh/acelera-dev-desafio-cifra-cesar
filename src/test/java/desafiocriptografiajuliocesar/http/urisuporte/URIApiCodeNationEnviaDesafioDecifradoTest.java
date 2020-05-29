package desafiocriptografiajuliocesar.http.urisuporte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class URIApiCodeNationEnviaDesafioDecifradoTest {

    private static final String USER_CODENATION_TOKEN_PROPERTY_NAME = "user-codenation-token";

    private static final String USER_CODENATION_TOKEN_PROPERTY_VALUE = "123456";

    private URIApiCodeNationEnviaDesafioDecifrado uriEnviaTextoDecifrado;

    @BeforeEach
    void setUp() {
        uriEnviaTextoDecifrado = new URIApiCodeNationEnviaDesafioDecifrado();
        System.clearProperty(USER_CODENATION_TOKEN_PROPERTY_NAME);
    }

    @Test
    public void lanca_exception_quando_montar_uri_nao_encontra_token() {
        assertThrows(RuntimeException.class,
                () -> uriEnviaTextoDecifrado.getURI(),
                "Token Não Encontrado (:");
    }

    @Test
    public void deve_retornar_uri_recebe_texto_criptografado() {
        setPropertyUserCodenationTokenUser();

        final String uriReceTetoCriptografado = uriEnviaTextoDecifrado.getURI();

        assertEquals(
                "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=".concat(USER_CODENATION_TOKEN_PROPERTY_VALUE),
                uriReceTetoCriptografado
        );
    }

    private void setPropertyUserCodenationTokenUser() {
        System.setProperty(USER_CODENATION_TOKEN_PROPERTY_NAME, USER_CODENATION_TOKEN_PROPERTY_VALUE);
    }
}
