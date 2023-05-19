package taskwork;

import java.io.*;
import java.util.Arrays;

//9 из 10. Напишите программу на Java для чтения содержимого текстового файла и подсчета
// количества слов в каждой строке. Однако, программа должна быть написана с использованием
// обработки исключений, чтобы обрабатывать ошибки, связанные с открытием файла, чтением
// содержимого файла и любыми другими исключениями, которые могут возникнуть при выполнении
// программы. В случае возникновения исключения, программа должна выводить соответствующее
// сообщение об ошибке и продолжать работу с другими строками файла.
public class WordCount {
    public static void main(String[] args) {

        countWordsInLineFromFile();

    }

    /**
     * Данный метод countWordsInLineFromFile выполняет следующие действия:
     * <p>
     * Создает переменную separator, которая содержит разделитель пути файла,
     * соответствующий операционной системе.
     * Задает путь к файлу в переменной path, предполагая, что файл находится в папке WordCountFile
     * в структуре проекта.
     * Инициализирует переменные count, fileReader и bufferedReader.
     * Открывает файл для чтения, используя FileReader и BufferedReader.
     * Внутри цикла while построчно считывает содержимое файла и присваивает каждую строку переменной line.
     * В блоке try выполняется следующая логика:
     * Проверяется, содержит ли строка только цифры с помощью line.matches("\\d+").
     * Если это так, выбрасывается исключение FormatException с сообщением "содержатся только цифры".
     * Иначе, выводится сообщение с номером строки и количеством слов, полученных с помощью метода
     * countWordWithStream.
     * Переменная count увеличивается на 1.
     * Если возникает исключение FormatException, выводится сообщение об ошибке с номером
     * строки и сообщением об исключении.
     * В блоке catch перехватываются исключения FileNotFoundException и IOException,
     * и выводятся соответствующие сообщения об ошибке.
     * В блоке finally закрываются bufferedReader и fileReader в случае, если они были открыты,
     * и обрабатываются возможные исключения при закрытии потоков
     */

    public static void countWordsInLineFromFile() {
        String separator = File.separator;
        String path = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "WordCountFile";
        int count = 1;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    if (line.matches("\\d+")) {
                        throw new FormatException("содержатся только цифры");
                    }
                    System.out.println("в строке " + count + " слов " + countWordWithStream(line));
                    count++;

                } catch (FormatException e) {
                    System.err.println("в строке " + count + " " + e.getMessage());
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл для чтения не найден");

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при чтении файла");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии потоков");
            }
        }
    }

    /**
     * метод для подсчета количества слов в строке. Он разделяет строку на слова с
     * использованием регулярного выражения \\s (соответствующего пробельным символам)
     * и возвращает количество элементов в массиве слов.
     */

    public static int countWord(String line) {
        String[] words = line.split("\\s");
        return words.length;
    }

    /**
     * метод  для подсчета количества слов в строке с использованием Stream API.
     * Он разделяет строку на слова с помощью регулярного выражения \\s
     * (соответствующего пробельным символам) и подсчитывает количество элементов с
     * помощью метода count().
     */
    public static int countWordWithStream(String line) {
        return (int) Arrays.stream(line.split("\\s")).count();
    }
}