import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Devoloper implements Serializable {
	int qstnNumber;
	String qstn;
	String op1;
	String op2;
	 String answer;
  	public Devoloper() {}
            	
	@Override
	public String toString() {
		return "" + qstnNumber + "." + qstn + "\n" + op1 + "\n" + op2 + /* "\nAnswer:"+answer+ */"";
	}
	
	public Devoloper(int qstnNumber, String qstn, String op1,String op2,String answer) {
		
		this.qstnNumber = qstnNumber;
		this.qstn = qstn;
		this.op1=op1;
		this.op2=op2;
		this.answer=answer;
	}
	static ArrayList<Devoloper> list=new ArrayList<Devoloper>();
	
	 
	 
	// main method
	public static void devoloperSection()throws FileNotFoundException, IOException, ClassNotFoundException  {
	int choice=-1;int n;char ch;
	
	Scanner sc=new Scanner(System.in);//for int
	Scanner sc1=new Scanner(System.in);//for string
	
    File file=new File("QuizFile1.txt");//creating a file 
    ObjectOutputStream oos=null;
   ObjectInputStream ooi=null;
    ListIterator li=null;
     
    if(file.isFile()) {
	ooi=new ObjectInputStream(new FileInputStream(file));
    list=(ArrayList<Devoloper>) ooi.readObject();
    ooi.close();
     }
    
     
    
       
  /*DEVOLOPER*/
	        int id = 0;String password = null;
	        Login login=new Login(id,password);
        	login.loginAsDevolooper();

	     do
	     {
	    System.out.println("**************************");
		System.out.println("**  1:INSERT QUESTION   **");
		System.out.println("**  2:DISPLAY QUESTION  **");
        System.out.println("**  3:SEARCH QUESTION   **");
        System.out.println("**  4:DELETE QUESTION   **");
        System.out.println("**  5:UPDATE QUESTION   **");
		System.out.println("**  0:EXIT              **");
	    System.out.println("**************************");

		System.out.println("Enter your choice");
		choice=sc.nextInt();
		switch(choice)
		{
/*INSERT*/case 1:System.out.println("How Many Question You Want To Add :");
		         n=sc.nextInt();

		for(int i=0;i<n;i++)
		{
		System.out.print("Enter Question Number :");
		int qstnNumber=sc.nextInt();
		System.out.print("Enter Question :");
		String qstn=sc1.nextLine();
		System.out.print("Enter Options 1 :");
		String op1=sc1.nextLine();
		System.out.print("Enter Options 2 :");
		String op2=sc1.nextLine();
		System.out.print("Enter Answer : ");
		String answer=sc1.nextLine();
		list.add(new Devoloper(qstnNumber,qstn,op1,op2,answer));//adding to ArrayList
		}
		oos=new  ObjectOutputStream(new FileOutputStream(file));//writing to the file
		oos.writeObject(list);
		oos.close();
		break;
		
/*DISPLAY*/	case 2:
			if(file.isFile()) {
			ooi=new ObjectInputStream(new FileInputStream(file));//reading from the file
			list=(ArrayList<Devoloper>) ooi.readObject();//loading content of file to list
		    ooi.close();
			li=list.listIterator();//using listIterator sequentially displaying all the questions
		    while(li.hasNext())
	        System.out.println(li.next());
		    }else
		    {
			System.out.println("File Not Exist!");
		     }
			break;
			
/*SEARCH*/	case 3:
			if(file.isFile()) {
			boolean found=false;
			System.out.println("Enter Question Number Search :");
		    int qstnNumber=sc.nextInt();
			li=list.listIterator();
		    while(li.hasNext()) {
		    	Devoloper d=(Devoloper)li.next();
			if(d.qstnNumber==qstnNumber) {
			System.out.println(d);
			found=true;
			}
			}
		    if(!found)
			System.out.println(" Question Not Found!");
		    }else
		    {
			System.out.println("File Not Exist!");
		     }
	        break;

/*DELETE*/  case 4: 
	        if(file.isFile()) {
	        ooi=new ObjectInputStream(new
            FileInputStream(file));
	        list=(ArrayList<Devoloper>) ooi.readObject();
            ooi.close(); 
            boolean found=false;
            System.out.println("Enter Question Number To Delete");
            int qstnNumber=sc.nextInt();
            li=list.listIterator();
            while(li.hasNext()) {
            	Devoloper d=(Devoloper)li.next();
            if(d.qstnNumber==qstnNumber) {
            li.remove();
            found=true;
            } }
            if(found) {
           oos=new ObjectOutputStream(new FileOutputStream(file));
           oos.writeObject(list);
           oos.close();
           System.out.println("Deleted Succsesfully"); } 
           else {
           System.out.println(" Question Not Found!");
           } }
	       else {
           System.out.println("File Not Exist!");
           } 
	       break;
	      
/*UPDATE*/ case 5:
           if(file.isFile()){
	       ooi=new ObjectInputStream(new
           FileInputStream(file));
	       list=(ArrayList<Devoloper>) ooi.readObject();//reading content of file to list
           ooi.close(); 
           boolean found=false;
   
          System.out.println("Enter Question Number To Update");
          int qstnNumber=sc.nextInt();
          li=list.listIterator();
          while(li.hasNext()) {
        	  Devoloper d=(Devoloper)li.next();
	      if(d.qstnNumber==qstnNumber) {
		  System.out.println("Update The Question :");
		  String qstn=sc1.nextLine();
		  System.out.println("Enter Option 1 :");
		  String op1=sc1.nextLine();
	      System.out.println("Enter Option 2 :");
	      String op2=sc1.nextLine();
		  System.out.println("Enter Answer :"); 
	      String answer=sc1.nextLine();
		  li.set(new Devoloper(qstnNumber,qstn,op1,op2,answer));
          found=true;
          } }
          if(found) {
          oos=new ObjectOutputStream(new FileOutputStream(file));
          oos.writeObject(list); oos.close();
  
          System.out.println("Updated Succsesfully"); } else {
          System.out.println(" Question Not Found!"); } }else {
          System.out.println("File Not Exist!"); } break;
 
		   }
		 }while(choice!=0);System.exit(0);
	     

         }}
