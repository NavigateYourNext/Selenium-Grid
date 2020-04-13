import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


//1. Open CMD and goto the folder where you kept Selenium Standalone file and enter command as java -jar selenium-server-standalone-3.141.59.jar -role hub (To register as hub)
//2. Open CMD and goto the folder where you kept Selenium Standalone file and enter commadn as java -Dwebdriver.chrome.driver="D:\ChromeDriver\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.176:4444/grid/register (To register as node)
//3. Check Hub Path & Node Path accordingly. It may change.
//3. Write below code as a sample and run it.

public class SeleniumGrid {

	public static void main(String[] args)throws Exception {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		ChromeOptions opt = new ChromeOptions();
		opt.merge(cap);
		
		String hub = "http://192.168.0.176:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(hub),cap);
		
		driver.get("https://google.com");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
