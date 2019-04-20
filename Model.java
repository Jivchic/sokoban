public class Model {

	private Viewer viewer;
	int x;
	int y;

	int x1;
	int y1;
	
	Model(Viewer viewer) {

		this.viewer = viewer;

		x = 150;
		y = 50;

		x1 = 50;
		y1 = 150;
	}

	public void move(int direction) {
                viewer.update();
	}


}