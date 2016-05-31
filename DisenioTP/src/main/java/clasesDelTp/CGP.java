package clasesDelTp;

public class CGP extends POI {
	
		public CGP (int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
        } 
		
		public Boolean calculoDeCercania(POI unPoi){
			return (getComuna()==unPoi.getComuna());
		}
		
		
}