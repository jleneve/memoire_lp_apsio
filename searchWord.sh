#!/bin/bash

n=$(echo $1 | awk -f /usr/share/awk/ord.awk -f f2.awk)
echo $n

#$file="unsortFr.dic$n"
file="unsortFrTest.dic$n"
[ ! -r "$file" ] && exit 1

while read word ; do

	IFS=';' read -a myarray <<< "$word"
	
	if [ $1 == ${myarray[0]} ]
	then
		echo ${myarray[0]}
		echo ${myarray[1]}
		break;
	fi
done < $file
