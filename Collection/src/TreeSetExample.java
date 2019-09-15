import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		
		//Integer는 Comparable을 구현 , 크기를 알 수 있다. 
		TreeSet<Integer> numbers = new TreeSet<>();
		
		numbers.add(50);
		numbers.add(78);
		numbers.add(5);
		numbers.add(11);
		numbers.add(1);
		numbers.add(99);
		
		//추가하면서 정렬, 출력 하면 정렬된 순서로 출력
		for( int num : numbers)
			System.out.println(num);
		

		//E ceiling​(E e)
		//요소   e와   같거나 ,  큰 요소들 중에서 가장 작은 요소를 반환 그런 요소가 없으면 null반환
		int num = numbers.ceiling(50);
		System.out.println("ceiling(50) ="+ num);
		num = numbers.ceiling(51);
		System.out.println("ceiling(51) ="+ num);
		
		
		//E first() 
		//첫번째(가장   작은) 요소를   반환
		num = numbers.first();
		System.out.println("first() ="+ num);
		
		
		
		//E floor​(E e)
		//요소 e와   같거나, 작은   요소들 중에서 가장 큰 요소를 반환.   그런   요소가 없으면 null   반환
		num = numbers.floor(50);
		System.out.println("floor(50) ="+ num);
		num = numbers.floor(49);
		System.out.println("floor(49) ="+ num);
	
		
		//E  higher​(E e)
		//요소 e보다 큰 요소들   중에서 가장 작은 요소를 반환.   그런   요소가 없으면 null   반환
		num = numbers.higher(50);
		System.out.println("higher(50) ="+ num);

		
		//E last()
		//마지막( 가장   큰) 요소를   반환
		num = numbers.last();
		System.out.println("last() ="+ num);

		
		//E lower​(E e)
		//요소 e보다 작은   요소들 중에서 가장 큰 요소를 반환.   그런   요소가 없으면 null   반환
		num = numbers.lower(50);
		System.out.println("lower(50) ="+ num);
		
		
		//Iterator<E> descendingIterator()
		//내림   차순으로 순환하는 iterator를   반환한다.
		Iterator<Integer> desItr = numbers.descendingIterator();
		
		while( desItr.hasNext())
			System.out.println(desItr.next());
		
		
		
		//NavigableSet<E>  descendingSet()
		//순서가   역순으로 정렬된 set을   반환한다.
		Set<Integer> desSet = numbers.descendingSet();
		
		
		for( int number : desSet)
			System.out.println(number);
		
		
		//E pollFirst()
		//첫   번째(가장   작은) 요소를   반환하고, 그   요소를 삭제 한다.
		num = numbers.pollFirst();
		System.out.println("pollFirst() ="+ num);

		for( int number : numbers)
			System.out.println(number);		
		
		//아까 생성했던 역순으로 만든 set의 상태는 어떨까?
		//삭제한 결과가 반영되었을까?
		for( int number : desSet)
			System.out.println(number);		
		
		
		//E pollLast()
		//마지막   (가장   큰) 요소를   반환하고 그 요소를 삭제한다.
		num = numbers.pollLast();
		System.out.println("pollLast() ="+ num);
	
		System.out.println(Arrays.toString(numbers.toArray()));
		
		
		//SortedSet<E> headSet​(E toElement)
		//toElement보다   작은 요소로 구성된 set을   반환한다.  [exclusive : toElement 미포함]
	
		Set<Integer> headSet = numbers.headSet(50);
		System.out.println("headSet(50)="+Arrays.toString(headSet.toArray()));
		
		
		//NavigableSet<E> headSet​(E toElement,   boolean inclusive)
		//toElement보다   작은 요소로 구성된 set을   반환한다.  [inclusive : toElement 포함   여부 결정]
		Set<Integer> headSetInclusive = numbers.headSet(50,true);
		System.out.println("headSet(50,true)="+Arrays.toString(headSetInclusive.toArray()));
	
		
		//NavigableSet<E> subSet​(E fromElement, boolean fromInclusive,
		// E toElement, boolean toInclusive)
		//fromElement부터 toElement까지로   구성된 set을   반환한다. [toInclusive : toElement 포함   여부 결정]
		Set<Integer> subSetInclusive = numbers.subSet(5, true, 50,true);
		System.out.println("subSet(5, true, 50,true)="+Arrays.toString(subSetInclusive.toArray()));

		Set<Integer> subSetExclusive = numbers.subSet(5, false, 50,false);
		System.out.println("subSet(5, false, 50,false)="+Arrays.toString(subSetExclusive.toArray()));
		
		
		//SortedSet<E> subSet​(E fromElement, E toElement)
		//fromElement부터 toElement까지로   구성된 set을   반환한다. [toElement :   exclusive]
		Set<Integer> subSet = numbers.subSet(5, 50);
		System.out.println("subSet(5, 50)="+Arrays.toString(subSet.toArray()));

		
		//SortedSet<E> tailSet​(E fromElement)
		//fromElement보다   크거나 같은 요소로 구성된 set을   반환한다.  [tailSet(fromElement,   true) 와   같다]
		Set<Integer> tailSet = numbers.tailSet(11);
		System.out.println("tailSet(11)="+Arrays.toString(tailSet.toArray()));
	
		
		//NavigableSet<E> tailSet​(E fromElement,   boolean inclusive)
		//fromElement보다   크거나 같은 요소로 구성된 set을   반환한다.  [ inclusive : fromElement 포함   여부 결정]
		Set<Integer> tailSetExclusive = numbers.tailSet(11,false);
		System.out.println("tailSet(11,false)="+Arrays.toString(tailSetExclusive.toArray()));

		//원래의 treeSet출력
		System.out.println(Arrays.toString(numbers.toArray()));

		//tailSet에서 삭제하면 원래의 tree에서는 어떻게 될까?
		tailSetExclusive.remove(50);
		
		//삭제 후 원래의 treeSet 결과 확인
		System.out.println(Arrays.toString(numbers.toArray()));
		
		//subSet과 Original tree , 서로 양쪽에게 영향을 준다.
	}
}
