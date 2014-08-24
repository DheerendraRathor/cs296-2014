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
http://www.tutorialspoint.com/listtutorials/java/swing/1
http://www.ase.md/~aursu/ClientServerThreads.html

Book- Thinking in Java
And lots of googling

RelationShips in Class:

JMessage:
This stores a truncated string of 140 characters at maximum.

JPacket:
Inherited from JMessage with a Date-time string in the format yyyy/MM/dd HH:mm:ss

JServer:
Starts a server at port 5123 and acceptConnection whenever available
When some client want to connect to it, it connects to it and open the gui to chat with server.When another client tries to connect from the same server, it connects from it also and open another gui for client and add options in gui of server.

JClient:
Ping to a server at specific IP and port 5123 and ask server for chat connection.

JTalk12:
This is the main class and starts server or client side socket depending on the presence of command line arguement. 

We have implemented thread here so that we ca
