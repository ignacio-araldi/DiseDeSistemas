package clasesDelTp;
import java.util.HashSet;
import java.util.Set;

public class Usuario {

	
		private POI miPoi;
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
		
		public Terminal getSistema() {
			return sistema;
		}

		public void setSistema(Terminal sistema) {
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