package menu_practice;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_pratice extends JPanel {
	private hi temp;
	private ArrayList<hi> shop_table=new ArrayList();
	int num=-1;
	int x,y;
	/**
	 * Create the panel.
	 */
	public menu_pratice() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 24, 713, 564);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp=new hi((++num)*150,(num)*150);
				shop_table.add(temp);
				
				panel.add(shop_table.get(num));
				panel.repaint();
			}
		});
		btnNewButton.setBounds(862, 84, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(862, 294, 97, 23);
		add(btnNewButton_1);
	}
}
class hi extends JButton{
	public hi(int x,int y){
		setBounds(x, y, 100, 100);
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
class hjh extends JPanel{
	public hjh() {
		
	}
}