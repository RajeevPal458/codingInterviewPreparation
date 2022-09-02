
public class Tester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2, 4));
		
	}
	private static int pow(int x, int n) {
		// TODO Auto-generated method stub
		if(n==1)
			return x;
		if(n==0)
			return 1;
		return x*pow(x, n-1);
	}

}
