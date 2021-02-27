import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {
	public static Library lib= new Library();
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			FileInputStream fStream=new FileInputStream("data/boss.txt");
			DataInputStream dStream=new DataInputStream(fStream);
			BufferedReader bReader=new BufferedReader(new InputStreamReader(dStream));
			String str=bReader.readLine();
			while(str!=null) {
				System.out.println(str);
				String []data=str.split("\t");
				Phone phone=new Phone(Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]));
				Boss boss=new Boss(data[0],data[1],phone,data[5],data[6]);
				lib.setBoss(boss);
				str=bReader.readLine();
			}



			fStream=new FileInputStream("data/customer.txt");
			dStream=new DataInputStream(fStream);
			bReader=new BufferedReader(new InputStreamReader(dStream));
			String str1=bReader.readLine();
			while(str1!=null) {

				String []data1=str1.split("\t");
				Phone phone=new Phone(Integer.valueOf(data1[2]),Integer.valueOf(data1[3]),Integer.valueOf(data1[4]));
				Customer customer=new Customer(data1[0],data1[1],phone,data1[5],data1[6],Integer.parseInt(data1[7]),Boolean.parseBoolean(data1[8]));
				lib.addCustomer(customer);
				str1=bReader.readLine();
			}


			fStream=new FileInputStream("data/employee.txt");
			dStream=new DataInputStream(fStream);
			bReader=new BufferedReader(new InputStreamReader(dStream));
			String str2=bReader.readLine();
			while(str2!=null) {

				String []data1=str2.split("\t");
				Phone phone=new Phone(Integer.valueOf(data1[2]),Integer.valueOf(data1[3]),Integer.valueOf(data1[4]));
				Employee emp=new Employee(data1[0],data1[1],phone,data1[5],data1[6],Double.parseDouble(data1[7]),Double.parseDouble(data1[8]),Integer.parseInt(data1[9]));
				lib.addEmployee(emp);
				str2=bReader.readLine();
			}
			fStream=new FileInputStream("data/books.txt");
			dStream=new DataInputStream(fStream);
			bReader=new BufferedReader(new InputStreamReader(dStream));
			str2=bReader.readLine();
			while(str2!=null) {

				String []data1=str2.split("\t");
				String [] s = data1[5].split("/");
				Date d=new Date(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
				Book b;
				
				switch(data1[6]) {
				case "PhyscologyBook":
					b=new Book(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),d,new PhyscologyBook(),Boolean.parseBoolean(data1[7]));
					lib.addBook(b);
					break;
				case "ChildBook":
					b=new Book(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),d,new ChildBook(),Boolean.parseBoolean(data1[7]));
					lib.addBook(b);
					break;
				case "ComputerBook":
					b=new Book(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),d,new ComputerBook(),Boolean.parseBoolean(data1[7]));
					lib.addBook(b);
					break;
				case "PoemBook":
					b=new Book(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),d,new PoemBook(),Boolean.parseBoolean(data1[7]));
					lib.addBook(b);
					break;
				case "ScienceFictionBook":
					b=new Book(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),d,new ScienceFictionBook(),Boolean.parseBoolean(data1[7]));
					lib.addBook(b);
					break;
				default:
					System.out.println("Wrong book type");
					break;
				}
				str2=bReader.readLine();
			}
			fStream=new FileInputStream("data/borrowedBook.txt");
			dStream=new DataInputStream(fStream);
			bReader=new BufferedReader(new InputStreamReader(dStream));
			str2=bReader.readLine();
			while(str2!=null) {

				String []data1=str2.split("\t");
				String[] date1=data1[3].split("/");
				String[] date2=data1[4].split("/");
				Date d1=new Date(Integer.parseInt(date1[0]),Integer.parseInt(date1[1]),Integer.parseInt(date1[2]));
				Date d2=new Date(Integer.parseInt(date2[0]),Integer.parseInt(date2[1]),Integer.parseInt(date2[2]));
				BorrowedBook bb=new BorrowedBook(Integer.parseInt(data1[0]),lib.getCustomers().get(Integer.parseInt(data1[1])-1),lib.getBooks().get(Integer.parseInt(data1[2])-1),d1,d2);
				lib.addBorrowedBook(bb);
				lib.getCustomers().get(Integer.parseInt(data1[1])-1).addBorrowedBook(bb);
				str2=bReader.readLine();
			}

			dStream.close();
			fStream.close();
			bReader.close();
			Swing swing=new Swing();
			swing.show();
			
			
			

			
		}catch(Exception e) {
			System.out.println("hata: "+e.getMessage());
		}
	}

}
