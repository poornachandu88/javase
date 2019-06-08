package foldersandfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetRequiredDateBetweenDates {

	public static void main(String[] args) throws ParseException {
		
		String startdate="06/11/2018 06:30:43";
		String enddate="06/11/2018 18:33:43";
		String requireddate="06/11/2018 14:27:58";
		
	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	
	Date sDate=sdf.parse(startdate);
	Date eDate=sdf.parse(enddate);
	Date date=sdf.parse(requireddate);
	
	if(date.compareTo(sDate)>=0 && date.compareTo(eDate)<=0)
	{
		
		System.out.println("required date is with "+requireddate +"");
	}
	else
	{
		System.out.println("date is outof range");
	}
	
	}
	
}
