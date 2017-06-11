#!/bin/bash

file=$1
[ ! -r "$file" ] && exit 1

cat $file | sed 's/à/a/' | sed 's/â/a/'|sed 's/ç/c/'|sed 's/é/e/'|sed 's/è/e/'|sed 's/ê/e/'|sed 's/ë/e/'|sed 's/î/i/'|sed 's/ï/i/'|sed 's/ô/o/'|sed 's/ö/o/'|sed 's/ù/u/'|sed 's/ü/u/'|sed 's/Â/A/'|sed 's/Ç/C/'|sed 's/É/E/'|sed 's/È/E/'|sed 's/Ê/E/'|sed 's/Ë/E/'|sed 's/Î/I/'|sed 's/Ï/I/'|sed 's/Ô/O/'|sed 's/Ö/O/'|sed 's/Ù/U/'|sed 's/Ü/U/' > $file
