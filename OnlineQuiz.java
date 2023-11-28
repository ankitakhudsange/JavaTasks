
package arcanepath;

import java.util.Scanner;

class functionality{
    
    public static final int TIME_LIMIT = 5000; // 5 seconds in milliseconds

    Scanner sc = new Scanner(System.in);
   
    
    public void LogOut(){
        System.out.println("Loging Out....");
        return;
    }
    
   public void Quiz(){
        int Score=0;
        int TotalScore=0;
        
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Answer the questions within 5 sec or the answer will be considered as wrong!!");
        System.out.println("-------------------------------------------------------------------------------");
        
        String[] questions = {
            "A. Who invented Java Programming?",
            "B. Which component is used to compile, debug and execute the java programs?",
            "C. Which of these cannot be used for a variable name in Java?",
            "D. Arrays in java are-?",
            "E. What is the extension of java code files?"
        };
        
        String[][] choices = {
                {" 1) Guido van Rossum", " 2)  James Gosling" ," 3)Dennis Ritchie", " 4) Bjarne Stroustrup"},
                {" 1) JRE"," 2) JIT "," 3) JDK"," 4) JVM"},
                {" 1) identifier & keyword", " 2) identifier", " 3) keyword", " 4) none of the mentioned"},
                {" 1) Object References", " 2) Objects ", " 3) Primitive Data Types", " 4) None"},
                {" 1) .js"," 2) .txt"," 3) .class"," 4) .java"}
        };

        String[] answers = {
            "2",
            "3",
            "3",
            "2",
            "4"
        };
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String choice : choices[i]) {
                System.out.println(choice);
            }
            System.out.print("Your answer:  ");

            // Get the start time for the timer
            long startTime = System.currentTimeMillis();

            String userAnswer = sc.next();

            long Time_elapsed= System.currentTimeMillis() - startTime;

            // Check if the user answered within the time limit
            if (Time_elapsed <= TIME_LIMIT) {
                Score++;
                // Check if the user's answer is correct
                if (userAnswer.equalsIgnoreCase(answers[i])) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect. The correct answer is: " + answers[i] + "\n");
                }
            } else {
                System.out.println("Time's up! Moving on to the next question.\n");
            }
        }

        System.out.println("Quiz completed!");
        
        // Showing total score of the test 
        TotalScore+=Score;
        System.out.println("------------------------------");        
        System.out.println("Total Score = "+TotalScore);
        System.out.println("------------------------------");
        
        System.out.println("Press 1 to give Retest\nPress 2 to go to Main menu ");
        int again=sc.nextInt();
        if(again==1){
            Quiz();
        }else{
            mainMenu();
        }
   }
    
    public void updateProfile() {
        
        System.out.println("------------------------------");
        System.out.println("Press 1 to change User Name \nPress 2 to change Password \nPress 3 to change both User name & Password ");
        int opt = sc.nextInt();
        
        if(opt==1){
            
            System.out.println("Enter new user name :");
            String newName= sc.next();
            System.out.println("Your User name is successfully changed!!");
            
        } else if (opt==2){
            System.out.println("Enter new password :");
            int newPass= sc.nextInt();
            System.out.println("Your Password is successfully  changed!!");
           
        }else{
            
            System.out.println("Enter new user name :");
            String newName= sc.next();

            System.out.println("Enter new password :");
            int newPass= sc.nextInt();
            System.out.println("Your User name & Password is successfully  changed!!");
                 
        }
        System.out.println("1. Main menu ");
        System.out.println("2. Exit");
        int mm= sc.nextInt();
        if(mm==1){
            mainMenu();
        }else{
            System.out.println("Exit......");
        }
        
    }
   
    
    public void Login(){
        String userName="Ankita";
        String  password="4536";
       
        System.out.println("Enter User Name : ");
        String user_ip=sc.next();
        System.out.println("Enter User Password : ");
        String user_pass = sc.next();

         
        if( user_ip.equalsIgnoreCase(userName) && user_pass.equalsIgnoreCase(password)){
            System.out.println("Login Successfully ....\nWelcome "+user_ip+"!!!");
            
        }else{
            System.out.println(" Please enter correct User Name or Password");
            Login();
        }
    }

    
    public void mainMenu(){
        
        System.out.println("------------------------------");
        System.out.println("1. Update Profile \n2. Start Exam \n3. Logout");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateProfile();
                break;
            case 2:
                Quiz();
                break;
            case 3:
              LogOut();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                mainMenu();
            }
    }
}
public class OnlineQuiz {
    
    public static void main(String args[]){
        
        System.out.println("------WELCOME TO ONLINE QUIZ PORTAL.-------- ");
        functionality f  = new functionality();
        f.Login();
        f.mainMenu();
    }
    
}
