import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("Security names.txt");
        writer.close();

        // Создание объекта для загрузки файлов
        FileLoader fileLoader = new FileLoader();



        // Запуск потока для генерации кодов доступа
        Thread accessCodeGeneratorThread = new Thread(fileLoader::generateAccessCodes);
        accessCodeGeneratorThread.start();

        // Ожидание генерации кодов доступа
        while (!fileLoader.isAccessCodesGenerated()) {
            System.out.println("Генерация кодов доступа...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Вывод содержимого файла
        System.out.println("Содержимое файла:");
        fileLoader.printFileContent();

        // Ввод номера сотрудника
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер сотрудника: ");
        int employeeNumber = scanner.nextInt();

        // Получение информации о сотруднике и его коде доступа
        EmployeeInfo employeeInfo = new EmployeeInfo();
        System.out.println("Сотрудник #" + employeeNumber + ": " + employeeInfo.getName() +
                ", код доступа: " + employeeInfo.getAccessCode());

    }
}
