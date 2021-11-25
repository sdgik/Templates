package gik.sd;

class NumberTheory {
	
	/**
	 * GCD Euclidean algorithm.
	 */
	long gcd(long x, long y) {
		if(x == 0) {
			return y;
		}
		if(y == 0) {
			return x;
		}
		
		return gcd(y, x % y);
	}
	
	/**
	 * Function that checks if positive number is prime.
	 */
	boolean isPrime(long n) {
		if(n <= 1) {
			return false;
		}
		if(n <=3) {
			return true;
		}
		
		if(n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		
		for (long i = 5; i * i <= n; i += 6) {
			if(n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// array for eratosthenes sieve
	boolean[] prime = new boolean[15000105];
	
	/**
	 * Eratosthenes sieve.
	 */
	void sieve(int n) {
		for(int i = 0; i <=n; i++) {
			prime[i] = true;
		}
		
		for(int i = 2; i * i <= n; i++) {
			if(prime[i]) {
				for(int p = i * i; p <= n; p += i) {
					prime[p] = false;
				}
			}
		}
		
		prime[1] = false;
		prime[0] = false;
	}
}
