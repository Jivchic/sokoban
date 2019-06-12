
import java.io.*;
import javax.swing.*;

public class Model {

	private Viewer viewer;
	
	int indexX, indexX2, indexX3, backupX;
	int indexY, indexY2, indexY3, backupY;

	Levels levels;
	int level;
	int mapX;
	int mapY;

	int [][] desktop;
	int [][] backup;

    int next;
	char dir;

	Model(Viewer viewer) {

		this.viewer = viewer;

		level  = viewer.level;
		levels = new Levels();
	}

	void loadMap() {
		
		//System.out.println("x:"+ indexX + "; y:" + indexY + "; s: null");	

		levels.getLevel(level);
		
		mapX = levels.mapX;
		mapY = levels.mapY;

		dir = 'S';
		
		desktop = new int[mapY][mapX];
		desktop = levels.map;
		backup  = new int[mapY][mapX];
		
		setStartPosition();

		backupX = indexX;
		backupY = indexY;
        	array2Copy(desktop, backup);

		viewer.setFrame();
		viewer.update();
	}
	
	void setStartPosition() {

		indexX =0;
		indexY =0;

		for(int i =0; i < desktop.length; i++) {
			for(int j = 0; j < desktop[i].length; j++) {
				
				//System.out.print(desktop[i][j] + " ");
				if(desktop[i][j] ==1 || desktop[i][j] ==6) {
                    			indexX =i;
					indexY =j;
				}
			}
                //System.out.println();
		}		
	}
	
	public void move(int keyCode) {

		switch(keyCode) {

			case 37:
				moveLeft();					
				break;

			case 38:
				moveUp();
				break;

			case 39:
				moveRight();
				break;

			case 40:
				moveDown();
				break;

			case 8:

				indexX = backupX;
				indexY = backupY;
				array2Copy(backup, desktop);

				break;
		        
			default: 
				return; 
		}

		viewer.update();
               
		if(wins()) {
			
			JOptionPane.showMessageDialog(null, "You wins level " + level + "!");

			level++;
			loadMap();
		}
	}

	private void moveLeft() {
		dir = 'L';	
		
		indexX2 = indexX;
		indexY2 = indexY -1;

		indexX3 = indexX;
		indexY3 = indexY -2;

		if(takePlay()) {
			indexY--;	                		
		}	
	}

	private void moveUp() {
		dir = 'U';		
		
		indexX2 = indexX -1;
		indexY2 = indexY;

		indexX3 = indexX -2;
		indexY3 = indexY;

		if(takePlay()) {
			indexX--;	                		
		}
    }

    private void moveRight() {
		dir = 'R';
		
		indexX2 = indexX;
		indexY2 = indexY +1;

		indexX3 = indexX;
		indexY3 = indexY +2;

		if(takePlay()) {
			indexY++;	                		
		}
    }

    private void moveDown() {
		dir = 'D';		
		
		indexX2 = indexX +1;
		indexY2 = indexY;

		indexX3 = indexX +2;
		indexY3 = indexY;

		if(takePlay()) {
			indexX++;	                		
		}
    }

    private boolean checkIndex(int ix, int iy) {
		if(ix <0 || ix >= desktop.length || iy <0 || iy >= desktop[0].length) {
			return false;
		} else {
			return true;
		}
    }

    private void moveBox(int state) {
		
		if(desktop[indexX3][indexY3] ==4 | desktop[indexX3][indexY3] ==0) {

			backupX = indexX;
			backupY = indexY;
			array2Copy(desktop, backup);

			desktop[indexX3][indexY3] = state;
			desktop[indexX2][indexY2] = 0; //(desktop[indexX2][indexY2] ==4) ? 4 : 0; // (condition) ? true : false 
		}
    }

