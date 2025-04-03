package extra;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class Demo4 {

	@Test
	public void DateTime() {
		Date dObj = new Date();
		System.out.println(dObj);
		
//		yyyy - 2020 , MM - 11 , dd - 08
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss_yyyy-MM-dd");
		String date = sdf.format(dObj);
		System.out.println(date);
	}
}
