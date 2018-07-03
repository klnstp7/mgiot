package test;

import com.migen.myiot.enums.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Administrator on 2018/6/3.
 */
public class SocketClient {
        public static void main(String[] args) throws  Exception
        {

/*byte[] bytes= BytesUtil.hexStringToBytes(hex);
            StringBuffer sb = new StringBuffer(bytes.length);
            for (int i = 0; i < bytes.length; ++ i) {
                if (bytes[i] < 0) throw new IllegalArgumentException();
                sb.append((char) bytes[i]);
            }
         String   result=sb.toString().replace("\r\n","");
            int i=0;*/
            //  DealMessageService.dealInstallYield(1,null,"010302869f9a4c");
          //System.out.println(Integer.parseInt("52555")<=Short.MAX_VALUE);
            /*String md5_pwd = new MD5Util().getMD5ofStr("20180622");

            int i=0;*/
           String result= "010304e36000164c67";



            //int distance= Utils.calDistanceInMeter(23.01042,113.871658,23.0114,113.871529);

        // startSocketCli();
        }

        public static void startSocketCli()
        {
            Socket socket = null;
            BufferedReader br = null;
		/*PrintWriter pw = null;*/
            try
            {
                // 客户端socket指定服务器的地址和端口号
                socket = new Socket(Constants.TEST_IP, Constants.SOCKETSERV_PORT);

                // 同服务器原理一样
                br = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
			/*System.out.println("Socket client1 =" + socket);
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			System.out.println("Socket client2 =" + socket);*/

                PrintStream out = new PrintStream(socket.getOutputStream());

                out.write("+SN:210118049999".getBytes() );
                out.flush();

              /*  out.write("+POSITION:113.871529,23.011406#OK".getBytes() );
                out.flush();
*/

                while(true)
                {
				/*String strTmp = String.format("client3 howdy = %d", i);
				System.out.println("Socket client3 =" + socket + ", " + strTmp);
				pw.write(strTmp);
				System.out.println("Socket client4 =" + socket);
				pw.flush();
				System.out.println("Socket client5 =" + socket);*/
                    byte[] byt = new byte[4096];
                    socket.getInputStream().read(byt);
                    if(byt.length>0){
                        System.out.println("Receive");
                    }
                    //System.out.println("Socket client6 =" + socket + ", " + str);
                }


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}
