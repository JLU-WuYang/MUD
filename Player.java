package cn.edu.jlu.ccst.mud;
public class Player extends Person{

	
	public Player() {
		// creat player default value
	}
	public Player(int experience,int con,int dex,int str,int wis,int hp,int max_hp,int nl,int max_nl,int jl,int max_jl,String id,String username,String party,String location){
		this.experience = experience;
		this.con = con;
		this.dex = dex;
		this.str = str;
		this.wis = wis;
		this.hp = hp;
		this.max_hp = max_hp;
		this.nl = nl;
		this.max_nl = max_nl;
		this.jl = jl;
		this.max_jl = jl;
		this.id = id;
		this.username = username;
		this.party = party;
		this.location = location;
	}

	public void move(CommonContent.DIRECTION direction) {
		Room nowPosition = RoomManagement.cityMap.get(this.location);
		Room destination = nowPosition.getRoom(direction);
		if (destination == null)
			MessageManagement.showToPlayer(this, CommonContent.CANNOTMOVE);
		else {
			nowPosition.exist(this,direction);
			setLocation(destination.getRoomId());
			destination.enter(this,direction);
			MessageManagement.showToPlayer(this, destination.getRoomLooking());
		}
	}
	public void look(String something){
		if(something.equals("room"))
			MessageManagement.showToPlayer(this,RoomManagement.cityMap.get(this.location).getRoomLooking());
		else
			;
	}
	public void finishCreat(){
		//感觉这个函数不应该放到这个类中 》》讨论
	}
	public void quit(){
		//告诉房间退出了，释放资源
		Room nowPosition = RoomManagement.cityMap.get(this.location);
		nowPosition.removePlayer(this);
		
		//save添加在这里
	}

}
