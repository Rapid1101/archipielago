package archipielago.dto;

public class Segmento {

	private Isla isla1;
	private Isla isla2;
	
	private double longitud;
	
	public Segmento(Isla isla1, Isla isla2) {
		super();
		this.isla1 = isla1;
		this.isla2 = isla2;
		setLongitud();
	}
	public Isla getIsla1() {
		return isla1;
	}
	public void setIsla1(Isla isla1) {
		this.isla1 = isla1;
	}
	public Isla getIsla2() {
		return isla2;
	}
	public void setIsla2(Isla isla2) {
		this.isla2 = isla2;
	}
	@Override
	public String toString() {
		return "Segmento [isla1=" + isla1 + ", isla2=" + isla2 + "]";
	}
	public double getLongitud() {
		return longitud;
	}
	
	private void setLongitud() {
		longitud=Math.sqrt(Math.pow((isla1.getX()-isla2.getX()), 2) + Math.pow((isla1.getY()-isla2.getY()), 2));
		
	}
	
	
	
	
	
	
}
