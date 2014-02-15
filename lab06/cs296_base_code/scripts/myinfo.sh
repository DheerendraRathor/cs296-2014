#! /bin/bash
echo "Today is $(date +%A', '%e' '%B', '%Y)."
get_dob(){
	noyear=`echo $1 | sed 's/^[^-]*//'`
	temp=$(date +%Y)$noyear
	temp1=`echo $temp | tr '-' '\0'`
	tempdate=$(date +%Y%m%d)
	[ $temp1 -gt $tempdate ] || temp=`date --date="+1 year" +%Y`$noyear
	t1=`date --date="$temp" +%s`
	t2=`date --date="$(date)" +%s`
	diff=$(($t1-$t2))
	week="$(($diff/604800))"
	day="$(($(($diff-$week*604800))/86400))"
	hour="$(($(($diff-$week*604800-$day*86400))/3600))"
	echo "There are $week weeks $day days and $hour hours left for the birthday of $2"
}

get_uptime(){
	temp=($(who -b))
	strt=`date --date="${temp[2]} ${temp[3]}" +%s`
	t1=`date +%s`
	diff=$(($t1-$strt))
	day=$(($diff/86400))
	diff=$(($diff-$day*86400))
	hour=$(($diff/3600))
	minute=$(($(($diff-$hour*3600))/60))
	if [ $minute -lt 10 ]
		then
		minute=0$minute
	fi
	echo "Your System has been running for $day days, $hour:$minute hours."
}
#####Date formate must be "YYYY-MM-DD"
get_dob "1996-12-22" "Vikas Garg"
get_dob "1996-03-14" "Dheerendra Singh Rathor"
get_dob "1994-10-05" "Ravi Kumar Verma"

echo "Thank you for asking, $(whoami)"
get_uptime
disk=($(df -P ~/ | tail -1))
echo "The current disk on which your home folder is located is ${disk[0]} and is ${disk[4]} full"
name=($(lsb_release -c))
uversion=($(lsb_release -r))
echo "You are running ${name[1]} and version ${uversion[1]} with Kernel $(uname -r)"
ram=($(free -k))
ramtotal=`echo "scale=3; ${ram[7]}/1024/1024" | bc`
ramused=`echo "scale=3; ${ram[8]}*100/${ram[7]}" | bc`
echo "Your machine has $ramtotal GB RAM. Of which $ramused% is in use."
scrwords=$(wc -w < ./scripts/myinfo.sh)
scrlines=$(wc -l < ./scripts/myinfo.sh)
scrchars=$(cat ./scripts/myinfo.sh | tr -d '\n\r\f\t ' | wc -c)
echo "This script has $scrwords words, $scrlines lines and $scrchars characters (without counting space)"
