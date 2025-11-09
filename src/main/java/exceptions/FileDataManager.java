package exceptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileOperationException extends Exception {
	public FileOperationException(String message, Throwable cause) {
		super(message, cause);
	}
}

public class FileDataManager {
	private final Path filePath;

	public FileDataManager(String fileName) {
		this.filePath = Path.of(fileName);
	}


	public void saveToFile(String data) throws FileOperationException {
		try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
			writer.write(data);
		} catch (IOException e) {
			throw new FileOperationException("Ошибка при записи данных в файл: " + filePath, e);
		}
	}

	public String loadFromFile() throws FileOperationException {
		try {
			return Files.readString(filePath);
		} catch (IOException e) {
			throw new FileOperationException("Ошибка при чтении данных из файла: " + filePath, e);
		}
	}

}

