package telnetclientwiththreads;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Mythread extends Thread {
	Socket so;

	public Mythread(Socket so) {
		this.so = so;
	}

	public void run() {

		InputStream is;
		try {
			is = so.getInputStream();

			OutputStream os = so.getOutputStream();
			String quit = "";

			Scanner sc = new Scanner(System.in);

			while (sc.hasNext()) {
				quit = sc.nextLine() + "\n";
				if (quit.equals("QUIT\n")) {
					System.out.println("you have exited");
					break;
				}
				os.write(quit.getBytes());
				os.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You exit the thread");

	}

}