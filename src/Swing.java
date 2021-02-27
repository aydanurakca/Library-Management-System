import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Swing extends JFrame {
	
	private String name;
	private String password;
	private String type;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField textPassword;

	/**
	 * Create the frame.
	 */
	public Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(127, 25, 86, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel UserName = new JLabel("User Name:");
		UserName.setBounds(52, 28, 77, 14);
		contentPane.add(UserName);
		
		JLabel Password = new JLabel("Password:");
		Password.setBounds(52, 57, 62, 14);
		contentPane.add(Password);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boss", "Employee", "Customer"}));
		comboBox.setBounds(124, 85, 89, 20);
		contentPane.add(comboBox);
		
		JLabel Type = new JLabel("Type:");
		Type.setBounds(52, 88, 46, 14);
		contentPane.add(Type);
		
		JButton btnSignin = new JButton("Sign-In");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtUserName.getText();
				String password = textPassword.getText();
				String type = (String)comboBox.getSelectedItem();
				isExist(name,password,type);
				
			}

			@SuppressWarnings("deprecation")
			private void isExist(String name, String password, String type) {
				switch(type)
				{
				case "Boss":
					if(Test.lib.getBoss().getName().equals(name) && Test.lib.getBoss().getPassword().equals(password))
					{
						bossScreen bs=new bossScreen();
						bs.show();
						contentPane.setVisible(false);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Wrong entry!!!");
					}
					
					break;
				case "Customer":
					boolean flag=false;
					for(Customer c:Test.lib.getCustomers()) {
						if(c.getName().equals(name)&& c.getPassword().equals(password)) {
							customerScreen cs=new customerScreen(c);
							cs.show();
							contentPane.setVisible(false);
							flag=true;
							dispose();
							break;
						}
					}
					if(!flag)
						JOptionPane.showMessageDialog(null,"Wrong entry!!!");
					break;
				case "Employee":
					flag=false;
					for(Employee e:Test.lib.getEmployees()) {
						if(e.getName().equals(name)&& e.getPassword().equals(password)) {
							employeeScreen es=new employeeScreen(e);
							es.show();
							contentPane.setVisible(false);
							flag=true;
							dispose();
							break;
						}
					}
					if(!flag)
						JOptionPane.showMessageDialog(null,"Wrong entry!!!");
					break;
				}
			
			}
			
			
		});
		btnSignin.setBounds(188, 116, 89, 23);
		contentPane.add(btnSignin);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(126, 54, 86, 20);
		contentPane.add(textPassword);
	}
}
