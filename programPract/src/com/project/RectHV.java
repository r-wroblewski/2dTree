package com.project;

public class RectHV {
	private double xmin;
	private double xmax;
	private double ymin;
	private double ymax;
	
	public RectHV(double xmi, double ymi, double xma, double yma) {
		this.xmin = xmi;
		this.xmax = xma;
		this.ymin = ymi;
		this.ymax = yma;
	}
	
	public double ymin() {
		return this.ymin;
	}
	
	public double ymax() {
		return this.ymax;
	}
	
	public double xmin() {
		return this.xmin;
	}
	
	public double xmax() {
		return this.xmax;
	}

	public boolean contains(Point2D point) {
		if((point.x() <= this.xmax) && (point.x() >= this.xmin)) {
			if((point.y() <= this.ymax) && (point.y() >= this.ymin)) {
				return true;
			}
		}
		return false;
	}
}
