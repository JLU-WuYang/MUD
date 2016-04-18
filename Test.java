package cn.edu.jlu.ccst.mud;
import java.util.Iterator;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*RoomManagement.creatRooms();
		Room room = new Room();
		//room.setDescription("据传这里是盐商黄应泰修建。园内种竹千杆，因竹叶形如“个”字，故以是名。入园门左转至复道廊，迎面花坛种竹，竹间立石笋。北面园门上有“个园”题字石额。园门向北为桂花厅，前植桂树，后凿水池，六角攒尖式小亭隔水相望。延北墙是湖石假山，山上古松，山下趋桥流水。夏日晴雨，水中倒影多变，有下山之称。");
		//System.out.println(room.getRoomLooking());
		for(Iterator<Room> it = RoomManagement.cityMap.values().iterator();it.hasNext();){
			room = it.next();
			System.out.println(room.getRoomLooking());
		}*/
		
		String s = "aaaaa";
		String[] temp = s.split("\t");
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		System.out.print(s);
	}

}
