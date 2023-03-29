package hanoi;

public class Disk {
	private int id;
	
	public Disk(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isSmallerThan(Disk b) {
		return id>b.id;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
