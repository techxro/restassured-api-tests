package steps;

import com.coinmaker.request.GetCurrencyInfo;
import cucumber.api.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CurrencyInfoTest {
    public List<com.coinmaker.models.CurrencyInfo> currencyRes;

    @Given("^I Retrieve the Ethereum Currency with its ID$")
    public void CurrencyInfoTest() {
        Response response = GetCurrencyInfo.getIDofCurrency();
        currencyRes = List.of(GetCurrencyInfo.getIDofCurrency().as(com.coinmaker.models.CurrencyInfo.class));
        JsonPath responseJsonPath = new JsonPath(response.asString());

        String ethereumIdLogo = responseJsonPath.getString("data.1027.logo");
        String dataAdded = responseJsonPath.getString("data.1027.date_added");
        String symbol = responseJsonPath.getString("data.1027.symbol");
        String technicalDoc = responseJsonPath.getString("data.1027.urls.technical_doc[0]");
        String tags= responseJsonPath.getString("data.1027.tags[0]");

        Assert.assertThat(ethereumIdLogo, equalTo("https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png"));
        Assert.assertThat(symbol, equalTo("ETH"));
        Assert.assertThat(dataAdded, equalTo("2015-08-07T00:00:00.000Z"));
        Assert.assertThat(technicalDoc, equalTo("https://github.com/ethereum/wiki/wiki/White-Paper"));
        assertThat(tags, equalTo("mineable"));
    }
}
