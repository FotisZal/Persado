package pages;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonGiftCardPAH extends WebComponent {

    public enum Locators{
        Amazon_GiftCards_Design_Standard("css=#gc-customization-type-button-Designs"),
        Amazon_GiftCards_PAH_Thirdimg("css=#gc-mini-picker-design-swatch-image-3"),
        Amazon_GiftCards_PAH_Price("css=span[class='a-color-price a-text-bold']"),
        Amazon_GiftCards_PAH_AddToBasket("css=#gc-buy-box-atc");
        private String myLocator;
        Locators(String locator){
            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }

    }
    public void pressThirdGiftCard() {
        controller().waitForElement(Locators.Amazon_GiftCards_PAH_Thirdimg.get(),3);
        controller().pressAndWaitForPageToLoad(Locators.Amazon_GiftCards_PAH_Thirdimg.get());
    }

    public String getGiftCardPrice() {
        controller().waitForElementPresence(Locators.Amazon_GiftCards_PAH_Price.get(),3);
        return(controller().getText(Locators.Amazon_GiftCards_PAH_Price.get()));
    }

    public void pressStandardDesign() {
        controller().pressAndWaitForPageToLoad(Locators.Amazon_GiftCards_Design_Standard.get());
    }

    public void pressAddToBasket() {
        controller().pressAndWaitForPageToLoad(Locators.Amazon_GiftCards_PAH_AddToBasket.get());
    }

}
