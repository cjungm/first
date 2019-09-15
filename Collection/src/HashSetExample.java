import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {

		HashSet<String> phoneNumberSet = new HashSet<>();
		
		phoneNumberSet.add("010-7243-9001");
		phoneNumberSet.add("010-6283-9001");
		phoneNumberSet.add("010-3129-9001");
		phoneNumberSet.add("010-989-9007");
		
		//추가된 순서와 상관없이 가져오게 됨
		Iterator<String> itr = phoneNumberSet.iterator();
		
		while( itr.hasNext())
			System.out.println(itr.next());
		
	
		boolean result = phoneNumberSet.add("010-989-9007");
		System.out.println("중복 자료 add시 result= "+ result);

		
	}

}
