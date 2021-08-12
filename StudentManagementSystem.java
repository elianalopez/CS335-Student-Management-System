//package Midterm;   //-------------------------------------------------------------------------------------commented out to run in my computer -Eliana
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import Student.java;

public class StudentManagementSystem{
    String username = "";
    String password = "";
    String filepath = "student.txt";
    
    
    //===Global Attributes========/-----------------------------------------------------------------------------------global attributes
    Student s1 = new Student(); //------------------------------------------------------------------created a global object of the student class
    //Student[] data;  //------------------------------------------------------------------------------might delete this since this does not do anything
    static ArrayList<String> name = new ArrayList<String>(); //-------------------------------------------------------name list
    static ArrayList<String> studID = new ArrayList<String>();//------------------------------------------------------ID list
    static ArrayList<String> emailList = new ArrayList<String>();//---------------------------------------------------email list
    
    
    private Formatter login, writer;
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException{        

        
        welcome();


        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("\n1.) New Student\n");
            System.out.print("2.) Existing Student\n");
            System.out.print("3.) Total Students\n");
            System.out.print("4.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");
            choice = input.nextInt();
            //input.close(); //----------------------------------------------------------------------------------------this would break loop

            StudentManagementSystem sms = new StudentManagementSystem();

            switch (choice) {
                case 1:
                    sms.folder();
                    sms.studentInput();
                    break;
                case 2:
                    sms.login();
                    //sms.sms(id);
                    break;
                case 3:
                    sms.studentNames();
                    break;
                case 4:
                    sms.deleteFile(); //--------------------------------------------------------delete Student folder and its contents
                    sms.clearTheFile(); //-------------------------------------------------------------------------------clear the file
                    System.exit(0);
                    break;
            }
        }
    }
    public static void welcome(){      //-------------------------------------------------------------------------------welcome method
        System.out.println("\nWelcome to student management system!\n");
    }
        

    public void studentInput(){  //--------------------------------------------------------------------------------------New student input method                                             
        Scanner scanner = new Scanner(System.in);
        //Student s1 = new Student();

        try{
            FileWriter fileWriter = new FileWriter("students.txt", true); //---------------------------------------------tries to create student.txt
            login = new Formatter(fileWriter); //------------------------------------------------------------------------open the file
        }
        catch(Exception e){
            System.out.println("ERROR");
        }

        System.out.println("\nSign up Form:\n");
        System.out.println("Fill in the following information to sign up for an account\n");
        System.out.print("\tFirst Name: ");
        String name1 = scanner.next();
        while (!name1.matches("[a-zA-Z_]+")) {
            System.out.println("\tInvalid name");
            System.out.print("\tFirst Name: ");
            name1 = scanner.next();
        }
        s1.setFirstName(name1);
        System.out.print("\tLast Name: ");
        String name2 = scanner.next();
        while (!name2.matches("[a-zA-Z_]+")) {
            System.out.println("\tInvalid name");
            System.out.print("\tLast Name: ");
            name2 = scanner.next();
        }
        s1.setLastName(name2);
        System.out.print("\tStudentID: ");
        String ids = scanner.next();
        while(studID.contains(ids)){
            System.out.println("\tID already exist");
            System.out.print("\tStudentID: ");
            ids = scanner.next();
        }
        while (!ids.matches("[0-9]{7}")) {
            System.out.println("\tInvalid ID");
            System.out.print("\tStudentID: ");
            ids = scanner.next();
        }
        s1.setStudentID(ids);
        studID.add(ids);


        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@simmons.edu";
        System.out.print("\tSchool Email: ");
        String email = scanner.next();
        while (email.matches(regex)==false){
            System.out.println("\nERROR: Invalid Email!\n");
            System.out.print("\tSchool Email: ");
            email = scanner.next();
        }
         while (emailList.contains(email)){
            System.out.println("\nEmail already exist\n");
            System.out.print("\tSchool Email: ");
            email = scanner.next();
        }
        s1.setEmail(email);

        name.add(name1 +" "+name2);

        System.out.println("\nNow let's make a new password!");
        System.out.print("\n\tPlease enter a password:");
        String pass =  scanner.next();
        System.out.print("\n\tPlease re-enter the password:");
        String pass2 =  scanner.next();
        while(pass2.equals(pass)==false){
            System.out.println("\nERROR:You have entered two different passwords!\n");
            System.out.print("\n\tPlease re-enter the password:");
            pass2 = scanner.next();
            if (pass2.equals(pass)){
                break;
            }
        }

        System.out.println("\nHere is your student information\n");
        String str=s1.toString();
        System.out.println(str);
        s1.setPassword(pass);

        if (name.size() ==  1){  //----------------------------if name in array is less than one it will print out column names of given student data
            login.format("%20s %20s %20s %20s","firstname", "lastname",  "student_ID", "password", System.getProperty("line.separator"));
            System.out.println("heading"); //---------------------------------------------------------------------------checking purposes
        }

        else{
            System.out.println("no need for heading"); //----------------------------------------------------------------checking purposes
        }

        login.format("\n%20s %20s %20s %20s",name1, name2, ids, pass); //-------------------------------------------------adds data
        login.flush(); //-------------------------------------------------------------------------------------------------push data into txt file
        //scanner.close(); //---------------------------------------------------------------------------------------------this would break loop
    }

    public void login() throws FileNotFoundException{ //-----------------------------------------------------------------login method
        
        String filepath = "students.txt";
        File file = new File(filepath);

        if(file.exists() && !file.isDirectory()) { 
            System.out.println("\nEnter your student ID:\n");
        }
        else{
            System.out.println("\nERROR: THERE ARE NO EXISTING STUDENTS IN THE DIRECTORY RIGHT NOW!\nCOME AGAIN AFTER STUDENTS ARE ADDED!");
            return;
        }

        if (file.length() == 0) {
            System.out.println("\nERROR: THERE ARE NO EXISTING STUDENTS IN THE DIRECTORY RIGHT NOW!\nCOME AGAIN AFTER STUDENTS ARE ADDED!");
            return;
        }

        Scanner read = new Scanner(file);

        try {
            boolean found = false;

            Scanner keyboard = new Scanner(System.in);
            
            System.out.print("Student ID: ");
            String userID = keyboard.nextLine();
    
            System.out.print("Password: ");
            String passwordField = keyboard.nextLine();
            read.nextLine(); //------------------------------------------------------------------------------------would skip header
            int i = 0;
            while(read.hasNext()){

                String line = read.nextLine();
                String[] lineArray = line.split("\\s+");
                String user = lineArray[3];
                String pass = lineArray[4];

                i ++;
                System.out.println("The user name is_" + user + " and the password is_" + pass + "!\n");

                    if(user.trim().equals(userID) && pass.trim().equals(passwordField))
                    {
                        found = true;
                        break;  
                    }                
                }
             if(found){
                System.out.println("\nGood Job it works!"); //using for testing purposes
                String line = Files.readAllLines(Paths.get("students.txt")).get(i);

                Pattern p = Pattern.compile("([a-zA-Z]+)(?:\s*)([a-zA-Z]+)(?:\s*)(\\d{7}?)(?:\s*)(.*)");
                Matcher m = p.matcher(line);
                if (m.find())
                {
                    String fname = m.group(1);
                    String lname = m.group(2);
                    String id = m.group(3);
                    String idFile = id + ".txt";
                    System.out.println(idFile);

                  // print the group out for verification
                  System.out.format("welcome %s %s!\n", fname, lname);
                  

                  sms(id, fname, lname, i); //------------------------------------------------------------------------new method referenced


                }
            }
        
            else {
                System.out.println("\nERROR: WRONG USERNAME OR PASSWORD");
            }

            read.close();
            //keyboard.close(); //---------------------------------------------------------------------------------this would break loop
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("THIS IS AN ERROR WITH THE SYSTEM");
        }
    };

    public void sms(String id, String fname, String lname, int i) throws InterruptedException, FileNotFoundException, IOException {// -----method for editing student files

        loading();
        String studentfile = "data-" + id + ".txt";
        System.out.println("\nYou are in " + studentfile);
        System.out.println("\nYour name is " + fname + " " + lname);
        String folder = "Students";
        try{
            File myObj = new File(folder, studentfile);
            if (myObj.createNewFile()) 
            {
                System.out.println("File created: " + myObj.getName());  //--------------------------------creating new file [studentid].txt
                filewriter(folder,studentfile,fname,lname);
                System.out.println("File Created.");
            } 
            else 
            {
                filewriter(folder,studentfile,fname,lname);
                System.out.println("File already exists.");
            }
        }catch(Exception e){
            System.out.println("ERROR WITH FILE");
        }


        //=========================================================================================================================================
        ///---------------------------------------------------------------------------------------------------new student filewriter
        Scanner scanners = new Scanner(System.in);
        boolean log =true;
        String studentFile = "Students/data-" + id + ".txt";
        //FileWriter fwriter = new FileWriter(studentFile, true); // -----------------------------------------tries to create new file

        while (log){ 
            System.out.print("\n1.) View GPA\n");
            System.out.print("2.) View Major\n");
            System.out.print("3.) View Minor\n");
            System.out.print("4.) View Class Schedule\n");
            System.out.print("5.) Return to Main Menu\n");
            System.out.print("6.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");
            int pick  = scanners.nextInt();
            if(pick==1){
              Scanner scanner= new Scanner(new FileInputStream(studentFile));
              while (scanner.hasNextLine()) {
                  String lines = scanner.nextLine();
                  if(lines.contains("GPA: ")) {
                      System.out.println(lines);
                      System.out.println("1.) Edit GPA");
                      System.out.println("2.) Go Back");
                      System.out.print("\nEnter Your Menu Choice: ");
                      pick  = scanners.nextInt();
                      if (pick==1){
                          System.out.println("Enter new GPA");
                          Float gpa= scanners.nextFloat();
                          while (gpa>4||gpa<=0.99){
                              System.out.println("score unavilable, enter new GPA: ");
                              gpa= scanners.nextFloat();
                          }
                          String newGPA=("GPA: "+gpa);
                          modifyFile(studentFile, "GPA: ([+-]?\\d*\\.?\\d*)", newGPA);
                          System.out.println(newGPA);
                          }
                      }
                      if(pick==2){
                          System.out.println("Returning...");
                          break;
                      }
                  }
              }
              if (pick==2){
                  Scanner look= new Scanner(new FileInputStream(studentFile));
                  while (look.hasNextLine()) {
                      String lines = look.nextLine();
                      if(lines.contains("Major: ")){
                          System.out.println(lines);
                          System.out.println("1.) Edit Major");
                          System.out.println("2.) Go Back");
                          System.out.print("\nEnter Your Menu Choice: ");
                          int picks  = scanners.nextInt();
                          if (picks==1){
                              System.out.println("Enter new Major(initial only): ");
                              String maj= scanners.next();
                              String newMaj=("Major: "+maj);
                              modifyFile(studentFile, lines, newMaj);
                              System.out.println(newMaj);
                          }
                          if(picks==2){
                              System.out.println("Returning...");
                              break;
                          }
                      }
                  }
              }
              if (pick==3){
                  Scanner look= new Scanner(new FileInputStream(studentFile));
                  while (look.hasNextLine()) {
                      String linesm = look.nextLine();
                      if(linesm.contains("Minor: ")){
                          System.out.println(linesm);
                          System.out.println("1.) Edit Minor");
                          System.out.println("2.) Go Back");
                          System.out.print("\nEnter Your Menu Choice: ");
                          int picks  = scanners.nextInt();
                          if (picks==1){
                              System.out.println("Enter new Minor(initial only): ");
                              String min= scanners.next();
                              String newMin=("Minor: "+min);
                              modifyFile(studentFile, linesm, newMin);
                              System.out.println(newMin);
                          }
                          if(picks==2){
                              System.out.println("Returning...");
                              break;
                          }
                      }
                  }

              }
              if (pick==4){
                  System.out.println("go to https://www.freecollegeschedulemaker.com/ to make your own schedule!!!");

              }
              if (pick==5){
                  Exiting();
                  log=false;
                  break;
              }
              if (pick==6){
                  deleteFile();   //---------------------------------------------------------------------delete student folder and its contents
                  clearTheFile(); //-------------------------------------------------------------------------------clear the file
                  System.exit(0);
                  break;
              }

          }
          //======================================================================================================================================
        
    }
    
    public void filewriter(String folder, String studentfile,String fname, String lname) throws IOException{
        File file = new File(folder, studentfile);
        System.out.println(studentfile);
        String path = "Students/"+studentfile;
        if (file.length() == 0) {
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
        

    }
    
    public void loading()throws InterruptedException{ //-------------------------------------------------------------loading method made for fun
        System.out.println("\n\n\nPLEASE WAIT, LOADING...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nCHECKING DATABASE...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nPULLING INFROMATION...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nDONE!");
        Thread.sleep((long)(Math.random()*1000));
    }

    public void Exiting()throws InterruptedException{ //-------------------------------------------------------------loading method made for fun
        System.out.println("\n\n\nPLEASE WAIT, LOADING...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nLOGGING OUT...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nPULLING OUT INFROMATION...");
        Thread.sleep((long)(Math.random()*5000));
        System.out.println("\n\n\nEXIT COMPLETED!");
        Thread.sleep((long)(Math.random()*1000));

    }
    
    public void clearTheFile() throws IOException{ //-----------------------------------------------------------------clear the file function
        FileWriter file = new FileWriter("students.txt", false); 
        PrintWriter clear = new PrintWriter(file, false);
        clear.flush();
        clear.close();
        file.close();
    }
    
    void studentNames(){ //--------------------------------------------------------------------------------------------displays student names
        System.out.println("\n----Student-List----\n");

        Scanner in = new Scanner(System.in);

        if (name.isEmpty()){
            System.out.println("\nThere are no students in the list");
        }
        else{
            System.out.println("\nStudent List: ");
            for (int i = 0; i < name.size();i++)
            {
                System.out.println(name.get(i));
            }
        }

        System.out.println("\n1. Main Menu: ");
        System.out.print("\nEnter Your Choice: ");
        int choice = in.nextInt();
        if (choice == 1) {
            return;
        }
    }

    public void folder(){
        File theDir = new File("Students");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }

    public void deleteFile() {
        File index = new File("Students");
        String[]entries = index.list();
        for(String s: entries){
            File currentFile = new File(index.getPath(),s);
            currentFile.delete();
        }   
        index.delete();
    }

    public void modifyFile(String file, String oldString, String newString){
        File fileToBeModified = new File(file);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(fileToBeModified)); 
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                //Closing the file 
                reader.close();
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
