package taskwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

//Создайте программу на Java, которая открывает файл для чтения и выводит его содержимое в консоль.
// Если файл не найден, программа должна вывести сообщение об ошибке "Файл не найден" и продолжить
// выполнение программы.
//6/10 сложность:


public class FileReaderExample {
    public static void main(String[] args) {
        readFile();
    }

    /**
     * В начале метода определена переменная separator, которая содержит символ разделителя для файловой системы (File.separator).
     * Это необходимо для создания правильного пути к файлу, независимо от операционной системы.
     * <p>
     * Затем переменная path формирует путь к файлу, состоящий из относительного пути "src/main/java/taskwork/fileReaderFile",
     * разделенного символом разделителя. Этот путь предполагает, что файл находится в том же модуле проекта,
     * где и выполняемый файл программы.
     * <p>
     * Затем в блоке try создаются экземпляры FileReader и BufferedReader, связанные с указанным файлом.
     * Затем происходит чтение файла построчно с помощью метода readLine() и вывод каждой строки в консоль
     * с помощью System.out.println().
     * <p>
     * Если возникает исключение IOException, программа перехватывает его и выводит сообщение "Файл не найден" в консоль.
     * <p>
     * В блоке finally происходит закрытие потоков bufferedReader и fileReader, чтобы освободить ресурсы.
     * Если потоки не равны null, они закрываются с помощью метода close(). Если при закрытии возникает исключение IOException,
     * программа выводит сообщение "Ошибка при закрытии потоков" в консоль.
     */
    public static void readFile() {
        String separator = File.separator;
        String path = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "fileReaderFile";
        java.io.FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new java.io.FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
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
}