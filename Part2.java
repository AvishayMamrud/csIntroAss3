/*
I, Avishay Mamrud (315746560), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
class Part2{
	
    public static boolean change(int [] coins, int n){
        boolean ans = false;
        //Task 2.1
        ans = change(coins, n, 0);
        return ans;
    }

    public static boolean change(int [] coins, int n,int index){
        boolean ans = false;
        if(n==0) {
        	ans=true;
        }else if(n>0 & index<coins.length) {
        	ans = change(coins,n-coins[index],index)||change(coins,n,index+1);
        }
    	return ans;
    }

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        boolean ans = false;
        //Task 2.2
        ans = changeLimited(coins,n,0,numOfCoinsToUse);
        return ans;
    }

    public static boolean changeLimited(int[] coins, int n,int index, int numOfCoinsToUse){
    	boolean ans = false;
    	if(n==0 & numOfCoinsToUse==0) {
        	ans=true;
        }else if(n>0 & index<coins.length & numOfCoinsToUse>0) {
        	ans = changeLimited(coins,n-coins[index],index,numOfCoinsToUse-1)||
        			changeLimited(coins,n,index+1,numOfCoinsToUse);
        }
    	return ans;
    }

    
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        //Task 2.3
    	printChangeLimited(coins, n,0, numOfCoinsToUse, "");
    }
    
    public static boolean printChangeLimited(int[] coins, int n, int index, int numOfCoinsToUse,String str){
    	boolean ans = false;
    	if(n==0 & numOfCoinsToUse==0) {
    		ans=true;
    		System.out.println(str.substring(1));
    	}else if(n>0 & index<coins.length & numOfCoinsToUse>0) {
        	ans = printChangeLimited(coins,n-coins[index],index,numOfCoinsToUse-1,str+","+coins[index])||
        			printChangeLimited(coins,n,index+1,numOfCoinsToUse,str);
        }
    	return ans;
    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        int ans = 0;
        //Task 2.4
        ans = countChangeLimited(coins, n, 0, numOfCoinsToUse);
        return ans;
    }
    
    public static int countChangeLimited(int[] coins, int n, int index, int numOfCoinsToUse){
    	//not good. must be fixed
    	int ans=0;
    	if(n==0 & numOfCoinsToUse==0) {
    		ans=1;
    	}else if(n>0 & index<coins.length & numOfCoinsToUse>0) {
        	ans = countChangeLimited(coins,n-coins[index],index,numOfCoinsToUse-1)+
        			countChangeLimited(coins,n,index+1,numOfCoinsToUse);
        }
    	return ans;
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        //Task 2.5
    	printAllChangeLimited(coins, n, 0, numOfCoinsToUse, "");
    }

    public static void printAllChangeLimited(int[] coins, int n, int index, int numOfCoinsToUse, String str) {
		if(n==0 & numOfCoinsToUse==0) {
			System.out.println(str.substring(1));
		}else if(n>0 & index<coins.length & numOfCoinsToUse>0) {
	    	printAllChangeLimited(coins,n-coins[index],index,numOfCoinsToUse-1,str+","+coins[index]);
	    	printAllChangeLimited(coins,n,index+1,numOfCoinsToUse,str);
	    }
    }
    
    public static int changeInCuba(int cuc){
        int ans = 0;
        //Task 2.6
        int[] cucArr = {3,9,15,30,60,150,300};
        int[] cupArr = {1,3,5,10,20,50,100};
		ans = changeInCuba(cuc*3, cucArr, cupArr, 0, 0);
        return ans;
    }
    
    public static int changeInCuba(int cuc, int[] cucArr, int[]cupArr, int indexCUC, int indexCUP){
    	int ans = 0;
    	if(cuc==0) {
    		ans=1;
    	}else if(cuc>0 & indexCUC>=cucArr.length & indexCUP<cupArr.length){
    		ans = changeInCuba(cuc-cupArr[indexCUP], cucArr, cupArr, indexCUC, indexCUP)+
    				changeInCuba(cuc, cucArr, cupArr, indexCUC, indexCUP+1);
    	}else if(cuc>0 & indexCUC<cucArr.length) {
    		ans = changeInCuba(cuc-cucArr[indexCUC], cucArr, cupArr, indexCUC, indexCUP)+
    				changeInCuba(cuc, cucArr, cupArr, indexCUC+1, indexCUP);
    	}
    	return ans;
    }

    public static void main(String[] args){
        //tests for part 2.1
    	
         int []changee1 = {1,5,10};
         int n = 7;
         System.out.println("change test 1:expected true, got " + change(changee1,n));
         int []cchange2 = {2,10,20,100};
         n = 15;
         System.out.println("change test 2: expected false, got " + change(cchange2,n)+"\n");

        // tests for part 2.2
         int []changeLimited1 = {1,12,17,19};
         n = 20;
         int numOfCoinsToUse = 2;
         System.out.println("ChangeLimited test 1: expected true, got " + changeLimited(changeLimited1,n ,numOfCoinsToUse));
         int []changeLimited2 = {5,7,12};
         n = 8;
         numOfCoinsToUse = 2;
         System.out.println("ChangeLimited test 2: expected false, got " + changeLimited(changeLimited2,n ,numOfCoinsToUse));
         int []changeLimited3 = {1,7,12,10};
         n = 10;
         numOfCoinsToUse = 5;
         System.out.println("ChangeLimited test 3: expected false, got " + changeLimited(changeLimited3,n ,numOfCoinsToUse)+"\n");
       
        // tests for part 2.3
         int []printChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("PrintChangeLimited test 1: expected 2,2 or 1,3 , got ");
         printChangeLimited(printChangeLimited1,n ,numOfCoinsToUse);
         int []printChangeLimited2 = {1,7,12};
         n = 10;
         numOfCoinsToUse = 5;
         System.out.println("PrintChangeLimited test 2: expected printing nothing, got ");
         printChangeLimited(printChangeLimited2,n ,numOfCoinsToUse);
         System.out.println("");

        //tests for part 2.4
         int []countChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("CountChangeLimited test 1: expected 2, got " + countChangeLimited(countChangeLimited1,n ,numOfCoinsToUse));
         int []countChangeLimited2 = {5,10,20,50,100};
         n = 100;
         numOfCoinsToUse = 5;
         System.out.println("CountChangeLimited test 2: expected 3, got " + countChangeLimited(countChangeLimited2,n ,numOfCoinsToUse));
         int []countChangeLimited3 ={5,10,50};
         n = 65;
         numOfCoinsToUse = 2;
         System.out.println("CountChangeLimited test 3: expected 0, got " + countChangeLimited(countChangeLimited3,n ,numOfCoinsToUse)+"\n");
        
        //tests for part 2.5
         int []printAllChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("PrintAllChangeLimited test 1: expected : \n 2,2 \n 1,3 \n or \n 1,3 \n 2,2 , got " );
         printAllChangeLimited(printAllChangeLimited1,n ,numOfCoinsToUse);
         int []printAllChangeLimited2 = {1,5,10,20};
         n = 13;
         numOfCoinsToUse = 2;
         System.out.println("PrintAllChangeLimited  test 2: expected printing nothing, got ");
         printAllChangeLimited(printAllChangeLimited2,n ,numOfCoinsToUse);
         System.out.println("");

        //tests for part 2.6
         System.out.println("ChangeInCuba 1");
         System.out.println(changeInCuba(1));
         System.out.println("ChangeInCuba 2");
         System.out.println(changeInCuba(2));
         System.out.println("ChangeInCuba 20");
         System.out.println(changeInCuba(20));
         System.out.println("ChangeInCuba 50");
         System.out.println(changeInCuba(50));
    }
}
