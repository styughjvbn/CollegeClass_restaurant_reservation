package github;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;

public class reservation_payment extends JPanel {

	/**
	 * Create the panel.
	 */
	public reservation_payment() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(629, 10, 335, 441);
		add(panel);
		
		JButton btnNewButton = new JButton("rufwp ");
		btnNewButton.setBounds(629, 461, 340, 36);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(53);
		panel_1.setBounds(12, 10, 592, 490);
		add(panel_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setPreferredSize(new Dimension(50, 50));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setPreferredSize(new Dimension(50, 50));
		panel_1.add(btnNewButton_1_1);

	}
}
