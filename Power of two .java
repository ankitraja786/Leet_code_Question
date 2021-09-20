public boolean isPowerOfTwo(int n) {
		if(n == 0)
			return false;
		double x = 0;
		boolean ans = false;
		x = (int)(Math.log(n) / Math.log(2));
		if(Math.pow(2,x) == n)
			ans = true;
		return ans;
	}
}