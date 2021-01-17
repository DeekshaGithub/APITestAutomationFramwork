package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.location;

public class TestDataBuild {
	
	

	public AddPlace addPlacePayload(String name, String language, String address) {
		// TODO Auto-generated method stub
		AddPlace ap= new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setPhone_number("937265445");
		ap.setName(name);
		ap.setWebsite("https://rahulsheetyacademy.com");
		
		List<String> myList= new ArrayList<String>();
		myList.add("Shoe Park");
		myList.add("shop");
		ap.setTypes(myList);
		
		location l= new location();
		l.setLat(-44.88778);
		l.setLng(33.7647);
		ap.setLocation(l);
		
		return ap;
	}
	
	public deletePlacePayload(String placeId)
	{
		return "{\r\n  \"place_id\" : \"+placeId" "+ndhghsfheguruhc+\ "\r\n}";
	}

}
