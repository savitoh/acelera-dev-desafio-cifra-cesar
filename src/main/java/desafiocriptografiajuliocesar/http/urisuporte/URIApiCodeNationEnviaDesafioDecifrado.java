package desafiocriptografiajuliocesar.http.urisuporte;

class URIApiCodeNationEnviaDesafioDecifrado extends URIApiCodeNationBase implements URIApiCodeNation {

    private static final String PATH_SUBMIT_SOLUTION = "/submit-solution";

    @Override
    public String getURI() {
        final String uriBaseComParametroToken = getBaseURIComParametroToken();
        return uriBaseComParametroToken.replace(URIConstantesSuporte.SIMBOLO_DELIMITADOR_PATH_URI, PATH_SUBMIT_SOLUTION);
    }
}
