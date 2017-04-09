public class Fibonaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=1;
		int count=10;
		System.out.println(a);
		System.out.println(b);
		for(int i=0;i<count;i++)
		{
			int c=a+b;
			System.out.println(c);
			b=a;
			a=c;
		}
			

	}

}
