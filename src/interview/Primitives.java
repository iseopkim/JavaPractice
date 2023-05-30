package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Primitives {
	
	public static void main(String[] args) throws IOException {
		
		//preCompute();
		//System.exit(0);
		
		List<Integer> list = new ArrayList<>();
		
		BufferedReader bf = new BufferedReader(new FileReader("output.txt"));
		
		String line = bf.readLine();
		while (line != null) {
			list.add(Integer.valueOf(line));
			line = bf.readLine();
		}
		
		Integer[] table = list.toArray(new Integer[0]);
		
		long startTime = System.currentTimeMillis();
		for (long i = 10000000000L; i <= 20000000000L; i++) {
			/*
			long cacheResult = (long)table[ (int)(i & 0xFFFF) ] << 48 | 
					(long)table[ (int)(i >>> 16 & 0xFFFF) ] << 32 | 
					(long)table[ (int)(i >>> 32 & 0xFFFF) ] << 16 | 
					(long)table[ (int)(i >>> 48 & 0xFFFF) ] ;
			*/
			
			long calcResult = flip(i);
			
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			x >>>= 1;
		}
		return numBits;
	}
	
	public static short getParity(long x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x = x >>> 1;
		}
		return result;
	}
	
	public static byte carry(byte x) {
		return (byte) ((x - 1) | x);
	}
	
	public static boolean isPowerOfTwo(long x) {
		return ((x - 1) | ~x) == ~x;
	}

	public static long swap(long x, int i, int j) {
		if (((x >> i) & 1) != ((x >> j) & 1)) {
			x ^= (1L << i);
			x ^= (1L << j);
		}
		return x;
	}
	
	public static long flip(long x) {
		int i = 63;
		for (int j = 0; j <= 31; j++) {
			if (((x >> i) & 1) != ((x >> j) & 1)) {
				x ^= (1L << i);
				x ^= (1L << j);
			}
			i--;
		}
		return x;
	}
	
	public static short flipShort(short x) {
		int i = 15;
		for (int j = 0; j <= 7; j++) {
			if (((x >>> i) & 1) != ((x >>> j) & 1)) {
				x ^= (1 << i);
				x ^= (1 << j);
			}
			i--;
		}
		return x;
	}
	
	public static String shortToBinaryString(short x) {
		StringBuilder sb = new StringBuilder();
		for (int i=15; i >= 0; i--) {
			sb.append((x >>> i) & 1);
		}
		return "0b" + sb.toString();
	}
	
	public static String longToBinaryString(long x) {
		StringBuilder sb = new StringBuilder();
		for (int i=63; i >= 0; i--) {
			sb.append((x >>> i) & 1);
		}
		return "0b" + sb.toString();
	}
	
	public static int flipHalfOfInt(int x) {
		int i = 15;
		for (int j = 0; j <= 7; j++) {
			if (((x >>> i) & 1) != ((x >>> j) & 1)) {
				x ^= (1 << i);
				x ^= (1 << j);
			}
			i--;
		}
		return x;
	}
	
	public static void preCompute() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		
		for (int i = 0; i <= 65534; i++) {
			int result = flipHalfOfInt(i);
			pw.write( result + "\r\n" );
		}

		int result = flipHalfOfInt(65535);
		pw.write( result + "" );
		
		pw.close();
	}
	
	
}

/*

1: 63 - 0 swap
2: 62 - 1 swap

*/