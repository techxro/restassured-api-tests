package steps;

import com.coinmaker.models.Currency;
import com.coinmaker.models.CurrencyInfo;
import com.coinmaker.request.GetCurrency;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import java.util.List;

import static com.coinmaker.api.Constants.etherumId;
import static com.coinmaker.api.Constants.usdTetherId;

public class RetrieveCurrencyTest {

    public static Integer amount = 120;
    public static final String symbol = "BOLI";
    private Response response;


    @Given("^I retrieve id of all currencies$")
    public void getCurrencyList() {
        Response response = GetCurrency.listAllCurrency();
        List<Currency> currencyInfoList = List.of(GetCurrency.listAllCurrency().as(Currency.class));
        etherumId = response.path("data.find { it.symbol == 'ETH' }.id");
        usdTetherId = response.path("data.find { it.symbol == 'USDT' }.id");
        Integer bitcoinId = response.path("data.find { it.symbol == 'BTC' }.id");
    }

    @Then("^I convert them to Bolivarcoin$")
    public void convertToBolivarcoin() {
        response = GetCurrency.convertCurrency(etherumId, amount, symbol);
        response = GetCurrency.convertCurrency(usdTetherId, amount, symbol);
        response = GetCurrency.convertCurrency(usdTetherId, amount, symbol);

    }


    @Given("^I retrieve first ten currencies$")
    public void getFirstTenCurrencies() {
        response = GetCurrency.getFirstTenCurrencies();
        List<CurrencyInfo> currencyInfoList = List.of(GetCurrency.getFirstTenCurrencies().as(CurrencyInfo.class));
    }

    @Then("^I verify that mineable exists in response$")
    public void verifyThatMineableExistsInResponse() {
        String currencyTag = response.path("data.find { it.tags == 'mineable' }");
        System.out.println(currencyTag);
    }
}
