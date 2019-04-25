public class Model {

	private Viewer viewer;
	
	int indexX;
	int indexY;

	int [][] desktop;
	int next;
	char dir;

	Model(Viewer viewer) {

		this.viewer = viewer;

		dir = 'S';
		desktop = new int[][]
			{
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
		
		next = desktop[indexX][indexY -1];
		if(next ==3) {
			if(checkIndex(indexX, indexY -2) && desktop[indexX][indexY -2] ==0) {
				desktop[indexX][indexY -2] =3;
				desktop[indexX][indexY -1] =0;	
			}                	
		}
			
		next = desktop[indexX][indexY -1];
		if(next ==0) {
			desktop[indexX][indexY] =0;
			indexY--;
			desktop[indexX][indexY] =1;	                	
		}	
	}

	private void moveUp() {
		dir = 'U';		
		
		next = desktop[indexX -1][indexY];
		if(next ==3) {
			if(checkIndex(indexX-2, indexY) && desktop[indexX -2][indexY] ==0) {
					desktop[indexX -2][indexY] =3;
					desktop[indexX -1][indexY] =0;	
				}                	
			}

		next = desktop[indexX -1][indexY];
		if(next ==0) {
			desktop[indexX][indexY] =0;
			indexX = indexX -1;
			desktop[indexX][indexY] =1;	                	
		}
        }

	private void moveRight() {
                dir = 'R';
		if(indexY <14) {

			next = desktop[indexX][indexY +1];
			if(next ==3) {
				if(desktop[indexX][indexY +2] ==0) {
					desktop[indexX][indexY +2] =3;
					desktop[indexX][indexY +1] =0;	
				}                	
			}
	
			next = desktop[indexX][indexY +1];
			if(next ==0) {
				desktop[indexX][indexY] =0;
				indexY = indexY +1;
				desktop[indexX][indexY] =1;	                	
			}	
		}
       	}

	private void moveDown() {
		dir = 'D';		
		if(indexX <14) {

			next = desktop[indexX +1][indexY];
			if(next ==3) {
				if(desktop[indexX +2][indexY] ==0) {
					desktop[indexX +2][indexY] =3;
					desktop[indexX +1][indexY] =0;	
				}                	
			}

			next = desktop[indexX +1][indexY];
			if(next ==0) {               	
				desktop[indexX][indexY] =0;
				indexX = indexX +1;
				desktop[indexX][indexY] =1;
			}	
		}
       	}

	private boolean checkIndex(int ix, int iy) {
		if(ix <0 || ix > desktop.length || iy <0 || iy > desktop[0].length) {
			return false;
		} else {
			return true;
		}
        }


}







