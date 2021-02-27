
public abstract class Person {
 
	private String name;
	private String surname;
	private Phone telPhone;
	private String email;
	private String password;
	
	
	
	public Person(String name, String surname, Phone telPhone, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.telPhone = telPhone;
		this.email = email;
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Phone getTelPhone() {
		return telPhone;
	}


	public void setTelPhone(Phone telPhone) {
		this.telPhone = telPhone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	abstract public Book searchBook(String bookName);
	abstract public Book searchBookByAuthor(String authorName);
	
}
