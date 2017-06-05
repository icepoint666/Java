首先编译QrEncode.java:
	javac -encoding utf-8 -cp E:\javajava\core-3.1.0.jar QrEncode,java
接下来编译EncodeMain.java:
	javac -encoding utf-8 EncodeMain.java
运行EncodeMain.java:
	java -classpath E:\javajava\core-3.1.0.jar;E:\javajava\JavaLab\lab09 EncodeMain
然后编译QrDecode.java:
	javac -encoding utf-8 -cp E:\javajava\core-3.1.0.jar;E:\javajava\zxing-javase-2.1.jar QrDecode.java
编译DecodeMain.java:
	javac -encoding utf-8 DecodeMain.java
运行DecodeMain.java:
	java -classpath E:\javajava\core-3.1.0.jar;E:\javajava\zxing-javase-2.1.jar;E:\javajava\JavaLab\lab09 DecodeMain