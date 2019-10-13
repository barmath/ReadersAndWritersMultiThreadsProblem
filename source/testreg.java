import java.util.*;

class testreg{
 
    public static void main(String []args ){
       String str = "X=89";

       String [] arr = str.split("=",2);


       System.out.println(arr[0]);
       System.out.println(arr[1]);
    }
}