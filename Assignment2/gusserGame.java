
import java.util.Scanner;

class guesser{
	int guessNum;
	
	int guessNumber() {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Number From Gusser:");
		guessNum=scan.nextInt();
		
		return guessNum;
	}
}

class Player{
	int pguessNum;
	int coin;
	Scanner scan=new Scanner(System.in);
	
	int guessNumber(int p){
		System.out.println("Player"+p+" Guess number:");
		pguessNum=scan.nextInt();
		return pguessNum;
	}
	
	int buycoin() {
		System.out.println("Coined you bought(coins>0):");
		coin=scan.nextInt();
		return coin;
	}
}


class Umpire{
	int numFromGusser,numFromPlayer1,numFromPlayer2,numFromPlayer3;
	int p1_coin,p2_coin,p3_coin;
	
	Player p1=new Player();
	Player p2=new Player();
	Player p3=new Player();
	
	
	void collectNumFromGusser(){
		guesser g=new guesser();
		numFromGusser=g.guessNumber();		
	}
	
	
	//buying coins function
	void getCoins() {
		System.out.print(">>>>Player1 ");
		p1_coin=p1.buycoin();
		
		System.out.print(">>>>Player2 ");
		p2_coin=p2.buycoin();
		
		System.out.print(">>>>Player3 ");
		p3_coin=p3.buycoin();
		
	}
	
	void collectNumFromPlayer() {		
		numFromPlayer1=p1.guessNumber(1);
		numFromPlayer2=p2.guessNumber(2);
		numFromPlayer3=p3.guessNumber(3);	
		
	}
	
	//showing remaining coins
	void showCoins() {
		System.out.println("\t\tPlayer1 coins="+p1_coin);
		System.out.println("\t\tPlayer2 coins="+p2_coin);
		System.out.println("\t\tPlayer3 coins="+p3_coin);
	}
	
	//erasing previous value
	void RemovePreValue() {
		numFromPlayer1=-1;
		numFromPlayer2=-1;
		numFromPlayer3=-1;
	}
	
	//checking if player can play further or not
	boolean check(int player1,int player2,int player3) {
		System.out.println("--------------------------------------------------------------");
		
		if(player1==1 && player2==0 && player3==0) {
			
			p1_coin+=100;
			p2_coin/=2;
			p3_coin/=2;
			
			showCoins();
			RemovePreValue();
			collectNumFromGusser();
			
			numFromPlayer1=p1.guessNumber(1);
			if(p2_coin>0)
				numFromPlayer2=p2.guessNumber(2);
			if(p3_coin>0)
				numFromPlayer3=p3.guessNumber(3);
			
			compare();
		}
		
		if(player1==0 && player2==1 && player3==0) {
			
			p1_coin/=2;
			p2_coin+=100;
			p3_coin/=2;
			
			showCoins();
			RemovePreValue();
			collectNumFromGusser();
			
			if(p1_coin>0)
				numFromPlayer2=p1.guessNumber(1);
			numFromPlayer2=p2.guessNumber(2);
			if(p3_coin>0)
				numFromPlayer3=p3.guessNumber(3);
			
			compare();
		}
		
		if(player1==0 && player2==0 && player3==1) {
			
			p1_coin/=2;
			p2_coin/=2;
			p3_coin+=100;
			
			showCoins();
			RemovePreValue();
			collectNumFromGusser();
			
			if(p1_coin>0)
				numFromPlayer1=p1.guessNumber(1);
			if(p2_coin>0)
				numFromPlayer2=p2.guessNumber(2);
			
			numFromPlayer3=p3.guessNumber(3);
			compare();
		}
		
		if(player1==1 && player2==1 && player3==0) {
			
			p1_coin+=100;
			p2_coin+=100;
			p3_coin/=2;
			
			RemovePreValue();
			showCoins();
			collectNumFromGusser();
			
			
			numFromPlayer1=p1.guessNumber(1);
			numFromPlayer2=p2.guessNumber(2);
			if(p3_coin>0)
				numFromPlayer3=p3.guessNumber(3);
			
			compare();
		}
			
		
		if(player1==1 && player2==0 && player3==1) {
			
			p1_coin+=100;
			p2_coin/=2;
			p3_coin+=100;
			
			RemovePreValue();
			showCoins();
			collectNumFromGusser();
			
			
			numFromPlayer1=p1.guessNumber(1);
			if(p2_coin>0)
				numFromPlayer2=p2.guessNumber(2);
			numFromPlayer3=p3.guessNumber(3);
			
			compare();
		}
		
		if(player1==0 && player2==1 && player3==1) {
			
			p1_coin/=2;
			p2_coin+=100;
			p3_coin+=100;
			
			RemovePreValue();
			showCoins();
			collectNumFromGusser();
			
			
			if(p1_coin>0)
				numFromPlayer1=p1.guessNumber(1);
			
			numFromPlayer2=p2.guessNumber(2);
			numFromPlayer3=p3.guessNumber(3);
			compare();
		}
		
		if(player1==1 && player2==1 && player3==1) {
			
			p1_coin+=100;
			p2_coin+=100;
			p3_coin+=100;
			
			RemovePreValue();
			showCoins();
			collectNumFromGusser();
			collectNumFromPlayer();
			compare();
		}
		
		if(player1==0 && player2==0 && player3==0) {
			p1_coin/=2;
			p2_coin/=2;
			p3_coin/=2;
			
			showCoins();
			RemovePreValue();
			if(p1_coin>0 || p2_coin>0 || p3_coin>0)
			collectNumFromGusser();
			
			if(p1_coin>0)
				numFromPlayer1=p1.guessNumber(1);
			if(p2_coin>0)
				numFromPlayer2=p2.guessNumber(2);
			if(p3_coin>0)
				numFromPlayer3=p3.guessNumber(3);
			if(p1_coin<=0 && p2_coin<=0 && p3_coin<=0) {
				System.out.println("<<<<<<<<<<<<<<GAME OVER!>>>>>>>>>>>>>>>");
				return false;
			}
			
			compare();
			
		}
			
			
		return false;
	}
		
				
			
	
	void  compare() {
		boolean run=true;
		
		//run till all player's coin become zero
		while(run) {
			
			if(numFromGusser==numFromPlayer1) {
				if(numFromGusser==numFromPlayer2 && numFromGusser==numFromPlayer3) {
					System.out.println("\t\tAll Player Win!");
					run=check(1,1,1);
				}
				else if(numFromGusser==numFromPlayer2) {
					System.out.println("\t\tPlayer1 And Player2 win");
					run=check(1,1,0);
				}
				else if(numFromGusser==numFromPlayer3) {
					System.out.println("\t\tPlayer3 and player1 win!");
					run=check(1,0,1);
				}
				else {
					System.out.println("\t\tPLayer1 win!");
					run=check(1,0,0);
				}
			}
			else if(numFromGusser==numFromPlayer2) {
				if(numFromGusser==numFromPlayer3) {
					System.out.println("\t\tPlayer2 and Player3 win the game");
					run=check(0,1,1);
				}
				else {
					System.out.println("\t\tPlayer2 Win!");
					run=check(0,1,0);
				}
				
			}
			else if(numFromGusser==numFromPlayer3) {
				System.out.println("\t\tplayer3 Win!");
				run=check(0,0,1);
			}
			else {
				System.out.println("\t\tNo one win!");
				run=check(0,0,0);
			}
		}
	}
}


public class gusserGame {

	public static void main(String[] args) {
		
		Umpire u=new Umpire();
		u.collectNumFromGusser();
		u.getCoins();
		u.collectNumFromPlayer();
		u.compare();
		

	}

}

