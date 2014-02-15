#! /bin/bash
#### Darcy By Vikas
#### Lady Catherine by Ravi 
#### Colonel Fitzwilliam by Dheerendra
file=./data/pnp_austen.txt
sed "s/''/\"/g;" $file | sed 's/``/"/g' | sed 's/Lady Catherine/Ravi/g;s/Catherine/Ravi/g' | sed 's/Darcy/Vikas/g' \
| sed 's/Colonel Fitzwilliam/Dheerendra/g;s/Fitzwilliam/Dheerendra/g' > ./data/pnp_austen_cs296.txt 
