
import java.util.ArrayList;
import java.util.Scanner;

public class FutureStudent {

    //Using scanner to get user input
    Scanner input = new Scanner(System.in);

    //ArrayList method
    public ArrayList<String> studentDetails(){

        //Creating an ArrayList
        ArrayList<String> futureStudentData = new ArrayList<>();

        //Adding all the student details to the ArrayList
        futureStudentData.add(promptFirstName());
        futureStudentData.add(promptLastName());
        futureStudentData.add(promptEmail());
        futureStudentData.add(promptPassword());

        //Returning ArrayList
        return futureStudentData;
    }


    public String promptFirstName(){

        System.out.print("Enter Your First Name: ");

        return input.nextLine();

    }

    public String promptLastName(){

        System.out.print("Enter Your Last Name: ");

        return input.nextLine();
    }

    public String promptEmail(){

        System.out.print("Enter Your Email: ");

        return input.nextLine();
    }

    public String promptPassword(){

        System.out.print("Enter Password: ");

        return input.nextLine();
    }

}

