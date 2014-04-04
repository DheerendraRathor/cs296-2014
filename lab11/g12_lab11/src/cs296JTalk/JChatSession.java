package cs296JTalk;
import java.io.*;
import java.util.*;
public class JChatSession {
	public class withwho extends JPacket{
		private String who;
		private String whom;
		public withwho(String s,String w1,String w2){
			super(s);
			who=w1;
			whom=w2;
		}
		private void print(){
			System.out.println(who+": "+msg);
			System.out.println(this.a1);
		}
	}
	
	List<withwho> myList = new ArrayList<withwho>();
	public void printLog(){
		for (withwho temp : myList){
			temp.print();
		}
	}
}
