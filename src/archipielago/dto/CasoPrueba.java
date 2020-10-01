package archipielago.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasoPrueba {
	
	private List<Isla> islas;
	private List<Segmento> segmento;
	private Map<Double, List<Segmento>> segmentosAgrupadosPorLongitud;
	private Map<Double, List<Archipielago>> archipielagosAgrupadosPorLongitud;
	

	public CasoPrueba() {
		super();
		
		this.islas = new ArrayList<>();
		this.segmento = new ArrayList<>();
		this.segmentosAgrupadosPorLongitud = new HashMap<Double, List<Segmento>>();
		this.archipielagosAgrupadosPorLongitud = new HashMap<Double, List<Archipielago>>();
	}

	public List<Isla> getIslas() {
		return islas;
	}

	public void setIslas(List<Isla> islas) {
		this.islas = islas;
	}

	public List<Segmento> getSegmento() {
		return segmento;
	}

	public void setSegmento(List<Segmento> segmento) {
		this.segmento = segmento;
	}

	public Map<Double, List<Segmento>> getSegmentosAgrupadosPorLongitud() {
		return segmentosAgrupadosPorLongitud;
	}

	public void setSegmentosAgrupadosPorLongitud(Map<Double, List<Segmento>> segmentosAgrupadosPorLongitud) {
		this.segmentosAgrupadosPorLongitud = segmentosAgrupadosPorLongitud;
	}

	public Map<Double, List<Archipielago>> getArchipielagosAgrupadosPorLongitud() {
		return archipielagosAgrupadosPorLongitud;
	}

	public void setArchipielagosAgrupadosPorLongitud(Map<Double, List<Archipielago>> archipielagosAgrupadosPorLongitud) {
		this.archipielagosAgrupadosPorLongitud = archipielagosAgrupadosPorLongitud;
	}

	
	
	public long archipielagosValidos() {
		 List<Archipielago> archipielago = new ArrayList<Archipielago>();
		 archipielagosAgrupadosPorLongitud.forEach((k,v) ->{
			archipielago.addAll(v);
	});
		 
return archipielago.stream()
		.filter(Archipielago::isValido)
		.count();
			
	
	}	
	

}
