/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mathapp;

/**
 *
 * @author gdots
 */
import java.util.Scanner;

public class MathApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Math App Menu ===");
            System.out.println("1. Addition of two numbers");
            System.out.println("2. Subtraction of two numbers");
            System.out.println("3. Multiplication of two numbers");
            System.out.println("4. Division of two numbers");
            System.out.println("5. Factorial of a number");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Sum of numbers 1 to N");
            System.out.println("8. Check if a number is prime");
            System.out.println("9. Greatest Common Divisor (GCD)");
            System.out.println("10. Absolute value of a number");
            System.out.println("11. Average of N numbers (stored in an array)");
            System.out.println("12. Maximum of N numbers (stored in an array)");
            System.out.println("0. Exit");

            // Challenge 2: Input Validation Loop for menu choice
            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1 ->  { // Addition
                    double num1 = readDouble(input, "Enter first number: ");
                    double num2 = readDouble(input, "Enter second number: ");
                    System.out.println("Result: " + (num1 + num2));
                }
                case 2 ->  { // Subtraction
                    double num1 = readDouble(input, "Enter first number: ");
                    double num2 = readDouble(input, "Enter second number: ");
                    System.out.println("Result: " + (num1 - num2));
                }
                case 3 ->  { // Multiplication
                    double num1 = readDouble(input, "Enter first number: ");
                    double num2 = readDouble(input, "Enter second number: ");
                    System.out.println("Result: " + (num1 * num2));
                }
                case 4 ->  { // Division (Handle divide-by-zero)
                    double num1 = readDouble(input, "Enter numerator: ");
                    double num2 = readDouble(input, "Enter denominator: ");
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        System.out.println("Result: " + (num1 / num2));
                    }
                }
                case 5 ->  { // Factorial (Handle negative numbers)
                    int n = readInt(input, "Enter a non-negative integer: ");
                    if (n < 0) {
                        System.out.println("Error: Factorial of a negative number does not exist.");
                    } else {
                        long fact = 1;
                        for (int i = 1; i <= n; i++) {
                            fact *= i;
                        }
                        System.out.println("Result: " + n + "! = " + fact);
                    }
                }
                case 6 ->  { // Power
                    double base = readDouble(input, "Enter base (x): ");
                    double exponent = readDouble(input, "Enter exponent (y): ");
                    System.out.println("Result: " + Math.pow(base, exponent));
                }
                case 7 ->  { // Sum from 1 to N
                    int n = readInt(input, "Enter N: ");
                    if (n < 1) {
                        System.out.println("Error: N must be at least 1.");
                    } else {
                        long sum = 0;
                        for (int i = 1; i <= n; i++) {
                            sum += i;
                        }
                        System.out.println("Result: Sum from 1 to " + n + " is " + sum);
                    }
                }
                case 8 ->  { // Prime check
                    int n = readInt(input, "Enter an integer to check prime: ");
                    if (n <= 1) {
                        System.out.println(n + " is NOT a prime number.");
                    } else {
                        boolean isPrime = true;
                        for (int i = 2; i <= Math.sqrt(n); i++) {
                            if (n % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) {
                            System.out.println(n + " is a prime number.");
                        } else {
                            System.out.println(n + " is NOT a prime number.");
                        }
                    }
                }
                case 9 ->  { // GCD
                    int a = Math.abs(readInt(input, "Enter first integer: "));
                    int b = Math.abs(readInt(input, "Enter second integer: "));
                    int tempA = a, tempB = b;
                    while (tempB != 0) {
                        int temp = tempB;
                        tempB = tempA % tempB;
                        tempA = temp;
                    }
                    System.out.println("GCD of " + a + " and " + b + " is " + tempA);
                }
                case 10 ->  { // Absolute Value
                    double num = readDouble(input, "Enter a number: ");
                    System.out.println("Result: " + Math.abs(num));
                }
                case 11 ->  { // Average of N numbers using Array
                    int n = readInt(input, "Enter number of elements (N): ");
                    if (n <= 0) {
                        System.out.println("Error: N must be greater than 0.");
                    } else {
                        double[] arr = new double[n];
                        double sum = 0;
                        for (int i = 0; i < n; i++) {
                            arr[i] = readDouble(input, "Enter element " + (i + 1) + ": ");
                            sum += arr[i];
                        }
                        System.out.println("Average: " + (sum / n));
                    }
                }
                case 12 ->  { // Maximum of N numbers using Array
                    int n = readInt(input, "Enter number of elements (N): ");
                    if (n <= 0) {
                        System.out.println("Error: N must be greater than 0.");
                    } else {
                        double[] arr = new double[n];
                        for (int i = 0; i < n; i++) {
                            arr[i] = readDouble(input, "Enter element " + (i + 1) + ": ");
                        }
                        double max = arr[0];
                        for (int i = 1; i < n; i++) {
                            if (arr[i] > max) {
                                max = arr[i];
                            }
                        }
                        System.out.println("Maximum value: " + max);
                    }
                }
                case 0 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice. Please select options 0-12.");
            }
        } while (choice != 0);

        input.close();
    }

    // Helper method for Challenge 2: Integer Input Validation Loop
    public static int readInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            System.out.print("Invalid input! Non-numeric entered. " + prompt);
            input.next(); // Discard non-numeric token
        }
        return input.nextInt();
    }

    // Helper method for Challenge 2: Double Input Validation Loop
    public static double readDouble(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input! Non-numeric entered. " + prompt);
            input.next(); // Discard non-numeric token
        }
        return input.nextDouble();
    }
}
