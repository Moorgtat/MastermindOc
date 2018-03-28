package domaine.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

	public class ChargerConfiguration {

			Properties prop = new Properties();
			InputStream input = null;
			
			public ChargerConfiguration() {	
				
				try {
					input = new FileInputStream("bin/domaine/properties/config.properties");
					prop.load(input);

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
				
			public Properties getProp() {
				return prop;
			 }
			
			public void setProp(Properties prop) {
				this.prop = prop;
			 }
			
			public int getPropNumTotal() {		
			return Integer.parseInt(prop.getProperty("NUM_TOTAL_CHIFF"));
			 }
			
			public int getPropMaxChiff() {
			return Integer.parseInt(prop.getProperty("MAX_CHIFF"));
			 }	
			
			public int getPropMaxEssai() {
			return Integer.parseInt(prop.getProperty("MAX_ESSAIS"));
			 }				
	}
	
		
		