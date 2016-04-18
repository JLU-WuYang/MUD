package cn.edu.jlu.ccst.mud;

public class StaticFunctions {
	public static String getDirection(CommonContent.DIRECTION direction){
		String chinese = "";
		switch(direction){
		case EAST:
			chinese = "东";break;
		case WEST:
			chinese = "西";break;
		case SOUTH:
			chinese = "南";break;
		case NORTH:
			chinese ="北";break;
		case NORTHEAST:
			chinese = "东北";break;
		case NORTHWEST:
			chinese = "西北";break;
		case SOUTHEAST:
			chinese = "东南";break;
		case SOUTHWEST:
			chinese = "西南";break;
		case UP:
			chinese = "上";break;
		case DOWN:
			chinese = "下";break;
		}
		return chinese;
	}
	public static String getReverseDirection(CommonContent.DIRECTION direction){
		String chinese = "";
		switch(direction){
		case EAST:
			chinese = "西";break;
		case WEST:
			chinese = "东";break;
		case SOUTH:
			chinese = "北";break;
		case NORTH:
			chinese ="南";break;
		case NORTHEAST:
			chinese = "西南";break;
		case NORTHWEST:
			chinese = "东南";break;
		case SOUTHEAST:
			chinese = "西北";break;
		case SOUTHWEST:
			chinese = "东北";break;
		case UP:
			chinese = "下";break;
		case DOWN:
			chinese = "上";break;
		}
		return chinese;
	}
        public static CommonContent.DIRECTION  getReverseDirectionEn(CommonContent.DIRECTION direction){
		
		switch(direction){
		case EAST:
			return CommonContent.DIRECTION.WEST;
		case WEST:
			return CommonContent.DIRECTION.EAST;
		case SOUTH:
			return CommonContent.DIRECTION.NORTH;
		case NORTH:
			return CommonContent.DIRECTION.SOUTH;
		case NORTHEAST:
			return CommonContent.DIRECTION.SOUTHWEST;
		case NORTHWEST:
			return CommonContent.DIRECTION.SOUTHEAST;
		case SOUTHEAST:
			return CommonContent.DIRECTION.NORTHWEST;
		case SOUTHWEST:
			return CommonContent.DIRECTION.NORTHEAST;
		case UP:
			return CommonContent.DIRECTION.DOWN;
		case DOWN:
			return CommonContent.DIRECTION.UP;
		}
                return CommonContent.DIRECTION.UP;//have to
	}
}
