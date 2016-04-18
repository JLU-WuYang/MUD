package cn.edu.jlu.ccst.mud;
import java.io.*;
import java.net.*;

public class Server {

	static class ServerThread extends Thread {

		public ServerThread(Socket socket) {
			this.socket = socket;
		}

		Socket socket;

		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				String inputMessage;
				Player player = new Player();
				out.write("欢迎你来到我们的武侠世界！\t");
				out.write("请输入您的用户名：\n");
				out.flush();
				inputMessage = in.readLine();
				player.setId(inputMessage);
				out.write("请输入您游戏中的名称：\n");
				out.flush();
				inputMessage = in.readLine();
				player.setName(inputMessage);
				player.setLocation("yangzhou_guangchang");
				
				MessageManagement.addPlayerChannels(player.getId(), out);
				RoomManagement.cityMap.get(player.getLocation()).addPlayer(player);
				System.out.println(player.getName()+"连线进入世界！");
				
				boolean quit = false;
				while (!quit) {
					inputMessage = in.readLine();
					
					if (inputMessage.equals("quit")) {
						quit = true;
						System.out.println(player.getName()+"离开了这个世界。");
					} 
					UserInput.dealInput(player, inputMessage);
					
				}
				//System.out.println("Client sayed:" + in.readLine());
				MessageManagement.showToPlayer(player, "谢谢你光临我们的世界，再会!\n");
				MessageManagement.removePlayerChannels(player.getId());

				socket.close();
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static int PORT_NUM = 1888;

	static public void main(String[] args) throws IOException {
		RoomManagement.creatRooms();
		ServerSocket serverSocket = new ServerSocket(PORT_NUM);
		for (;;) {
			Socket socket = serverSocket.accept();

			new ServerThread(socket).start();

		}
	}//end main

}//end Server class
