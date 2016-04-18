package cn.edu.jlu.ccst.mud;
import java.util.*;

public class Room {

	private HashMap<CommonContent.DIRECTION, Room> neighbor = new HashMap<CommonContent.DIRECTION, Room>();

	void setRoom(CommonContent.DIRECTION d, Room r) {
		neighbor.put(d, r);
		// assert r.getRoom(d) == this;
	}

	public Room getRoom(CommonContent.DIRECTION d) {
		return neighbor.get(d);

	}

	private String roomDescription;
	private String roomLooking;
	private String roomId;
	private String roomName;
	private HashMap<String, Player> playerList = new HashMap<String, Player>();

	public void exist(Player player, CommonContent.DIRECTION direction) {
		playerList.remove(player.getId());
		Collection<Player> c = playerList.values();
		for (Iterator<Player> it = c.iterator(); it.hasNext();) {
			Player tempPlayer = (Player) it.next();
			MessageManagement.showToPlayer(tempPlayer, player.getName()
					+ "向" + StaticFunctions.getDirection(direction) + "面离开了。");
		}

	}

	public void enter(Player player, CommonContent.DIRECTION direction) {
		Collection<Player> c = playerList.values();
		for (Iterator<Player> it = c.iterator(); it.hasNext();) {
			Player tempPlayer = (Player) it.next();
			MessageManagement.showToPlayer(tempPlayer, player.getName()
					+ "从" + StaticFunctions.getReverseDirection(direction)
					+ "面走了过来。");
		}
		playerList.put(player.getId(), player);
	}
	public void removePlayer(Player player){
	//用户退出后，清除用户在列表中内容，通知房间内其他玩家
		playerList.remove(player.getId());
		Collection<Player> c = playerList.values();
		for (Iterator<Player> it = c.iterator(); it.hasNext();) {
			Player tempPlayer = (Player) it.next();
			MessageManagement.showToPlayer(tempPlayer, player.getName()
					+ "退出了游戏。");
		}
	}
	public void addPlayer(Player player){
	//用户连线进入，加入列表，通知房间其他玩家
		Collection<Player> c = playerList.values();
		for (Iterator<Player> it = c.iterator(); it.hasNext();) {
			Player tempPlayer = (Player) it.next();
			MessageManagement.showToPlayer(tempPlayer, player.getName()
					+ "连线进入了世界。");
		}
		MessageManagement.showToPlayer(player, "你连线进入了世界。\t"+getRoomLooking());
		playerList.put(player.getId(), player);
		
	}

	public void setDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getDescription() {
		return roomDescription;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void SetRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	/*public String getRoomLooking() {
		return roomLooking;
	}*/

	public String getRoomLooking() {
		// 房间名
		roomLooking = roomName + "\t";
		// 房间描述
		// 应该由Client负责解析传输过来的字符（设定字体，每行字数）
		int roomDescriptionLength = roomDescription.length();
		if (roomDescriptionLength <= CommonContent.CHARS_PER_LINE)
			roomLooking += roomDescription + "\t";
		else {
			int i;
			for (i = 0; i <= roomDescriptionLength
					- CommonContent.CHARS_PER_LINE; i = i
					+ CommonContent.CHARS_PER_LINE) {
				roomLooking += roomDescription.substring(i, i
						+ CommonContent.CHARS_PER_LINE)
						+ "\t";
			}
			roomLooking += roomDescription.substring(i, roomDescriptionLength)
					+ "\t";
		}

		// 房间出口
		roomLooking += getChuKou() + "\t";
		// 房间npc

		// 房间player
		roomLooking += listRoomPlayers();
		// 房间obj
		return roomLooking;
	}
	private String listRoomPlayers(){
		//列出这个房间中的所有玩家
		String temp = "";
		Collection<Player> c = playerList.values();
		for (Iterator<Player> it = c.iterator(); it.hasNext();) {
			Player tempPlayer = (Player) it.next();
			temp += tempPlayer.getName()+ "(" + tempPlayer.getId()+ ")\t";
		}
		return temp;
	}
	private String getChuKou() {
		/*描述每个房间的出口
		 * 
		 * 
		 * */
		String temp = "";
		int first = 0;
		if (neighbor.containsKey(CommonContent.DIRECTION.EAST))
			if (first == 0) {
				temp += "east";
				first = 1;
			} else
				temp += "、east";
		if (neighbor.containsKey(CommonContent.DIRECTION.WEST))
			if (first == 0) {
				temp += "west";
				first = 1;
			} else
				temp += "、west";
		if (neighbor.containsKey(CommonContent.DIRECTION.SOUTH))
			if (first == 0) {
				temp += "south";
				first = 1;
			} else
				temp += "、south";
		if (neighbor.containsKey(CommonContent.DIRECTION.NORTH))
			if (first == 0) {
				temp += "north";
				first = 1;
			} else
				temp += "、north";
		if (neighbor.containsKey(CommonContent.DIRECTION.NORTHEAST))
			if (first == 0) {
				temp += "northeast";
				first = 1;
			} else
				temp += "、northeast";
		if (neighbor.containsKey(CommonContent.DIRECTION.NORTHWEST))
			if (first == 0) {
				temp += "northwest";
				first = 1;
			} else
				temp += "、northwest";
		if (neighbor.containsKey(CommonContent.DIRECTION.SOUTHEAST))
			if (first == 0) {
				temp += "southeast";
				first = 1;
			} else
				temp += "、southeast";
		if (neighbor.containsKey(CommonContent.DIRECTION.SOUTHWEST))
			if (first == 0) {
				temp += "southwest";
				first = 1;
			} else
				temp += "、southwest";
		if (neighbor.containsKey(CommonContent.DIRECTION.UP))
			if (first == 0) {
				temp += "up";
				first = 1;
			} else
				temp += "、up";
		if (neighbor.containsKey(CommonContent.DIRECTION.DOWN))
			if (first == 0) {
				temp += "down";
				first = 1;
			} else
				temp += "、down";
		if (temp == "")
			temp = "这里没有明显的出口。";
		else
			temp = "这里明显的出口是  " + temp+"。";
		return temp;
	}
}
