package lab3Lab6;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayCollectionUser user = new ArrayCollectionUser();
		user.processMethodCall ("a1 ArrayCollection");
 	   user.processMethodCall ("a1 add yes");
 	   user.processMethodCall ("a1 add no");
 	   user.processMethodCall ("a1 add maybe");
 	   user.processMethodCall ("a1 remove no");
 	   System.out.print(user.a1.toString());
	}

}
