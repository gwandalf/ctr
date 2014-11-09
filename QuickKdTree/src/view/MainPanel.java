package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JPanel;

import viewModel.NodeViewModel;
import viewModel.SceneViewModel;

public class MainPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SceneViewModel sceneVM;
	private Set<NodeViewModel> nodes;

	public MainPanel(SceneViewModel sceneVM) throws HeadlessException {
		this.sceneVM = sceneVM;
		this.nodes = new HashSet<NodeViewModel>();
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2 = (Graphics2D)arg0;
		g2.draw(this.sceneVM.getUpRectangle());
		g2.draw(this.sceneVM.getBottomRectangle());
		for(Line2D line : this.sceneVM.getUpSegments())
			g2.draw(line);
		for(Line2D line : this.sceneVM.getBottomSegments())
			g2.draw(line);
		g2.setColor(Color.BLUE);
		for(NodeViewModel nvm : nodes) {
			if(nvm.getPlane() != null)
				g2.draw(nvm.getPlane());
		}
		g2.setColor(Color.BLACK);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		NodeViewModel node = (NodeViewModel)arg0;
		if(nodes.contains(arg0)) {
			String msg = (String)arg1;
			if("plane".equals(msg))
				repaint();
			if("leftNode".equals(msg)) {
				NodeViewModel nvm = node.getLeftNode();
				nodes.add(nvm);
				nvm.addObserver(this);
			}
			if("rightNode".equals(msg)) {
				NodeViewModel nvm = node.getLeftNode();
				nodes.add(node.getRightNode());
				nvm.addObserver(this);
			}
		}
	}

	public Set<NodeViewModel> getNodes() {
		return nodes;
	}

}
