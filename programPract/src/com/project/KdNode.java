package com.project;


public class KdNode {
	private boolean V;
    private Point2D key;
    private KdNode leftBranch;
    private KdNode rightBranch;

    public KdNode(Point2D key) {
        this.V = true;
        this.key = key;
    }

    public KdNode(Point2D key, boolean v) {
        this.V = v;
        this.key = key;
    }

    public Point2D getKey() {
        return key;
    }

    public void setKey(Point2D key) {
        this.key = key;
    }

    public void setV(boolean v) {
        V = v;
    }

    public boolean isV() {
        return V;
    }

    public KdNode getLeftBranch() {
        return leftBranch;
    }

    public KdNode getRightBranch() {
        return rightBranch;
    }

    public void setLeftBranch(KdNode leftBranch) {
        this.leftBranch = leftBranch;
    }

    public void setRightBranch(KdNode rightBranch) {
        this.rightBranch = rightBranch;
    }

//    public void draw() {
//        StdDraw.setPenRadius(0.005);
//        double xVal = key.x();
//        double yVal = key.y();
//        if (V) {
//            StdDraw.setPenColor(StdDraw.RED);
//            StdDraw.line(0.0, yVal - 0.005, 1.0, yVal + 0.005);
//        }
//        else {
//            StdDraw.setPenColor(StdDraw.BLUE);
//            StdDraw.line(xVal - 0.005, 0.0, xVal + 0.005, 1.0);
//        }
//        StdDraw.setPenRadius(0.05);
//        StdDraw.point(xVal, yVal);
//        if (rightBranch != null) {
//            rightBranch.draw();
//        }
//        if (leftBranch != null) {
//            leftBranch.draw();
//        }

}
