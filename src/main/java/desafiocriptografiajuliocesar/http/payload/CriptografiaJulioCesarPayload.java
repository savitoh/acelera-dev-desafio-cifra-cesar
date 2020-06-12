package desafiocriptografiajuliocesar.http.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CriptografiaJulioCesarPayload {

    @JsonProperty("numero_casas")
    private short numeroCasas;

    private String token;

    private String cifrado;

    private String decifrado;

    @JsonProperty("resumo_criptografico")
    private String resumoCriptografado;

    /**
     * @deprecated Usado apenas pelo Jackson para realizar Desserialização
    */
    @Deprecated(since = "30/05/2020")
    public CriptografiaJulioCesarPayload() {
    }

    public CriptografiaJulioCesarPayload(short numeroCasas, String token,
                                         String cifrado, String decifrado,
                                         String resumoCriptografado) {
        this.numeroCasas = numeroCasas;
        this.token = token;
        this.cifrado = cifrado;
        this.decifrado = decifrado;
        this.resumoCriptografado = resumoCriptografado;
    }

    public short getNumeroCasas() {
        return numeroCasas;
    }

    public String getToken() {
        return token;
    }

    public String getCifrado() {
        return cifrado;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public String getResumoCriptografado() {
        return resumoCriptografado;
    }

    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    public String retonarFormatoJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "CriptografiaJulioCesarPayload{" +
                "numeroCasas=" + numeroCasas +
                ", token='" + token + '\'' +
                ", cifrado='" + cifrado + '\'' +
                ", decifrado='" + decifrado + '\'' +
                ", resumoCriptografado='" + resumoCriptografado + '\'' +
                '}';
    }
}
