package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0)
            return new int[0];

        int x = inputArray[inputArray.length - 1];
        for(int i = inputArray.length - 1; i >= 1; i--)
            inputArray[i] = inputArray[i-1];
        inputArray[0] = x;

        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return 0;
        if (inputArray.length == 1)
            return inputArray[0];

        Arrays.sort(inputArray);

        return Math.max(inputArray[0] * inputArray[1], inputArray[inputArray.length - 1] * inputArray[inputArray.length - 2]);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0)
            return 0;

        input = input.toUpperCase();

        int count = 0;
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == 'A' || input.charAt(i) == 'B')
                count++;

        return (count * 100) / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;

        for(int i = 0, j = input.length() - 1; i < j; i++, j--)
            if (input.charAt(i) != input.charAt(j))
                return false;

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int j = i;
            while (j < input.length() && input.charAt(i) == input.charAt(j))
                j++;
            stringBuilder.append(input.charAt(i));
            stringBuilder.append(j - i);
            i = j;
        }

        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.equals("") || two.equals("") || one.length() != two.length())
            return false;

        int set1[] = new int[256];
        int set2[] = new int[256];

        for (int i = 0; i < one.length(); i++) {
            set1[one.charAt(i)]++;
            set2[two.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++)
            if (set1[i] != set2[i])
                return false;

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0)
            return false;

        int ch[] = new int[256];
        for (int i = 0; i < s.length(); i++)
            if(ch[s.charAt(i)]++ == 1)
                return false;

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if( m == null || m.length == 0)
            return new int[][]{{}, {}};

        int tmp;
        for(int i = 0; i < m.length; i++)
            for(int j = i; j < m[0].length; j++){
                tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null)
            return "";

        if(separator == null)
            separator = ' ';

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputStrings.length; i++) {
            stringBuilder.append(inputStrings[i]);
            if (inputStrings.length != i + 1)
                stringBuilder.append(separator);
        }

        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;

        int num = 0;
        for (String str : inputStrings)
            if(str.startsWith(prefix))
                num++;

        return num;
    }
}
