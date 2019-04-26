public class Model {

	private Viewer viewer;
	
	int indexX, indexX2, indexX3;
	int indexY, indexY2, indexY3;

	int [][] desktop;
	int next;
	char dir;

	Model(Viewer viewer) {

		this.viewer = viewer;

		dir = 'S';
		desktop = new int[][]
			{
				{2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
				{2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0, 0, 2},
				{2, 0, 0, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 0},
				{2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2},
				{2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
				{2, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 2, 2},
				{2, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 2},
				{2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
				{2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
				{2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 2},
				{2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
				{2, 0, 4, 0, 0, 0, 3, 0, 0, 2, 0, 0, 4, 0, 2},
				{0, 0, 4, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
				{2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
				{2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2},
			};

		indexX =1;
		indexY =2;
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
		}
               
		viewer.update();
	
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
			desktop[indexX3][indexY3] = state;
			desktop[indexX2][indexY2] = (desktop[indexX2][indexY2] ==4) ? 4 : 0; // (condition) ? true : false
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
				moveBox((desktop[indexX3][indexY3] ==4) ? 5 : 3); // (condition) ? true : false	
				desktop[indexX2][indexY2] = 6;
				desktop[indexX][indexY]   = (desktop[indexX][indexY] ==6) ? 4:0;

				return true;                	
			}	
		}
                System.out.println("-");
		return false; 
        }	


}







