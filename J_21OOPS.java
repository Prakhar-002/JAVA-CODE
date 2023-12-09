public class J_21OOPS {

      public static void callPenClass(){
            Pen p1=new Pen();
            p1.setColor("blue");
            p1.setPrice(50);
            System.out.println(p1.color);
            System.out.println(p1.price);
      }

      public static void callBankClass(){
            BankDetails U1=new BankDetails();
            U1.username ="Purnima";
            // U1.password=" 12375";   // not accessible...
            U1.setPass("looks");   // we can only set the password but can't access it ...
            System.out.println(U1.username);
      }

      public static void StudentsCall(){
            //call constructor with name
            Students s3 =new Students("purnima");
            //call constructor with marks
            Students s2 =new Students(123);
            //call constructor without any args
            Students s1 =new Students();
            s1.name ="kumari";
            s1.mark=10;
            s1.marks[0]=10;
            s1.marks[1]=20;
            s1.marks[2]=30;

            Students s4 =new Students(s1);
            // if we change s1 marks after copy constructor ...then s4 marks will also change,...
            s1.marks[0]=100;

            // because s4 just refer a array who was created by s1 ...
            // this called shallow copy... just copy references...
            // print s4 marks as s1 
            for(int i =0;i <3;i++){
                  System.out.println(s4.marks[i]);
            }
      }

      // single level inheritance...
      public static void AnimalSingleFish(){
            Fish shark =new Fish();
            shark.eat();
      }

      // multi level inheritance...
      public static  void AnimalMultiDogCall(){
            Dogs sheru = new Dogs();
            sheru.property();
            sheru.eat();
      }

      // abstracts class and functions call 

      public static void AbstractsAnimalsCall(){
            // we can't create direct an animals class because it's of type ABSTRACT 
            // Animals a =new Animals();   // this line will give you an error (walk is not define)
            Horse Joe =new Horse();
            Joe.eat();
            Joe.walk();
            System.out.println(Joe.color);
            // we have to first call the function  to change the color from parent class to existing class
            Joe.changeColor();
            System.out.println(Joe.color);

            Chicken chi =new Chicken();
            chi.eat();
            chi.walk();
            Mustang myHorse =new Mustang();
            // Animals -> Horse -> Mustang
      }

      // interface class 
      public static void interfaceChessPlayer(){
            Queen q1= new Queen();
            q1.walk();
      }




      public static void main(String args[]){
            interfaceChessPlayer();
      }
}



// interface ...
interface ChessPlayer{
      void walk();
}class Queen implements ChessPlayer{
      public void walk(){
            System.out.println(" up, down ,left , right , diagonal");
      }
}class Rook implements ChessPlayer{
      public void walk(){
            System.out.println(" up, down ,left , right ");
      }
}class King implements ChessPlayer{
      public void walk(){
            System.out.println(" up, down ,left , right , diagonal - (by one step)");
      }
}

// abstract class and functions 
abstract class Animals{
      String color;
      // constructor ...
      Animals(){
            color ="brown";
            System.out.println("Animals constructor called");
      }
      void eat(){     // non - abstracts functions 
            System.out.println("Animals eats ...");
      }

      abstract void walk(); // abstract  function ...it's definition will be in the child class.

}class Horse extends Animals{
      //  constructor ...
      Horse(){
            System.out.println("horse constructor called");
      }
      void changeColor(){
            color ="dark brown and black";
      }
      void walk (){
            System.out.println("horse walks on 4 legs...");
      }
}class Chicken extends Animals{
      void changeColor(){
            color="yellow";
      }
      void walk (){
            System.out.println("chicken walks on 2 legs..");
      }
}
// hierarchy checking...
class Mustang extends Horse{
      Mustang(){
            System.out.println("Mustang constructor is called");
      }
}

//inheritance property ...
class Animal{
      String color;

      void eat(){
            System.out.println(" eat");
      }

      void breath(){
            System.out.println("breaths to live");
      }
}
// single level inheritance...
class Fish extends Animal{   // we right extends to inheritance the function and property
      String name;
      int fins;
      void swim(){
            System.out.println("swims in water");
      }
}

// multi level inheritance ...
class Mammal extends Animal{  // child of Animal
      int legs;
}class Dogs extends Mammal{   // child of Mammal and 2nd child of Animal
      String bread;
      void property(){
            System.out.println("This is in the dog class which is child of Mammal and 2nd child of Animal");
      }
}

// here both fish and dogs are using animals class hence it's called hierarchial inheritance...


// constructors ...
class Students{
      String name;
      int mark;
      int marks[];


      // copy constructor ...
      Students(Students s1){
            this.name =s1.name;
            this.mark =s1.mark;
            marks =new int[3];
            // this is shallow copy of marks array...

            // this.marks =s1.marks;

            // for deep copy we use 
            for (int i = 0; i < this.marks.length; i++) {
                  this.marks[i]=s1.marks[i];
            }
      }
      // creation of constructor  ... without any return type
      Students(String name){
            System.out.println("constructor is called...");
            this.name =name;
            System.out.println("your name is :"+name);
      }
      // we can have more than one constructor at a time with different args
      Students(){
            System.out.println("not any args");
            marks =new int[3];
      }
      Students(int mark){
            this.mark =mark;
            System.out.println(mark);
      }
}


// study about private public default and protected   access modifier ...
class BankDetails{
      public String username;
      private String password;
      public void setPass(String pwd){
            password = pwd;
      }
}

// class creation and apply getter nd setter concept ...
class Pen {
      String color;
      int price;
      
      // getter for color...
      String getColor(){
            return this.color;  // this keyword refer to the current object...
      }
      // setter for color...
      void setColor(String newColor){
            color=newColor;
      }

      // getter for price...
      int getPrice(){
            return this.price;
      }

      // setter for price...
      void setPrice(int price){
            this.price=price;
      }
}
