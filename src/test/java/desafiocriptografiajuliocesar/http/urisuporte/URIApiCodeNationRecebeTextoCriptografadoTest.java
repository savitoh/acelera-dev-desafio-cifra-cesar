package desafiocriptografiajuliocesar.http.urisuporte;

import desafiocriptografiajuliocesar.http.urisuporte.URIApiCodeNationRecebeTextoCriptografado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class URIApiCodeNationRecebeTextoCriptografadoTest {

    private static final String USER_CODENATION_TOKEN_PROPERTY_NAME = "user-codenation-token";

    private static final String USER_CODENATION_TOKEN_PROPERTY_VALUE = "123456";

    private URIApiCodeNationRecebeTextoCriptografado uriRecebeTextoCriptografado;

    @BeforeEach
    void setUp() {
        uriRecebeTextoCriptografado = new URIApiCodeNationRecebeTextoCriptografado();
        System.clearProperty(USER_CODENATION_TOKEN_PROPERTY_NAME);
    }

    @Test
    public void lanca_exception_quando_montar_uri_nao_encontra_token() {
        assertThrows(RuntimeException.class,
                () -> uriRecebeTextoCriptografado.getURI(),
                "Token Não Encontrado (:");
    }

    @Test
    public void deve_retornar_uri_recebe_texto_criptografado() {
        setPropertyUserCodenationTokenUser();

        final String uriReceTetoCriptografado = uriRecebeTextoCriptografado.getURI();

        assertEquals(
                "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=".concat(USER_CODENATION_TOKEN_PROPERTY_VALUE),
                uriReceTetoCriptografado
        );
    }

    private void setPropertyUserCodenationTokenUser() {
        System.setProperty(USER_CODENATION_TOKEN_PROPERTY_NAME, USER_CODENATION_TOKEN_PROPERTY_VALUE);
    }
}
