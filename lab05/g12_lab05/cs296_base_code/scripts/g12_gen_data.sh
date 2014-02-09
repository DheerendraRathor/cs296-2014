#! /bin/bash
iteration=1500
rerun=150
for i in $(seq 1 $iteration);
	do
		for j in $(seq 1 $rerun);
			do
				../bin/cs296_base $i > ../data/g12out-$i-$j.txt 
			done
	done




