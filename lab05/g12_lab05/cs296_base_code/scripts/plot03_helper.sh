#!bin/bash
iteration=1500
rerun=150
mean=0
sum=0
i=0
j=1
count=1
while read -ra f
do
if [ $i -eq $rerun ];
then
i=0
mean=$(echo "scale=5; $mean/$rerun"|bc)
std=$(echo "scale=5; sqrt($sum/$rerun - $mean*$mean)"|bc)
echo $j,$mean,$std >>temp.csv
mean=0
sum=0
j=$(($j+1))
fi
f=($(echo $f | tr ',' ' '))
mean=$( echo "scale=5; ${f[2]}+$mean" | bc)
sum=`echo "scale=5; ${f[2]}*${f[2]}+$sum"| bc`
i=$(($i+1))
done <g12_lab05data_01.csv
mean=$(echo "scale=5; $mean/$rerun"|bc)
std=$(echo "scale=5; sqrt($sum/$rerun - $mean*$mean)"|bc)
echo $j,$mean,$std >>temp.csv		
