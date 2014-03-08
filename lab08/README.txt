Group No. 12
Group Members
	Vikas Garg  		  120050017
	Ravi kumar Verma 	  120050027
	Dheerandra singh Rathor   120050033


All work that We are submitting is our own work and we have not copied it from anywhere.

All resources that we have used

stackexchange.com
https://docs.python.org/3/tutorial
http://stackoverflow.com
https://imsdb.com
http://www.google.co.in

Algorithms:

1. Title and author

The first non empty line is considered as title 
The lines after the first "by" is considered as author

2. Finding Characters

All lines with only Capital letters are considered as characters except the lines describing scenes like EXT, INT, etc
All other capital letters are also included.
For finding occurence of the characters, all occurences of the characters are included with the capitalization. 
ex. Wayne is also counted for WAYNE.

3. Finding Male and Female,

For each characters, next 4 lines are searched and gender determinig words - he, him, she, her are searched. 
This occurence is kept weighted with the weight for 1st line is 1, for 2nd line is 0.75, for third line is 0.5, 
for fourth line is 0.25.

Then the male value is multiplied with Total female value and female value is multiplied with 
total male value for canceling the error of small data.
Now it male*totalfemale > 1.05*female*totalmale => gender is male
similarly for female.
Rest are considered as undetermined

4. Finding Hero, Heroine and Villain
the most occuring male is considered as Hero, 
The most occuring female is considered as Heroine,
For villain, 
the person with most percentage occurece in the last 25% who is neither hero nor heroine is considered as villain.

5. For finding type of movie
Few keywords are stored for each genere and then the occurence of those keywords are 
seached in script.
the genre with highest percentage (percentage=(occurence of that genre words)/(total value of genre determing words)*100)
is the main genre and the other genre which satify the following condition:
genre_value% > (main_genre_value - genre_value) are considered as other genre.
