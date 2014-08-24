package cs296JTalk2;
import java.io.*;
import java.util.*;
import java.text.*;
class JMessage implements Serializable{
	public String message;
	public JMessage(String msg) {
		if(msg.length() > 140)
			message = msg.substring(0, 140).trim();
		else
			message = msg.trim();
	}

}
