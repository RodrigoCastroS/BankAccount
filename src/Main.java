import Model.Account;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        ArrayList <Account> accounts = new ArrayList<>();

        createAccount(accounts, "17834099E", "Rodrigo", "Castro");
        createAccount(accounts, "17834099E", "Rodrigo", "Castro");
        createAccount(accounts, "2389044DJ", "Jose", "Lopez");
        createAccount(accounts, "78302343B", "Mariana", "Burgundy");
        createAccount(accounts, "17774098N", "Florencia", "Fernandez");


     /* Account{IBAN='40334.0', DNI='17834099E', name='Rodrigo', surname='Castro', balance=0.0}
        Account{IBAN='39618.0', DNI='17834099E', name='Rodrigo', surname='Castro', balance=0.0}
        Account{IBAN='60870.0', DNI='2389044DJ', name='Jose', surname='Lopez', balance=0.0}
        Account{IBAN='55668.0', DNI='78302343B', name='Mariana', surname='Burgundy', balance=0.0}
        Account{IBAN='43652.0', DNI='17774098N', name='Florencia', surname='Fernandez', balance=0.0}*/

        Account accountToFind = accounts.get(1);
        Account accountToTest = accounts.get(0);

//        System.out.println(findAccountByIBAN(accounts, accountToFind.getIBAN()));
        System.out.println("Antes de ingresar");
        System.out.println(findAccountByIBAN(accounts, accountToTest.getIBAN()).getBalance());

        depositMoney(accounts, accountToTest.getIBAN(),2350.00);
        System.out.println("Despues de ingresar");
        System.out.println(findAccountByIBAN(accounts, accountToTest.getIBAN()).getBalance());

        System.out.println("Despues de retirar");
        withdrawMoney(accounts, accountToTest.getIBAN(),300.00);
        System.out.println(findAccountByIBAN(accounts, accountToTest.getIBAN()).getBalance());

        System.out.println("Despues de retirar");
        withdrawMoney(accounts, accountToTest.getIBAN(),500.00);
        System.out.println(findAccountByIBAN(accounts, accountToTest.getIBAN()).getBalance());

        depositMoney(accounts, accountToTest.getIBAN(),334350);
        System.out.println("Despues de ingresar");
        System.out.println(findAccountByIBAN(accounts, accountToTest.getIBAN()).getBalance());

    }

    public static void createAccount (ArrayList<Account> accounts, String DNI, String name, String surname){
            accounts.add(new Account(DNI,name,surname));
    }

    public static Account findAccountByIBAN(ArrayList<Account> accounts, String IBAN ) {
        Account accountFound = null;
        for (Account account : accounts){

            String nuevo = new String(IBAN);

            if(account.getIBAN().equals(nuevo)){
                accountFound = account;
            }
        }

        return accountFound;
    }

    public static List<Account> findAccountsByDNI(ArrayList<Account> bankAccounts, String DNI){
        List<Account> userAccountsFound = new ArrayList<>();

        for (Account currentAccount : bankAccounts){
            if(currentAccount.getDNI().equals(DNI)){
                userAccountsFound.add(currentAccount);
            }
        }

        return userAccountsFound;
    }

    public static void depositMoney(ArrayList<Account> bankAccounts, String IBAN, double amount){
        findAccountByIBAN(bankAccounts, IBAN).depositMoney(amount);
    }

    public static void withdrawMoney(ArrayList<Account> bankAccounts, String IBAN, double withdrawAmount){
        Account account = findAccountByIBAN(bankAccounts, IBAN);
        account.withdrawMoney(withdrawAmount);

    }

    public static void transferBetweenAccounts(ArrayList<Account> bankAccounts, String accountOriginNumber,
                                               String accountDestination, double amount){
        findAccountByIBAN(bankAccounts, accountOriginNumber).withdrawMoney(amount);
        findAccountByIBAN(bankAccounts, accountDestination).depositMoney(amount);

    }
}
