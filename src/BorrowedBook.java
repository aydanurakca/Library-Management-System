
public class BorrowedBook {
	private int id;
	private Customer customer;
	private Book book;
	private Date pickUpDate;
	private Date deliveryDate;
	public BorrowedBook(int id,Customer customer, Book book, Date pickUpDate, Date deliveryDate) {
		super();
		this.id=id;
		this.customer = customer;
		this.book = book;
		this.pickUpDate = pickUpDate;
		this.deliveryDate = deliveryDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "customer name=" +  customer.getName() + ", book title=" + book.getTitle() + ", pickUpDate=" + pickUpDate
				+ ", deliveryDate=" + deliveryDate;
	}
	public String yazma()
	{
		return id+"\t"+customer.getCustomerId()+"\t"+book.getId()+"\t"+pickUpDate.toString()+"\t"+deliveryDate.toString();
	}
	
	
	
	
}
