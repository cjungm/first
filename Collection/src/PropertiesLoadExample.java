import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoadExample {

	public static void main(String[] args) {
		
		
		//Properties()
		//기본값이   없는 빈 Properties   생성		
		Properties prop = new Properties();

		try {
			
			//void load​(InputStream inStream)
			//전달한   InputSream inStream에서 properties를  읽어온다. 			
			prop.load(new FileInputStream("setting"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("설정을 파일에서 로드하였습니다");
		
		System.out.println("모든 설정을 출력");
		//Set<String> stringPropertyNames()
		//Key들의 집합을 Set<String> 형태로   반환		
		Set<String> keySet = prop.stringPropertyNames();
		for(String key : keySet ) {
			System.out.println(key + "=" + prop.getProperty(key));
		
		}
		System.out.println("===출력 완료===");
		
		//String getProperty​(String key)
		//key   값으로 속성을 찾아 반환한다		
		String volume = prop.getProperty("volume");
		String lastLevel = prop.getProperty("last-level");
		String lastCharacter = prop.getProperty("last-character");
		

		System.out.println("volume =" + volume);
		System.out.println("last-level =" + lastLevel);
		System.out.println("last-character =" + lastCharacter);
		

		
	}

}
