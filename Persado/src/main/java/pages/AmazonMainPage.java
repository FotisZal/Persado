package pages;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;
public class AmazonMainPage extends WebComponent{

    public enum Locators{
        Amazon_Main_ChangeDeliveryAddr("xpath=//input[@data-action-type='DISMISS']"),
        Amazon_Main_NavBar_GiftCards("xpath=//a[contains(text(),'Gift Cards')]");
        private String myLocator;

        Locators(String locator){
            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }

    }

    //--------Nav Bar--------//
    public void GiftCardNavBar(){
        if(controller().isComponentVisible(Locators.Amazon_Main_ChangeDeliveryAddr.get(),2)){
            controller().press(Locators.Amazon_Main_ChangeDeliveryAddr.get());
        }
        controller().waitForElement(Locators.Amazon_Main_NavBar_GiftCards.get(),2);
        controller().press(Locators.Amazon_Main_NavBar_GiftCards.get());
    }

}

