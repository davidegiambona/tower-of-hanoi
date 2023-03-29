package hanoi;

import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Hanoi hanoi = new Hanoi();
		
		System.out.print("Numero dischi: ");
		hanoi.reset(scan.nextInt());
		System.out.println(hanoi);
		
		System.out.println("Total moves: " + hanoi.totalMoves());
		System.out.println("Do you wish to proceed? [y/n]: ");
		if(scan.next().toCharArray()[0] == 'y') {
			while(hanoi.hasMoves()) {
				hanoi.nextMove();
			System.out.println(hanoi);
			}
		}
		
		System.out.println("Bye.");
	}

}
