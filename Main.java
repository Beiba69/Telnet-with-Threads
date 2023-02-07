package telnetclientwiththreads;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		String host;
		int port;

		if (args.length >= 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);

		} else {
			System.out.println("I NEED TWO ARGUMENTS(HOST) AND (PORT)!!! ");
			return;
		}

		try {
			Socket s = new Socket(host, port);
            Mythread th=new Mythread(s);
            th.start();
			InputStream is = s.getInputStream();
			System.out.println("Type QUIT to quit");

			byte[] byteArr = new byte[1000];
			int num;
			Scanner sc = new Scanner(System.in);
			while ((num = is.read(byteArr)) > 0) {

				System.out.write(byteArr, 0, num);
			}
			sc.close();

			System.out.println("the server has closed the connetion");
			s.close();
			System.exit(0);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
