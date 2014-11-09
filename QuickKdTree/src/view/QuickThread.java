package view;

import implementations.Node;
import implementations.QuickTree;
import implementations.Scene;
import viewModel.NodeViewModel;
import viewModel.SceneViewModel;
import viewModel.Transformations;

public class QuickThread extends Thread {

	private SceneViewModel sceneViewModel;
	private MainPanel panel;
	
	public QuickThread(SceneViewModel sceneVM, MainPanel panel) {
		this.sceneViewModel = sceneVM;
		this.panel = panel;
	}

	@Override
	public void run() {
		super.run();
		Scene scene = this.sceneViewModel.getScene();
		QuickTree tree = new QuickTree(this.sceneViewModel.getScene());
		double[] bounds = new double[4];
		bounds[0] = this.sceneViewModel.getBottomRectangle().getMinX();
		bounds[3] = this.sceneViewModel.getBottomRectangle().getMinY();
		bounds[2] = this.sceneViewModel.getBottomRectangle().getMaxX();
		bounds[1] = this.sceneViewModel.getBottomRectangle().getMaxY();
		NodeViewModel nvm = new NodeViewModel((Node)tree.getRoot(),
				bounds,
				scene.getEnd().getX(),
				scene.getEnd().getY(),
				Transformations.OFFSET);
		this.panel.getNodes().add(nvm);
		nvm.addObserver(panel);
		tree.build();
	}
	
}
