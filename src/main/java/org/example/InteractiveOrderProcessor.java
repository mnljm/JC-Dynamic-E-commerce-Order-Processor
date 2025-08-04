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

        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = sc.nextLine();
        if ((!customerTier.equalsIgnoreCase("gold"))
                && (!customerTier.equalsIgnoreCase("silver"))
                && (!customerTier.equalsIgnoreCase("regular"))) {
            System.out.println("Invalid input, please try again");
            System.exit(1);
        }

        System.out.print("Enter discount code: ");
        String discountCode = sc.nextLine();

        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): "); //Requirement: Use switch-case statement here
        String shippingZone = sc.nextLine();

        System.out.println("\n--- Order Details ---");
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + unitQty);
        System.out.println("Member: " + customerAMember);
        System.out.println("Customer Tier: " + customerTier);
        System.out.println("Shipping Zone: " + shippingZone);
        System.out.println("Discount Code: " + discountCode);

        System.out.println("\n--- Calculation Steps ---");
        //Subtotal
        double subtotal = unitPrice * unitQty;
        System.out.printf("Initial Subtotal: $%.2f\n", subtotal);

        //Tier Discount Requirement: Use if-else here
        if(customerTier.equalsIgnoreCase("gold")) {
            subtotal = subtotal - (subtotal * 0.15);
            System.out.printf("After Tier Discount (Gold 15%%): $%.2f\n", subtotal);

        }
        else if(customerTier.equalsIgnoreCase("silver")) {
            subtotal = subtotal - (subtotal * 0.10);
            System.out.printf("After Tier Discount (Silver 10%%): $%.2f\n", subtotal);
        }
        else
            System.out.printf("After Tier Discount (Regular 0%%): $%.2f\n", subtotal);


        //Quantity Discount Requirement: Use if statement here
        if(unitQty >= 5){
            subtotal = subtotal - (subtotal * 0.05);
            System.out.printf("After Quantity Discount(5%% if qty >= 5): $%.2f\n", subtotal);
        }


        // Promotional Code Application Requirement: Use if-else statement here
        boolean freeShipping = false;
        if(discountCode.equals("SAVE10") && (subtotal > 75.00)) {
            subtotal = subtotal - 10.00;
            System.out.printf("After Promotional Code(SAVE10%%): $%.2f\n", subtotal);
        }
        else if(discountCode.equalsIgnoreCase("FREESHIP") && (subtotal > 75.00)) {
            freeShipping = true;
            System.out.println("After Promotional Code(FREESHIP): $0.00 Shipping Fee");
        }

        //Small Order Surcharge Requirement: Use Ternary Operator
        double surcharge = (subtotal < 25.00) ? 3.00 : 0.0;
        subtotal = subtotal + surcharge;
        if(surcharge > 0) {
            System.out.printf("After Small Order Surcharge: $%.2f\n", subtotal);
        }
        else
            System.out.printf("After Small Order Surcharge(No Surcharge Applied): %.2f", subtotal);

        //Shipping Cost Calculation Requirement: Use a switch case statement here
        double shippingCost = 0.0;
        if(!freeShipping) {
            shippingCost = switch (shippingZone.toLowerCase()) {
                case "zonea" -> 5.00;
                case "zoneb" -> 12.50;
                case "zonec" -> 20.00;
                default -> 25.00;
            };
        }
        System.out.printf("\nShipping Cost: $%.2f\n", shippingCost);

        double finalOrderTotal = subtotal + shippingCost;
        System.out.printf("\nFinal Order Total: $%.2f", finalOrderTotal);

        StringEqualityDemo(sc);

        sc.close();
    }

    public static void StringEqualityDemo(Scanner sc) {
        System.out.println("\n\n--- String Equality Demo ---");
        System.out.print("Enter First String: ");
        String a = sc.nextLine();
        System.out.print("Enter Second String: ");
        String b = sc.nextLine();
        System.out.println();

        System.out.println("== :" + (a == b));
        System.out.println(".equals() :" + a.equals(b));
        System.out.println(".equalsIgnoreCase() :" + a.equalsIgnoreCase(b));
        System.out.println();

        System.out.println("== compares the address references, not the actual string value," +
                " which is why even though Strings may have the same value, " +
                "if they do not point to the same address, the == operator returns false.");
        System.out.println(".equals() compares the actual String values instead of addresses. " +
                "If the same characters are present in both Strings, the method will return true.");
        System.out.println(".equalsIgnoreCase() also compares the String values, " +
                "the difference is that it disregards of whether the characters present " +
                "are in upper case or lower case.");


    }


}
