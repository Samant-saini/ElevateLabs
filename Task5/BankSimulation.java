import java.util.Scanner;

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        Account acc = new Account(name, accNum);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double d = sc.nextDouble();
                    acc.deposit(d);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double w = sc.nextDouble();
                    acc.withdraw(w);
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    acc.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

