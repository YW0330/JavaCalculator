default: run

compile:
	javac -encoding UTF8 Calculator.java

run: compile
	java Calculator

clean:
	rm -f *.class
	rm -f src/*.class
	rm -f win/*.class
