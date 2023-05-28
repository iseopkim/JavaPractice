package interview;

public class Primitives {
	
	public static void main(String[] args) {
		
		System.out.println(isPowerOfTwo(258));
		
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

	public static short swap(short x) {
		return x;
	}
	
	public static short fastSwap(short x) {
		return x;
	}
	
}

/*

short는 16bit

0000 0000 0000 0000

*/