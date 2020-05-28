package desafiocriptografiajuliocesar.http.urisuporte;

class URIApiCodeNationEnviaTextoDecifrado extends URIApiCodeNationBase implements URIApiCodeNation {

    private static final String PATH_SUBMIT_SOLUTION = "/submit-solution";

    @Override
    public String getURI() {
        final String uriBaseComParametroToken = getBaseURIComParametroToken();
        return uriBaseComParametroToken.replace("{PATH}", PATH_SUBMIT_SOLUTION);
    }
}
