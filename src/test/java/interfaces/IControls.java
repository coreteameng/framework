package interfaces;

public interface IControls {

    void openURL(String url) throws Exception;

    public void clickButtonById(String id) throws Exception;

    public String getTextById(String id) throws Exception;

    public void setTextById(String id, String value) throws Exception;

    public boolean isVisibleById(String id) throws Exception;

    public boolean isSelectedById(String id) throws Exception;

    public void clearTextById(String id) throws Exception;

    public void selectViaVisibleTextById(String id,String value) throws Exception;

    public void selectViaValueTextById(String id, String value) throws Exception;

    public void changeCheckStatusById(String id) throws Exception;


}
