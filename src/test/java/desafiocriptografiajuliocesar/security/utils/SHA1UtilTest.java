package desafiocriptografiajuliocesar.security.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SHA1UtilTest {

    private static Stream<Arguments> sh1GenaratorProvider() {
        return Stream.of(
                Arguments.of("GeeksForGeeks", "addf120b430021c36c232c99ef8d926aea2acd6b"),
                Arguments.of("hello world", "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed")
        );
    }

    @Test
    public void deve_lancar_exception_quando_gerar_hash_passando_valor_nulo() {
        assertThrows(NullPointerException.class,
                () -> SHA1Util.genarateHash(null),
                "Para criptografar valor não pode ser nulo (;");
    }

    @ParameterizedTest
    @MethodSource("sh1GenaratorProvider")
    public void deve_gerar_hash(String value, String hashValue) throws NoSuchAlgorithmException {
        assertEquals(hashValue, SHA1Util.genarateHash(value));
    }
}
