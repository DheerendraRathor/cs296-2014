package cs296JTalk2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClientPane extends JFrame {
public JTextField tf;
public JTextArea ta;
public JChatClient jcc;
private JScrollPane scroll;
public ClientPane(String title) {
	super(title);
	setSize(new Dimension(700, 500));
	JPanel pane = new JPanel();
	pane.setSize(new Dimension(700, 500));
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	tf = new JTextField();
	ta = new JTextArea();
	ta.setEditable(false);
	scroll = new JScrollPane(ta);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	tf.setMinimumSize(new Dimension(700, 50));
	tf.setMaximumSize(new Dimension(700, 50));
	tf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!jcc.sendMessage())
				jcc.endChat();
		}
	});
	pane.add(scroll);
	pane.add(tf);
	add(pane);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
	}
}
