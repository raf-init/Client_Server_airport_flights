/*
 * Meso tis class Main dimiourgoume 3 threads sigrafeon
 * ke 3 threads anagnoston
 */
public class Main {

	public static void main(String[] args) {
		// create 3 writer type threads  
		WriterThread w1 = new WriterThread();
		w1.start();
		WriterThread w2 = new WriterThread();
		w2.start();
		WriterThread w3 = new WriterThread();
		w3.start();

		// create 3 reader type threads
		ReaderThread r1 = new ReaderThread();
		r1.start();
		ReaderThread r2 = new ReaderThread();
		r2.start();
		ReaderThread r3 = new ReaderThread();
		r3.start();
	}

}
