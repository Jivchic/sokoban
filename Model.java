public class Model {

	private Viewer viewer;
	
	int indexX;
	int indexY;

	int [][] desktop;
	int next;

	Model(Viewer viewer) {

		this.viewer = viewer;

		desktop = new int[][]
			{
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 2, 2, 2, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 2, 2, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
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
                check();
		viewer.update();
	
	}

	private void moveLeft() {
		
		if(indexY >0) {

			next = desktop[indexX][indexY -1];
			if(next ==2) {
				return;                	
			}
			
			desktop[indexX][indexY] =0;
			indexY = indexY -1;
			desktop[indexX][indexY] =1;	
		}	
	}

	private void moveUp() {
		
		if(indexX >0) {

			next = desktop[indexX -1][indexY];
			if(next ==2) {
				return;                	
			}
			
			desktop[indexX][indexY] =0;
			indexX = indexX -1;
			desktop[indexX][indexY] =1;	
		}
        }

	private void moveRight() {
                
                if(indexY <9) {

			next = desktop[indexX][indexY +1];
			if(next ==2) {
				return;                	
			}
			
			desktop[indexX][indexY] =0;
			indexY = indexY +1;
			desktop[indexX][indexY] =1;	
		}
       	}

	private void moveDown() {
		
		if(indexX <9) {

			next = desktop[indexX +1][indexY];
			if(next ==2) return;               	
			
			desktop[indexX][indexY] =0;
			indexX = indexX +1;
			desktop[indexX][indexY] =1;	
		}
       	}

	private void check() {
		/*if(
			x >= xBigR
			&&
			y >= yBigR
			&&
			(x + w)	<= (xBigR + wBigR)
			&&
			(y + h) <= (yBigR + hBigR)

		) {
			System.out.print('*');
		}*/
        }


}







