package hanoi;

import java.util.Arrays;
import java.util.Stack;

public class Hanoi {
	private Stack<Disk> sourceTower;
	private Stack<Disk> auxiliaryTower;
	private Stack<Disk> destinationTower;
	private int disks;
	private int actualMove;
	
	public Hanoi() {
		sourceTower = new Stack<Disk>();
		auxiliaryTower = new Stack<Disk>();
		destinationTower = new Stack<Disk>();
		reset(3);
	}
	
	public void reset(int disks) {
		this.disks = disks;
		actualMove = 1;
		DiskFactory.reset();
		buildTowers();
		inizializeSourceTower();
	}
	
	private void buildTowers() {
		sourceTower.clear();
		sourceTower.push(DiskFactory.dummyDisk());
		auxiliaryTower.clear();
		auxiliaryTower.push(DiskFactory.dummyDisk());
		destinationTower.clear();
		destinationTower.push(DiskFactory.dummyDisk());
	}
	
	private void inizializeSourceTower() {
		for(int i=0;i<disks;i++) {
			sourceTower.push(DiskFactory.build());
		}
	}
	
	public int totalMoves() {
		return (int) Math.pow(2, disks)-1;
	}
	
	public boolean hasMoves() {
		return actualMove <= totalMoves();
	}
	
	public int nextMove() {
		if(actualMove % 3 == 1) {
			//move S <-> D
			move(sourceTower, (disks%2 != 0)? destinationTower : auxiliaryTower);
		}else if(actualMove % 3 == 2) {
			//move S <-> A
			move(sourceTower, (disks%2 != 0)? auxiliaryTower : destinationTower);
		} else {
			//move D <-> A
			move(destinationTower, auxiliaryTower);
		}
		
		return actualMove++;
	}
	
	private void move(Stack<Disk> stackA, Stack<Disk> stackB) {
		if(stackA.peek().isSmallerThan(stackB.peek())) {
			stackB.push(stackA.pop());
		} else {
			stackA.push(stackB.pop());
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("S: " + Arrays.toString(sourceTower.toArray()));
		sb.append(System.lineSeparator());
		sb.append("A: " + Arrays.toString(auxiliaryTower.toArray()));
		sb.append(System.lineSeparator());
		sb.append("B: " + Arrays.toString(destinationTower.toArray()));
		sb.append(System.lineSeparator());
		return sb.toString();
	}
}
