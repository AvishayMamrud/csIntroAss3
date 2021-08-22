/*
I, Avishay Mamrud (315746560), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
import java.math.BigInteger;
import java.util.Random;

class Part1{

    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        //Task 1.1
        BigInteger unit = BigInteger.ONE;       
        BigInteger indexCounter = new BigInteger("1");       
    	while(indexCounter.compareTo(n)<0) {
    		sum = sum.add(indexCounter);
    		indexCounter = indexCounter.add(unit);
    	}
        return sum;
    }

    public static void printRandoms(int n){
        //Task 1.2
    	Random randy = new Random();
    	for(int i=0;i<n;i=i+1) {
    		System.out.println(randy.nextInt());
    	}
    }

    public static boolean isPrime(BigInteger n){
        boolean ans= true;
        //Task 1.3
        BigInteger unit = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger counter = new BigInteger("2");
        while(ans & (counter.multiply(counter)).compareTo(n)<=0) {
        	ans = !(n.mod(counter).equals(zero));
        	counter = counter.add(unit);
        }
        return ans;
    }

    public static BigInteger randomPrime(int n){
    	
        BigInteger randBig = new BigInteger("0");
        //Task 1.4
        boolean found = false;
        Random randy = new Random();
        while (!found){
	        BigInteger randyx = new BigInteger(n, randy);
	        randyx = randyx.nextProbablePrime();
	        if (randyx.bitLength()<=n && isPrime(randyx)) {//checks at first if it is in the range to make it quicker
	        	randBig = randyx;
	        	found = true;
	        }
        }
        
        return randBig;
    }

    public static void main(String[] args) {
        //test for part 1.1
    	
        BigInteger biMinus = new BigInteger("-10");
        System.out.println("sumSmaller test expected 0 - got " + sumSmaller(biMinus));
    
        BigInteger bi0 = new BigInteger("0");
        System.out.println("sumSmaller test expected 0 - got " + sumSmaller(bi0));
    
        BigInteger bi7 = new BigInteger("7");
        System.out.println("sumSmaller test expected 21 - got " + sumSmaller(bi7));
    
    	BigInteger biHigh = new BigInteger("99999");
        System.out.println("sumSmaller test expected 4999850001 - got " + sumSmaller(biHigh)+"\n");
        
    	
        //test for part 1.2
    	
         System.out.println("printRandoms 5");
         printRandoms(5);
         System.out.println("");
		
    	
        //test for part 1.3
    	
         BigInteger biVeryHigh = new BigInteger("13");
         System.out.println("isPrime test expectet true got " + isPrime(biVeryHigh));
         biVeryHigh = new BigInteger("2147521921");
         System.out.println(("isPrime test expectet false got " +  isPrime(biVeryHigh))+"\n");
        
    	
        //test for part 1.4
         System.out.println("randomPrime test");
         System.out.println(randomPrime(20));
         System.out.println(randomPrime(40));
    }
}