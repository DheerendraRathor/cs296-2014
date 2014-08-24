package cs296JTalk2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class Tab extends JPanel {
	public JTextField tf;
	public JTextArea ta;
	public JScrollPane scroll;
	public Tab(final JThread jst) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		tf = new JTextField();
		ta = new JTextArea();
		scroll = new JScrollPane(ta);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ta.setEditable(false);
		tf.setMinimumSize(new Dimension(700, 50));
		tf.setMaximumSize(new Dimension(700, 50));
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!jst.sendMessage())
					jst.endChat();
			}
		});
		add(scroll);
		add(tf);
		revalidate();
		repaint();
	}
}
