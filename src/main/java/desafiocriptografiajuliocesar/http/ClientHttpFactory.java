package desafiocriptografiajuliocesar.http;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Objects;

final class ClientHttpFactory {

    private static HttpClient httpClient;

    private ClientHttpFactory() {
    }

    static HttpClient of() {
        if(Objects.isNull(httpClient)) {
            httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        }
        return httpClient;
    }
}
