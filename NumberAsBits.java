/*
I, <name> (<ID>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
public class NumberAsBits {

    private Bit[] bits;

    public NumberAsBits(Bit[] bits){
        //Task 3.4
    	if(bits==null) {
    		throw new IllegalArgumentException("I want an array with stuff in it!!");
    	}
    	for(Bit a: bits) {
    		if(a==null) {
        		throw new IllegalArgumentException("fill the array with non-null bit arguments. please.");
    		}
    	}
		this.bits = new Bit[bits.length];
    	for(int i=0;i<bits.length;i=i+1) {
    		this.bits[i] = new Bit(bits[i].toInt() == 1);
    	}
    }

    public String toString() { 
        String ans ="";
        //Task 3.5
        int n = 1;//start with the value 2^0
        int result = 0;
        for(int i=0;i<bits.length;i=i+1) {
        	result=result+(bits[bits.length-i-1].toInt()*n);
        	n=n*2;//now n=2^i
        }
        ans = String.valueOf(result);//casting result to string
        return ans;
    }

    public String base2() {
        String ans ="";
        //Task 3.6
        for(int i=0;i<bits.length;i=i+1) {
        	ans = ans + bits[i].toInt();
        }
        return ans;
    }
}

