import cs296JTalk2.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;

public class JTalk12 {


 public static void main(String[] args) {
 if(args.length == 0) {
		final JTab tabs = new JTab("JTalk12");
		try {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
                tabs.setup();
            }
        });
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        final JConnect cons = tabs.getCons();
        final JServer js = new JServer();
        while(true) {
        	js.acceptConnection();
        }
    }
else {
	String ip = args[0];
	JClient jc = new JClient(ip);
	try{
		if(jc.callServer()) {
			ClientPane cp = new ClientPane("JTalk12");
			JChatClient jcc = new JChatClient(jc.sock, cp);
			cp.jcc = jcc;
			while(true) {
				if(!jcc.receiveMessage())
					break;
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
}
