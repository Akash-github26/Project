import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class User  extends Devoloper {
	    //Random Class in Java
		 Random random=new Random();
	    private static void randomList(ArrayList<Devoloper> list) {
		int index=(int)(Math.random()*list.size());
		System.out.println(list.get(index));
	}
	
		static ArrayList<Devoloper> list=new ArrayList<Devoloper>();

	public void userSection() throws FileNotFoundException, IOException, ClassNotFoundException {
		Devoloper dev=new Devoloper();
		File file=new File("QuizFile1.txt"); 
	    ObjectOutputStream oos;
	   ObjectInputStream ooi;
	    ListIterator li;
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);

		
		int score=0;char choice1;int attempt = 0;char ch;int choice=-1;int i;
        System.out.println("Enter Your Name :");
        String name=sc1.next();
        String character="ADAM";//Character cannot be changed 
        int health=10;
        Character character1=new Character(name,character,health);
        do {
         
       
       
        System.out.println("********************");
    	System.out.println("**   QUIZ GAME    **");
	    System.out.println("********************");
	    System.out.println("**  1:STAR GAME   **");
	    System.out.println("**  2:HOW TO PLAY **");
	    System.out.println("**  3:SCORE       **");
	    System.out.println("**  4:Exit        **");
	    System.out.println("********************");
        choice =sc1.nextInt();
        switch(choice)
        {
/*Start*/case 1:
	      character1.health=10;
         System.out.println("*******************************");
         System.out.println("**  Player Name : "+character1.getName()+"");
         System.out.println("**  Steve's Initial Health : "+character1.getHealth()+"");
         System.out.println("**  Total Questions : 6");
 	     System.out.println("*******************************");

			
			if(file.isFile()) {
	    ooi=new ObjectInputStream(new FileInputStream(file));
	    list=(ArrayList<Devoloper>) ooi.readObject();//reading content of file to list
	    ooi.close();
	    score=0; attempt=0;
	    System.out.println("NOTE :Type the Correct Answer Carefully.\n      Steve's Health will  decrease if "
	    		+ "the answer is Wrong!");	
	    int count=0;
	    for(i=0;i<6;i++)
	     {
	  
		/*if(character1.health<100) {*/
	   
	    if(count==1) {
	    	
	    	character1.damageByGun();//if the answer is wrong steve will recieve damage
	    	
	    }
	    if(character1.health==0) {
	    	break;
	    }
	    
	    if(character1.health>0 && character1.health<100) {
	    System.out.println("(Health : "+character1.getHealth()+")");
	    count=1;
		System.out.println("*******************************");
	    randomList(list);//randomly print questions
	    System.out.println("*******************************");
	    attempt++;
	    System.out.println("Enter Correct Answer :");
	    String op1=sc1.next();
	    li=list.listIterator();
		while(li.hasNext()) {
			Devoloper d=(Devoloper)li.next();
		
		if(d.answer.equals(op1))
		{
		character1.healthIncrease();
		
		score++;
		count++;
			}
		
		if	(character1.getHealth()>99)
		{
		System.out.println("***********************************");
		System.out.println("Great . You Saved Your Friend Life");
		System.out.println("Go And Check Your Score.");
		System.out.println("***********************************");

		break;
		    }
			}	
			}
		
		    }
	    if(i==6) {
	    if(count==1) {
	    	character1.damageByGun();
	    }}
	    if(character1.getHealth()>=70&& character1.getHealth()<=99)
	    {
	    	System.out.println("Steve's Health : "+character1.getHealth());
			System.out.println("***************************************");

	    	System.out.println("Close call!, Your Friend is about to die,"
	    			+ " But now he is Out Of Danger");
	    	System.out.println("Go And Check Your Score. ");
			System.out.println("***************************************");

	    }
	    if(character1.getHealth()<70)
	    {
			System.out.println("*************************************************");

	    	System.out.println("Steve's Health : "+character1.getHealth());
	    	System.out.println("HARD LUCK! Unable to save Friend Life. He's Dead!");
	    	System.out.println("Go And Check Your Score. ");
			System.out.println("*************************************************");

	    }
	        } 
	
	    break;
	    
/*HowToPlay*/ case 2:
    	 System.out.println("       --->HOW TO PLAY<---");
    	 System.out.println("************************************************");
    	 System.out.println("-->Your Friend Steve is in Danger!<--\n-->Your task is to Rescue him<--"
    			 +"\n-->Steve's initial Health will be 10<--\n-->There will be 5 Questions<--\n"
    			 + "-->For Each Correct Answer Steve's Health will  increase by 30<--\n"
    			 +"-->If Wrong Answer - His Health will  decrease by 20<--"
    			 + "-->If his Health reaches 100, Then your task is Done, Steve is completely Safe.<--\n"
    			 + "-->If Steve's Health is Between 70 and 100, He's Out Of Danger!<--\n"
    			 + "-->If Steve's Health is below 70 then he will be Dead! because of Bleeding!<--\n"
    			 + "That's It.");
    	 System.out.println("**************************************************");
    	 System.out.println("ALL THE BEST CHAMP. GO AND SAVE YOUR FRIEND LIFE");
    	 break;
    	 
/*Score*/case 3:
		System.out.println("Do you want to see Your Score y/n");
		char option=sc1.next().charAt(0);
		if(option=='y')
		{
		System.out.println("*************************************");
        System.out.println("             SCORE");
		System.out.println("*************************************");
		System.out.println("Player name    : "+character1.getName());
		if(character1.getHealth()>=70 && character1.getHealth()<100)
		{
		System.out.println("Steve's Health :"+character1.getHealth()+" (Out Of Danger)");
		}
	    else if(character1.getHealth()>99) {
		System.out.println("Steve's Health :"+character1.getHealth()+" (Completely Safe)");
		}
		else if(character1.getHealth()<70){
		System.out.println("Steve's Health : "+character1.getHealth()+" (Dead!)");
		}
	    
	   System.out.println("Score          : Total Question =6\n                 Attempted = "+attempt+"\n"
					+ "                 Correct   = "+score);
	  
		System.out.println("*************************************");

		}
		
		break;
		
/*Exit*/case 4:
		System.out.println("Exited Succesfully");
		System.exit(0);
		break;
        }System.out.println("Press y to go back to the Menu");
        ch=sc1.next().charAt(0);}while(ch=='y'||ch=='Y');
	    }
        

	    }

	


