#!/bin/bash

file=$1
[ ! -r "$file" ] && exit 1

# size of file
size=$(wc -l < "$file")
echo $size

tab=()
while read word ; do
	tab+=("$word");
done < $file

for (( i=0 ; i<size ; i++))
do
	for(( j=($i+1) ; j<size ; j++))
	do
		lettreI=$(echo ${tab[i]} | awk -f /usr/share/awk/ord.awk -f ordLetterInWord.awk)
		lettreJ=$(echo ${tab[j]} | awk -f /usr/share/awk/ord.awk -f ordLetterInWord.awk)		
		if [ $lettreJ -le $lettreI ]
        	then
            		tampon=${tab[i]}
            		tab[i]=${tab[j]}
            		tab[j]=$tampon
		fi
	done
done

for (( i=0 ; i<size ; i++ ))
do
    echo ${tab[i]}
done
