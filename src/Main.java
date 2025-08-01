import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("A1001", "Roshan", 10000, 1234));
        accounts.add(new BankAccount("A1002", "Rahul", 5000, 5678));
        accounts.add(new BankAccount("A1003", "Priya", 8000, 4321));

        while (true) {
            System.out.println("\n Login to Your Bank Account");
            System.out.print("Enter Account Number: ");
            String enteredAcc = sc.nextLine();

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();
            sc.nextLine(); // Clear newline

            BankAccount currentUser = null;

            for (BankAccount acc : accounts) {
                if (acc.getAccountNumber().equals(enteredAcc) && acc.isValidPin(enteredPin)) {
                    currentUser = acc;
                    break;
                }
            }

            if (currentUser != null) {
                System.out.println("\n Login successful. Welcome, " + currentUser.getHolderName());

                while (true) {
                    System.out.println("\n===== Bank Menu =====");
                    System.out.println("1. Show Account Details");
                    System.out.println("2. Deposit Money");
                    System.out.println("3. Withdraw Money");
                    System.out.println("4. Update PIN");
                    System.out.println("5. Logout");
                    System.out.print("Choose an option: ");
                    int option = sc.nextInt();
                    sc.nextLine(); // Clear newline

                    switch (option) {
                        case 1:
                            currentUser.display();
                            break;
                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            double depAmount = sc.nextDouble();
                            currentUser.depositMoney(depAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to withdraw: ");
                            double wdAmount = sc.nextDouble();
                            System.out.print("Enter PIN to confirm: ");
                            int pinToWithdraw = sc.nextInt();
                            currentUser.withdrawMoney(wdAmount, pinToWithdraw);
                            break;
                        case 4:
                            System.out.print("Enter OLD PIN: ");
                            int oldPin = sc.nextInt();
                            System.out.print("Enter NEW PIN: ");
                            int newPin = sc.nextInt();
                            currentUser.updatePin(oldPin, newPin);
                            break;
                        case 5:
                            System.out.println(" Logged out successfully.");
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }

                    if (option == 5) break;
                }

            } else {
                System.out.println(" Invalid account number or PIN. Try again.");
            }

            System.out.print("\nDo you want to exit the system? (yes/no): ");
            String exitChoice = sc.nextLine().trim().toLowerCase();
            if (exitChoice.equals("yes")) {
                System.out.println(" Thank you for using the Bank App!");
                break;
            }
        }

        sc.close();
    }
}
