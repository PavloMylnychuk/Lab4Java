import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введіть текст (натисніть Ctrl + Z для завершення):");
            String fileName = "output.txt"; // Ім'я файлу, куди будуть записані дані

            FileWriter fileWriter = new FileWriter(fileName);

            int charCode;
            while ((charCode = reader.read()) != -1) {
                fileWriter.write(charCode);
            }

            fileWriter.close();
            System.out.println("Дані були успішно записані у файл '" + fileName + "'.");
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл.");
            e.printStackTrace();
        }
    }
}
