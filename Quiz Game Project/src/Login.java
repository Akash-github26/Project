import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Login implements Serializable {
	 public int id;
	 public String password;
	
	public Login(int id, String password ) {
		super();
		this.id = id;
		this.password = password;
		}
	
	List<Login>loginList=new ArrayList<>();
    public void loginAsDevolooper() throws FileNotFoundException, IOException, ClassNotFoundException
    {
    char choice1=0;char choice2 = 0;
    Scanner scanner=new Scanner(System.in);
    Scanner scanner1=new Scanner(System.in);
    Scanner scanner2=new Scanner(System.in);
	File loginFile=new File("loginFile.txt");
	ObjectOutputStream loginOos=null;
	ObjectInputStream loginoOis=null;
	ListIterator loginli=null;
	do
	{
	System.out.println("1:SIGN IN");
	System.out.println("2:LOGIN");
	int option=scanner.nextInt();
    
	switch(option)
	{
	case 1:	System.out.println("         SIGN IN ");
		do 
		{
		System.out.print("Enter Your Devolper id :");
		int id=scanner.nextInt();
		//(Devoloper Id=1234)
		if(id==1234) {
		System.out.print("Enter Your Password :");
		String password=scanner1.nextLine();
		loginList.add(new Login(id,password));
		loginOos=new ObjectOutputStream(new FileOutputStream(loginFile));
		loginOos.writeObject(loginList);
		loginOos.close();
		System.out.println("Password Changed Succesfull");
		}
		else
		{
		System.out.println("Wrong Id, Please Enter Valid Devolper Id ");
		}
		System.out.print("Press [y] to retry :");
		choice2=scanner.next().charAt(0);
		}while(choice2=='y');
	
	case 2:
		System.out.println("        LOGIN");
		char login=0;
		
		if(loginFile.isFile()) {
			loginoOis=new ObjectInputStream(new FileInputStream(loginFile));
			loginList=(ArrayList<Login>) loginoOis.readObject();
			loginoOis.close();
		
		     do 
		     {
			login=0;
			System.out.print("Enter Your Devoloper Id :");
		    int id1=scanner.nextInt();
		    System.out.print("Enter Password : ");
		    String password1=scanner1.nextLine();
			loginli=loginList.listIterator();
		    while(loginli.hasNext()) {
		    	Login l=(Login)loginli.next();
			if(l.id==id1 && l.password.equals(password1)) {
			System.out.println("Login Succesfull");
			}
			else
			{
			System.out.print("Login Failed Please Enter Valid Password And Id\nPress [y] to retry");
		    login=scanner2.next().charAt(0);
				}
			    }
		   
				}
		    while(login=='y');
		    }
		     else 
		    {
			System.out.println("Failed!"
						+ " Sign In Before Login");
			System.exit(0);
			}
		     System.out.print("Press [n] To Continue  ");
		    scanner2.next().charAt(0);
        	}
	
	     }while(choice1=='y');
	     }
         
}
