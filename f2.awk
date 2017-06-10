{ l=length($1);
        l2=int(l/2);
        a=substr($1,0,1);
        b=substr($1,l2,1);
        c=substr($1,l,1);
        s=ord(a)+ord(b)+ord(c);
#       printf "%s %c %c %c %f %d\n", $1, a, b, c, s, int(s % 10);
        printf "%d\n", int(s % 10);
}
