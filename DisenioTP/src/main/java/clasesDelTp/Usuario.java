package clasesDelTp;

public class Usuario {

	
		private POI miPoi,POIaBuscar;
		private Administrador admin;

		public Usuario() {
			
		}
		
		//GET / SET
		
		public POI obtenerPOI(){
			return miPoi;
		}
		
		public POI getMiPoi() {
			return miPoi;
		}

		public void setMiPoi(POI miPoi) {
			this.miPoi = miPoi;
		}

		public POI getPOIaBuscar() {
			return POIaBuscar;
		}

		public void setPOIaBuscar(POI pOIaBuscar) {
			POIaBuscar = pOIaBuscar;
		}

		public Administrador getAdmin() {
			return admin;
		}

		public void setAdmin(Administrador admin) {
			this.admin = admin;
		}
		
		//OTROS METODOS
	/*	public POI buscarPunto(String palabra){
			admin.resolverBusqueda(palabra);
			return POIaBuscar;
		}*/
		
		Boolean meQuedaCerca(POI unPoi){
			return unPoi.estaDentroDeLaComuna(unPoi);
		}

		Boolean estaDisponible(POI poi){
			return poi.calculoDeDisponibilidad();
		}
		
		Boolean estaDisponible(CGP poi ,String x){ //ACA FALTA LA OTRA OPCION DE DISPONIBILIDAD DE CGP PERO TENGO QUE VER BIEN LO DE LOS SERVICIOS
			if((poi.getServicio()==x)&&(poi.calculoDeDisponibilidad()))
			{
				return true;
			}
			else
				return false;
		}
		
	}