    private boolean takePlay() {

		if(checkIndex(indexX2, indexY2)) {
			next = desktop[indexX2][indexY2];
			if(next ==3) {
				if(checkIndex(indexX3, indexY3) && desktop[indexX3][indexY3] ==0) {
					moveBox(3);
				} else if(checkIndex(indexX3, indexY3) && desktop[indexX3][indexY3] ==4) {
					moveBox(5);
				}               	
			}
	
			next = desktop[indexX2][indexY2];
			if(next ==0) {
				desktop[indexX2][indexY2] = 1;
				desktop[indexX][indexY]   = (desktop[indexX][indexY] ==6) ? 4:0; // (condition) ? true : false

				return true;	                	
			
			} else if(next ==4) {
				desktop[indexX2][indexY2] = 6;
				desktop[indexX][indexY]   = (desktop[indexX][indexY] ==6) ? 4:0;

				return true;	

			} else if(next ==5) {
				if(desktop[indexX3][indexY3] !=4 & desktop[indexX3][indexY3] !=0) {
					return false;
				}

				moveBox((desktop[indexX3][indexY3] ==4) ? 5 : 3); // (condition) ? true : false
				desktop[indexX2][indexY2] = 6;
				desktop[indexX][indexY]   = (desktop[indexX][indexY] ==6) ? 4:0;

				return true;                	
			}	
		}
				return false;
    }	

	private void array2Copy(int[][] source, int[][] dest) {

		for(int i =0; i < source.length; i++) {
			for (int j = 0; j < source[i].length; j++) {
				dest[i][j] = source[i][j];
			}
		}
	}

	private boolean wins() {
		for(int i =0; i < desktop.length; i++) {
			for(int j = 0; j < desktop[i].length; j++) {
				if(desktop[i][j] ==4 | desktop[i][j] ==6) {
					return false;
				}
			}
		}
		
		return true;				
	}

	public void loadLevelFromFile(File file) {

		FileInputStream in = null;

		try {
                	in = new FileInputStream(file);
                        
			int c;
			
                        String trueSymbols = "";
			
			while ((c = in.read()) != -1) {
                        	
				char symbol = (char)c;
				//System.out.println(" " + s + " -> " + symbol);
                    		
				if ('0' <= symbol && symbol <= '6' || symbol == '\n' || symbol == ' ') {
                        		trueSymbols = trueSymbols + symbol;
                    		}
                	}
                        
			in.close();

			String lines[] = trueSymbols.split("\n");
			
			int rows = lines.length;
			
			int newMap[][] = new int[rows][];

			int col = 0;
                        for(int i =0; i< lines.length; i++) {
				if(col < lines[i].length()) {
					col = lines[i].length();
				}
			}
                        
			for(int i =0; i< lines.length; i++) {
				
				newMap[i] = new int [col]; 
				
				String upLine = lines[i] + "00000000000000000000000000";				
				for(int j = 0; j < col; j++) {
					
					char symbol = upLine.charAt(j);
					//System.out.println(symbol);

					if(symbol != '\n') {
						if(symbol == ' ') {
							newMap[i][j] = 0;
						} else {
							newMap[i][j] = Integer.parseInt("" + symbol);
						}
					}	
				}
			}
                
		desktop = newMap;

                if(chekMap()) {
		
			mapX = col;
			mapY = rows;

			dir = 'S';
		
			backup  = new int[mapY][mapX];
		
			setStartPosition();
                
			backupX = indexX;
			backupY = indexY;
        		array2Copy(desktop, backup);

			viewer.setFrame();
			viewer.update();
		} else {
			level = 0;
			loadMap();		
		}
		
		/*for(int i =0; i < newMap.length; i++) {
			for(int j = 0; j < newMap[i].length; j++) {
				System.out.print(newMap[i][j]);
			}
                	System.out.println();
		}*/
                
		} catch (IOException e) {
                	System.out.println("Error: " + e);
            }
	}

	private boolean chekMap() {
		
		int digGamer = 0;
		int digBox = 0;
		//System.out.println("Количество элементов игры не правильное!");

		for(int i =0; i < desktop.length; i++) {
			for(int j =0; j < desktop[i].length; j++) {
				
				int cursor = desktop[i][j];

				if(cursor == 1) {
					digGamer++;

				} else if(cursor == 6) {
					digGamer++; digBox--;
                                				
				} else if(cursor == 3) {
					digBox++;

                                } else if(cursor == 4) {
					digBox--;

				}				 
			}
		}

		if(digGamer !=1) {
			JOptionPane.showMessageDialog(null, "Gamer must be only 1 \n(num 1, or 6 when Gamer in Goal Zone)");
			return false;

		} else if(digBox !=0) {
			JOptionPane.showMessageDialog(null, "Quantity of Goal Zone and Boxes must be the same \n(num 3 for Box, num 4 for Goal Zone)");
			return false;

		} else {
			return true;
		}
	}	

}









