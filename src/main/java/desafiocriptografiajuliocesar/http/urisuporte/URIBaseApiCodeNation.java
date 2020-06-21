package desafiocriptografiajuliocesar.http.urisuporte;

import desafiocriptografiajuliocesar.security.UserCodenationTokenStore;

abstract class URIBaseApiCodeNation {

    private static final String URL_BASE_API = "https://api.codenation.dev/v1/challenge/dev-ps";

    private static final String PARAMETER_TOKEN = "?token";

    private String getBaseURIComParametroToken() {
        final String userCodenationTokenStore = UserCodenationTokenStore.getToken()
                .orElseThrow(() -> new  RuntimeException("Token Não Encontrado (:"));
        return URL_BASE_API.concat(URIConstantesSuporte.SIMBOLO_DELIMITADOR_PATH_URI)
                .concat(PARAMETER_TOKEN)
                .concat("=")
                .concat(userCodenationTokenStore);
     }

     final String mountURI(final String path) {
         final String uriBaseComParametroToken = this.getBaseURIComParametroToken();
         return uriBaseComParametroToken.replace(URIConstantesSuporte.SIMBOLO_DELIMITADOR_PATH_URI, path);
     }


}
