
package Test.MainJava.com;

//import javax.swing.JPasswordField;
import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class SignUpScreen {
	
    Student s1 = new Student(); //------------------------------------------------------------------created a global object of the student class
    //Student[] data;  //------------------------------------------------------------------------------might delete this since this does not do anything
    static ArrayList<String> name = new ArrayList<String>(); //-------------------------------------------------------name list
    static ArrayList<String> studID = new ArrayList<String>();//------------------------------------------------------ID list
    static ArrayList<String> emailList = new ArrayList<String>();//---------------------------------------------------email list
    
    
    private static Formatter login;
    
	
	
	public static void main(String[] args){
		signUp();
	}
		
		
	 public static void signUp(){
	 JPanel welcomeSheet = new JPanel();
	 
	 welcomeSheet.setLayout(new GridLayout(0,1));
	 welcomeSheet.setBorder(BorderFactory.createEmptyBorder(50,50,30,50));
	 
	 JFrame signUp=new JFrame("Make an Account");//creating instance of JFrame

	 
	 JButton submit=new JButton("submit");//creating instance of JButton
	 submit.setBounds(150,250,100,20);//x axis, y axis, width, height
	 signUp.add(submit);//adding button in JFrame


	 

	 JTextField fname = new JTextField(15);
	 JLabel fnamelabel = new JLabel("First Name:");
	 fname.setBounds(175,30,150,20);
	 fnamelabel.setBounds(20,30,160,20);


	 JTextField lname = new JTextField(15);
	 JLabel lnamelabel = new JLabel("Last Name:");
	 lname.setBounds(175,65,150,20);
	 lnamelabel.setBounds(20,65,160,20);
	 
	 JTextField studentID = new JTextField(7);
	 JLabel studentIDlabel = new JLabel("Student ID:");
	 studentID.setBounds(175,100,150,20); //adjust bounds
	 studentIDlabel.setBounds(20,100,160,20);
	 
	 JTextField email = new JTextField(7);
	 JLabel emailLabel = new JLabel("Email:");
	 email.setBounds(175,135,150,20); //adjust bounds
	 emailLabel.setBounds(20,135,160,20);

	 
	  JPasswordField password = new JPasswordField(15);
	  JLabel passlbl = new JLabel("Password");
	  password.setBounds(175,170,150,20);
	  passlbl.setBounds(20,170,160,20);

	  
	  JPasswordField password2 = new JPasswordField(15);
	  JLabel passlbl2 = new JLabel("Re-Enter Password");
	  password2.setBounds(175, 200,150,20);
	  passlbl2.setBounds(20,200,160,20);
	  

	 JLabel errorLabel = new JLabel();// add error message
	 errorLabel.setBounds(20,5,300,20);
	 
	 signUp.add(errorLabel);
	  
	 signUp.add(submit);//adding button in JFrame
	 signUp.add(fname);
	 signUp.add(lname);
	 signUp.add(lnamelabel);
	 signUp.add(fnamelabel);
	 signUp.add(studentID);
	 signUp.add(studentIDlabel);
	 signUp.add(email);
	 signUp.add(emailLabel);
	 signUp.add(password);
	 signUp.add(passlbl);
	 signUp.add(password2);
	 signUp.add(passlbl2);

	 signUp.setSize(400,500);//400 width and 500 height
	 signUp.setLayout(null);//using no layout managers
	 signUp.setVisible(true);//making the frame visible
	 
	

	 /*
	 Writer writer = null;
	  File check = new File("students.txt");
	  if(check.exists()) {
	  }
	  else{
		  try{
			  File texting = new File("students.txt");
			  writer = new BufferedWriter(new FileWriter(texting));
			  writer.write("message");
		  }
		  catch(IOException e){
			  e.printStackTrace();
		  }

	  }*/
	 
	 
	 
 //}
	 
	 
	 
	 
	 
	 
	 
	 
	 Timer timer = new Timer(500, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent ae) {                    
             state = !state;
             if (state) {
                 label.setForeground(Color.RED);
             } else {
                 label.setForeground(Color.BLACK);
             }                    
             repaint();                    
         }
     });
	 
	 
	 
	 
	 

	  submit.addActionListener(new ActionListener() {
		private Object firstname;
		private Object lastname;
		private Object studentid;
		private Object pass;
		private String studentmail;
		private int counter = 0;
		private int error = 0;

		

		//Scanner scanner = new Scanner(System.in);
		  @Override   
		  public void actionPerformed (ActionEvent e) {
	        Student s1 = new Student();
	        try{
	            FileWriter fileWriter = new FileWriter("students.txt", true); //---------------------------------------------tries to create student.txt
	            login = new Formatter(fileWriter); //------------------------------------------------------------------------open the file
	        }
	        catch(Exception e2){
	            System.out.println("ERROR");
	        }


	        boolean bool = true;
	        
//	        while(bool){
	        	try {
					String firstname = fname.getText();
			        if (!firstname.matches("[a-zA-Z_]+")) {
			            System.out.println("\tInvalid first name");
			        	fnamelabel.setForeground(Color.red);
			        	error += error + 1;
			            //fname.setText("");
			        }
			        else {
			        	fnamelabel.setForeground(Color.black);
			        	System.out.println(firstname);
			        	s1.setFirstName(firstname);
			        	counter = counter +1;
			        	System.out.println("fname " + counter);

			        }
	        	}
		        catch(Exception e3){
		            System.out.println("ERROR");
		        }
	        	
	        	
	        	try {
	        		String lastname = lname.getText();			       
			        if (!lastname.matches("[a-zA-Z_]+")) {
			            System.out.println("\tInvalid last name");
			        	lnamelabel.setForeground(Color.red);
			        	error += error + 1;

			            //lname.setText("");
			        }
			        else {
			        	lnamelabel.setForeground(Color.black);
			        	System.out.println(lastname);
				        s1.setLastName(lastname);
			        	counter = counter +1;
			        	System.out.println("lname "+ counter);

			        }
	        	}
		        catch(Exception e4){
		            System.out.println("ERROR");
		        }
	        	
	        	
	        	try {
					String studentid = studentID.getText();
			        if(studID.contains(studentid)){
			            System.out.println("\tID already exist");
			            studentIDlabel.setForeground(Color.red);
			        	error += error + 1;

			            //studentID.setText("");
			        }
			        if (!studentid.matches("[0-9]{7}")) {
			            System.out.println("\tInvalid ID");
			            studentIDlabel.setForeground(Color.red);
			        	error += error + 1;

			            //studentID.setText("");
			        }
			        else {
			        	studentIDlabel.setForeground(Color.black);
				        s1.setStudentID(studentid);
			        	counter = counter +1;
			        	System.out.println("ID "+ counter);
				        }
	        	}
		        catch(Exception e2){
		            System.out.println("ERROR");
		        }


	        	try {
		        	String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@simmons.edu";
	        		String studentmail = email.getText();
			        if ((studentmail.equals("")==true)||(studentmail.matches(regex)==false) ){
			            System.out.println("\nERROR: Invalid Email!\n");
			            emailLabel.setForeground(Color.red);
			        	error += error + 1;


			            //email.setText("");

			            
			        }
			        if ((emailList.contains(studentmail))|(studentmail.equals("")==true)){
			            System.out.println("\nEmail already exist\n");
			            emailLabel.setForeground(Color.red);
			        	error += error + 1;

			            //email.setText("");
			            
			        }
			        else if(studentmail.matches(regex)) {
			        	emailLabel.setForeground(Color.black);
				        s1.setEmail(studentmail);		
			        	counter = counter +1;
			        	System.out.println("email "+counter);

				        }
	        	}
		        catch(Exception e2){
		            System.out.println("ERROR");
		        }

		        
				//String studentmail = email.getText();


		        //name.add(firstname +" "+lastname);


		        
	        	try {
					String pass = password.getText();
					String pass2 = password2.getText();
	
					if ((pass2.equals(pass)==false)^(pass2.equals("")==true)){
				            System.out.println("\nERROR:You have entered two different passwords!\n");
				            //passlbl.setText("");
				            //passlbl2.setText("");
				            passlbl.setForeground(Color.red);
				            passlbl2.setForeground(Color.red);
				        	error += error + 1;

				        }
			        else {
			        	passlbl.setForeground(Color.black);
			        	passlbl2.setForeground(Color.black);
			        	counter = counter +1;
				        s1.setPassword(pass);
			        	System.out.println("password "+ counter);

				        }
	        	}
		        catch(Exception e2){
		            System.out.println("ERROR");
		        }
		        
		        

	        	System.out.println("final: " + counter);
	        	counter = 0;

		        System.out.println("----------------------------------------------------------------");
		        
		        if(error > 0 ) {				    	  
		          errorLabel.setForeground(Color.RED); //set color of text
		    	  //userlbl.setText("Enter Username**:");//change text after the button is click
		          errorLabel.setBounds(100,300,350,20);
		          errorLabel.setText("Please modify the fields in red");//add text after the button is click
		          error = 0;
		        }

		        else if(counter < 4) {
		        	System.out.println("Hello");
			        
			        studID.add((String) studentid);	
			        //emailList.add((String) studentmail);	

			      
		  
		        	System.out.println("\nHere is your student information\n");
			        String str=s1.toString();
			        System.out.println(str);
			        //s1.setPassword(pass);

			        if (name.size() <  1){  //----------------------------if name in array is less than one it will print out column names of given student data
			            //login.format("%20s %20s %20s %20s","firstname", "lastname",  "student_ID", "password", System.getProperty("line.separator"));
			            System.out.println("heading"); //---------------------------------------------------------------------------checking purposes
			            
			        }

			        else{
			            System.out.println("no need for heading"); //----------------------------------------------------------------checking purposes
			        }
			        System.out.print(firstname);
			        login.format("\n%20s %20s %20s %20s",s1.firstName, s1.lastName, s1.studentID, s1.passowords); //-------------------------------------------------adds data
			        login.flush();
			        
			        errorLabel.setForeground(Color.black); //set color of text
			        errorLabel.setBounds(100,280,350,40);
			        errorLabel.setText("<html><center>Sign Up Successful!<br/>This window will close automatically.</center></html>");

			        int delay = 5000;//closes after 5 seconds

			        //Timer source https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
			        
			        ActionListener taskPerformer = new ActionListener() {
			            public void actionPerformed(ActionEvent evt) {
					        signUp.dispatchEvent(new WindowEvent(signUp, WindowEvent.WINDOW_CLOSING));

			            }
			        };
			        
			        new Timer(delay, taskPerformer).start();
			        

		        }
	        //}
		  }
	  });
	        
      
 }
	 
}
