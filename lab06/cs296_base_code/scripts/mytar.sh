#! /bin/bash

if [ $1 -eq 1 ] 
then
	tar czf src.tar.gz src
elif [ $1 -eq 2 ]
then
	gzip ./src/* > /dev/null 2>&1
	tar cf src.tar src/*.gz
fi
