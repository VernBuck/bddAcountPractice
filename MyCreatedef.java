package Steps;

import com.company.Account;
import com.company.Main;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MyCreatedef {

    @When("^I decide on the amount of money I want to place$")
    public void iDecideOnTheAmountOfMoneyIWantToPlace() {
        System.out.println("Testing $200 account creation");
        Account[] accTest = Main.createAccount(200);
        int testValue = accTest[0].getBalance();
        assertEquals(200, testValue);
    }

    @Then("^The account I created should have the set amount of money$")
    public void theAccountICreatedShouldHaveTheSetAmountOfMoney() {
        System.out.println("Testing $100 account creation");
        Account[] accTest = Main.createAccount(100);
        int testValue = accTest[0].getBalance();
        assertEquals(100, testValue);
    }

    @Given("^That I want to create an account$")
    public void thatIWantToCreateAnAccount() {
        System.out.println("Testing $300 account creation");
        Account[] accTest = Main.createAccount(300);
        int testValue = accTest[0].getBalance();
        assertEquals(300, testValue);
    }

    @Given("^That account exists$")
    public void thatAccountExists() {
        System.out.println("Testing $7000 account creation");
        Account[] accTest = Main.createAccount(7000);
        int testValue = accTest[0].getBalance();
        assertEquals(7000, testValue);
    }

    @When("^I choose to add money$")
    public void iChooseToAddMoney() {
        Account[] accTest = Main.createAccount(45);
        Main.optionsTest("deposit", accTest);
    }

    @Then("^My account's value is increased by that amount$")
    public void myAccountSValueIsIncreasedByThatAmount() {
        System.out.println("This is testing the adding of 500 dollars to a 7000 dollar account");
        Account[] accTest = Main.createAccount(7000);
        Account[] xTest = Main.deposit(accTest, 500);
        assertEquals(7500, xTest[0].getBalance());
    }

    @When("^I choose to remove money$")
    public void iChooseToRemoveMoney() {
        Account[] accTest = Main.createAccount(65);
        Main.optionsTest("withdraw", accTest);
    }

    @Then("^My account's value is decreased by that amount$")
    public void myAccountSValueIsDecreasedByThatAmount() {
        System.out.println("This is testing the removing of 75 dollars from  a 4000 dollar account");
        Account[] accTest = Main.createAccount(4000);
        Account[] xTest = Main.withdraw(accTest, 75);
        assertEquals(3925, xTest[0].getBalance());
    }

    @Then("^I should have two accounts$")
    public void iShouldHaveTwoAccounts() {
        System.out.println("This is testing the cloning of a 300 dollar account");
        Account[] accTest = Main.createAccount(300);
        String xTest = Main.clone(accTest);
        assertEquals("[149] [150]", xTest);
    }

    @When("^I choose to clone my account$")
    public void iChooseToCloneMyAccount() {
        System.out.println("This method must work for cloning");
    }

    @Given("^That account exists with \\$(\\d+)$")
    public void thatAccountExistsWith$(int arg0) {
        System.out.println("Testing $400 account creation");
        Account[] accTest = Main.createAccount(arg0);
        System.out.println(accTest[0].getBalance());
    }

    @Given("^that account exists with hidden money exists$")
    public void thatAccountExistsWithHiddenMoneyExists() {
        System.out.println("Testing 8 account creation");
        Account[] accTest = Main.createAccount(8);
        System.out.println(accTest[0].getBalance());
    }
}
