package psd;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;
public class AmazonGeneralActions extends WebComponent {

    public enum Locators{
        Amazon_GoToBasket("xpath=//span[normalize-space()='Cart']"),
        Amazon_ItemPriceCart("xpath=//p[@class='a-spacing-mini']/span");
        private String myLocator;

        Locators(String locator){
            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }

    }

    public void refreshPage(){
        controller().refresh();
    }

    public void goToBasket(){
        controller().waitForElementPresence(Locators.Amazon_GoToBasket.get(),3);
        controller().press(Locators.Amazon_GoToBasket.get());
    }

    public String getPriceCart() {
        controller().waitForElementPresence(Locators.Amazon_ItemPriceCart.get(),3);
        return(controller().getText(Locators.Amazon_ItemPriceCart.get()));
    }

    public String replaceNewLineDot(String text) {
        if(text.contains("\n")){
            text = text.replaceAll("[\\n\\r]", ".");
        }
        return text;
    }

    public synchronized void waitDynamicElement(int time) throws InterruptedException {
        synchronized (controller()){
            controller().wait(time);
        }
    }

}
