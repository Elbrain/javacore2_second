package lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(){
        super("В масиве находятся не только буквы");
    }
}
