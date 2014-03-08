import sys
inn=input("Please enter the name of txt file ")
f=open(inn)
arr=f.readlines()
p=0
q=0
j=len(arr)
for i in range(j):
	arr[i]=arr[i].strip()

for line in arr:
	word=line.split()
	if len(line) == 0:
		pass
	elif p == 0:
		print("Title of the film is" ,line)
		p=p+1
	elif 'by' in line.lower():
		print("Authors of the film are",end=' ')
		if word[-1].lower() == 'by':
			q=1
			pass
		else:
			fy=0
			for kj in range(len(word)):
				if fy==1:
					print(word[kj],end=' ')
				elif 'by' == word[kj].lower():
					fy=1
			print(' ')
			break
	elif q == 1:
		print(line)
		break
