import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSaveExample {

	public static void main(String[] args) {
		
		//Properties()
		//기본값이   없는 빈 Properties   생성		
		Properties prop = new Properties();
		
		
		//Object setProperty​(String key, String value)
		//Key와 value를 셋팅한다		
		prop.setProperty("volume", "50");
		prop.setProperty("last-level", "7");
		prop.setProperty("last-character", "wizard");
		
		
		try {
	
			//void store​(OutputStream out, String comments)
			//OutputStream out에 Key와 value들을   저장한다.   Comments는   속성에 대한 설명			
			prop.store(new FileOutputStream("setting"), "store setting for next playing");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("설정이 파일에 저장되었습니다");
	}

}
