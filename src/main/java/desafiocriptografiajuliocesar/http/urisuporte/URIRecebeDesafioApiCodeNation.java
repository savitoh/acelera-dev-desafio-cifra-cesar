package desafiocriptografiajuliocesar.http.urisuporte;

public class URIRecebeDesafioApiCodeNation extends URIBaseApiCodeNation implements URIApiCodeNation {

    private static final String PATH_GENERATE_DATA = "/generate-data";

    @Override
    public String getURI() {
        return this.mountURI(PATH_GENERATE_DATA);
    }
}
