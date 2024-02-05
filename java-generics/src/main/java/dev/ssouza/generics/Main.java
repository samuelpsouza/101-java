package dev.ssouza.generics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        Double[] doubles = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        Character[] chars = { 'A', 'E', 'I', 'O', 'U' };
        String[] strings = { "Hello", "World" };

        printArray(numbers);
        printArray(doubles);
        printArray(chars);
        printArray(strings);
    }

    public static <Tipo> void printArray(Tipo[] arrayTipos) {
        Arrays.stream(arrayTipos)
                .forEach(System.out::println);
    }

    /*
        public static void printArray(Integer[] numbers) {
            Arrays.stream(numbers)
                    .forEach(System.out::println);
        }

        public static void printArray(Double[] doubles) {
            Arrays.stream(doubles)
                    .forEach(System.out::println);
        }

        public static void printArray(Character[] chars) {
            Arrays.stream(chars)
                    .forEach(System.out::println);
        }

        public static void printArray(String[] strings) {
            Arrays.stream(strings)
                    .forEach(System.out::println);
        }

    */
}
