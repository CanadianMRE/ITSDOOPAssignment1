package project.shapes;

import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.GetVolume() > o2.GetVolume() )
		{
			return 1;
		}
		else if( o1.GetVolume() < o2.GetVolume() )
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
