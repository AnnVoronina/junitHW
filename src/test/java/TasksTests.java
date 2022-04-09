import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TasksTests  {

    Tasks sut; // system under testing

    @BeforeAll
    public static void initTest() {
        System.out.println("Tests start");
    }

    @BeforeEach // для того что бы обнулить до этого переданные данные
    public void newSut() {
        sut = new Tasks();
    }

    @AfterEach
    public void endTest() {
        System.out.println("Test end");
    }

    @Test
    public void testVolumeCube() {
        //arrange    given
        int r = 3, // указываем парамаетры с которыми вызывается метод
                expected = 27; // ожидаемый результат

        //act    when
        int result = sut.volumeCube(r);

        //assert   then
        assertEquals(expected, result);

    }

    @Test
    public void testCentimetreInMetre() {
        int c = 0, e = 0;
        int r = sut.centimetreInMetre(c);
        assertEquals(e, r);
    }

    @Test
    public void testMoreN() {
        int n = 10;
        List<Integer> input = Arrays.asList(10, 67, 90, 4, 6, 8, 9, 0, -6);
        List<Integer> e = Arrays.asList(67, 90);
        List<Integer> r = sut.moreN(input, n);
        assertEquals(e, r);
    }

    @Test
    public void testTransformationArray() {
        int[] outputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11};
        var e =
                ArrayIndexOutOfBoundsException.class;// создали переменную с ожидаемой ошибкой
        var e2 = Exception.class; // тест прошел удачно
        //ожидаемый результат можем передать лямбдой или
    //   Executable executable = () -> sut.transformationArray(outputArray);
        assertThrows(e, () -> sut.transformationArray(outputArray));
    }
 // @ParameterizedTestпараметризированные тесты, данные приходят, не вводим сами
/*аннотация Source указывает откуда берем аргументы   @MethodSource() - из метода
есть и другие варианты смотри @Source
    */

 @ParameterizedTest
    @MethodSource("sourse")
    public void testVolumeCube2 (int r, int e ){
        int result = sut.volumeCube(r);
        assertEquals(e,result);
}
private static Stream<Arguments> sourse() {
        return  Stream.of(Arguments.of(3,27),Arguments.of(6,6*6*6));
 }

 // Hamcrest library
@Test //https://www.baeldung.com/java-junit-hamcrest-guide
    public void givenAList_whenChecksSize_thenCorrect() {
        List<Integer> hamcrestMatchers = Arrays.asList(4,6,7,8);
        assertThat(hamcrestMatchers,hasSize(4));
    }
    @Test
    public void givenValueAndArray_whenValueIsOneOfArrayElements_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat("text", isOneOf(hamcrestMatchers));
    }
//    @ParameterizedTest
//    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
//    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
//            String input, String expected) {
//        String actualValue = input.toUpperCase();
//        assertEquals(expected, actualValue);
//    }
}
