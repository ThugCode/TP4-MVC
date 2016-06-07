package src.modele;

import java.awt.Color;
import java.awt.Point;

/**
 * @author GERLAND - LETOURNEUR
 */
public class Segment {
	
	private Point ptStart, ptEnd;
	private Color color;
	
	public Segment() {
		ptStart = new Point(0,0);
		ptEnd = new Point(0,0);
		color = Color.black;
	}

	public Point getPtStart() {
		return ptStart;
	}

	public void setPtStart(Point ptStart) {
		this.ptStart = ptStart;
	}

	public Point getPtEnd() {
		return ptEnd;
	}

	public void setPtEnd(Point ptEnd) {
		this.ptEnd = ptEnd;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}