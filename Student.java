public class Student {
    String studentID;
    String firstName;
    String lastName;
    String email;
    String major;
    float gpa;
    String passowords;
    
    void setStudentID(String numb){
        studentID=numb;
    }

    void setFirstName(String name1){
        firstName=name1;
    }

    void setLastName(String name2){
        lastName=name2;
    }

    void setEmail(String mail){
        email=mail;
    }

    void setMajor(String maj){
        major=maj;
    }

    void setGPA(float grade){
        gpa=grade;
    }

    void setPassword(String pass){
        passowords=pass;
    }

    public boolean doesPasswordEqual(String pass) {
        return this.passowords.equals(pass);
    }
   
    public String getStudentID(){
        return (studentID);
    }

    public String toString(){
        return ("StudentID: "+studentID+"\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nSchool Email: "+email);
    }
}

