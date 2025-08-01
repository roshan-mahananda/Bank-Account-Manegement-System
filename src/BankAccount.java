public class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void depositMoney(double amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Deposited Successfully.");
        } else {
            System.out.println("Invalid amount...");
        }
    }

    public boolean isValidPin(int pin) {
        return pin == this.pin;
    }

    public void withdrawMoney(double amount, int pin) {
        if (isValidPin(pin)) {
            if (amount <= balance && amount > 0) {
                balance -= amount;
                System.out.println("Withdrawn Successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid Pin");
        }
    }

    public void display() {
        System.out.println("Account Number = " + accountNumber);
        System.out.println("Holder Name = " + holderName);
        System.out.println("Balance = " + balance);
    }

    public void updatePin(int oldPin, int newPin) {
        if (isValidPin(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN updated successfully.");
        } else {
            System.out.println("Invalid old PIN.");
        }
    }
}