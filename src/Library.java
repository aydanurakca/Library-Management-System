import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;
	private ArrayList<Employee> employees;
	private ArrayList<Customer> customers;
	private Boss boss;
	private ArrayList<BorrowedBook> borrowedBook;
	
	public Library() {
		super();
		this.books =new ArrayList<Book>();
		this.employees = new ArrayList<Employee>() ;
		this.customers = new ArrayList<Customer>();
		this.borrowedBook = new ArrayList<BorrowedBook>();
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	public ArrayList<BorrowedBook> getBorrowedBook() {
		return borrowedBook;
	}
	public void setBorrowedBook(ArrayList<BorrowedBook> borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	
	public Book searchBook(Book b)
	{
		
		if(!this.books.contains(b))
		{
			System.out.println("this book not exists.");
			return null;
		}
		for(int i=0;i<this.books.size();i++)
		{
			if(this.books.get(i).getId()==b.getId())
			{
				return books.get(i);
			}
		}
		return null;
		
		
	}

	public Book searchBook(String s)
	{
		
		
		for(int i=0;i<this.books.size();i++)
		{
			if(this.books.get(i).getTitle().equalsIgnoreCase(s))
			{
				return books.get(i);
			}
		}
		return null;
		
		
	}
	public Book searchBookbyAuthor(String s)
	{
		
		
		for(int i=0;i<this.books.size();i++)
		{
			if(this.books.get(i).getAuthor().equalsIgnoreCase(s))
			{
				return books.get(i);
			}
		}
		return null;
		
		
	}
	
	public void addBook(Book b)
	{
		books.add(b);
	}
	
	public void addCustomer(Customer c)
	{
		customers.add(c);
	}
	public void addEmployee(Employee c)
	{
		employees.add(c);
	}

	public void addBorrowedBook(BorrowedBook bb)
	{
		this.borrowedBook.add(bb);
	
	}
	public void deleteBorrowedBook(BorrowedBook bb)
	{
		if(!this.borrowedBook.contains(bb))
		{
			System.out.println("this operations can not find");
			return ;
		}
		for(int i=0;i<this.borrowedBook.size();i++)
		{
			if(this.borrowedBook.get(i).getId()==(bb.getId()))
			{
				 this.borrowedBook.remove(i);
			}
		}
	}
	public void listBorrowedBook()
	{
		for(int i=0;i<this.borrowedBook.size();i++)
		{
			this.borrowedBook.get(i).toString();
		}
		
	}
	public Employee findEmployee(int id) {
		for(Employee e:this.employees)
		{
			if(e.getID()==id)
			{
				return e;
			}
		}
		return null;
	}
	
	
	
}
