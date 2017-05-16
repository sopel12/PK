import java.util.List;

import dao.KalendarzDAO;
import model.Czytelnik;

public class JDBCTest {
	public static void main(String[] args) {
		KalendarzDAO b = new KalendarzDAO();
//		czytelnicy.add(new Czytelnik(1, "Pawel", "Cichocki", "123"));
//		czytelnicy.add(new Czytelnik(2, "Piotr", "Cichocki", "1234"));
//		czytelnicy.add(new Czytelnik(3, "Gaweł", "Cichocki", "12345"));
//		b.insertCzytelnik(imie, nazwisko, pesel)

		b.insertCzytelnik("Pawel", "Cichocki", "123");
		b.insertCzytelnik("Piotr", "Cichocki", "1234");
		b.insertCzytelnik("Gaweł", "Cichocki", "12345");
		
		List<Czytelnik> czytelnicy = b.selectCzytelnicy();
		
		System.out.println("Lista czytelników: ");
		for (Czytelnik c : czytelnicy)
			System.out.println(c);
		b.closeConnection();
	}
}