#! /bin/bash
die () {
	echo >&2 "$@"
	exit 1
}
[ "$#" = "1" ] || die "No command line arguement. Exit"
if [ $1 -eq 2 ]
then
	ls ./src/*.cpp | awk '{ print "mv " $0 }' | awk '{print $0 " "$NF".bak"}' | bash
###	rename 's/\.cpp/\.cpp.bak/' ./src/*.cpp > /dev/null 2>&1
elif [ $1 -eq 1 ]
then
	dir=./src/*.cpp
	for file in $dir
	do
		mv "$file" "$file.bak" > /dev/null 2>&1
	done
fi

