package clasesDelTp;

public class CGP extends POI {
	
	private String servicio;
	
		public CGP (int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
        } 
		
		public Boolean calculoDeCercania(POI unPoi){
			return (estaDentroDeComuna(unPoi.getComuna()));
		}
		
		public String getServicio() {
			return servicio;
		}

		public void setServicio(String servicio) {
			this.servicio = servicio;
		}
		
		public Boolean calculoDeCercania(POI unPoi){
			return (comuna=unPoi.getComuna());
		}
		
		
}