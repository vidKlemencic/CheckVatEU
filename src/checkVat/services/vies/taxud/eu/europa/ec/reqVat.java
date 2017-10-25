package checkVat.services.vies.taxud.eu.europa.ec;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.holders.DateHolder;

public class reqVat {

	public static void main(String[] args) {
		
		StringHolder countryCode = new StringHolder();
		StringHolder vatNumber = new StringHolder();
		
		DateHolder requestDate = new DateHolder();
		BooleanHolder valid = new BooleanHolder();
		StringHolder name = new StringHolder();
		StringHolder address = new StringHolder();
		
		if(args.length < 2)
		{
			System.out.println("Not enough arguments! You need atleast 2");
		}
		else
		{
			countryCode.value = args[0].toString();
			vatNumber.value=args[1].toString();
			
			CheckVatServiceLocator serviceLocator = new CheckVatServiceLocator();
			try {
				CheckVatPortType req = serviceLocator.getcheckVatPort();
				try {
					req.checkVat(countryCode, vatNumber, requestDate, valid, name, address);
					System.out.println("Data for that VAT NUMBER:");
					System.out.println("Country code: " + countryCode.value);
					System.out.println("Request date: " + requestDate.value);
					System.out.println("VAT number: " + vatNumber.value);
					System.out.println("Valid: " + valid.value);
					System.out.println("addres: " + address.value);
					System.out.println(address.value);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
