package lesson2;

import java.util.Arrays;

public class Main {
    static int[][] arr = {{10, 3, 1, 2}, {2, 3, 2, 2}, {5, 6, 7, 1}, {300, 3, 1, 0}};


    public static void main(String[] args) throws MyArrayDataException {
        checkArray(arr);
    }


    public static void checkArray(int[][] arr) throws MyArrayDataException {
        try {
            if (arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 || arr[3].length != 4) {
                throw new MyArraySizeException("массив не равен 4х4");
            }
            fillArray(arr);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка инциализации");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка заполнения");
            e.printStackTrace();
            throw new MyArrayDataException();
        }
    }

    public static void fillArray(int[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum += arr[i][j];
            }
        }
    }
}
