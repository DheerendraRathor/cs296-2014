#! /bin/bash
iteration=1500
rerun=150
for i in $(seq 1 $iteration);
	do
		for j in $(seq 1 $rerun);
			do
				../bin/cs296_base $i | \
				sed 's/[^0-9.]*//g' | tr '\n' ',' | \
				sed -e :a -e '/^\n*$/{$d;N;ba' -e '}' | sed -e '$s/,$/\n/'| \
				sed -e "s/,\+/,$j,/" >> g12_lab05data_02.csv
			done
	done
