import java.util.ArrayList;

public class Customer extends Person{

	private int customerId;
	private ArrayList<Book> readBook;
	private ArrayList<BorrowedBook> customerBorrowedBook;
	private boolean status;
	
	
	

	public Customer(String name, String surname, Phone telPhone, String email, String password, int customerId,boolean status) {
		super(name, surname, telPhone, email, password);
		this.customerId = customerId;
		this.readBook = new ArrayList<Book>();
		this.customerBorrowedBook = new ArrayList<BorrowedBook>();
		this.status = status;
	}

	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public ArrayList<Book> getReadBooks() {
		return this.readBook;
	}


	public void setReadBooks(ArrayList<Book> readBooks) {
		this.readBook = readBooks;
	}


	public ArrayList<BorrowedBook> getCustomerBorrowedBook() {
		return customerBorrowedBook;
	}


	public void setCustomerBorrowedBook(ArrayList<BorrowedBook> customerBorrowedBook) {
		this.customerBorrowedBook = customerBorrowedBook;
	}


	public boolean isStatus() {
		return status;
	}

	public void addBorrowedBook(BorrowedBook bb)
	{
		this.customerBorrowedBook.add(bb);
	
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void learnDeadline()
	{
		for(int i=0;i<this.customerBorrowedBook.size();i++)
		{
			System.out.println("Book name :"+customerBorrowedBook.get(i).getBook().getTitle()+" deadline : "+customerBorrowedBook.get(i).getDeliveryDate());
		}
	}

	//This function lists customers borrowed books.
	public void listCustomerBorrowedBook()
	{
		for(int i=0;i<this.customerBorrowedBook.size();i++)
		{
			System.out.println(this.customerBorrowedBook.get(i).toString());
		}
	}
	
	
	@Override
	public Book searchBook(String bookName) {
		ArrayList<Book> temp=Test.lib.getBooks();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getTitle().equalsIgnoreCase(bookName))
			{
				return temp.get(i);
			}	
		}
		System.out.println("The book do not exists !");
		return null;
	}

	@Override
	public Book searchBookByAuthor(String authorName) {
		ArrayList<Book> temp=Test.lib.getBooks();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getAuthor().equalsIgnoreCase(authorName))
			{
				return temp.get(i);
			}	
		}
		System.out.println("The book do not exists !");
		return null;
	}


	@Override
	public String toString() {
		return getName()+"\t"+getSurname()+"\t"+getTelPhone().toString()+"\t"+getEmail()+"\t"+getPassword()+"\t"+getCustomerId()+"\t"+isStatus();
	}

	
}
