package testclass.server;

import com.clean.ults.ReadConfigFile;
import org.aeonbits.owner.ConfigFactory;

public class check {
    public static void main(String[] args) {
        ReadConfigFile readConfigFile = ConfigFactory.create(ReadConfigFile.class);
//        String urlLocalhost=readConfigFile.Scheme()+ readConfigFile.domain()+":";
        System.out.println(readConfigFile.Scheme());
    }
}
