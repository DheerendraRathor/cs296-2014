package cs296JTalk2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JConnect extends JPanel {
	public JTabbedPane pane;
	private JTextArea ta;
	private JLabel title = new JLabel("Connected Clients");
	private ArrayList<JButton> blist = new ArrayList<JButton>();
	private JScrollPane spane;
	public JConnect(JTabbedPane pane) {
		this.pane = pane;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(title);
		ta = new JTextArea();
		ta.setEditable(false);
		ta.append("New Added Client Notification Center\n");
		spane = new JScrollPane(ta);
		spane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spane.setMinimumSize(new Dimension(300,200));
		spane.setMaximumSize(new Dimension(300,200));
		add(spane);
	}
	public void addClient(final String ip, final JThread jst) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JButton b = new JButton(ip);
				b.setMinimumSize(new Dimension(300,40));
				b.setMaximumSize(new Dimension(300,40));
				blist.add(b);
				final Tab tab = new Tab(jst);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pane.removeAll();
						 pane.add(ip, tab);
						 for (int i= 0 ; i < blist.size(); i++){
							 JButton temp = blist.get(i);
							 temp.setBackground(null);
						 }
						 b.setBackground(Color.GREEN);
						 
					}
				});
				add(b);
				ta.append("New Client with IP: "+ip+"\n");
				revalidate();
				repaint();
				jst.b = b;
				jst.tab = tab;
			}
		});
	}
}
