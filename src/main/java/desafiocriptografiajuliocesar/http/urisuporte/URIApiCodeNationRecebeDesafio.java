package desafiocriptografiajuliocesar.http.urisuporte;

public class URIApiCodeNationRecebeDesafio extends URIApiCodeNationBase implements URIApiCodeNation {

    private static final String PATH_GENERATE_DATA = "/generate-data";

    @Override
    public String getURI() {
        final String uriBaseComParametroToken = getBaseURIComParametroToken();
        return uriBaseComParametroToken.replace(URIConstantesSuporte.SIMBOLO_DELIMITADOR_PATH_URI, PATH_GENERATE_DATA);
    }
}
