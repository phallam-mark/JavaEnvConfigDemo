package envConfigDemo;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"classpath:${env}.properties" // will get env name passed by testng.xml suite
	//"classpath:work-windows-config.properties" // reference the property file name
	//"classpath:home-mac-config.properties"
})
public interface Environment extends Config {

    String appurl();
    String chromeDriverLocation();
    
}