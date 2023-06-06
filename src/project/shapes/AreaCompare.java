package project.shapes;

import java.util.Comparator;

public class AreaCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.GetArea() > o2.GetArea() )
		{
			return 1;
		}
		else if( o1.GetArea() < o2.GetArea() )
		{
			return -1;
		}
		else // stud1.getGrade() == stud2.getGrade()
		{
			return 0;
		}
	}
}
