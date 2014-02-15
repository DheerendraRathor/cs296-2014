#! /bin/bash
cut -f1 -d' ' ~/.bash_history | sort | uniq -c | sort -n | tail | sort -n -r
