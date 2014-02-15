#! /bin/bash
temp=`ps -eo uname:20,pid,cmd | grep 'cs296_base$' | grep -v grep`

if [ "$temp" = "" ] 
then 
echo "cs296_base is not running by any user"
exit 1
fi

parse=($temp)
user=${parse[0]}
pid=${parse[1]}
echo "cs296_base is running by the user $user and process id $pid"
cuser=$(whoami)
if [ $user = $cuser ]
then
read  -p "Do you want to quit cs296_base? (y or n) " response
if [ $response = "y" ] || [ $response = "Y" ] 
then
kill $pid
fi
else 
echo "The current User doesn't have permission to kill this process"
exit 1
fi


