import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListExample {

	public static void main(String[] args) {

		//[생성자]
		//ArrayList()
		// 빈   리스트를 만든다. 이때   초기 용량은 10이다.
		ArrayList<String> salariedNames = new ArrayList<>();
		

		//ArrayList​(int initialCapacity)
		//지정한   용량으로 ArrayList를   만든다 		
		ArrayList<String> employeeNames = new ArrayList<>(100);
		
		
		/*
		 *  Collection Interface
		 *  아래 메서드는 모든 Collection class에 동일하게 적용 가능하다
		 *  
		 */
		
		//boolean isEmpty()
		//비어   있는지 결과 리턴
		
		System.out.println("[salariedNames] 비어있는가? :" + salariedNames.isEmpty());

		System.out.println("[employeeNames] 비어있는가? :" + employeeNames.isEmpty());

		
		//boolean add​(E e)
		//요소 추가
		salariedNames.add("오영규");
		salariedNames.add("김세훈");
		salariedNames.add("이영훈");
		salariedNames.add("최세림");

		//int size()
		//총   요소의 개수
		System.out.println("[salariedNames] size :" + salariedNames.size());

		System.out.println("[employeeNames] size :" + employeeNames.size());
		
		
		
		//boolean addAll​(Collection<? extends E> c)
		//전달된   collection   c의 모든   요소를 추가함.
		employeeNames.addAll( salariedNames );		
		System.out.println("[employeeNames] size :" + employeeNames.size());
		
		
		
		//boolean contains​(Object o)
		//명시한   객체가 있는지 확인
		System.out.println("[employeeNames] contains(\"오영규\") :" 
		+ employeeNames.contains("오영규"));
		
		
	
		//boolean containsAll​(Collection<?> c)
		//전달된   collection c의   모든 요소가 포함되었을 경우 true   반환 
		System.out.println("[employeeNames] containsAll(salariedNames) :" 
		+ employeeNames.containsAll(salariedNames));
		
		
		//하나씩 자료 읽어오기
		
		//방법1 : Iterator 이용			
		//Iterator<T> iterator()
		//Iterator를   반환한다
		Iterator<String> itr = salariedNames.iterator();
		
		
		//[Iterator] 
		// boolean hasNext()
		//다음에   가져올 자료가 있는지 확인한다 ( 가져올 자료가 있다 : true 없다 : false )		
		while( itr.hasNext() ) {
				
			//[Iterator]
			//E next()  
			//저장된 다음 자료를 가져온다			
			String name = itr.next();
			System.out.println("[Itr]salariedNames : "+ name);
		}
		
		//iterator는 모두 읽고 난뒤 다시 처음부터 읽을 수 없다 [1회용] 
		//다시 읽을 때는 새로 얻어와야 한다
		//itr.next();
		
		itr = salariedNames.iterator();
		while( itr.hasNext() ) {
			
			//[Iterator]
			//E next()  
			//저장된 다음 자료를 가져온다			
			String name = itr.next();
			
			if( name.contains("림")) {
				//[Iterator]
				//void remove()
				//가져온   자료를 삭제한다
				itr.remove();				
			}
				
		}		
		
		
		//방법2 : 향상된 for문 이용
		for( String name : salariedNames) {
			System.out.println("[EnhancedFor]salariedNames : "+ name);
		}
		
		//향상된 for 문과 Iterator의 차이
		//Iterator  : 요소를 지울 수 있다.
		//향상된 for문 : 요소를 지울 수 없다.		
		
		
		
		//boolean retainAll​(Collection<?> c)
		//전달된   collection   c에   포함된 요소만을 남기고 모두 제거.   변화가   생겼을 경우 true   반환 
		employeeNames.retainAll(salariedNames);
		
		for(String name : employeeNames)
			System.out.println("[employeeNames]:"+name);
		
		
		//boolean remove​(Object o)
		//특정   객체를 제거
		salariedNames.remove("오영규");
		
		
//		Object[] toArray​()
//		모든 요소를 Object 객체 배열로 return함
		Object[] objArray = salariedNames.toArray();
		System.out.println("[salariedNames]삭제결과 확인(오영규):"+ Arrays.toString(objArray));
		

		//boolean removeAll​(Collection<?> c)
		//다른 collection c의 각   요소에 대해, 해당   요소 존재할   경우 해당 요소 삭제
		employeeNames.removeAll(salariedNames);
		System.out.println("[employeeNames]삭제결과 확인(removeAll):"
				+ Arrays.toString( employeeNames.toArray()));
		
		
		//void  clear()
		//모든   요소를 제거
		salariedNames.clear();
		System.out.println("[salariedNames]삭제결과 확인(clear):"
				+ Arrays.toString( salariedNames.toArray()));
		
		System.out.println("[salariedNames]삭제결과 확인(size):"
				+ salariedNames.size()) ;
		
		
		/*
		 *  List Interface
		 *  아래 메서드는 모든 List class에 동일하게 적용 가능하다
		 *  
		 */		
		
		//void add​(int index, E element) 
		//index 위치에 요소 추가		
		salariedNames.add(0,"오영규");
		salariedNames.add(0,"김세훈");
		salariedNames.add(0,"이영훈");
		salariedNames.add(0,"최세림");
		salariedNames.add(0,"최세림");

		
		//E get​(int index)
		//index 위치의   요소를 반환
		for(int i = 0 ; i < salariedNames.size() ; i ++) {
			System.out.printf("[salariedNames]index= %d name=%s \n",
											i, salariedNames.get(i));
		}
		
		
		//int indexOf​(Object o)
		//전달된   객체의 위치 index를   반환 만약 없을 경우 -1   반환		
		int index = salariedNames.indexOf("최세림");
		System.out.println("[salariedNames] index of 최세림 : "+index);

		//int lastIndexOf​(Object o)
		//전달된 객체의 마지막 요소의   index를   반환.   만약   없을 경우 -1   반환
		index = salariedNames.lastIndexOf("최세림");
		System.out.println("[salariedNames] last index of 최세림 : "+index);

		
		//E set​(int index, E element)
		//Index   위치의 요소를 전달하는  element요소로   바꿈
		salariedNames.set(1, "최민지");
		System.out.println( Arrays.toString(salariedNames.toArray()));
		
		
		//ListIterator<E> listIterator()
		//List에   특화된 ListIterator를   반환 (  previous()로   이전 자료 가져옴) 		
		ListIterator<String> listItr = salariedNames.listIterator();
		System.out.println("== print by [hasNext, next] ===");
		while( listItr.hasNext())
			System.out.println( listItr.next());		
		System.out.println("===  end of print ====");

		System.out.println("== print by [hasPrevious, previous] ===");		
		while( listItr.hasPrevious())
			System.out.println( listItr.previous());
		System.out.println("===  end of print [hasPrevious, previous]====");
	
		
		//E remove​(int index)
		//Index   위치의 요소를 삭제 (   우측   요소들은 모두 좌측으로 이동,   빈   영역 메꿈)
		salariedNames.remove("최민지");
		
		
		for(int i = 0 ; i < salariedNames.size() ; i ++) {
			System.out.printf("[salariedNames]index= %d name=%s \n",
											i, salariedNames.get(i));
		}
		
		
	}

}
