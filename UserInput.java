package cn.edu.jlu.ccst.mud;
public class UserInput {
	public static void dealInput(Player player, String inputMessage) {
		/*
		 * 可以处理的命令 l,look e,east,w,west,n,north,s,south,
		 */

		String[] inputs = inputMessage.split(" ");
		if (inputs[0].equals("l") || inputs[0].equals("look")){
			
				player.look("room");
				return;
                }	
		if (inputs[0].equals("quit")) {
			player.quit();
			return;
		}
		if (inputs[0].equals("e") || inputs[0].equals("east")) {
			player.move(CommonContent.DIRECTION.EAST);
			return;
		}
		if (inputs[0].equals("w") || inputs[0].equals("west")) {
			player.move(CommonContent.DIRECTION.WEST);
			return;
		}
		if (inputs[0].equals("s") || inputs[0].equals("south")) {
			player.move(CommonContent.DIRECTION.SOUTH);
			return;
		}
		if (inputs[0].equals("n") || inputs[0].equals("north")) {
			player.move(CommonContent.DIRECTION.NORTH);
			return;
		}
		if (inputs[0].equals("ne") || inputs[0].equals("northeast")) {
			player.move(CommonContent.DIRECTION.NORTHEAST);
			return;
		}
		if (inputs[0].equals("nw") || inputs[0].equals("northwest")) {
			player.move(CommonContent.DIRECTION.NORTHWEST);
			return;
		}
		if (inputs[0].equals("se") || inputs[0].equals("southeast")) {
			player.move(CommonContent.DIRECTION.SOUTHEAST);
			return;
		}
		if (inputs[0].equals("sw") || inputs[0].equals("southwest")) {
			player.move(CommonContent.DIRECTION.SOUTHWEST);
			return;
		}
		if (inputs[0].equals("u") || inputs[0].equals("up")) {
			player.move(CommonContent.DIRECTION.UP);
			return;
		}
		if (inputs[0].equals("d") || inputs[0].equals("down")) {
			player.move(CommonContent.DIRECTION.DOWN);
			return;
		}
		
		MessageManagement.showToPlayer(player, "未知命令\n");
	}
}
