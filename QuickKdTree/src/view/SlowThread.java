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
		int[] bounds = new int[4];
		bounds[0] = (int)this.sceneViewModel.getUpRectangle().getLocation().getX();
		bounds[3] = (int)this.sceneViewModel.getUpRectangle().getLocation().getY();
		bounds[2] = (int)this.sceneViewModel.getUpRectangle().getSize().getWidth() + bounds[0];
		bounds[1] = (int)this.sceneViewModel.getUpRectangle().getSize().getHeight() + bounds[3];
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
