package desafiocriptografiajuliocesar.security.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public final class SHA1Util {

    private SHA1Util() {

    }

    public static String genarateHash(final String input) throws NoSuchAlgorithmException {
        Objects.requireNonNull(input, "Para gerar HASH o valor não pode ser nulo (;");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] byteHash = sha1.digest();
        sha1.reset();
        return String.format("%040x", new BigInteger(1, byteHash));
    }
}
