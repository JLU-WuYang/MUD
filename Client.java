package cn.edu.jlu.ccst.mud;
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Client extends JFrame {
	private JTextArea screen;
	private JTextField input;
	private JButton connection;

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;

	private String ipaddress = "127.0.0.1";
	private int port = 1888;
	private boolean connected = false;

	class MonitorThread extends Thread {
		public MonitorThread(BufferedReader br) {
			this.br = br;
		}

		BufferedReader br;

		@Override
		public void run() {
			while (connected) {
				try {
					String tempString = in.readLine();
					setText(screen, tempString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Client() {
		super("Mud Client");
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		container.add(BorderLayout.CENTER, leftPanel);
		container.add(BorderLayout.EAST, rightPanel);
		leftPanel.setLayout(new BorderLayout());
		screen = new JTextArea();
		screen.setEditable(false);
		screen.setAutoscrolls(true);
		JScrollPane jsp = new  JScrollPane(screen);
		input = new JTextField();
		connection = new JButton("conncetion");
		leftPanel.add(BorderLayout.CENTER, jsp);
		leftPanel.add(BorderLayout.SOUTH, input);
		// rightPanel.setLayout(new FlowLayout());
		rightPanel.add(connection);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar() == '\n' && !input.getText().equals("")) {
					String commond = input.getText();
					setText(screen, commond);
					input.setText("");
					if (connected) {
						try {
							out.write(commond + "\n");
							out.flush();
							if (commond.equals("quit")) {
								connected = false;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		connection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					setText(screen, "connecting " + ipaddress + ":" + port);
					socket = new Socket(ipaddress, port);
					connected = true;
					in = new BufferedReader(new InputStreamReader(socket
							.getInputStream()));
					out = new BufferedWriter(new OutputStreamWriter(socket
							.getOutputStream()));
					new MonitorThread(in).start();

				} catch (Exception e) {
					e.printStackTrace();
					screen.setText(screen.getText() + "链接服务器失败！请重试\n");
					System.exit(1);
				}
			}
		});
	}

        @Override
	public void setDefaultCloseOperation(int arg0) {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (connected) {
			try {
				connected = false;
				socket.close();
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.exit(1);
	}

	public void setText(JTextArea screen, String Message) {
		String[] temp = Message.split("\t");
		for (int i = 0; i < temp.length; i++) {
			screen.setText(screen.getText() + temp[i] + "\n");
			// System.out.print(temp[i]+"\n");
		}
		screen.setCaretPosition(screen.getDocument().getLength());
	}

	public static void main(String[] args) {
		new Client();
		/*
		 * try { Socket socket = new Socket("127.0.0.1", Server.PORT_NUM);
		 * 
		 * BufferedReader in = new BufferedReader(new InputStreamReader(
		 * socket.getInputStream())); BufferedWriter out = new
		 * BufferedWriter(new OutputStreamWriter( socket.getOutputStream()));
		 * 
		 * out.write("How are you!\n"); out.flush();
		 * 
		 * System.out.print("Server sayed:" + in.readLine());
		 * 
		 * 
		 * socket.close(); in.close(); out.close(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}

}
