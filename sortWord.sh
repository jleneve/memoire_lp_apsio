#!/bin/bash

file=$1
[ ! -r "$file" ] && exit 1

sort $file > "tmp_file"
cat "tmp_file" > $file
