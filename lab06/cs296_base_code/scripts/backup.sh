#! /bin/bash
temp=$(df -kh | grep -i /media | tail -n  1 | grep -oE '[^ ]+$')
dir=$temp/$1
srcq=src
rsync -rb $srcq $dir

#### cp -u $src $dir
##Code with cp. Can be done with scp too in a similar way
if false
then
for file in $srcq
do
	stamp1=`stat --printf=%y $file | cut -d. -f1`
	time1=`date --date="$stamp1" +%s`
	file1=`echo $file | sed 's/src\///'`
	time2=`date --date="$(stat --printf=%y $dir/$file1 | cut -d. -f1)" +%s`
	if [ $time2 -lt $time1 ]
	then
		cp $file $dir/$file1
	fi	
done
fi
