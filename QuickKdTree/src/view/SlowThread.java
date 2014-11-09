package view;

import implementations.Node;
import implementations.Scene;
import implementations.SlowTree;
import viewModel.NodeViewModel;
import viewModel.SceneViewModel;

public class SlowThread extends Thread {

	private SceneViewModel sceneViewModel;
	private MainPanel panel;
	
	public SlowThread(SceneViewModel sceneVM, MainPanel panel) {
		this.sceneViewModel = sceneVM;
		this.panel = panel;
	}

	@Override
	public void run() {
		super.run();
		Scene scene = this.sceneViewModel.getScene();
		SlowTree tree = new SlowTree(this.sceneViewModel.getScene());
		double[] bounds = new double[4];
		bounds[0] = this.sceneViewModel.getUpRectangle().getMinX();
		bounds[3] = this.sceneViewModel.getUpRectangle().getMinY();
		bounds[2] = this.sceneViewModel.getUpRectangle().getMaxX();
		bounds[1] = this.sceneViewModel.getUpRectangle().getMaxY();
		NodeViewModel nvm = new NodeViewModel((Node)tree.getRoot(),
				bounds,
				scene.getEnd().getX(),
				scene.getEnd().getY(),
				0);
		this.panel.getNodes().add(nvm);
		nvm.addObserver(panel);
		tree.build();
	}
	
}
