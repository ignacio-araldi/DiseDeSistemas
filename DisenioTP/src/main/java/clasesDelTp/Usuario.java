package clasesDelTp;
import java.util.HashSet;
import java.util.Set;

public class Usuario {

	
		private POI miPoi,POIaBuscar;
		private Terminal sistema;

		public Usuario() {
			sistema=new Terminal();
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
		
		public Terminal getSistema() {
			return sistema;
		}

		public void setSistema(Terminal sistema) {
			this.sistema = sistema;
		}

		public Terminal getsistema() {
			return sistema;
		}

		public void setsistema(Terminal sistema) {
			this.sistema = sistema;
		}


		
		//OTROS METODOS
		
		public Set<POI> buscarPoi(String palabra){  
			Set<POI> poisAux=new HashSet<POI>();
			poisAux.clear();
			for (POI poi:sistema.getPois()){
				if(poi.getPalabrasClaves().contains(palabra))
				{
					poisAux.add(poi);
				}
			}
			return poisAux;
		}
		
		Boolean meQuedaCerca(POI unPoi){
			return miPoi.calculoDeCercania(unPoi);
		}

		Boolean estaDisponible(POI poi){
			return poi.calculoDeDisponibilidad();
		}



	}

//lalala