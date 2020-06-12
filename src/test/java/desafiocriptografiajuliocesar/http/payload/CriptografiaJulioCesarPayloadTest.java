package desafiocriptografiajuliocesar.http.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriptografiaJulioCesarPayloadTest {

    private static final String TOKEN = "1aad8d91418f4e6c8522df06316b13a336b11cfd";

    private static final String TEXTO_CIFRADO = "zbyqbkwwsxq dynki sc k bkmo lodgoox cypdgkbo oxqsxoobc cdbsfsxq dy lesvn lsqqob kxn loddob snsyd-zbyyp zbyqbkwc, kxn dro exsfobco dbisxq dy zbynemo lsqqob kxn loddob snsydc. cy pkb, dro exsfobco sc gsxxsxq. bsmr myyu";

    private static final String TEXTO_DECIFRADO = "";

    private static final String RESUMO_CRIPTOGRAFADO = "";

    private static final short NUMERO_CASAS = 10;

    @Test
    public void deve_desserializar_objeto_para_json() throws JsonProcessingException {
        CriptografiaJulioCesarPayload criptografiaJulioCesarPayload =
                new CriptografiaJulioCesarPayload(NUMERO_CASAS, TOKEN, TEXTO_CIFRADO, TEXTO_DECIFRADO, RESUMO_CRIPTOGRAFADO);

        final String formatoJson = criptografiaJulioCesarPayload.retonarFormatoJson();

        final String formatoJsonEsperado = "{\"token\":\"1aad8d91418f4e6c8522df06316b13a336b11cfd\",\"cifrado\":\"zbyqbkwwsxq dynki sc k bkmo lodgoox cypdgkbo oxqsxoobc cdbsfsxq dy lesvn lsqqob kxn loddob snsyd-zbyyp zbyqbkwc, kxn dro exsfobco dbisxq dy zbynemo lsqqob kxn loddob snsydc. cy pkb, dro exsfobco sc gsxxsxq. bsmr myyu\",\"decifrado\":\"\",\"numero_casas\":10,\"resumo_criptografico\":\"\"}";
        assertEquals(formatoJsonEsperado, formatoJson);
    }

}
