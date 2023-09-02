package Utils;

import java.util.Date;
import java.util.Random;

public class JavaUtils {

	
	/**
	 * The method is use to generate Random Numbers
	 */
		public int randomNumber() {
			Random r=new Random();
			int x= r.nextInt(1000);
			return x;
		}
		
		/**
		 *The method is use to generate the current date 
		 */
		public String currentDate() {
			Date da= new Date();
			String date= da.toString();
			return date;
		}
		
		/**
		 * The method is use to generate the current date in format of date:month:year
		 */
		
		public String formatedDate() {
			Date da=new Date();
			
			String[] splitformat= da.toString().split(" ");
			
			String formatdate= splitformat[2]+"-"+splitformat[1]+"-"+splitformat[5];
			
			return formatdate;
			
		}
		
		/**
		 * This method will give current the formated date and time 
		 */
		public String formatedDateTime() {
			
			Date da=new Date();
			
		String[] dateTime=	da.toString().split(" ");
		
		String dateTime1=dateTime[2]+"-"+dateTime[1]+"-"+dateTime[3];
		
		return dateTime1;
		
		}
}
