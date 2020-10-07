package archipielago.dto;

public class Archipielago {
	
	private Segmento segmento1;
	private Segmento segmento2;
	private boolean valido;
	
	public Archipielago() {
		super();
	}

	public Archipielago(Segmento segmento1, Segmento segmento2) {
		super();
		this.segmento1 = segmento1;
		this.segmento2 = segmento2;
		setValido();
	}

	public Segmento getSegmento1() {
		return segmento1;
	}

	public void setSegmento1(Segmento segmento1) {
		this.segmento1 = segmento1;
	}

	public Segmento getSegmento2() {
		return segmento2;
	}

	public void setSegmento2(Segmento segmento2) {
		this.segmento2 = segmento2;
	}

	

	public boolean isValido() {
		return valido;
	}

	public void setValido() {
		int contador=0;
		if(segmento1.getIsla1()==segmento2.getIsla1()) {
			contador++;
		}
		
		if(segmento1.getIsla1()==segmento2.getIsla2()) {
			contador++;
		}
		
		
		if(segmento1.getIsla2()==segmento2.getIsla1()) {
			contador++;
		}
		
		if(segmento1.getIsla2()==segmento2.getIsla2()) {
			contador++;
		}
		
		valido=contador==1;
		
		
	}

	@Override
	public String toString() {
		return "Archipielago [segmento1=" + segmento1 + ", segmento2=" + segmento2 + ", valido=" + valido + "]";
	}


	
	
	

	

	
	
	
	
	
	

}
