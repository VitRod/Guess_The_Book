import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
	 
		// ����������  ���������� ����������
		int numOfBooks = 0;
		int randomBook = 0;
		String selectedBook = "";
		String books ="";
		
		// �������������� ������
		File fileWithBooks = new File ("books.txt");
		Scanner scanner = new Scanner(fileWithBooks);
		
		//�������� ���������� ����
		while (scanner.hasNextLine()) {
			String line  = scanner.nextLine();
			
			books += (line + "\n");
			numOfBooks++;
		}
		
		// ���������� ���������� ����
		System.out.println("Number of books: " + numOfBooks);
		
		//�������� ���������  ���������� ���� �������� ��  ��������� ����
		randomBook = (int) (Math.random() * numOfBooks);
		
		//���������� ���������  ���������� ����
		System.out.println("Random book number: " + randomBook);
		
		
		//�������� ��������� �����
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
