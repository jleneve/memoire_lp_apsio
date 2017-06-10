#!/bin/bash

n=$(echo $1 | awk -f /usr/share/awk/ord.awk -f f2.awk)

$file="unsortFr.dic$n"
[ ! -r "$file" ] && exit 1


