import java.util.ArrayList;

public class Type {
	private ArrayList<Book> listBook;

	public Type(ArrayList<Book> listBook) {
		this.listBook =listBook;
	}

	public ArrayList<Book> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<Book> listBook) {
		this.listBook = listBook;
	}
	
	public  void addBook(Book b) {
		this.listBook.add(b);	
	}
	
	public  void deleteBook(Book b) {
		if(this.listBook.isEmpty())
			return;
		if(this.listBook.contains(b))
		{
			listBook.remove(b);
		}
		else
		{
			System.out.println("This book not exists");
		}
	}
	
}


