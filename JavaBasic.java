import java.util.*;

public class JavaBasic {
      public static void main(String args[]) {
            // System.out.println("alpha plus");
            // System.out.println("First day class");
            Scanner Joe = new Scanner(System.in);
            // System.out.println("enter your name");
            // long a= Joe.nextInt();
            // long b= Joe.nextInt();

            // float area =3.14f*a*a; /*f denotes 3.14 is float value othervise it is
            // considered as a double value */
            // System.out.println(area);

            // System.out.println(b*2);
            // long ab=21;
            // int ba=ab;
            // System.out.println(ba);

            // type casting => narrowing convertion =>explicit
            // int marks =(int)(45.6f);
            // System.out.println(marks);
            // byte a=5;
            // byte b = a*2; /*wrong statement */
            // byte b= (byte) a*2; /*wrong statement */
            // byte b =(byte)(a*2);
            // System.out.println(b);
            // System.out.println();

            // JDK java devleper kit
            // JRE java run time environment
            // JVM java virtual machine

            // System.out.println("enter the price of pencil");
            // float pencil=Joe.nextFloat();

            // System.out.println("enter the price of pen");
            // float pen =Joe.nextFloat();

            // System.out.println("enter the price of eraser");
            // float eraser=Joe.nextFloat();

            // float total = pencil+pen+eraser;
            // total+=total*0.18f;

            // System.out.println("your total price is "+total);

            // int a=25;
            // System.out.println(" value of a"+a);
            // System.out.println(2+3);
            // int sum=0;
            // sum+=a;
            // System.out.println(sum);
            // String s=Joe.nextLine();

            // System.out.println(s);

            // hk que 3
            // int i = Joe.nextInt();
            // double d=Joe.nextDouble();
            // String s=Joe.nextLine();

            // System.out.println("String: " + s);
            // System.out.println("Double: " + d);
            // System.out.println("Int: " + i);

            // hk que 4

            System.out.println("================================");
            // for (int i = 0; i < 3; i++) {
            //       String s1 = Joe.next();
            //       int x = Joe.nextInt();
            //       // Complete this line
            //       System.out.println(s1.length());

            // }
            String s1 = Joe.next();
            System.out.println(s1.length());
            System.out.print(s1);
            for (int i = s1.length(); i < 15; i++) {
                  System.out.print(" ");
            }
            System.out.println();
            System.out.println("================================");
            System.out.println("\ud800\udc35");
            Joe.close();

      }
}