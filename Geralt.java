import java.util.*;
public class Geralt {
      public static void main(String args[]){
            Scanner js=new Scanner(System.in);
            System.out.println("enter the value of income`");
            int a=js.nextInt();
            int tax;
            if(a<500000){
                  tax=0;
                  // System.out.println(tax);
            }else if(a>=500000 &&1000000<a){
                  tax=(int)(a*0.2);
                  // System.out.println(tax);
            }else{
                  tax=(int)(a*0.3);
            }
            System.out.println("your tax is :"+tax);
            int number1=10;
            // ternary operator
            String doj=number1%2==0?"true--even":"false--odd";
            System.out.println(doj);
            System.out.println("Enter a number");
            int number=js.nextInt();
            System.out.println(number);
            if (number>0){
                  System.out.println("This is a positive number");

            }else{
                  System.out.println("-ve numb");
            }
            js.close();

      }
      
}
