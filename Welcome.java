package Test.MainJava.com;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Welcome{
	
	  private static Formatter writer;
	
	  JTextField username;
	  JTextField password;
	  public static void main(String[] args){
		  JFrame login=new JFrame("Login Screen");//creating instance of JFrame


		  JButton create=new JButton("login");//creating instance of JButton
		  create.setBounds(110,100,80,20);//x axis, y axis, width, height
		  login.add(create);
		  //create.addActionListener(new Action());
 
		  JButton account =new JButton("Sign Up");//creating instance of JButton
		  account.setBounds(220,100,100,20);//x axis, y axis, width, height
		  login.add(account);


		  JTextField username = new JTextField(15);
		  JLabel userlbl = new JLabel("Enter Username:");
		  username.setBounds(175,30,150,20);
		  userlbl.setBounds(20,30,160,20);

		  JLabel error = new JLabel();// add error message
		  error.setBounds(20,5,300,20);
		  

		  JPasswordField password = new JPasswordField(15);
		  JLabel passlbl = new JLabel("Enter Password:");
		  password.setBounds(175,65,150,20);
		  passlbl.setBounds(20,65,160,20);
		  

		  login.add(create);//adding button in JFrame
		  login.add(username);
		  login.add(password);
		  login.add(passlbl);
		  login.add(userlbl);
		  login.add(error);

		  login.setSize(400,500);//400 width and 500 height
		  login.setLayout(null);//using no layout managers
		  login.setVisible(true);//making the frame visible
 
 
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

		  }
	  //}
 
		  create.addActionListener(new ActionListener() {
	  //class Action implements ActionListener{
			  @Override   
			  public void actionPerformed (ActionEvent e) {
				  try {
					  boolean found = false;
					  File file = new File("students.txt");          
					  Scanner read = new Scanner(file);


					  String puname = username.getText();
					  String ppaswd = password.getText();

					  
					  read.nextLine();
					  int i = 0;
					  
					  while(read.hasNext()){
						  String line = read.nextLine();
						  String[] lineArray = line.split("\\s+");
						  String usertxt = lineArray[3];
						  String passtxt = lineArray[4];
						  i ++;
						  System.out.println("The user name is_" + usertxt + " and the password is_" + passtxt + "!\n");
						  if(puname.equals(usertxt) && ppaswd.equals(passtxt))
						  {
							  System.out.println("This works!");
							  found  = true;
							  break;  
						  }
					  }
					  
					  if(found) {
						  String lines = Files.readAllLines(Paths.get("students.txt")).get(i);
						  Pattern p = Pattern.compile("([a-zA-Z]+)(?:\s*)([a-zA-Z]+)(?:\s*)(\\d{7}?)(?:\s*)(.*)");
						  Matcher m = p.matcher(lines);
						  if (m.find())
						  {
							  String fname = m.group(1);
							  String lname = m.group(2);
							  String id = m.group(3);
							  String idFile = id + ".txt";
							  System.out.println(idFile);
							  
							  //login.setVisible(false);//making the frame visible
							  //JFrame login=new JFrame("");//creating instance of JFrame
							  //This also works----------------------------------------------------------
							  //login.getContentPane().removeAll();
							  //login.getContentPane().repaint();
							  //login.validate();
							  login.setTitle("Success!");
							  //JPanel panel = new JPanel();
							  JLabel l1 = new JLabel ("welcome ");
							  login.add(l1);
							  error.setForeground(Color.black); //set color of text
						    	  //userlbl.setText("Enter Username**:");//change text after the button is click
							  error.setBounds(80,150,300,20);
						    	  error.setText("welcome " + fname +" " + lname + "!");
							  
							  
							  
							  File theDir = new File("Students");
						          if (!theDir.exists()){
								  theDir.mkdirs();
							  }
						    	  
						    	  String studentfile = "data-" + id + ".txt";
						          String folder = "Students";
							  try{
								  File myObj = new File(folder, studentfile);
								  if (myObj.createNewFile()) {
									  System.out.println("File created: " + myObj.getName());  //--------------------------------creating new file [studentid].txt
									  filewriter(folder,studentfile,fname,lname);
									  System.out.println("File Created.");
								  } 
								  else 
								  {
									  filewriter(folder,studentfile,fname,lname);
									  System.out.println("File already exists.");
								  }
							  }catch(Exception e2){
								  System.out.println("ERROR WITH FILE");
						          }
							  
							  File filer = new File(folder, studentfile);
						          System.out.println(studentfile);
						          String path = "Students/"+studentfile;
						          if (filer.length() == 0) {
								  System.out.println("\nEmpty File!");
								  file.setWritable(true);
								  file.setReadable(true);
								  FileWriter fileWriter = new FileWriter(path, true); // -----------------------------------------tries to create new file
								  writer = new Formatter(fileWriter); // -----------------------------------------------------------------opens file
								  writer.format(fname + " " + lname+"'s file"); // ------------------------------------------------------------writes student name in file
								  fileWriter.write("\nGPA: 0.0");
								  fileWriter.write("\nMajor: null");
								  fileWriter.write("\nMinor: null");
								  writer.flush();
								  System.out.println("Pushed");
							  }
						          else{
								  System.out.println("System out");
						          }
						
						

						    	  Mainmenu newMainmenu =new Mainmenu();// linke to Main Menu
						    	  newMainmenu.menu();
							  
							  
							  //login.getContentPane().add(panel);
			          		  	//login.setBounds(20,30,160,20);
			          		  	//login.setVisible(true);//making the frame visible
			          		  	//login.revalidate();
			          		  	//login.repaint();
			                   		 //login.validate();

			                    
			          		  	//This words-----------------------------------------------------------------
			                    //JFrame frame2 = new JFrame("Success");
			                    //frame2.setVisible(true);
			                    //frame2.setSize(400,400);
			                    //JLabel label = new JLabel ("welcome " + fname +" " + lname + "!");
			                    //JPanel panel = new JPanel();
			                    //frame2.add(panel);
			                    //panel.add(label);
						  } 
					  }
					  else {
						  JFrame frame2 = new JFrame("Wrong password");
						  //frame2.setVisible(true);
						  //frame2.setSize(400,500);
						  JLabel label = new JLabel ("incorrect student ID and/or passcode");
						  JPanel panel = new JPanel();
						  frame2.add(panel);
						  panel.add(label);
						  error.setForeground(Color.RED); //set color of text
						  //userlbl.setText("Enter Username**:");//change text after the button is click
						  error.setBounds(60,150,300,20);
						  error.setText("Incorrect student ID and/or passcode");//add text after the button is click
					  }
				  }
				  catch (Exception error) {
			    	  JFrame frame2 = new JFrame("error");
			    	  frame2.setVisible(true);
			    	  frame2.setSize(400,400);
			    	  JLabel label = new JLabel ("It's not you, it's me");
			    	  JPanel panel = new JPanel();
			    	  frame2.add(panel);
			    	  panel.add(label);
				  }
			  }
		  });
		  
		   account.addActionListener(new ActionListener() {
			   public void actionPerformed (ActionEvent e) {
				  SignUpScreen newSignUpScreen =new SignUpScreen();
				  newSignUpScreen.signUp();
				  
			  }
		   });
	  }
}
