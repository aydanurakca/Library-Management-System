import java.util.ArrayList;

public class Employee extends Person{
	
	
	private double workingHours;
	private double salary;
	private int ID;
	public Employee(String name, String surname, Phone telPhone, String email, String password, double workingHours,
			double salary ,int ID) {
		super(name, surname, telPhone, email, password);
		this.workingHours = workingHours;
		this.salary = salary;
		this.ID=ID;
	}
	public double getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Employee [workingHours=" + workingHours + ", salary=" + salary + "]";
	}
	
	public void addBook(Book b)
	{
		Test.lib.addBook(b);
	}
	
	public void addCustomer(Customer c)
	{
		Test.lib.addCustomer(c);
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
		return null;
	}
	public String yazma()
	{
		return  getName()+"\t"+getSurname()+"\t"+getTelPhone().toString()+"\t"+getEmail()+"\t"+getPassword()+"\t"+getWorkingHours()+"\t"+getSalary()+"\t"+ID;
	}
}
