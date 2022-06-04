package psd;

import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AmazonMainPage;
import pages.AmazonGiftCardsPage;
import pages.AmazonGiftCardPAH;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class AmazonGiftCardToBasket extends SteviaTestBase {

    @BeforeSuite
    public void insertSystemBrowser() throws URISyntaxException {
        URL res = getClass().getResource("/drivers/chromedriver.exe");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
    }
    @Autowired
    protected AmazonMainPage amazonMainPage;
    @Autowired
    protected AmazonGiftCardsPage amazonGiftCardsPage;
    @Autowired
    protected AmazonGeneralActions amazonGeneralActions;
    @Autowired
    protected AmazonGiftCardPAH amazonGiftCardPAH;

    @Test
    public void giftCardToBasket() throws InterruptedException {
        try{
            amazonMainPage.GiftCardNavBar();
        }catch (TimeoutException e){ // Different landing page (probably A/B testing)
            amazonGeneralActions.refreshPage();
            amazonMainPage.GiftCardNavBar();
        }
        amazonGiftCardsPage.pressPrintAtHomeType();
        amazonGiftCardPAH.pressStandardDesign();
        amazonGeneralActions.waitDynamicElement(2000);
        try{
            amazonGiftCardPAH.pressThirdGiftCard();
        } catch(StaleElementReferenceException staleElementReferenceException){ // Dynamic Element
            amazonGiftCardPAH.pressThirdGiftCard();
        }
        String card_price = amazonGiftCardPAH.getGiftCardPrice();
        amazonGiftCardPAH.pressAddToBasket();
        amazonGeneralActions.goToBasket();
        String checkout_card_price = amazonGeneralActions.getPriceCart();
        checkout_card_price = amazonGeneralActions.replaceNewLineDot(checkout_card_price);
        Assert.assertEquals(card_price,checkout_card_price);
    }
}
