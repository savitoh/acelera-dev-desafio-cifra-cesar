package desafiocriptografiajuliocesar.http.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CriptografiaJulioCesarPayload {

    @JsonProperty("numero_casas")
    private int numeroCasas;

    private String token;

    private String cifrado;

    private String decifrado;

    @JsonProperty("resumo_criptografico")
    private String resumoCriptografado;

    public int getNumeroCasas() {
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

    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCifrado(String cifrado) {
        this.cifrado = cifrado;
    }

    public void setDecifrado(String decifrado) {
        this.decifrado = decifrado;
    }

    public void setResumoCriptografado(String resumoCriptografado) {
        this.resumoCriptografado = resumoCriptografado;
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
