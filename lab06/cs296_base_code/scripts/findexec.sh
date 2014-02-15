#! /bin/bash
file=`find $1 -type f | wc -l`
dir=`find $1 -type d | wc -l`
echo "$(($file+$dir))"
find $1 -type f -executable
