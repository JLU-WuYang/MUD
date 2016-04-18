package cn.edu.jlu.ccst.mud;
import java.io.*;
import java.util.*;
public class MessageManagement {
	static HashMap<String,BufferedWriter> playerChannels = new HashMap<String,BufferedWriter>();
	
	public static void showToPlayer(Player player, String message){
		BufferedWriter out = (BufferedWriter)playerChannels.get(player.getId());
		try {
			out.write(message+"\n");
			out.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void addPlayerChannels(String playerId,BufferedWriter bw){
		playerChannels.put(playerId, bw);
	}
	public static void removePlayerChannels(String playerId){
		playerChannels.remove(playerId);
	}
}
