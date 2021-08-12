import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.*;

public class Mainmenu{
	
	public void main(String[] args){
		menu();
	}
	public void menu() {
		  JFrame login=new JFrame("Main Menu Screen");//creating instance of JFrame
		  
		  JLabel welcome = new JLabel("Welcome to Student Management system");
		  welcome.setBounds(20,5,300,20);
		  login.add(welcome);


		  JButton egpa=new JButton("Edit");//creating instance of JButton
		  egpa.setBounds(200,30,80,20);//x axis, y axis, width, height
		  login.add(egpa);
		  //create.addActionListener(new Action());
		  
		  JButton emaj =new JButton("Edit");//creating instance of JButton
		  emaj.setBounds(200,65,80,20);//x axis, y axis, width, height
		  login.add(emaj);

		  JLabel gpalbl = new JLabel("GPA: 0.0");
		  gpalbl.setBounds(20,30,160,20);
		
		  JLabel majlbl = new JLabel("Major: Not None");
		  majlbl.setBounds(20,65,160,20);
		  



		  login.add(majlbl);
		  login.add(gpalbl);

		  login.setSize(400,500);//400 width and 500 height
		  login.setLayout(null);//using no layout managers
		  login.setVisible(true);//making the frame visible
 
 
		 

		  }
}
