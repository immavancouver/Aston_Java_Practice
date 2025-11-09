package exceptions;

public class FileDataManagerApp {
	public static void main(String[] args) {
		FileDataManager manager = new FileDataManager("data.txt");

		try {
			manager.saveToFile("Пример сохранения данных в файл.\nРабота выполнена успешно.");
			System.out.println("Данные успешно записаны.");

			String content = manager.loadFromFile();
			System.out.println("Содержимое файла:");
			System.out.println(content);

		} catch (FileOperationException e) {
			System.err.println("Ошибка: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
