import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import bean.weatherBean;

import weather.weatherGet;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        weatherGet weather = new weatherGet();
         
        List<weatherBean> lwb = new ArrayList<weatherBean>();
        
        try {
			lwb = weather.weatherOf("el tarf");
			
			for(weatherBean wf:lwb){
				
				 System.out.println(wf.getFrom());
				 System.out.println(wf.getTemperature());
		         System.out.println(wf.getCielClaire());
		         System.out.println(wf.getPression());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
