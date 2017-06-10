#!/bin/bash

file=$1
[ ! -r "$file" ] && exit 1

while read word ; do

    n=$(echo $word | awk -f /usr/share/awk/ord.awk -f f2.awk)

    number=$[($RANDOM % ($[200 - 100] + 1)) + 100]
    word="$word;url_$number"
    echo $word >> ${file}$n

done < $file
