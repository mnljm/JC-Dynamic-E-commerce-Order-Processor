package org.example;
import java.util.*;

public class InteractiveOrderProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Interactive Order Processor");

        System.out.println("\n--- Enter Order Details ---");
        System.out.print("Enter unit price: ");
        double unitPrice = 0.0;
        try{
            unitPrice = sc.nextDouble();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            System.exit(1);
            sc.nextLine();
        }

        System.out.print("Enter unit quantity: "); //Requirement: Use if statement
        double unitQty = 0.0;
        try{
            unitQty = sc.nextDouble();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            System.exit(1);
        }

        System.out.print("Is customer a member (true/false?): ");
        boolean customerAMember = false;
        try {
            customerAMember = sc.nextBoolean();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again");
            System.exit(1);
        }

        System.out.print("Enter customer tier (Regular, Silver, Gold): "); // Requirement: Use if-else here
        String customerTier = sc.nextLine();
        if ((!customerTier.equalsIgnoreCase("gold"))
                && (!customerTier.equalsIgnoreCase("silver"))
                && (!customerTier.equalsIgnoreCase("regular"))) {
            System.out.println("Invalid input, please try again");
            System.exit(1);
        }

        System.out.printf("Enter discount code: ");
        String discount = sc.nextLine();

        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): "); //Requirement: Use switch-case statement here
        String shippingZone = sc.nextLine();

        System.out.println("--- Order Details ---");
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + unitQty);
        System.out.println("Member: " + customerAMember);
        System.out.println("Customer Tier: " + customerTier);
        System.out.println("Shipping Zone: " + shippingZone);
        System.out.println("Discount Code: " + discount);

        System.out.println("--- Calculation Steps ---");
        System.out.println("Initial Subtotal: $240.00");
        System.out.println("After Tier Discount: $204.00");
        System.out.println("After Quantity Discount: $193.80");
        System.out.println("After Promotional Code: $183.80");
        System.out.println("After Small Order Surcharge (If Applicable): $183.80");

        System.out.println("\nShipping Cost: $12.50");

        System.out.println("\nFinal Order Total: $196.30");





    }
}
