package archipielago.dto;

public class Isla {
	
	
	private int x;
	private int y;
	
	public Isla() {
		super();
	}

	public Isla(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Isla [x=" + x + ", y=" + y + "]";
	}


	

	
	
	
	
	
}
