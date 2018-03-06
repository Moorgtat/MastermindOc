package domaine.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

	public class ChargerConfiguration {
		
		public static void main(String[] args) {

			Properties prop = new Properties();
			InputStream input = null;

			try {

				input = new FileInputStream("bin/domaine/properties/config.properties");

				// load a properties file
				prop.load(input);

				// get the property value and print it out
				System.out.println(prop.getProperty("NUM_TOTAL_CHIFF"));
				System.out.println(prop.getProperty("MAX_CHIFF"));
				System.out.println(prop.getProperty("MAX_ESSAIS"));

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