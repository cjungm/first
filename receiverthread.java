import java.net.Socket;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class receiverthread extends Thread{
    Socket socket;

    receiverthread(Socket socket){
        this.socket=socket;
    }

    public void run() {
        try {
            Random rand = new Random();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //소켓에서 넘오는 stream 형태의 문자를 얻은 후 읽어 들어서
            //bufferstream 형태로 in 에 저장.
        PrintWriter out = new PrintWriter( socket.getOutputStream());//String 타입을 stream 형태로 변환하여 전송한다는 뜻

        //String str1 = in.readLine();
        //System.out.println(str1);
       
        while(true) {
            String str = in.readLine();
            System.out.println(str);
            if(str.equals("a")) {
                int n = rand.nextInt(100);
                String str3 = Integer.toString(n);
                String a = str3;
                System.out.println(a);
                out.println(a.getBytes());//write대신 println
            }else if(str.equals("b")) {
                int p = rand.nextInt(100);
                String str2 = Integer.toString(p);
                String aa = str2;
                System.out.println(aa);
                out.println(aa.getBytes());//write대신 println
            }    

        }
        }catch (Exception e) {
            // TODO: handle exception
        }
        finally {
            try {
                socket.close();
                
            }catch (Exception e1) {
                // TODO: handle exception


            }
        }


    }

    
}