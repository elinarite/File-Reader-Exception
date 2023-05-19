package taskwork;

import java.io.FileReader;
import java.io.*;

////Напишите программу на Java, которая считывает данные из нескольких файлов и записывает их в
//// один файл. Если хотя бы один из файлов не найден, программа должна выбросить исключение
//// FileNotFoundException IO . Если в процессе чтения или записи файла возникают ошибки ввода-вывода,
//// программа должна выбросить исключение IOException. Если при чтении данных из файла происходит
//// ошибка формата, программа должна выбросить исключение FormatException.
public class FileWriterExample {
    public static void main(String[] args) {

        writingFile();
    }

    public static void writingFile() {

        String separator = File.separator;
        String path1 = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "FileReaderFileWriter1";
        String path2 = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "FileReaderFileWriter2";
        String path3 = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "FileReaderFileWriter3";
        String[] inputFiles = {path1, path2, path3};
        String outputFile = "src" + separator + "main" + separator + "java" + separator + "taskwork" + separator + "FileReaderFileWriter4";

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(outputFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String fileName : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.matches("[a-zA-Z]+")) {
                            throw new FormatException("вашем файле не строковой формат");
                        }
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.flush();
                } catch (FormatException e) {
                    System.out.println(e.getMessage());
                } catch (FileNotFoundException e) {
                    System.out.println("файл для чтения не найден" + fileName);
                } catch (IOException e) {
                    System.out.println("Ошибка ввода-вывода при чтении файла: " + fileName);
                }
            }
        } catch (IOException ex) {
            System.out.println("файл для записи не найден: " + outputFile);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Произошла ошибка при закрытии модуля записи файлов.");
            }
        }
    }
}