import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> nameList = new LinkedList<>();
		
		
		//boolean add​(E e)
		//리스트의   마지막 부분에 요소를 추가한다
		nameList.add("오영규");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		//void addFirst​(E e)
		//리스트의   첫 부분에 요소를 추가한다.
		nameList.addFirst("서민규");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		//void addLast​(E e)
		//리스트의   마지막 부분에 요소를 추가한다.
		nameList.addLast("박미경");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		//boolean offer​(E e)
		//리스트의   마지막 부분에 요소를 추가한다.   
		nameList.offer("오준환");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		
		//boolean offerFirst​(E e)
		//리스트의   첫 부분에 요소를 추가한다
		nameList.offerFirst("최경민");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		//boolean offerLast​(E e)
		//리스트의   마지막 부분에 요소를 추가한다.   
		nameList.offerLast("김태석");
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		//void push​(E e)
		//리스트를   stack을   간주 요소를 push한다.  ( = addFirst )
		nameList.push("염수홍");
		System.out.println(Arrays.toString(nameList.toArray()));
	
		
		
		//E getFirst()
		//리스트의   첫 부분의 요소를 반환한다 (리스트에서   삭제하지 않는다) 요소가   없을 시 NoSuchElementException   발생
		String name = nameList.getFirst();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		
		//E getLast()
		//리스트의   마지막 요소를 반환한다 (리스트에서   삭제하지 않는다) 요소가   없을 시 NoSuchElementException   발생
		name = nameList.getLast();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));
		
		
		//E peek()
		//리스트의   첫 부분의 요소를 반환한다 (리스트에서   삭제하지 않는다) 요소가   없을 시 null   반환
		name = nameList.peek();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		
		//E peekFirst()
		//리스트의   첫 부분의 요소를 반환한다 (리스트에서   삭제하지 않는다) 요소가   없을 시 null   반환
		name = nameList.peekFirst();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		
		//E peekLast()
		//리스트의   마지막 요소를 반환한다 (리스트에서   삭제하지 않는다) 요소가   없을 시 null   반환
		name = nameList.peekLast();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		
		//E poll()
		//리스트의   처음 요소를 반환하며 삭제한다.   (없을   시 null   반환)
		name = nameList.poll();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		
		//E pollFirst()
		//리스트의   첫 번째 요소를 반환하며 삭제한다.   (없을   시 null   반환)
		name = nameList.pollFirst();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));
	
		
		//E pollLast()
		//리스트의   마지막 요소를 반환하며 삭제한다.   (없을   시 null   반환)
		name = nameList.pollLast();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		//E pop()
		//리스트를   stack을   간주 요소를 pop한다.  ( = removeFirst )
		name = nameList.pop();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		//E removeFirst()
		//리스트의   첫 번째 요소를 반환하며 삭제한다.   (요소가   없을 시 NoSuchElementException   발생)
		name = nameList.removeFirst();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));

		
		//E removeLast()
		//리스트의   마지막  요소를 반환하며 삭제한다. (요소가   없을 시 NoSuchElementException   발생)
		name = nameList.removeLast();
		System.out.println(name);
		System.out.println(Arrays.toString(nameList.toArray()));
		
		System.out.println(nameList.remove());
		
		//NoSuchElementException  발생
//		System.out.println(nameList.remove());
		
	}

}
