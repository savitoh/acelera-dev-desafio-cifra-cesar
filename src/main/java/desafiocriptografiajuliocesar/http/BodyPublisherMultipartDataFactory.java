package desafiocriptografiajuliocesar.http;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

final class BodyPublisherMultipartDataFactory {

    private BodyPublisherMultipartDataFactory() {

    }

    public static HttpRequest.BodyPublisher of(Map<String, Path> data, final String boundary) throws IOException {
        var byteArrays = new ArrayList<byte[]>();
        byte[] separator = ("--" + boundary + "\r\nContent-Disposition: form-data; name=")
                .getBytes(StandardCharsets.UTF_8);

        for(String key : data.keySet()) {
            byteArrays.add(separator);
            Path path = data.get(key);
            String mimeType = Files.probeContentType(path);
            byteArrays.add(("\"" + key + "\"; filename=\"" + path.getFileName()
                    + "\"\r\nContent-Type: " + mimeType + "\r\n\r\n").getBytes(StandardCharsets.UTF_8));
            byteArrays.add(Files.readAllBytes(path));
            byteArrays.add("\r\n".getBytes(StandardCharsets.UTF_8));
        }
        byteArrays.add(("--" + boundary + "--").getBytes(StandardCharsets.UTF_8));
        return HttpRequest.BodyPublishers.ofByteArrays(byteArrays);
    }
}
