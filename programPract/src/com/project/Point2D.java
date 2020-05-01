package com.project;

public class Point2D implements Comparable<Point2D>{
	private double x;
	private double y;
	private String city;
	
	public Point2D(double x_in, double y_in) {
		x = x_in;
		y = y_in;
	}
	
	public Point2D(double x_in, double y_in, String city) {
		this.x = x_in;
		this.y = y_in;
		this.city = city;
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public String city() {
		return city;
	}
	
	public double distanceTo(Point2D point) {
		return Math.sqrt(Math.pow((this.x-point.x()), 2)+ Math.pow((this.y-point.y()), 2));
	}
	
	public int compareTo(Point2D point) {
		if(this.x == point.x()) {
			if(this.y == point.y()) {
				return 0;
			}
			else  if(point.y() < this.y) {
				return -1;
			}
			else {
				return 1;
			}
		}
		else if(point.x() < this.x) {
			return -1;
		}
		else {
			return 1;
		}
	}

}
