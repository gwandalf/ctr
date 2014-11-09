package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Line2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import viewModel.SceneViewModel;

public class MainPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SceneViewModel sceneVM;

	public MainPanel(SceneViewModel sceneVM) throws HeadlessException {
		this.sceneVM = sceneVM;
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2 = (Graphics2D)arg0;
		g2.draw(
				this.sceneVM.getUpRectangle());
		g2.draw(this.sceneVM.getBottomRectangle());
		for(Line2D line : this.sceneVM.getUpSegments())
			g2.draw(line);
		for(Line2D line : this.sceneVM.getBottomSegments())
			g2.draw(line);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
