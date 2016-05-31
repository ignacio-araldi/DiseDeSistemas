package clasesDelTp;

public class CGP extends POI {
	
	private String servicio;
	
		public CGP (int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
        } 
		
		public String getServicio() {
			return servicio;
		}

		public void setServicio(String servicio) {
			this.servicio = servicio;
		}
		
		// repeticion del metodo calculoDeCercania 
		
		
	    public Boolean estaDentroDeLaComuna(POI unPoi){
				return (elNroDeLaComunaIngresadaCoincideConElDeLaComunaDelPOI(unPoi.getComuna())) & (super.estaDentroDeLaComuna(unPoi));
			}
	    

		
}