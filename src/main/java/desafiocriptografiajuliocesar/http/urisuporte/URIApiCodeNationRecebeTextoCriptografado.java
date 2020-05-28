package desafiocriptografiajuliocesar.http.urisuporte;

class URIApiCodeNationRecebeTextoCriptografado extends URIApiCodeNationBase implements URIApiCodeNation {

    private static final String PATH_GENERATE_DATA = "/generate-data";

    @Override
    public String getURI() {
        final String uriBaseComParametroToken = getBaseURIComParametroToken();
        return uriBaseComParametroToken.replace("{PATH}", PATH_GENERATE_DATA);
    }
}
