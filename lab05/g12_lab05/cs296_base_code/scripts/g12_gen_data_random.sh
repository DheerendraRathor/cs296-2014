#! /bin/bash
iteration=1500
rerun=150
for i in $(seq 1 $iteration)
	do 
		for j in  $(seq 1 15)
			do 
				rand=$((($i-1)*$rerun + $(( $(($RANDOM % $rerun)) + 1))))
				sed -n "$rand p" < g12_lab05data_02.csv >> g12_lab05data_random.csv  
			done 
	done
