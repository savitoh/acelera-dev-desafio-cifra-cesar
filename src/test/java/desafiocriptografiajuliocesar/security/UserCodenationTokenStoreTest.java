package desafiocriptografiajuliocesar.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCodenationTokenStoreTest {

    private static final String USER_CODENATION_TOKEN_PROPERTY_NAME = "user-codenation-token";

    @BeforeEach
    void beforeAll() {
        System.clearProperty(USER_CODENATION_TOKEN_PROPERTY_NAME);
    }

    @Test
    public void deve_retornar_empty_quando_nao_encontrar_token() {
        Optional<String> userCodenationToken = UserCodenationTokenStore.getToken();

        assertTrue(userCodenationToken.isEmpty());
    }

    @Test
    public void deve_retornar_token() {
        setPropertyUserCodenationTokenUser();

        Optional<String> userCodenationToken = UserCodenationTokenStore.getToken();

        assertTrue(userCodenationToken.isPresent());
        assertEquals( "fail-value", UserCodenationTokenStore.getToken().get());
    }

    private void setPropertyUserCodenationTokenUser() {
        System.setProperty(USER_CODENATION_TOKEN_PROPERTY_NAME, "fail-value");
    }

}
