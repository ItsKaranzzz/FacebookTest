package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import base.BaseClass;

public class Utils extends BaseClass {

	public static final String CONFIG_FILE_PATH = "C:\\\\Users\\\\kxc212\\\\Downloads\\\\FacebookTest-master\\\\Assignment1-master\\\\src\\\\main\\\\java\\\\config\\\\configurations.properties";

	public static Properties propertyReader() throws IOException {

		oProp = new Properties();

		FileInputStream fpropReader = new FileInputStream(new File(CONFIG_FILE_PATH));
		oProp.load(fpropReader);

		return oProp;
	}
}
