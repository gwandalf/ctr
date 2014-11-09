package view;

import javax.swing.JFrame;

import viewModel.SceneViewModel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SceneViewModel sceneVM = new SceneViewModel(200, 50, 50);
		MainPanel panel = new MainPanel(sceneVM);
		JFrame frame = new JFrame("Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setSize(500, 300);
		frame.setVisible(true);
		QuickThread quick = new QuickThread(sceneVM, panel);
		SlowThread slow = new SlowThread(sceneVM, panel);
		quick.start();
		slow.start();
	}

}
