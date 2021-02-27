import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class employeeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField BookTittleForAdd;
	private JTextField authorName;
	private JTextField publisher;
	private JTextField pageCount;
	private JTextField releaseDate;
	private JComboBox bookType;
	private JTextField nameTextCust;
	private JTextField textPhonecust;
	private JTextField textemailCust;
	private JPasswordField textPasswordCust;
    private JPanel panelAddcust;
    private JPanel addBookPanel;
    private JTextField bookname;
    private JPanel searchByName;
    private JTextField authornameText;
	private JButton btnSearchAuthor;
	private JPanel searchByAuthorPanel;
	private JTextField customerID;
	private JTextField textbookID;
	private JTextField textgiveDate;
	private JTextField pickupDate;
	private  JPanel giveBookPanel;
	private JPanel TakeBookPanel;
	private JTextField bbID;
    
	public employeeScreen(Employee emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Search book by author");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(false);
				addBookPanel.setVisible(false);
				searchByName.setVisible(false);
				searchByAuthorPanel.setVisible(true);
				giveBookPanel.setVisible(false);
				TakeBookPanel.setVisible(false);
			}
		});
		button.setBounds(10, 170, 188, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Search book by name");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(false);
				addBookPanel.setVisible(false);
				searchByName.setVisible(true);
				searchByAuthorPanel.setVisible(false);
				giveBookPanel.setVisible(false);
				TakeBookPanel.setVisible(false);
			}
		});
		button_1.setBounds(10, 120, 188, 23);
		contentPane.add(button_1);
		//This part of class sets the visibility of unrelated panels.
		JButton btnAddBook = new JButton("Add book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(false);
				addBookPanel.setVisible(true);
				searchByName.setVisible(false);
				searchByAuthorPanel.setVisible(false);
				giveBookPanel.setVisible(false);
				TakeBookPanel.setVisible(false);
			}
		});
		btnAddBook.setBounds(10, 20, 188, 23);
		contentPane.add(btnAddBook);
		//This part of class sets the visibility of unrelated panels.
		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.setBounds(10, 70, 188, 23);
		contentPane.add(btnAddCustomer);
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(true);
				addBookPanel.setVisible(false);
				searchByName.setVisible(false);
				searchByAuthorPanel.setVisible(false);
				giveBookPanel.setVisible(false);
				TakeBookPanel.setVisible(false);
				
			}
		});
		//This part of class sets the visibility of unrelated panels.
		JButton btnNewButton = new JButton("Take book from customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(false);
				addBookPanel.setVisible(false);
				searchByName.setVisible(false);
				searchByAuthorPanel.setVisible(false);
				giveBookPanel.setVisible(false);
				TakeBookPanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 270, 188, 23);
		contentPane.add(btnNewButton);
		//This part of class sets the visibility of unrelated panels.
		JButton btnNewButton_1 = new JButton("Give book to customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 570, 350);
				panelAddcust.setVisible(false);
				addBookPanel.setVisible(false);
				searchByName.setVisible(false);
				searchByAuthorPanel.setVisible(false);
				giveBookPanel.setVisible(true);
				TakeBookPanel.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 220, 188, 23);
		contentPane.add(btnNewButton_1);
		
		panelAddcust = new JPanel();
		panelAddcust.setBounds(237, 39, 253, 149);
		contentPane.add(panelAddcust);
		panelAddcust.setLayout(null);
		
		JLabel lblnameCus = new JLabel("Name Surname:");
		lblnameCus.setBounds(10, 11, 94, 14);
		panelAddcust.add(lblnameCus);
		
		nameTextCust = new JTextField();
		nameTextCust.setBounds(114, 8, 86, 20);
		panelAddcust.add(nameTextCust);
		nameTextCust.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 36, 46, 14);
		panelAddcust.add(lblPhone);
		
		textPhonecust = new JTextField();
		textPhonecust.setBounds(114, 33, 86, 20);
		panelAddcust.add(textPhonecust);
		textPhonecust.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 61, 46, 14);
		panelAddcust.add(lblEmail);
		
		textemailCust = new JTextField();
		textemailCust.setBounds(114, 58, 86, 20);
		panelAddcust.add(textemailCust);
		textemailCust.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 86, 94, 14);
		panelAddcust.add(lblPassword);
		
		//This function adds customer to the library.
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[]name=nameTextCust.getText().split(" ");
				String []phone=textPhonecust.getText().split(" ");
				Phone p=new Phone(Integer.parseInt(phone[0]),Integer.parseInt(phone[1]),Integer.parseInt(phone[2]));
				String email= textemailCust.getText();
				String password=textPasswordCust.getText();
				Customer c=new Customer(name[0], name[1], p, email, password, Test.lib.getCustomers().size()+1, true);
				Test.lib.addCustomer(c);
				JOptionPane.showMessageDialog(null,"Customer is added!!");
				
				try {
					File file = new File("data/customer.txt");
					PrintWriter pw = new PrintWriter(new FileOutputStream(file));
					FileOutputStream fo = new FileOutputStream(file);
					for(Customer cust: Test.lib.getCustomers())
					{
						pw.println(cust.toString());
					}
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				

			}
		});
		btnAdd.setBounds(154, 114, 89, 23);
		panelAddcust.add(btnAdd);
		
		textPasswordCust = new JPasswordField();
		textPasswordCust.setBounds(114, 83, 86, 20);
		panelAddcust.add(textPasswordCust);
		
		addBookPanel = new JPanel();
		addBookPanel.setBounds(237, 24, 253, 257);
		contentPane.add(addBookPanel);
		addBookPanel.setLayout(null);
		
		BookTittleForAdd = new JTextField();
		BookTittleForAdd.setBounds(110, 11, 101, 20);
		addBookPanel.add(BookTittleForAdd);
		BookTittleForAdd.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(22, 14, 46, 14);
		addBookPanel.add(lblTitle);
		
		authorName = new JTextField();
		authorName.setBounds(110, 42, 101, 20);
		addBookPanel.add(authorName);
		authorName.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(22, 43, 46, 14);
		addBookPanel.add(lblAuthor);
		
		publisher = new JTextField();
		publisher.setBounds(110, 71, 101, 20);
		addBookPanel.add(publisher);
		publisher.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setBounds(22, 74, 68, 14);
		addBookPanel.add(lblPublisher);
		
		pageCount = new JTextField();
		pageCount.setBounds(110, 106, 101, 20);
		addBookPanel.add(pageCount);
		pageCount.setColumns(10);
		
		JLabel lblPageCount = new JLabel("Page Count:");
		lblPageCount.setBounds(22, 109, 68, 14);
		addBookPanel.add(lblPageCount);
		
		releaseDate = new JTextField();
		releaseDate.setBounds(110, 137, 101, 20);
		addBookPanel.add(releaseDate);
		releaseDate.setColumns(10);
		
		JLabel lblRelaseDate = new JLabel("Release Date:");
		lblRelaseDate.setBounds(22, 139, 86, 14);
		addBookPanel.add(lblRelaseDate);
		
		bookType = new JComboBox();
		bookType.setModel(new DefaultComboBoxModel(new String[] {"Poem", "Child", "Science Fiction", "Computer", "Physcology"}));
		bookType.setBounds(110, 167, 101, 20);
		addBookPanel.add(bookType);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(22, 170, 46, 14);
		addBookPanel.add(lblType);
		
		//This function adds book to the library.
		JButton bookAdd = new JButton("Add");
		bookAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title=BookTittleForAdd.getText();
				String author=authorName.getText();
				String publisherName=publisher.getText();
				int page=Integer.parseInt(pageCount.getText());
				String[] date=releaseDate.getText().split("/");																									
				String type=(String) bookType.getSelectedItem();
				Book b;
				switch(type) {
					case "Physcology":
						b=new Book(Test.lib.getBooks().size()+1,title,author,publisherName,page,new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new PhyscologyBook(),true);					
						JOptionPane.showMessageDialog(null,"Book is added!!");
						Test.lib.addBook(b);
						break;
					case "Child":
						b=new Book(Test.lib.getBooks().size()+1,title,author,publisherName,page,new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new ChildBook(),true);					
						JOptionPane.showMessageDialog(null,"Book is added!!");
						Test.lib.addBook(b);
						break;
					case "Computer":
						b=new Book(Test.lib.getBooks().size()+1,title,author,publisherName,page,new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new ComputerBook(),true);					
						JOptionPane.showMessageDialog(null,"Book is added!!");
						Test.lib.addBook(b);
						break;
					case "Poem":
						b=new Book(Test.lib.getBooks().size()+1,title,author,publisherName,page,new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new PoemBook(),true);					
						JOptionPane.showMessageDialog(null,"Book is added!!");
						Test.lib.addBook(b);
						break;
					case "Science Fiction":
						b=new Book(Test.lib.getBooks().size()+1,title,author,publisherName,page,new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])),new ScienceFictionBook(),true);					
						JOptionPane.showMessageDialog(null,"Book is added!!");
						Test.lib.addBook(b);
						break;
					default:
						System.out.println("Wrong book type");
						break;
				}
				try {
					File file = new File("data/books.txt");
					PrintWriter pw = new PrintWriter(new FileOutputStream(file));
					FileOutputStream fo = new FileOutputStream(file);
					for(Book book:Test.lib.getBooks())
					{
						pw.println(book.yazma());
					}
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		bookAdd.setBounds(154, 223, 89, 23);
		addBookPanel.add(bookAdd);
		
		 searchByName = new JPanel();
		 searchByName.setBounds(247, 112, 261, 81);
		contentPane.add(searchByName);
		searchByName.setLayout(null);
		
		bookname = new JTextField();
		bookname.setBounds(108, 11, 86, 20);
		searchByName.add(bookname);
		bookname.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book name:");
		lblBookName.setBounds(27, 14, 86, 14);
		searchByName.add(lblBookName);
		//This function searches book by its name.
		JButton SearchByNamebutton = new JButton("Search");
		SearchByNamebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book=emp.searchBook(bookname.getText());
				if(book==null)
				{
					JOptionPane.showMessageDialog(null,"There is no book with that name.");
					setBounds(100, 100, 216, 250);				
				}
				else
				{
					JOptionPane.showMessageDialog(null,book.getTitle());
				}
				
			}
		});
		SearchByNamebutton.setBounds(142, 41, 89, 23);
		searchByName.add(SearchByNamebutton);
		
		 searchByAuthorPanel = new JPanel();
		 searchByAuthorPanel.setBounds(237, 119, 282, 92);
		 contentPane.add(searchByAuthorPanel);
		 searchByAuthorPanel.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("Author name: ");
		 lblNewLabel.setBounds(10, 24, 92, 14);
		 searchByAuthorPanel.add(lblNewLabel);
		 
		 authornameText = new JTextField();
		 authornameText.setBounds(100, 21, 86, 20);
		 searchByAuthorPanel.add(authornameText);
		 authornameText.setColumns(10);
		 //This function searches book by authors name.
		  btnSearchAuthor = new JButton("Search");
		  btnSearchAuthor.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Book book=emp.searchBookByAuthor(authornameText.getText());
				if(book==null)
				{
					JOptionPane.showMessageDialog(null,"There is no book with that author name.");
					setBounds(100, 100, 216, 250);				
				}
				else
				{
					JOptionPane.showMessageDialog(null,book.getTitle());
				}
		  	}
		  });
		  btnSearchAuthor.setBounds(97, 58, 89, 23);
		  searchByAuthorPanel.add(btnSearchAuthor);
		  
		   giveBookPanel = new JPanel();
		  giveBookPanel.setBounds(241, 85, 303, 140);
		  contentPane.add(giveBookPanel);
		  giveBookPanel.setLayout(null);
		  
		  JLabel lblCustomerId = new JLabel("Customer ID:");
		  lblCustomerId.setBounds(10, 11, 94, 14);
		  giveBookPanel.add(lblCustomerId);
		  
		  customerID = new JTextField();
		  customerID.setBounds(105, 8, 86, 20);
		  giveBookPanel.add(customerID);
		  customerID.setColumns(10);
		  
		  JLabel lblBookId = new JLabel("Book ID:");
		  lblBookId.setBounds(10, 36, 71, 14);
		  giveBookPanel.add(lblBookId);
		  
		  textbookID = new JTextField();
		  textbookID.setBounds(105, 33, 86, 20);
		  giveBookPanel.add(textbookID);
		  textbookID.setColumns(10);
		  
		  textgiveDate = new JTextField();
		  textgiveDate.setBounds(105, 58, 86, 20);
		  giveBookPanel.add(textgiveDate);
		  textgiveDate.setColumns(10);
		  
		  JLabel lblDel = new JLabel("Delivery Date:");
		  lblDel.setBounds(10, 61, 94, 14);
		  giveBookPanel.add(lblDel);
		  
		  JLabel lblPickupDate = new JLabel("Pickup Date:");
		  lblPickupDate.setBounds(10, 86, 94, 14);
		  giveBookPanel.add(lblPickupDate);
		  
		  pickupDate = new JTextField();
		  pickupDate.setBounds(105, 83, 86, 20);
		  giveBookPanel.add(pickupDate);
		  pickupDate.setColumns(10);
		  //If a customer's borrowed books are less than three books  and the searched book is available the book is borrowed.
		  JButton giveBookButton = new JButton("Enter");
		  giveBookButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Book book=Test.lib.getBooks().get(Integer.parseInt(textbookID.getText())-1);
		  		if(book.isStatus() && Test.lib.getCustomers().get(Integer.parseInt(customerID.getText())-1).getCustomerBorrowedBook().size()<3)
		  		{
		  			String[] date1=textgiveDate.getText().split("/");
		  			Date d1=new Date(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]));
		  			date1=pickupDate.getText().split("/");
		  			Date d2=new Date(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]));
		  			BorrowedBook bb=new BorrowedBook(Test.lib.getBorrowedBook().size()+1,Test.lib.getCustomers().get(Integer.parseInt(customerID.getText())),book,d1,d2);
		  			Test.lib.addBorrowedBook(bb);
		  			Test.lib.getCustomers().get(Integer.parseInt(customerID.getText())).addBorrowedBook(bb);
		  			book.setStatus(false);
		  			JOptionPane.showMessageDialog(null,"Done !");
		  		}
		  		else if(!book.isStatus())
		  		{
		  			JOptionPane.showMessageDialog(null,"This book given someone else .");
		  		}
		  		else
		  		{
		  			JOptionPane.showMessageDialog(null,"This customer has 3 book already.");
		  		}
		  		try {
					File file = new File("data/borrowedbook.txt");
					PrintWriter pw = new PrintWriter(new FileOutputStream(file));
					FileOutputStream fo = new FileOutputStream(file);
					for(BorrowedBook borrowed:Test.lib.getBorrowedBook())
					{
						pw.println(borrowed.yazma());
					}
					pw.close();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
		  	}
		  });
		  giveBookButton.setBounds(105, 106, 89, 23);
		  giveBookPanel.add(giveBookButton);
		  
		  TakeBookPanel = new JPanel();
		  TakeBookPanel.setBounds(223, 85, 261, 119);
		  contentPane.add(TakeBookPanel);
		  TakeBookPanel.setLayout(null);
		  
		  JLabel lblBorrowedBookId = new JLabel("Borrowed Book ID:");
		  lblBorrowedBookId.setBounds(10, 11, 119, 14);
		  TakeBookPanel.add(lblBorrowedBookId);
		  
		  bbID = new JTextField();
		  bbID.setBounds(122, 8, 86, 20);
		  TakeBookPanel.add(bbID);
		  bbID.setColumns(10);
		  
		  //This function takes back the book that customer has borrowed before.
		  JButton btnTakeBook = new JButton("Enter");
		  btnTakeBook.setBounds(119, 39, 89, 23);
		  TakeBookPanel.add(btnTakeBook);
		  btnTakeBook.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		int id= Integer.parseInt(bbID.getText());
			  		BorrowedBook bb=Test.lib.getBorrowedBook().get(id-1);
			  		if(Test.lib.getBorrowedBook().contains(bb) && Test.lib.getBorrowedBook().size()>id)
			  		{
			  			bb.getBook().setStatus(true);
			  			Test.lib.deleteBorrowedBook(bb);
			  			bb.getCustomer().getCustomerBorrowedBook().remove(bb);		  
			  			JOptionPane.showMessageDialog(null,bb);
			  		}
			  		else
			  		{
			  			JOptionPane.showMessageDialog(null,"There is no operations such that.");
			  		}
			  		try {
						File file = new File("data/borrowedbook.txt");
						PrintWriter pw = new PrintWriter(new FileOutputStream(file));
						FileOutputStream fo = new FileOutputStream(file);
						for(BorrowedBook borrowed:Test.lib.getBorrowedBook())
						{
							pw.println(borrowed.yazma());
						}
						pw.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}
			  	}
		  });
	}
}

