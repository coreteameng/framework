package interfaces;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.ExecutionException;

public interface IDriver {


    public WebDriver getBrowser() throws  Exception;

    public void openBrowser(String url) throws Exception;

    public void closeBrowser() throws Exception;

    public void closeAllBrowser() throws ExecutionException;

    public String getTitle() throws Exception;

    public String getPageSource() throws Exception;

    public String getCurrentUrl() throws Exception;

    public void navigateTo(String url) throws Exception;

    public void navigateRefresh() throws Exception;

    public void navigateForward() throws Exception;

    public void navigateBack() throws Exception;
}
