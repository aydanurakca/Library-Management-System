import java.util.ArrayList;


public class Boss extends Person{
	public Boss(String name, String surname, Phone telPhone, String email, String password) {
		super(name, surname, telPhone, email, password);
	}

	public void checkSalary(Employee e)
	{
		double salary=e.getWorkingHours()*10;
		e.setSalary(salary);
	
	}
	
	public void addEmployee(Employee e)
	{
		Test.lib.addEmployee(e);
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
	//This function searches book by the author name.
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

	@Override
	public String toString() {
		return getName()+"\t"+getSurname()+"\t"+getTelPhone().toString()+"\t"+getEmail()+"\t"+getPassword();
	}
	
	
	
}
