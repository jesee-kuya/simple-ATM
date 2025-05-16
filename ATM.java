import java.util.Scanner;

public class ATM {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount("12345678", "4321", 1000.0);

        System.out.print("Enter Account Number: ");
        String enteredAcc = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (!account.getAccountNumber().equals(enteredAcc) || !account.validatePin(enteredPin)) {
            System.out.println("Invalid account number or PIN. Exiting...");
            return;
        }

        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 2: 
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    account.deposit(deposit);
                    System.out.println("Deposited successfully.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (account.withdraw(withdraw)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (choice != 4);

        scanner.close();
    }
}