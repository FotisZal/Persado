package pages;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonGiftCardsPage extends WebComponent {

    public enum Locators{
        Amazon_GiftCards_Type_Pah("css=img[alt='Print at home']");
        private String myLocator;

        Locators(String locator){
            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }

    }

    //------------ Shop By Card Type-----------//

    public void pressPrintAtHomeType(){
        controller().waitForElementPresence(Locators.Amazon_GiftCards_Type_Pah.get(),3);
        controller().press(Locators.Amazon_GiftCards_Type_Pah.get());
    }

}
