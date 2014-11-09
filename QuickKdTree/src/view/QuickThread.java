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
		int[] bounds = new int[4];
		bounds[0] = (int)this.sceneViewModel.getBottomRectangle().getLocation().getX();
		bounds[3] = (int)this.sceneViewModel.getBottomRectangle().getLocation().getY();
		bounds[2] = (int)this.sceneViewModel.getBottomRectangle().getSize().getWidth() + bounds[0];
		bounds[1] = (int)this.sceneViewModel.getBottomRectangle().getSize().getHeight() + bounds[3];
		System.out.println("Bounds = " + bounds[0] + ',' + bounds[1] + ',' + bounds[2] + ',' + bounds[3]);
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
