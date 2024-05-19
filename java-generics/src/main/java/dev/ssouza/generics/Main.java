package dev.ssouza.generics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 2, 4, 5 };
        Double[] doubles = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        Character[] chars = { 'A', 'E', 'I', 'O', 'U' };
        String[] strings = { "Hello", "World" };

        /*printArray(numbers);
        printArray(doubles);
        printArray(chars);
        printArray(strings);
        */
        System.out.println(findDuplicated(numbers));
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

    public static int findDuplicated(int[] array) {
        for(int i=0;i<array.length;i++){
            int index = Math.abs(array[i]) -1;
            if(array[index] < 0){
                System.out.println(index);
                return Math.abs(array[i]);
            }

            System.out.println(index);
            array[index] = -array[index];
        }

        return -1;
    }
}
