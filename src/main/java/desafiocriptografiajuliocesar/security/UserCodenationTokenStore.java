package desafiocriptografiajuliocesar.security;

import java.util.Optional;

public final class UserCodenationTokenStore {

    private UserCodenationTokenStore() {
    }

    private static final String USER_CODENATION_TOKEN_PROPERTY_NAME = "user-codenation-token";

    public static Optional<String> getToken() {
        return Optional.ofNullable(System.getProperty(USER_CODENATION_TOKEN_PROPERTY_NAME));
    }

}
