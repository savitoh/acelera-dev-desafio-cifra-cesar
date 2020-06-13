package desafiocriptografiajuliocesar.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BodyPublisherMultipartDataFactoryTest {

    private final ClassLoader classLoader = BodyPublisherMultipartDataFactory.class.getClassLoader();

    @Test
    public void deve_criar_requestbody_multipart_data() throws URISyntaxException, IOException {
        URL url = classLoader.getResource("json/test.json");
        Path pathTest = Path.of(url.toURI());
        final String keyTest = "test";

        Map<String, Path> data = new HashMap();
        data.put(keyTest, pathTest);

        final String boundaryTest = new BigInteger(256, new Random()).toString();


        HttpRequest.BodyPublisher bodyPublisher = BodyPublisherMultipartDataFactory.of(data, boundaryTest);


        assertNotNull(bodyPublisher);
        assertTrue(bodyPublisher.contentLength() > 0);
    }
}
