package clasesDelTp;
import java.util.Set;

public class Usuario {

	
		private POI miPoi,POIaBuscar;
		private Sistema buscador;

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

		
		//OTROS METODOS
		
	 	public Set<POI> buscarPunto(String texto){
	 		return buscador.buscarPoi(texto);
		}
		
		Boolean meQuedaCerca(POI unPoi){
			return miPoi.calculoDeCercania(unPoi);
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

//lalala