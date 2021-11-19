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
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp=new hi();
				shop_table.add(temp);
				num++;
				panel.add(shop_table.get(num));
				panel.repaint();
				System.out.println("hi");
			}
		});
		btnNewButton.setBounds(862, 84, 97, 23);
		add(btnNewButton);
	}
}
class hi extends JButton{
	int x,y;
	public hi(){
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}