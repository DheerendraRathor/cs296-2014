#! /usr/bin/python3
import re
from collections import Counter
import collections

inp=input("Write movie's name ")
f=open(inp)
content=f.readlines()


list1=[]
for i in range(len(content)):
	list1.append(content[i].strip(' \n'))
while '' in list1:
	list1.remove('')


#Finding names of characters in the list
notchar = ("EXT","INT","THE","CONT","FADE","DRAFT","(BEAT)","TITLE","MORE","TNT",":","!","--","..."," -","SCREEN","TO ",
"CREDIT","OMIT","DAY","MORNING","EVENING","NIGHT")


list2=[]
for i in range(len(list1)):
	if list1[i].isupper() :
		if any(s in list1[i] for s in notchar):
			pass
		else:
			temp = re.sub('\(\w*.*\)', '', list1[i])
			if temp :
				list2.append(temp.strip())
	else:
		temp=list1[i].split()
		for s in temp:
			if s.isupper():
				if any(s for s in notchar):
					pass
				else:
					list2.append(s.strip())

list2=list(set(list2))
character=[]
for i in range(len(list2)):
	if(len(list2[i].split())>1):
		character.append([list2[i],1])
	else:
		character.append([list2[i],0])


for i in range(len(list1)):
	temp=list1[i].split()
	for j in range(len(character)):
		name = character[j][0][:1] + character[j][0][1:].lower()
		character[j][1]+=temp.count(name)
		character[j][1]+=temp.count(character[j][0])

for i in range(len(character)):
	name=character[i][0]
	for j in range(len(character)):
		if j==i:
			pass
		else:
			lst=character[j][0].split()
			temp=lst.count(name)
			if temp:
				character[j][1]=0
				
for i in range(len(character)):
	name=character[i][0].split()
	if len(name)>3:
		character[i][1]=0

list2=sorted(character)
for i in range(len(list2)):
	print (list2[i])
