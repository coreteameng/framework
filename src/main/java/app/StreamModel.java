package app;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class StreamModel {


    public StreamModel() {

    }

    public void getFile() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://npm.taobao.org/mirrors/chromedriver/77.0.3865.40/chromedriver_win32.zip").openStream());
             FileOutputStream fileOS = new FileOutputStream("C:/Users/ASUS/.m2/repository/webdriver/chromedriver_win32.zip")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            // handles IO exceptions
        }
    }

}
