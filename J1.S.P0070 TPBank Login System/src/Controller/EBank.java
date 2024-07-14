/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GetInput;
import Model.Account;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class EBank {

    public static void loginWithVietNamese() {
        Locale locale = new Locale("vn");//Đại diện vùng ngôn ngữ, tại sao: đề bài yêu cầu
        setLocale(locale);
    }

    public static void loginWithEnglish() {
        Locale locale = new Locale("en");
        setLocale(locale);
    }

    public static void setLocale(Locale locale) {
        loiginSystem(locale);
    }

private static void loiginSystem(Locale locale) {
    ResourceBundle bundle = ResourceBundle.getBundle("Resources.lang", locale);
    //tải tài nguyên từ file properties,
    //Resources.lang sẽ đọc những file properties trong packet resources vì nó có chữ lang
    //locale là ngôn ngữ e chọn 
    GetInput getInput = new GetInput(); //nhập dữ liệu người dùng
    String accountNumber = getInput.getString(bundle.getString("Account"), bundle.getString("AccountError"), bundle.getString("AccountEmpty"), "[0-9]{10,}");
    String password = getInput.getPassword(bundle.getString("Password"), bundle.getString("PasswordEmpty"), bundle.getString("PasswordError"));
    //bundle để đọc thông điệp trong file properties
    String userEnterCaptcha;
    
    while (true) {
        String captcha = generateCaptcha();
        System.out.println(bundle.getString("Captcha") + captcha);
        userEnterCaptcha = getInput.getString(bundle.getString("CaptchaEnter"), "", bundle.getString("CaptchaEmpty"), "");
        // Loop until checking if user enters a correct captcha
        if (userEnterCaptcha.equals(captcha)) {
            break;
        }
        System.out.println(bundle.getString("CaptchaWrong"));
    }

    boolean accountExists = checkAccountNumber(accountNumber);
    boolean passwordCorrect = checkPassword(accountNumber, password);

    // Check if accountNumber and password of accountNumber exist in the list of accounts
    if (accountExists && passwordCorrect) {
        System.out.println(bundle.getString("LoginSuccess"));
    } else {
        System.out.println(bundle.getString("LoginFail"));

        // If account does not exist, add it to the list
        if (!accountExists) {
            addNewAccount(accountNumber, password);
            System.out.println(bundle.getString("AccountAdded"));
        }

        // Prompt for login again after adding the account
        loiginSystem(locale);
    }
}

private static void addNewAccount(String accountNumber, String password) {
    accountList.add(new Account(accountNumber, password));
}



    //Check account number is
    public static boolean checkAccountNumber(String accountNumber) {
        ArrayList<Account> accountList = listAccount();
        //check list account has empty or not
        if (accountList.isEmpty()) {
            return false;
        } else {
            //Traverso to first element of array to last element 
            for (Account account : accountList) {
                //check account user enter is exit or not
                if (account.getAccountNumber().equals(accountNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkPassword(String accountNumber, String password) {
        ArrayList<Account> accountList = listAccount();
        //check list account has empty or not
        if (accountList.isEmpty()) {
            return false;
        } else {
            //Traverso to first element of array to last element 
            for (Account account : accountList) {
                /*check account and password user enter same account 
              and passsword in list accont or not
                 */
                if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String generateCaptcha() {
        Random random = new Random();
        String captcha = "";
        String numberCharacter = "0123456789";
        char character = 'A';
        for (int i = 0; i < 26; i++) {
            numberCharacter += Character.toString(character).toLowerCase() + character;
            character += 1;
        }
        do {
            for (int i = 0; i < 5; i++) {
                int indexCharacter = random.nextInt(numberCharacter.length());
                captcha += numberCharacter.charAt(indexCharacter);
            }
            if (captcha.length() == 5) {
                break;
            }
        } while (true);
        return captcha;
    }

private static ArrayList<Account> accountList = new ArrayList<>();

public static ArrayList<Account> listAccount() {
    return accountList;
}


}
