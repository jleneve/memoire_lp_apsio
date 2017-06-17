#!/bin/bash

#mot recherché
word=$1

#recherche du paquet 
n=$(echo $1 | awk -f /usr/share/awk/ord.awk -f f2.awk)

#paquet
#$file="unsortFr.dic$n"
file="unsortFrTest.dic$n"

cat $file > "tmp_file_dic"
file="tmp_file_dic" 


VAR="";

while [ "$VAR" == "" ]; do

	#taille du paquet
	size=$(wc -l < $file)

	#ligne au millieu du fichier
	num_line=$(($size/2))

	#reception de la ligne 
	line=$(sed -n $num_line'p' $file)

	#separation de la ligne entre le mot et l'url
	IFS=';' read -a myarray <<< "$line"

	if [ "$word" == "${myarray[0]}" ]
	then
		VAR=${myarray[1]}
	else
		echo $word > "tmp_file"
		echo ${myarray[0]} >> "tmp_file"

		file_unsort=$(cat "tmp_file")
		file_sort=$(sort "tmp_file")
		
		if [ "$file_unsort" == "$file_sort" ]
		then
			awk 'NR >= 0 && NR <= '$num_line $file > 'tmp_file_dic_2'
		else
			awk 'NR >= '$num_line' && NR <= '$size $file > 'tmp_file_dic_2'
		fi
		echo $num_line
		cat 'tmp_file_dic_2' > 'tmp_file_dic'
		rm 'tmp_file_dic_2'
	fi
done

echo $VAR







