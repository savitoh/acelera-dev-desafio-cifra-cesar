package desafiocriptografiajuliocesar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlfabetoTest {

    private static Stream posicaoCaracterProvider() {
        return Stream.of(
                Arguments.of(1, 'a'),
                Arguments.of(2, 'b'),
                Arguments.of(3, 'c'),
                Arguments.of(4, 'd'),
                Arguments.of(5, 'e'),
                Arguments.of(25, 'y'),
                Arguments.of(26, 'z')
        );
    }

    @ParameterizedTest
    @ValueSource(shorts = {-1, 0, 27, 28})
    public void deve_subir_exception_quando_posicao_possuir_valor_invalido(short posicao) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Alfabeto.getCharacter(posicao),
                "A posicao do caracter no alfabeto deve ser entre 1 e 26 (: "
        );
    }

    @ParameterizedTest
    @MethodSource("posicaoCaracterProvider")
    public void deve_retornar_character_por_posicao(Integer posicao, char character) {
        assertEquals(character, Alfabeto.getCharacter(posicao.shortValue()));
    }

    @ParameterizedTest
    @ValueSource(chars = {'m', 'M'})
    public void deve_retornar_posicao_meio_quando_pesquisar_character_central(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isPresent());
        assertEquals(13, posicao.get());
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'A'})
    public void deve_retornar_posicao_inicial_quando_pesquisar_primeiro_character(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isPresent());
        assertEquals(1, posicao.get());
    }

    @ParameterizedTest
    @ValueSource(chars = {'z', 'Z'})
    public void deve_retornar_posicao_final_quando_pesquisar_ultimo_character(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isPresent());
        assertEquals(26, posicao.get());
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'b', 'c', 'd', 'e',
                          'f', 'g', 'h', 'i', 'l',
                          'm', 'n', 'o', 'p', 'q',
                          'r', 's', 't', 'u', 'v',
                          'w', 'x', 'y', 'z'})
    public void deve_retornar_posicao_quando_character_for_letra(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isPresent());
    }

    @ParameterizedTest
    @ValueSource(chars = {'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'L',
            'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'})
    public void deve_retornar_posicao_quando_character_for_letra_maiuscula(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isPresent());
    }

    @ParameterizedTest
    @ValueSource(chars = {'.', ',', '/', '*', '-', '>', '<'})
    public void deve_retornar_empty_quando_character_nao_for_letra_alfabetica(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
    public void deve_retornar_empty_quando_character_for_numerico(char character) {
        Optional<Integer> posicao = Alfabeto.getPosicao(character);

        assertTrue(posicao.isEmpty());
    }


}
