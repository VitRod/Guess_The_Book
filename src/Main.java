import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
	 
		// обь€вление  глобальных переменных
		int numOfBooks = 0;
		int randomBook = 0;
		String selectedBook = "";
		String books ="";
		
		// »нициализируем классы
		File fileWithBooks = new File ("books.txt");
		Scanner scanner = new Scanner(fileWithBooks);
		
		//ѕолучить количество книг
		while (scanner.hasNextLine()) {
			String line  = scanner.nextLine();
			
			books += (line + "\n");
			numOfBooks++;
		}
		
		// напечатать количество книг
		System.out.println("Number of books: " + numOfBooks);
		
		//ѕолучить рандомное  количество книг опира€сь на  текстовый файл
		randomBook = (int) (Math.random() * numOfBooks);
		
		//напечатать рандомное  количество книг
		System.out.println("Random book number: " + randomBook);
		
		
		//ѕолучить выбранную книгу
		File fileWithBooks2 = new File ("books.txt");
		Scanner scanner2 = new Scanner(fileWithBooks2);
		int i = 0;
		while (i <= randomBook) {
			selectedBook = scanner2.nextLine();
			i++;
		}
		
		// System.out.println(selectedBook);
		
		GuessingABook guessingABook = new GuessingABook();
		guessingABook.Start(selectedBook);

	}

}
