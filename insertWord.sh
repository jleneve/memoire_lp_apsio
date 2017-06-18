#!/bin/bash

if [ $# -eq 2 ]
then
	n=$(echo $1 | awk -f /usr/share/awk/ord.awk -f f2.awk)

	number=$[($RANDOM % ($[200 - 100] + 1)) + 100]
	word="$1;url_$number"
	echo $word >> ${2}$n

	./sortWord.sh ${2}$n
fi
