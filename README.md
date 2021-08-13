# Student Management System

This project came into two parts, where it was first written as a commandline based program and then that functionality was moved over to GUIs implemented with the Java Swing framework. 

### What the Student Management System does:
The student mangement system is a program that is fully created in Java that takes in and stores Student information, such as full name, student ID, university email, password, GPA, major, and minor.

## Authors

* Livic Inoa
* Krissy Llyod
* Wanjing Li
* Eliana Lopez

## Student Mangement System

### The overall program

The program runs within a switch-case statement that is nested within a while loop

``` java
        while (true) {
            StudentManagementSystem sms = new StudentManagementSystem();

            switch (choice) {
                case 1: //New Student
                    sms.folder();
                    sms.studentInput();
                    break;
                case 2: //Existing Student
                    sms.login();
                    //sms.sms(id);
                    break;
                case 3: //Total Students
                    sms.studentNames();
                    break;
                case 4: //Exit
                    sms.deleteFile(); 
                    sms.clearTheFile(); 
                    System.exit(0);
                    break;
```
#### Methods

After the user pressed one two methods will follow as a result:

* folder()
* studentInput

##### folder method
The **folder method** creates a new directory(folder) named Student. This would be where all student information is located at. 
``` java
    public void folder(){
        File theDir = new File("Students");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }
```
##### student input method
The **student input method** is where two things happens:

 * students.text is created
 * students type the requested information
        
``` java
        
        try{
            FileWriter fileWriter = new FileWriter("students.txt", true); 
            login = new Formatter(fileWriter); 
        }catch(Exception e){
            System.out.println("ERROR");
        }
```

``` java
        //Sample of student input
        String name1 = scanner.next();
        while (!name1.matches("[a-zA-Z_]+")) {
            System.out.println("\tInvalid name");
            System.out.print("\tFirst Name: ");
            name1 = scanner.next();
        }

```

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252329-4abc3080-8c33-11eb-9803-337c246aeb46.png"></p>
After all the student information is the first name, last name, id, and password would be pushed into students.txt.


``` java
        login.format("\n%20s %20s %20s %20s",name1, name2, ids, pass);
        login.flush();
```
##### login method
The **login method** has two parts:

* logging students in
* editing student files

*The reason why editing student files is within the login method so far is because this is the only way we found it best to be workable in the program.*

The login method would read the file students.txt and turn each line into an array, for each word, this would make sure that the username and password are always consistent of each other.

After the login is complete a text file would be created within the Students folder. This text file would be named data-{id}.txt, where the id would be the corresponding student ID. 
``` java
//reading students.txt
String line = read.nextLine();
                String[] lineArray = line.split("\\s+"); //would split each word making in the line into the array
                String user = lineArray[3]; //containts student ids
                String pass = lineArray[4]; //contains passwords
```

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252526-a090d880-8c33-11eb-8d1f-079139d10d59.png"></p>

The illustration above shows the files that are named *data-{id}.txt* within the Students folder


##### studentNames method
The **studentNames method** would list all the names of the students within the data base. 

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252560-b30b1200-8c33-11eb-8913-872a3006b168.png"></p>

##### deleteFile method
This method would delete the Students folder and all of its contents

##### clearTheFile method
This method would clear students.txt for the next preson who uses the program

``` java
    public void clearTheFile() throws IOException{
        FileWriter file = new FileWriter("students.txt", false); 
        PrintWriter clear = new PrintWriter(file, false);
        clear.flush();
        clear.close();
        file.close();
    }
```


## Images

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252583-c74f0f00-8c33-11eb-8d48-67a1f1b96e19.png"></p>

<p align="center">The welcome screen of the Student Mangement System</p>

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252648-e188ed00-8c33-11eb-81f4-19545a5d77a3.png"></p>
       
<p align="center">The students.txt file</p>

<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252719-fd8c8e80-8c33-11eb-96bd-4e3d2e12afdc.png"></p>

<p align="center">Student's file after it is created</p>



<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252805-109f5e80-8c34-11eb-8d1b-ab7875e38114.png"></p>

<p align="center">Editing GPA</p>


<p align="center"><img src="https://user-images.githubusercontent.com/39322110/112252843-24e35b80-8c34-11eb-9a15-f74db2a2c500.png"></p>

<p align="center">Overwriting the data that was originally null</p>

## Gifs of the Student Management System in GUI format

<p align="center">
  <img src="https://raw.githubusercontent.com/elianalopez/CS335-Student-Management-System/main/Images/sms1.gif" alt="animated" />
</p>
<p align="center">Pressing the Sign Up Button calls another screen</p>

<p align="center">
  <img src="https://raw.githubusercontent.com/elianalopez/CS335-Student-Management-System/main/Images/sms2.gif" alt="animated" />
</p>
<p align="center">When the username or password is no correct/does not exist</p>


<p align="center">
  <img src="https://raw.githubusercontent.com/elianalopez/CS335-Student-Management-System/main/Images/sms3.gif" alt="animated" />
</p>
<p align="center">Illustrating what invalid information would look like to the user if it is not corrected</p>


<p align="center">
  <img src="https://raw.githubusercontent.com/elianalopez/CS335-Student-Management-System/main/Images/sms4.gif" alt="animated" />
</p>
<p align="center">After the user was created from the previous process above this login is now valid and another window with user information will pop-up</p>


<p align="center">
  <img src="https://raw.githubusercontent.com/elianalopez/CS335-Student-Management-System/main/Images/sms.gif" alt="animated" />
</p>
<p align="center">What this process looks like through a desktop </p>




