package clasesDelTp;

public class CGP extends POI {
	
	private String zonas,director,domicilio,servicios;
	private int telefono,id;
	

		public CGP (int horaA, int horaC, int diaA, int diaC) {
			super();
    		setDisponibilidadHoraria(horaA,horaC,diaA, diaC);
    		tipoCercania=new MismaComuna();

        }


		public String getZonas() {
			return zonas;
		}


		public void setZonas(String zonas) {
			this.zonas = zonas;
    		super.getPalabrasClaves().add(zonas);
		}


		public String getDirector() {
			return director;
		}


		public void setDirector(String director) {
			this.director = director;
		}


		public String getDomicilio() {
			return domicilio;
		}


		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
    		super.getPalabrasClaves().add(domicilio);
		}


		public int getTelefono() {
			return telefono;
		}


		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public void listar()
		{
	         System.out.println("ID     Comuna   Zonas                                   Director                      Domicilio                     Telefono    Servicios\n");

	            System.out.println(id+"      "+super.getUbicacion().getComuna()+"        "+director+""+domicilio+""+telefono+""+servicios);

	         
		}
		
}