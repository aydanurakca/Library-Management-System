import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class customerScreen extends JFrame {

	private JPanel contentPane;
	private JTextField BookNameTxt;
	private JTextField AuthorNameTXT;
	private JPanel panel_1;
	private JPanel panel;
	private JTable table2;
	private DefaultTableModel table;
	private JTable table3;
	private	JPanel tablep;
	private	JPanel tablep1;
	private JTable table_1;
	private JTable table_2;

	public customerScreen(Customer c) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 217, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//This function creates table of borrowed books by their deadline.
		JButton Deadline = new JButton("Learn deadline");
		Deadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel.setVisible(false);
				panel_1.setVisible(false);
				setBounds(100, 100, 637, 519);
				tablep1 = new JPanel();
				tablep1.setBounds(20, 250, 532, 153);
				contentPane.add(tablep1);
				String col[] = {"Title","Author","Deadline"};
				table = new DefaultTableModel(col, 0);
				table_1 = new JTable();
				table_1.setBounds(50, 372, 532, 153);
				tablep1.add(table_1);
				table.addRow(col);
				String temp[]=new String[3];
				for(BorrowedBook b:c.getCustomerBorrowedBook())
				{
					temp[0]=b.getBook().getTitle();
					temp[1]=b.getBook().getAuthor();
					temp[2]=b.getDeliveryDate().toString();
					table.addRow(temp);
				}
				table_1.setModel(table);

				
			}
		});
		Deadline.setBounds(10, 35, 188, 23);
		contentPane.add(Deadline);
		
		//This function creates table of borrowed books.
		JButton listborrowed = new JButton("List borrowed book");
		listborrowed.setBounds(10, 69, 188, 23);
		listborrowed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel.setVisible(false);
				panel_1.setVisible(false);
				setBounds(100, 100, 637, 519);
				tablep = new JPanel();
				tablep.setBounds(20, 250, 600, 153);
				contentPane.add(tablep);
				String col[] = {"Id","Title","Author","PageCount","Publisher","Status"};
				table = new DefaultTableModel(col, 0);
				table_2 = new JTable();
				table_2.setBounds(50, 372, 532, 153);
				tablep.add(table_2);
				table.addRow(col);
				String temp[]=new String[6];
				for(BorrowedBook b:c.getCustomerBorrowedBook())
				{
					temp[0]=Integer.toString(b.getBook().getId());
					temp[1]=b.getBook().getTitle();
					temp[2]=b.getBook().getAuthor();
					temp[3]=Integer.toString(b.getBook().getPageCount());
					temp[4]=b.getBook().getPublisher();
					temp[5]=Boolean.toString(b.getBook().isStatus());
					table.addRow(temp);
				}
				table_2.setModel(table);
			}
		});
		contentPane.add(listborrowed);

		JButton btnNewButton = new JButton("Search book by name");
		btnNewButton.setBounds(10, 103, 188, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablep.setVisible(false);
				tablep1.setVisible(false);
				setBounds(100, 100, 466, 260);
				
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
				tablep.setVisible(false);
				tablep1.setVisible(false);
				setBounds(100, 100, 466, 260);

				tablep.remove(table_1);
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

		JButton SearchedButton = new JButton("Search");
		SearchedButton.setBounds(101, 50, 89, 23);
		panel_1.add(SearchedButton);
		SearchedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=AuthorNameTXT.getText();
				Book book=c.searchBookByAuthor(name);

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

		JButton SearchButtonByName = new JButton("Search");
		SearchButtonByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name=BookNameTxt.getText();
				Book book=c.searchBook(name);
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
		
		
		
		
		
		
		
	
	}
}
