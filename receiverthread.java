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
            //���Ͽ��� �ѿ��� stream ������ ���ڸ� ���� �� �о� ��
            //bufferstream ���·� in �� ����.
        PrintWriter out = new PrintWriter( socket.getOutputStream());//String Ÿ���� stream ���·� ��ȯ�Ͽ� �����Ѵٴ� ��

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
                out.println(a.getBytes());//write��� println
            }else if(str.equals("b")) {
                int p = rand.nextInt(100);
                String str2 = Integer.toString(p);
                String aa = str2;
                System.out.println(aa);
                out.println(aa.getBytes());//write��� println
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