package hanoi;

public class DiskFactory {
	private static int diskNumber = 0;
	
	public static Disk build() {
		return new Disk(++diskNumber);
	}
	
	public static Disk dummyDisk() {
		return new Disk(0);
	}
	
	public static void reset() {
		diskNumber = 0;
	}
}
