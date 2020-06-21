package desafiocriptografiajuliocesar.http.urisuporte;

public class URIEnviaDesafioDecifradoApiCodeNation extends URIBaseApiCodeNation implements URIApiCodeNation {

    private static final String PATH_SUBMIT_SOLUTION = "/submit-solution";

    @Override
    public String getURI() {
        return this.mountURI(PATH_SUBMIT_SOLUTION);
    }
}
