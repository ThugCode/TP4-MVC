package vue;

import java.awt.Graphics;

import modele.Segment;

public class SegmentVue {

	private Segment segment;
	
	public SegmentVue(Segment p_segment) {
		
		segment = p_segment;
	}
	
	public void drawSegment(Graphics graph) {
		if (graph==null)
			return;

		graph.setColor(segment.getColor());
		graph.drawLine(segment.getPtStart().x, segment.getPtStart().y, segment.getPtEnd().x, segment.getPtEnd().y);
	}
}
