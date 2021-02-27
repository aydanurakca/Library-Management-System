import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class bossScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField NameText;
	private JTextField BookNameTxt;
	private JTextField AuthorNameTXT;
	private JPanel checkSalaryPanel ;
	private JPanel AddEmployeePanel;
	private JPanel panel_1;
	private JPanel panel;
	private JTextField Phone;
	private JTextField Email;
	private JPasswordField PasswordText;
	
	public bossScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 223, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		//This part of class sets the visibility of unrelated panels.
		JButton btnSalary = new JButton("Check salary for employee");
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 466, 260);
				checkSalaryPanel.setVisible(true);
				AddEmployeePanel.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(false);
			}
		});
		btnSalary.setBounds(10, 35, 188, 23);
		contentPane.add(btnSalary);

		//This part of class sets the visibility of unrelated panels.
		JButton btnAddEmp = new JButton("Add new employee");
		btnAddEmp.setBounds(10, 69, 188, 23);
		btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkSalaryPanel.setVisible(false);
				AddEmployeePanel.setVisible(true);
				panel_1.setVisible(false);
				panel.setVisible(false);
				setBounds(100, 100, 466, 260);
			}
		});
		contentPane.add(btnAddEmp);

		//This part of class sets the visibility of unrelated panels.
		JButton btnNewButton = new JButton("Search book by name");
		btnNewButton.setBounds(10, 103, 188, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 466, 260);
				checkSalaryPanel.setVisible(false);
				AddEmployeePanel.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(true);

			}
		});
		contentPane.add(btnNewButton);

		//This part of class sets the visibility of unrelated panels.
		JButton btnSearchBookBy = new JButton("Search book by author");
		btnSearchBookBy.setBounds(10, 137, 188, 23);
		btnSearchBookBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 466, 260);
				checkSalaryPanel.setVisible(false);
				AddEmployeePanel.setVisible(false);
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		contentPane.add(btnSearchBookBy);



		panel_1 = new JPanel();
		panel_1.setBounds(208, 56, 200, 86);
		contentPane.add(panel_1);
		panel_1.setVisible(false);
		panel_1.setLayout(null);


		JLabel lblAuthorName = new JLabel("Author name:");
		lblAuthorName.setBounds(10, 22, 86, 14);
		panel_1.add(lblAuthorName);

		AuthorNameTXT = new JTextField();
		AuthorNameTXT.setColumns(10);
		AuthorNameTXT.setBounds(88, 19, 86, 20);
		panel_1.add(AuthorNameTXT);

		//When search button is selected this function searches book by the author name.
		JButton SearchedButton = new JButton("Search");
		SearchedButton.setBounds(101, 50, 89, 23);
		panel_1.add(SearchedButton);
		SearchedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=AuthorNameTXT.getText();
				Book book=Test.lib.getBoss().searchBookByAuthor(name);

				if(book==null)
				{
					JOptionPane.showMessageDialog(null,"There is no book with that author name.");
					setBounds(100, 100, 216, 250);				}

				else
				{
					JOptionPane.showMessageDialog(null,book.getTitle());
				}
			}
		});
		

		AddEmployeePanel = new JPanel();
		AddEmployeePanel.setBounds(208, 35, 200, 166);
		contentPane.add(AddEmployeePanel);
		AddEmployeePanel.setVisible(false);
		AddEmployeePanel.setLayout(null);

		//When add button is selected a new employee is added to the library.
		JButton AddButton = new JButton("Add");
		AddButton.setBounds(69, 134, 89, 23);
		AddEmployeePanel.add(AddButton);
		AddButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{setBounds(100, 100, 466, 260);
				String []name=NameText.getText().split(" ");
				String password=PasswordText.getText();
				String email=Email.getText();
				String [] phone=Phone.getText().split(" ");
				Phone p=new Phone(Integer.parseInt(phone[0]),Integer.parseInt(phone[1]),Integer.parseInt(phone[2]));
				Employee employee=new Employee(name[0],name[1],p,email,password,6.0,10.0,Test.lib.getEmployees().size()+1);
				JOptionPane.showMessageDialog(null,"Employee is added!!");
				Test.lib.addEmployee(employee);
				File file = new File("data/employee.txt");
				PrintWriter pw = new PrintWriter(new FileOutputStream(file));
				FileOutputStream fo = new FileOutputStream(file);
				for(Employee e:Test.lib.getEmployees())
				{
					pw.println(e.yazma());
				}
				pw.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Wrong entry!!");
				}

			}

		});


		JLabel lblName = new JLabel("Name surname:");
		lblName.setBounds(10, 11, 98, 14);
		AddEmployeePanel.add(lblName);

		NameText = new JTextField();
		NameText.setBounds(101, 8, 86, 20);
		AddEmployeePanel.add(NameText);
		NameText.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 73, 14);
		AddEmployeePanel.add(lblPassword);

		Phone = new JTextField();
		Phone.setBounds(101, 61, 86, 20);
		AddEmployeePanel.add(Phone);
		Phone.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 61, 46, 14);
		AddEmployeePanel.add(lblPhone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 86, 46, 14);
		AddEmployeePanel.add(lblEmail);

		Email = new JTextField();
		Email.setBounds(101, 92, 86, 20);
		AddEmployeePanel.add(Email);
		Email.setColumns(10);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(101, 36, 86, 20);
		AddEmployeePanel.add(PasswordText);

		checkSalaryPanel = new JPanel();
		checkSalaryPanel.setBounds(208, 35, 200, 86);
		contentPane.add(checkSalaryPanel);
		checkSalaryPanel.setVisible(false);
		checkSalaryPanel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(104, 8, 86, 20);
		checkSalaryPanel.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(101, 37, 89, 23);
		checkSalaryPanel.add(btnSearch);

		JLabel lblId = new JLabel("Employee ID:");
		lblId.setBounds(10, 11, 84, 14);
		checkSalaryPanel.add(lblId);

		panel = new JPanel();
		panel.setBounds(208, 35, 200, 151);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblBookName = new JLabel("Book name:");
		lblBookName.setBounds(17, 42, 68, 14);
		panel.add(lblBookName);

		BookNameTxt = new JTextField();
		BookNameTxt.setBounds(95, 39, 86, 20);
		panel.add(BookNameTxt);
		BookNameTxt.setColumns(10);
 
		//When search button is selected this function searches book by its name.
		JButton SearchButtonByName = new JButton("Search");
		SearchButtonByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=BookNameTxt.getText();
				Book book=Test.lib.getBoss().searchBook(name);
				if(book==null)
				{
					JOptionPane.showMessageDialog(null,"There is no book with that tittle.");
					setBounds(100, 100, 216, 250);				}

				else
				{
					JOptionPane.showMessageDialog(null,book.isStatus());
				}
			}
		});
		SearchButtonByName.setBounds(92, 70, 89, 23);
		panel.add(SearchButtonByName);
		btnSearch.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(textField.getText());
				Employee employee=Test.lib.findEmployee(id);
				if(employee==null)
				{
					JOptionPane.showMessageDialog(null,"There is no employee with that id.");
					setBounds(100, 100, 216, 250);				}

				else
				{

					Test.lib.getBoss().checkSalary(employee);
					JOptionPane.showMessageDialog(null,employee.getName()+"'s salary: "+employee.getSalary());
				}

			}

		});
		
	}
}
