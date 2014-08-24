package cs296JTalk2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JTab extends JFrame {    
    public static final JTabbedPane pane = new JTabbedPane();
	public static JConnect cons = new JConnect(pane);
	private JScrollPane scroll;
    private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pane, cons);
    public JTab(String title) {
        super(title);
        split.setDividerLocation(700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scroll= new JScrollPane(split);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
    }
    public void setup() {
        pane.removeAll();
        pane.setSize(200, 700);
        pane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        setSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public JConnect getCons() {
    	return cons;
    }
}
