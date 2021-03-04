import java.util.Random;

public class Game {
	int playerLeftIndent, computerLeftIndent, topIndent, centerIndent, 
	fieldSize, cellSize;
	
	Field playerField, computerField;
	
	Game(){
		topIndent = 150;
		
		centerIndent = 250;
		fieldSize = 10;
		cellSize = 50;
		
		playerLeftIndent = 350;
		computerLeftIndent = playerLeftIndent + fieldSize * cellSize + centerIndent;
	
		
		playerField = new Field(topIndent, playerLeftIndent, fieldSize, cellSize, false);
		
		computerField = new Field(topIndent, computerLeftIndent, fieldSize, cellSize, true);
		
		
	}
	public void computerTurn() {
		Random rn = new Random();
		int x = rn.nextInt(10);
		int y = rn.nextInt(10);
		while(playerField.shoot(x, y) > 0) {
			x = rn.nextInt(10);
			y = rn.nextInt(10);
		}
		
	}
	
	public void playerTurn(int x, int y) {
		x -= computerLeftIndent;
		y -= topIndent;
		x /= cellSize;
		y /= cellSize ;
		if(computerField.shoot(x, y) == 0) {
			computerTurn();
		}
	}
	
}
