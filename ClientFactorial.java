package taskwork;

import java.util.Scanner;

//Напишите программу на Java, которая вычисляет факториал числа, заданного пользователем в качестве входного параметра.
// Если пользователь ввел отрицательное число, программа должна сгенерировать исключение и вывести сообщение об ошибке
// "Введено отрицательное число".
public class ClientFactorial {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inputValue();
    }

    /**
     * В данном коде представлена программа, которая запрашивает у пользователя ввод числа и
     * вычисляет его факториал. Если пользователь вводит отрицательное число, программа генерирует
     * исключение IllegalArgumentException с сообщением "Negative number entered!!!!!!".
     * <p>
     * в коде используется конструкция try-catch-finally. В блоке try программа проверяет,
     * является ли введенное число положительным. Если это так, то программа вычисляет факториал
     * числа и выводит результат. В противном случае, программа генерирует исключение
     * IllegalArgumentException и выводит соответствующее сообщение об ошибке в блоке catch.
     * В блоке finally происходит закрытие сканнера для ввода числа.
     */
    public static void inputValue() {
        System.out.println("please input your number ");
        int value = scanner.nextInt();

        try {
            if (value > 0) {
                System.out.printf("factorial ist %d", calculateFactorial(value));
            } else {
                throw new IllegalArgumentException("Negative number entered!!!!!!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * метод calculateFactorial рекурсивно вычисляет факториал числа
     * <p>
     * Если входное значение value равно 0, то метод возвращает 1,
     * поскольку факториал числа 0 равен 1.
     *<p>
     * В противном случае, метод рекурсивно вызывает себя с аргументом value - 1
     * и умножает результат на value. Это продолжается до тех пор, пока значение value не достигнет 0,
     * после чего происходит возврат результата.

     */
    public static int calculateFactorial(int value) {
        if (value == 0) {
            return 1;
        }
        return value * calculateFactorial(value - 1);
    }
}