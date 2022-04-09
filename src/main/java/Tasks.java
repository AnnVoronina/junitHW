import java.lang.reflect.Array;
import java.util.List;

public class Tasks {


    // Дана длина ребра куба. Найти объем куба

    public int volumeCube(int r) {
        if (r < 0) {
            return 0;
        }
        return r * r * r;
    }

    //Дано расстояние в сантиметрах. Найти число полных мет- ров в нем.

    public int centimetreInMetre(int c) {
        if (c < 0) {
            return 0;
        }
        return (int) Math.floor(c / 100);
    }

    // Дано число n. Из чисел 1, 4, 9, 16, 25, ... напечатать те, которые не превышают n. Оператор цикла с параметром не ис- пользовать
    public List<Integer> moreN(List<Integer> numbers, Integer n) {

        return numbers.stream().filter(number -> number > n).toList();
    }

    //апрашивает отдельно имя и отдельно фамилию, а затем выводит их как одну символьную строку
    public String concatenate(String nextName, String name) {

        return (nextName + " " + name);
    }

    //  преобразование массива
    public int[] transformationArray(int[] array) {
        int[] outputArray = new int[10];
        for (int i = 0; i < array.length; i++) {
            outputArray[i] = array[i]*90;
        } return outputArray;
    }


}
