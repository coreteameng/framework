package helpers;

import enums.Browser;
import interfaces.IOS;
import models.*;

public class OSFactory {
    public IOS getInstance(Browser browser) {
        if (browser == Browser.FIREFOX) {
            return new FirefoxModel();
        } else if (browser == Browser.CHROME) {
            return new ChromeModel();
        } else if (browser == Browser.EDGE) {
            return new EdgeModel();
        } else if (browser == Browser.IEXPLORE) {
            return new IExploreModel();
        } else if (browser == Browser.OPERA) {
            return new OperaModel();
        } else if (browser == Browser.SAFARI) {
            return new SafariModel();
        } else {
            return null;
        }
    }

}
