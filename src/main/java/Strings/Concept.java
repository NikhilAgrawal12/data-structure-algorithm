package Strings;
import java.util.*;

public class Concept {
    public static void main(String[] args){
        String firstName="Nikhil";
        String lastName="Agrawal";

        String name=firstName+" "+lastName;

        System.out.println(name);

//        Scanner sc = new Scanner(System.in);
//        String fullname = sc.nextLine();
//
//        System.out.println("Your name is: "+fullname);

        System.out.println(name.length());

        //charAt
        for(int i=0;i<name.length();i++){
            System.out.println(name.charAt(i));
        }

        String str1="abc";
        String str2="abcd";

        if(str1.equals(str2)){
            System.out.println("Strings are equal");
        }

    }
}
