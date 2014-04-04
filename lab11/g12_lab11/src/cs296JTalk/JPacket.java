package cs296JTalk;
import java.io.*;
import java.util.*;
import java.text.*;

public class JPacket extends JMessage implements Serializable{	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	 String a1 = sdf.format(date);
	public JPacket(String s1){
		super(s1);
	}
}
