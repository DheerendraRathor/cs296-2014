#! /usr/bin/python3

import re
import collections

action=["kill","fight","fought","bomb"," gun","pistol","sniper","rifle","kick","punch","army","jump","missile",
"weapon","destruct","destruction","war ","wars","battle"," arrow","military","tank","bullet","destroy","nemesis","chase",
"attack","police","drone"]


romance=["love","date","kiss","affection","heart","hug","crush","embrace","honey","dear","sweet","marriage",
"married","moon","together","partner","couple","darling","attract","sex","champaign","propos","cake","choco","fiance","engaged",
"relationship","commit","beaut"]


comedy=["laugh","laughter","chuckle","giggle","crack","joke","joker","comedy","comedian","stand up",
"happy","happiness","amuse","bitch","drunk","hangover","fun","sarcasm"]


scifi=["alien","space","machine","robot","power","science","gravity","satellite","star ","stars","sun","galaxy","universe",
"dimension","disapper","fly ","flew"," suit","moon","cyborg","scientist","disaster","bots","hydrogen","oxygen"," iss ","orbit"]


horror=["fear","afraid","ghost","witch","adrenaline","scream","cry","scar","bone","skul","vampire"
"blood","axe","paranormal","haunt","curse","dead"," shak","empty","grave","coffin","sprit"]


fantasy=["eagle","wizard","magic","prince","dragon","curse","wonder","witch","lord"," king","queen","prince","princess","super",
"adventur","spell","potion","wand","fairy"," angel "," angels ","fairies","monster","raven","unicorn","centaur","phoenix","evil","pirates"
,"mermaid","dungeon"]


drama=["emotion","weep","cry","drama","husband","wife","dad","judge","jury","sick","mad","father","mother","life","black","white",
"poor","rich","politic","-in-law","friend","hate","satire","sarcasm","narrat","music","tragedy","sympathy","prison"]

actionCount=0
romanceCount=0
comedyCount=0
scifiCount=0
horrorCount=0
fantasyCount=0
dramaCount=0
l1=[]
l2=[]
l3=[]
l4=[]
l5=[]
l6=[]
l7=[]

filename=input("please enter filename: ")
with open(filename) as f:
	words=f.read()
	
words=words.lower()
	
#words=content.split()

for i in range(len(action)):
	temp=words.count(action[i])
	actionCount+=temp
	l1.append(temp)
for i in range(len(romance)):
	temp=words.count(romance[i])
	romanceCount+=temp
	l2.append(temp)
for i in range(len(comedy)):
	temp=words.count(comedy[i])
	comedyCount+=temp
	l3.append(temp)
for i in range(len(scifi)):
	temp=words.count(scifi[i])
	scifiCount+=temp
	l4.append(temp)
for i in range(len(horror)):
	temp=words.count(horror[i])
	horrorCount+=temp
	l5.append(temp)
for i in range(len(fantasy)):
	temp=words.count(fantasy[i])
	fantasyCount+=temp
	l6.append(temp)
for i in range(len(drama)):
	temp=words.count(drama[i])
	dramaCount+=temp
	l7.append(temp)
total=actionCount+romanceCount+comedyCount+scifiCount+horrorCount+fantasyCount+dramaCount
def percent(value):
	return value*100/total
output=[[actionCount,"Action"],[romanceCount,"Romance"],[comedyCount,"Comedy"],[scifiCount,"Sci-Fi"]
,[horrorCount,"Horror"],[fantasyCount,"Fantasy"],[dramaCount,"Drama"]]
def sortoutput(output):
	for i in range(len(output)):
		output[i][0]=percent(output[i][0])
	output=sorted(output,reverse=True)
	return output
	
def average(lst):
	total=0
	for i in range(len(lst)):
		total+=lst[i][0]
	return total/len(lst)
	
def stddev(lst):
	total=0
	mean=average(lst)
	for i in range(len(lst)):
		total+=(mean-lst[i][0])**2#(mean-lst[i])
	temp=total/len(lst)
	return (temp)**(0.5)
	

#print(percent(actionCount)," ",actionCount," action")
#print(l1)
#print(percent(romanceCount)," ",romanceCount," romance")
#print(l2)
#print(percent(comedyCount)," ",comedyCount," comedy")
#print(l3)
#print(percent(scifiCount)," ",scifiCount," scifi")
#print(l4)
#print(percent(horrorCount)," ",horrorCount," horror")
#print(l5)
#print(percent(fantasyCount)," ",fantasyCount," fantasy")
#print(l6)
#print(percent(dramaCount)," ",dramaCount," drama")
#print(l7)
output=sortoutput(output)
mean=average(output)
stdev=stddev(output)
print(output[0][1],end=" ")
#if output[1][0]>(output[0][0]-mean):
#	print(output[1][1],end=" ")
for i in range(1,len(output)):
	if output[i][0]>(output[0][0]-output[i][0]):
		print(output[i][1],end=" ")
	else:
		break

print("")

