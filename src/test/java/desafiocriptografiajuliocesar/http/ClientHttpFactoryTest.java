package desafiocriptografiajuliocesar.http;

import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientHttpFactoryTest {

    @Test
    public void deve_retornar_sempre_mesma_instancia() {
        HttpClient httpClient1 = ClientHttpFactory.of();
        HttpClient httpClient2 = ClientHttpFactory.of();

        assertEquals(httpClient1, httpClient2);
    }
}
