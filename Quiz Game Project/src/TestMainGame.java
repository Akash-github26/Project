import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestMainGame {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner scan=new Scanner(System.in);
		int choice;char ch;
		
		Devoloper devoloper=new Devoloper();
		User user=new User();
		do
		{
		 System.out.println("*********************");
	     System.out.println("**  1:DEVOLOPER    **\n**  2:USER         **");
	     System.out.println("*********************");
         choice=scan.nextInt();
         switch(choice)
         {
         case 1:devoloper.devoloperSection();
         break;
         case 2:user.userSection();
         break;
         default:System.out.println("Invlid Choice");
         }
         System.out.println("Do You Want to Go Back To Main Menu");
         ch=scan.next().charAt(0);
	}while(ch=='y');

}}
