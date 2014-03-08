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







myone=[]
mytwo=[]
for kj in list2:
	myone.append(kj[0])
	mytwo.append(kj[1])


con=[]
male=[]
female=[]
for lin in list1:
	w=lin.split()
	for jjj in range(len(w)):
		con.append(w[jjj])


for kh in range(len(myone)):
	kj = myone[kh]
	if mytwo[kh]==0:
		pass
	m=0
	f=0
	bo= 0
	wor1=""
	word=kj.split()
	for wor in con:
		wor2=wor
		if wor[0].isupper():
			wor2=wor.upper()
		for i in range(len(word)):
			if word[i] == wor2:
				bo = 1
				if 'MR.' == wor1.upper() or 'MR' == wor1.upper() or 'MISTER' == wor1.upper():
					m=m+1000
				elif 'MS.' == wor1.upper() or 'MISS' == wor1.upper() or 'MS' == wor1.upper():
					f=f+1000
					
			elif ('HE' == wor.upper() or 'HIM' == wor.upper() or 'HIS' == wor.upper()) and bo == 1:
				m=m+1
				bo= 0
			elif ('SHE' == wor.upper() or 'HER' == wor.upper()) and bo == 1:
				f=f+1
				bo= 0
			else:
				wor1=wor

	male.append(m)
	female.append(f)
	
mt=0
ft=0	
for wor in con:
	if 'HE' == wor.upper() or 'HIM' == wor.upper() or 'HIS' == wor.upper():
		mt=1+mt
	elif 'SHE' == wor.upper() or 'HER' == wor.upper():
		ft=ft+1
	
ans=[]
ans1=[]
an1=[]
ans2=[]
an2=[]
for kh in range(len(male)):
	kj=myone[kh]
	if(mytwo[kh]<2):
		ans.append((kj, mytwo[kh], "Undetermined"))
	elif(male[kh]*ft > 1.05*female[kh]*mt):
		ans.append((kj, mytwo[kh], "Male"))
		ans1.append((mytwo[kh], kj))
	elif(male[kh]*ft*1.5 < female[kh]*mt):
		ans.append((kj, mytwo[kh], "Female"))
		ans2.append((mytwo[kh], kj))
	else:
		ans.append((kj, mytwo[kh], "Undetermined"))		
	
an=sorted(ans)
an1=sorted(ans1)
an2=sorted(ans2)
for j in an:
	if j[1] ==0:
		pass
	else:
		print(j)

print("The hero is", an1[-1][1])
print("The heroine is", an2[-1][1])

new=sorted(an,key=lambda x: x[1],reverse=True)
top6=new[:6]

allp=(len(list1)*3)//4
lastt=list1[allp:]
cou=[0,0,0,0,0,0]
for i in range(len(lastt)):
	temp=lastt[i].split()
	for j in range(len(top6)):
		name = top6[j][0][:1] + top6[j][0][1:].lower()
		cou[j]+=temp.count(name)
		cou[j]+=temp.count(top6[j][0])


added=[]
for i in range(6):
	if(top6[i][0] == an1[-1][1] or top6[i][0] == an2[-1][1]):
		pass
	else:
		added.append((top6[i][0],cou[i],cou[i]/top6[i][1]))

new2=sorted(added,key=lambda x: x[2],reverse=True)
print("The villain is",new2[0][0])
