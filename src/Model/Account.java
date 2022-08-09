package Model;

import java.math.BigDecimal;

public class Account {
    private String IBAN;
    private String DNI;
    private String name;
    private String surname;
    private double balance;

    public Account(String DNI, String name, String surname) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.generateIban();
        this.balance = 0;
    }

    private void generateIban(){
        double ibanNumber = Math.round(Math.random() * 600000);
        this.IBAN = String.valueOf(ibanNumber);
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositMoney(double balance){
        if(balance >= 0){
            this.balance += balance;
        }else {
            throw new RuntimeException("Not enough money on your account");
        }
    }

    public void withdrawMoney(double balance){
        if(getBalance() <= 0){
            throw new RuntimeException("Not enough money on your account");
        }

        if ((getBalance() - balance) < 0){
            throw new RuntimeException("Yo can't withdraw that amount of money," + '\'' +
                                        "Current balance: " + getBalance());
        }else {
            this.balance -= balance;
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", DNI='" + DNI + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }


}
