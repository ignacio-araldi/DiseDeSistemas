package clasesDelTp;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Contexto {
	
	
	private static Object otro;

	public static void main(String[] args)
	{
		Scanner capt= new Scanner(System.in);
		POI miPoi = new POI();
		POI otroPoi = new POI();
		Kiosco unKiosco = new Kiosco();
		Usuario yo = new Usuario();
		
		yo.setMiPoi(miPoi);
	
		//miPoi.establecerAltura(capt.nextInt());
		
		System.out.println(yo.meQuedaCerca(unKiosco));
	}

}
