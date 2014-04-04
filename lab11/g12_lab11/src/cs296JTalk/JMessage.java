package cs296JTalk;
import java.io.*;
import java.util.*;

public class JMessage implements Serializable {
	public String msg;
	protected JMessage(String s1){
		if(s1.length() <= 140)msg=s1;
		else {
			msg=s1.substring(0,139);
		}
	}
}
