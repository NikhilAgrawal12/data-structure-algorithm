package Hashing;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Concept {
    public static void main(String[] args){
        //country{key), population(value)
        HashMap<String,Integer> map = new HashMap<>();

        //Insertion
        map.put("India",140);
        map.put("US",30);
        map.put("China",130);

        System.out.println(map);

        map.put("India",150);
        System.out.println(map);

        //Search
        if(map.containsKey("China")){
            System.out.println("Key is present in the map");
        }
        else
        {
            System.out.println("Key is not present in map");
        }

        System.out.println(map.get("China"));

        //Iterate
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.print(e.getKey());
            System.out.println(e.getValue());
        }

        //Remove
        map.remove("China");
        System.out.println(map);

        //Scanner
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int b = sc.nextInt();

        System.out.println(a+" "+b);


    }
}
