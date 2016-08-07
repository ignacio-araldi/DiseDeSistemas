package clasesDelTp;

public class Kiosco extends LocalComercial{

    public Kiosco (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC); 
	    setRadioLimite(2);
	}
    public Kiosco () {
    	super();
	}

}