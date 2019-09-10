package helpers;

import java.util.Arrays;

import enums.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static enums.Browser.CHROME;

public class BrowserHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserHelper.class);

    public static Browser validateBrowser(Browser browser) {
        for (Browser browserType : Browser.values()) {
            if (browser == browserType) {
                return browserType;
            }
        }

        LOGGER.info(
                "Invalid value passed as desired browser. One of: "
                        + Arrays.toString(Browser.values())
                        + " is expected. Defaulting to "
                        + CHROME.toString()
                        + ".");

        return CHROME;
    }
}
