package domaine.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
 
public class ToutRecuperer {
 
  public static void main(String[] args) {
	ToutRecuperer app = new ToutRecuperer();
	app.printThemAll();
  }
 
  private void printThemAll() {
 
	Properties prop = new Properties();
	InputStream input = null;
 
	try {
 
		input = new FileInputStream("bin/domaine/properties/config.properties");
		prop.load(input);
 
		System.out.println( "Configuration Mastermind OC" );
		
		Enumeration<?> e = prop.propertyNames();
		
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println( key + " = " + value );
		}
 
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
  }
 
}