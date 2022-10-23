//********Don't forget to include JDBC drivers prior using this program*******

//This program can store students data in MySQL database, connected to Java.
//GitHub: ayoamrit

import java.util.Scanner;

public class Main {

    //main function
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        //object of Connect class
        Connect call = new Connect();

        while(true) {

            //calling method from Connect class
            call.startUp();

            try {

                //getting input
                int choice = input.nextInt();

                if (choice == 1) {

                    //calling nested class constructor if choice is 1
                    call.new FutureStudentConnect();

                } else if (choice == 2) {

                    //calling nested class constructor if choice is 2
                    call.new CurrentStudentConnect();

                } else if (choice == 3) {

                    //quiting program if choice is 3
                    break;

                }else {
                    System.out.println(); //leaving space
                    System.out.println("Unexpected Input");
                }

            }catch(Exception e){

                System.out.println("Please Make A Valid Choice");

                input.nextLine(); //swallowing input if it get struck
            }


        }

        System.out.println(); //leaving space
        System.out.println("Program Terminated");
    }
}
