import java.util.Scanner;

/*
 * Run this file in VS Code.
 * Enter the program number (1, 2, 5, 6, 9, 10, 15, 16, 18, 23)
 * and then provide input if required.
 */

public class Main {

    // Program 1: ArithmeticException – Division
    // Question: Perform division and handle ArithmeticException when denominator is zero.
    static void program1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("First number = ");
        int a = sc.nextInt();
        System.out.print("Second number = ");
        int b = sc.nextInt();

        try {
            System.out.println("Result = " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    // Program 2: ArrayIndexOutOfBoundsException
    // Question: Display an array element and handle an invalid array position.
    static void program2() {
        Scanner sc = new Scanner(System.in);
        int[] a = {10, 20, 30, 40, 50};

        System.out.print("Position = ");
        int pos = sc.nextInt();

        try {
            System.out.println("Element = " + a[pos]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array position.");
        }
    }

    // Program 5: Using throw for Voting Eligibility
    // Question: Use throw to check whether a person is eligible to vote.
    static void program5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Age = ");
        int age = sc.nextInt();

        try {
            if (age < 18)
                throw new Exception();
            System.out.println("Eligible to vote.");
        } catch (Exception e) {
            System.out.println("Not eligible to vote.");
        }
    }

    // Program 6: Using throw for Valid Marks
    // Question: Use throw to validate marks between 0 and 100.
    static void program6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Marks = ");
        int marks = sc.nextInt();

        try {
            if (marks < 0 || marks > 100)
                throw new Exception();
            System.out.println("Valid marks.");
        } catch (Exception e) {
            System.out.println("Invalid marks.");
        }
    }

    // Program 9: Thread by Extending Thread Class
    // Question: Create a thread by extending Thread and display numbers 1 to 5.
    static void program9() {
        class NumberThread extends Thread {
            public void run() {
                for (int i = 1; i <= 5; i++)
                    System.out.println(i);
            }
        }

        NumberThread t = new NumberThread();
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    // Program 10: Thread Using Runnable Interface
    // Question: Create a Runnable thread that displays "Hello Student" three times.
    static void program10() {
        Runnable r = () -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("Hello Student");
        };

        Thread t = new Thread(r);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Main thread completed.");
    }

    // Program 15: Sequential Execution of Two Threads
    // Question: First thread prints "First Thread" three times,
    // then second thread prints "Second Thread" three times.
    static void program15() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("First Thread");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("Second Thread");
        });

        t1.start();

        try {
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    // Program 16: Demonstrating Thread Life Cycle
    // Question: Demonstrate starting, running and completing a thread.
    static void program16() {
        Thread t = new Thread(() -> {
            System.out.println("Thread is running.");
        });

        System.out.println("Thread is starting.");
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Thread has completed.");
    }

    // Program 18: Setting Thread Priority
    // Question: Set LowPriority to 3 and HighPriority to 8.
    static void program18() {
        Thread low = new Thread(() -> {});
        Thread high = new Thread(() -> {});

        low.setName("LowPriority");
        high.setName("HighPriority");

        low.setPriority(3);
        high.setPriority(8);

        System.out.println(low.getName() + " = " + low.getPriority());
        System.out.println(high.getName() + " = " + high.getPriority());

        low.start();
        high.start();

        try {
            low.join();
            high.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Both threads completed.");
    }

    // Program 23: Basic wait() and notify()
    // Question: Use wait() and notify() for inter-thread communication.
    static void program23() {
        class Shared {
            String message;

            synchronized void getMessage() {
                try {
                    while (message == null) {
                        System.out.println("Waiting for message...");
                        wait();
                    }
                    System.out.println("Message received: " + message);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }

            synchronized void setMessage(String msg) {
                message = msg;
                notify();
            }
        }

        Shared shared = new Shared();

        Thread t1 = new Thread(shared::getMessage);

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
            shared.setMessage("Hello Student");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   JAVA PROGRAMS 1,2,5,6,9,10,15,16,18,23");
        System.out.println("====================================");
        System.out.println("1  - ArithmeticException");
        System.out.println("2  - ArrayIndexOutOfBoundsException");
        System.out.println("5  - throw for Voting Eligibility");
        System.out.println("6  - throw for Valid Marks");
        System.out.println("9  - Thread by Extending Thread");
        System.out.println("10 - Thread Using Runnable");
        System.out.println("15 - Sequential Two Threads");
        System.out.println("16 - Thread Life Cycle");
        System.out.println("18 - Thread Priority");
        System.out.println("23 - wait() and notify()");
        System.out.print("\nEnter program number: ");

        int choice = sc.nextInt();

        System.out.println();

        switch (choice) {
            case 1:  program1(); break;
            case 2:  program2(); break;
            case 5:  program5(); break;
            case 6:  program6(); break;
            case 9:  program9(); break;
            case 10: program10(); break;
            case 15: program15(); break;
            case 16: program16(); break;
            case 18: program18(); break;
            case 23: program23(); break;
            default: System.out.println("Invalid program number.");
        }

        sc.close();
    }
}
