# cron-parser-cli
Command line application to parse a cron string and expands each field to show the times at which it will run.

## Instructions to run the cli
```
$ ./cronparser.sh "*/15 0 1,15 * 1-5 /usr/bin/find"
```
## Expected output for the input given avobe
```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```