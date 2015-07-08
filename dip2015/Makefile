# Makefile

exe = run
outputdir = output
objs = main.cpp image.c bmp.c

main: $(objs)
	g++ -Wall -O2 -o $(exe) $(objs) -lm

clean:
	rm -f $(exe)
	rm -f $(outputdir)/*
