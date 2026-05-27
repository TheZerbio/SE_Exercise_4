package org.campuscoffee.steps;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import jdk.javadoc.doclet.Taglet;
import org.campuscoffee.CoffeStore;
import org.campuscoffee.Search;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchSteps {
    Search search = new Search();
    CoffeStore output;

    @ParameterType("true|false")
    public Boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }

    @Before
    public void before() {
         search = new Search();
         output = null;
     }

    @Given("there are no registered CoffeShops")
    public void there_are_no_registered_CoffeShops() {
        search.clearStores();
        assertTrue(search.getAllStores().isEmpty());
    }
    @When("a CoffeShop with Name {string},Location {string} and returnpoint {booleanValue} and {string} Price {int} is added to the System")
    public void add_store_with_price(final String name, final String location, final boolean reuse, final String coffetype, final int price) {
        CoffeStore cs = new CoffeStore(name, org.campuscoffee.Location.valueOf(location.toUpperCase()),reuse);
        cs.setPrice(coffetype, price);
        search.addStore(cs);
    }
    @When("the price for {string} gets compared for {string} and {string}")
    public void comparePrices(final String coffetype, final String name1, final String name2) {
        output = search.compareByPrice(name1,name2,coffetype);
    }
    @Then("the System should show {string} as the one with cheaper coffee")
    public void checkOutput(final String storeName) {
        assertEquals(output.getName(), storeName);
    }

    @Then("it's name should be {string}")
    public void itSNameShouldBe(String name) {
        boolean storeExists = false;
        var stores = search.getAllStores();
        for(var store : stores){
            if (store.getName().equals(name)){
                storeExists = true;
                break;
            }
        }
        assertTrue(storeExists);
    }

    @Then("there should only be {int} registered CoffeShop")
    public void thereShouldOnlyBeRegisteredCoffeShop(int length) {
        assertEquals(search.getAllStores().size(), length);
    }
}
