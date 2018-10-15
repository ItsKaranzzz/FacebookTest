package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import base.BaseClass;

public class Utils extends BaseClass {

	public static Properties propertyReader() throws IOException {

		oProp = new Properties();

		FileInputStream fpropReader = new FileInputStream(new File(
				"E:\\Program Files\\Workspace_0.2\\Assignment1-master\\Assignment1-master\\src\\main\\java\\config\\configurations.properties"));
		oProp.load(fpropReader);

		return oProp;
	}
}
