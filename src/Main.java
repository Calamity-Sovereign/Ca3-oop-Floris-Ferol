import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;
public class Main {

    //Question 1

    public static void main(String[] args) throws FileNotFoundException{

        //question1();
        //question2();
        //question3();
        //question4();
        //question5();
          question6();


    }

    public static void question1() {
        System.out.println("Q1");

        ArrayDeque<Integer> driveStack = new ArrayDeque<>();  // recommended to use ArrayDeque for a stack
        ArrayDeque<Integer> streetStack = new ArrayDeque<>();

        driveStack.push(1);
        driveStack.push(2);
        driveStack.push(3);

        // remove one car1
        int num = 2;
        if (driveStack.contains(num)) ;
        System.out.println("enter number");
        while (!driveStack.isEmpty()) {
            int car1 = driveStack.pop();        // remove top element from stack
            System.out.println(++car1);
        }

        streetStack.push(1);
        streetStack.push(2);
        streetStack.push(3);

    }

    //Question 2
    public static void question2() {
        System.out.println("Q2");

        ArrayDeque<Pair> stack = new ArrayDeque<>();  // recommended to use ArrayDeque for a stack //This is the declaration of the Array stack

        //////This is the 2D Array formation
        int[][] array = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = 0;

            }
        }


        //////number used to keep track of cellular formation position
        int count = 1;

        // set starting cell position
        Pair current = new Pair(3, 4);

        stack.push(current);

        while (!stack.isEmpty()) {  // while stack is not empty

            current = stack.pop();

            int row = current.x;
            int column = current.y;

            if (array[row][column] == 0) {
                array[row][column] = count;
                count++;

                //North
                if (row > 0 && array[row - 1][column] == 0)

                    stack.push(new Pair(row - 1, column));

                //South
                if (row < 9 && array[row + 1][column] == 0)
                    stack.push(new Pair(row + 1, column));

                //East
                if (column < 9 && array[row][column + 1] == 0)
                    stack.push(new Pair(row, column + 1));


                //West
                if (column > 0 && array[row][column - 1] == 0)
                    stack.push(new Pair(row, column - 1));
            }

        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

//////

    /////Question 3


    public static void question3() throws FileNotFoundException {
        System.out.println("Q3");


        TreeMap<String, HashSet<Integer>> map = new TreeMap<>();

        String token = "Token";
        int lineNumber = 0;

        Scanner input = new Scanner(new File("Pair.java"));

        while (input.hasNextLine()) {
            lineNumber++;
            Scanner words = new Scanner(input.nextLine());
          // words.useDeLimiter(pattern"[^A-Za-z0-9_]+");
            while (words.hasNext()) {
                token = words.next();

            //   if (map.co)


            }
        }



        if (map.containsKey(token)) {
            map.get(token).add(lineNumber);
        } else {

            HashSet<Integer> set = new HashSet<>();
            set.add(lineNumber);
            map.put(token, set);
        }

    }


//////////////////////////////////////
        //Question 4
        public static boolean validate(String tags_bad) throws FileNotFoundException
        {
            System.out.println("Question 4");

            Stack<String> stack = new Stack<>();
            Scanner fin = new Scanner(new File("tags_bad.txt"));
            String tag;
            while(fin.hasNext())
            {
                //System.out.println("Stack:" + tokens);

                tag = fin.next().trim();  // get next word, and trim
                tag = tag.substring(1, tag.length()-1); // strip off the opening < and closing >
                if(tag.charAt(0)=='/')  // if '/' before tag name, then it's a closing tag
                {
                    tag = tag.substring(1);
                    String top = stack.pop();
                    if( ! top.equals(tag)) // if NOT equal, then tags are invalid
                    {
                        return false;   // exit the method, with false, meaning not valid, so bail out
                    }
                }
                else  // it must be an opening tag
                {
                    stack.push(tag);
                }
            }
            return stack.isEmpty();
        }

        public static void question4 () throws FileNotFoundException {
            String[] files = {"tags_valid.txt", "tags_bad.txt"};

            // process files one by one
            for(String fName: files) {
                System.out.print(fName +": ");
                if (validate(fName)==true) {
                    System.out.println("The file is valid");
                } else {
                    System.out.println("This file is invalid");
                }
            }
        }



//////////////////////////////////////////////////////////////////////
//Question 5




    public static void  question5()
    {
        Queue<String> flightSymbol = new PriorityQueue<>();

        flightSymbol.add("takeoff(“Flight-100”)");
        flightSymbol.add("takeoff(“Flight-220”)");
        flightSymbol.add("land(“Flight-320”)");
        flightSymbol.add("next");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (takeoff flightSymbol, land flightSymbol, next, or quit): ");
        System.out.println("Queue: " + flightSymbol); //is queued

        System.out.println("Queue: " + flightSymbol); //is queued

        flightSymbol.add("Queue: " + flightSymbol);

        flightSymbol.add("Queue: " + flightSymbol);


    }


//////////////////////////////////////////////////////
//Question 6

    public static void question6()
    {

        Queue<Block> shares = new ArrayDeque<>();

        Scanner in = new Scanner(System.in);
        String command=" ";


        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                shares.add(new Block(qty, price));
                System.out.println(shares);

            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                double total = 0;

                while(qty > 0 && !shares.isEmpty()){
                    Block bee = shares.peek();

                    qty -= bee.quantity;

                    if(qty > 0){
                        total += bee.quantity*price - bee.quantity* bee.wallet;
                        shares.remove();

                        System.out.println(total);
                    }
                          else{
                        total += (qty + bee.quantity)*price - (qty + bee.quantity)* bee.wallet;
                        System.out.println(total);

                        shares.peek().quantity = -qty;
                        System.out.println(-qty);

                    }
                }
                System.out.println("This is the total profit:" + total);

            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}














/////////////////////////////////////////////////////////////////////////
            //  Question.3---what Dermot wrote on board
//            public class Main
//            public static void main(String[] args throws FileNotFoundException)
//
//            Map<String, HashSet<Integer>> map = new TreeMap<>();
//            Scanner fin = new Scanner(new File("Ex3Q1.java");
//            int lineNumber=1;
//
//            while(fin.hasNextLine()) {
//                Scanner in = new Scanner(fin.nextLine());
//                in.useDeLimiter(pattern:"[^A-Za-z0-9_]+");
//                while( in.hasNext())
//                {
//                    String token = in.next();
//
//                    if(map.co)
//                }
//            }
//        }
//}
//
//
//}
//////////////////////////////////////////////////////////////////
//   simply forced code in a stack question 4
//
//
//////////////////////////
//question 5
//    String front = flightSymbol.remove();
//        System.out.println("Removed element: " + front);