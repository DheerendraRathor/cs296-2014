Group No. 12
Group Members
	Vikas Garg  		  120050017
	Ravi kumar Verma 	  120050027
	Dheerandra singh Rathor   120050033


All work that We are submitting is our own work and we have not copied it from anywhere.

All resources that we have used

http://stackoverflow.com
http://msdn.microsoft.com/en-us/library/system.net.sockets.socket.receivetimeout(v=vs.110).aspx
http://stackoverflow.com/questions/4969760/set-timeout-for-socket
http://docs.oracle.com/javase/tutorial/
Book- Thinking in Java
And lots of googling

RelationShips in Class:

JMessage:
This stores a truncated string of 140 characters at maximum.

JPacket:
Inherited from JMessage with a Date-time string in the format yyyy/MM/dd HH:mm:ss

JChatSession:
This includes a class withwho inherited from JPacket with extra information of who sent msg to whom. 
JChatSession includes a list of withwho to store all chats during the conversation.

JServer:
Starts a server at port 5123 and acceptConnection whenever available
When some client want to connect to it, It asks server for "y or n" for accepting connection. At y server acceptsConnection
 and start chat Session. At n server refuses to connect and close itself.

JClient:
Ping to a server at specific IP and port 5123 and ask server for chat connection. If server doesn't respond in 10 seconds 
then client assumes that server is not available and close itself. If server sends any other msg than "Sure, Let us Begin." then 
client also assumes that server is not available and close itself.

JChatComm:
This a abstract class for both server and client to send, receive and log messages. It also includes endChat method for ending chat session
whenever one of Server or Client want to end chat.

jtalkG12:
This is the main class and starts server or client side socket depending on the presence of command line arguement. 

This is a peer to peer system and it is one to one message transfer method. It waits for other to send msg before sending their own message. 
This doesn't implements thread.
