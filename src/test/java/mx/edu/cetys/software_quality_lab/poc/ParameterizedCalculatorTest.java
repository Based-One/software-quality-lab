package mx.edu.cetys.software_quality_lab.poc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ParameterizedCalculatorTest {


    // @Test
    @ParameterizedTest
    @DisplayName("Test Sum of 2 Parameters with CSV Source")
    @CsvSource({
            "340, 459, 799",
            "-234,-340, -574,9",
            "0,0,0"

    })
    void testSumWithCsvSource(int a, int b, int expected){
        var sum = a + b;
        assertEquals(expected, sum);
    }
    @ParameterizedTest
    @ValueSource(strings= {
            "hello",
            "world",
            //""

    })
    @DisplayName("Validate String not Empty ") //vacia, solo funciona con happy paths
        void testValidateStringNotEmpty(String values){
            var isNotEmpty = values.isEmpty();
            assertFalse(isNotEmpty);
        }
    @ParameterizedTest
    @DisplayName("Validate double of an integer with MethodSource")
    @MethodSource("provideNumbers")
    void testValidateInteger_witMethodSource(int a, int expected){
        var doubleValue = a + a;
        assertEquals(expected,doubleValue);
    }
    public static Stream<Object[]> provideNumbers() {

    return Stream.of(new Object[]{2,4}, new Object[]{24,48}, new Object[]{"Hola","HolaHola"});
    }

    @ParameterizedTest
    @DisplayName(
            "Validate Pets"
    )
    @MethodSource("providePets")
    void validatePets(Pet pet,boolean expected){
        var isOlderThanTen = pet.age() > 10;
        assertEquals(expected,isOlderThanTen);
    }
    public static Stream<Object[]> providePets() {
        return Stream.of(new Object[] {new Pet("Perrito","purple","castanio",15),true},
        new Object[]{new Pet(null,null,null,10),false});
    }
    //POJO Plain Old Java Object
    //
    private record Pet(String name,String color,String race, int age) {};
}
