package com.project;

public class KdTree {
	private int size;
    private KdNode root;

    public KdTree() {                              // construct an empty set of points
        size = 0;
        root = null;
    }

    public boolean isEmpty() {                    // is the set empty?
        return (size == 0);
    }

    public int size() {                       // number of points in the set
        return size;
    }

    public void insert(Point2D newPoint) {
        // add the point to the set (if it is not already in the set)
        root = put(root, newPoint, true);
    }

    private KdNode put(KdNode x, Point2D point, boolean level) {

        if (x == null) {
            size += 1;
            return new KdNode(point, level);
        }
        if (level) {
            if (point.y() > x.getKey().y()) {
                x.setRightBranch(put(x.getRightBranch(), point, false));
            }
            else if (point.y() < x.getKey().y()) {
                x.setLeftBranch(put(x.getLeftBranch(), point, false));
            }
        }
        else {
            if (point.x() > x.getKey().x()) {
                x.setRightBranch(put(x.getRightBranch(), point, true));
            }
            else if (point.x() < x.getKey().x()) {
                x.setLeftBranch(put(x.getLeftBranch(), point, true));
            }

        }
        return x;
    }

    public boolean contains(Point2D p) {           // does the set contain point p?
        KdNode x = root;
        while (x != null) {
            boolean level = x.isV();
            if (p.compareTo(x.getKey()) == 0) {
                return true;
            }
            else if (level) {
                if (p.y() > x.getKey().y()) {
                    x = x.getRightBranch();
                }
                else if (p.y() < x.getKey().y()) {
                    x = x.getLeftBranch();
                }
            }
            else {
                if (p.x() > x.getKey().x()) {
                    x = x.getRightBranch();
                }
                else if (p.x() < x.getKey().x()) {
                    x = x.getLeftBranch();
                }
            }
        }
        return false;
    }

//    public void draw() {                        // draw all points to standard draw
//        if (root != null) {
//            root.draw();
//        }
//    }


    public RandomizedQueue<Point2D> range(RectHV rect) {
        // all points that are inside the rectangle (or on the boundary)
        RandomizedQueue<Point2D> queue = new RandomizedQueue<Point2D>();
        range(rect, root, queue);
        return queue;
    }

    private void range(RectHV rect, KdNode currNode, RandomizedQueue<Point2D> queue) {
        if (currNode != null) {
            Point2D key = currNode.getKey();
            boolean dir = root.isV();
            if (rect.contains(key)) {
                queue.enqueue(key);
            }
            if (dir) {
                if (key.y() < rect.ymin()) {
                    range(rect, currNode.getRightBranch(), queue);
                }
                else if (key.y() > rect.ymax()) {
                    range(rect, currNode.getLeftBranch(), queue);
                }
                else {
                    range(rect, currNode.getLeftBranch(), queue);
                    range(rect, currNode.getRightBranch(), queue);
                }
            }
            else {
                if (key.x() < rect.xmin()) {
                    range(rect, currNode.getRightBranch(), queue);
                }
                else if (key.x() > rect.xmax()) {
                    range(rect, currNode.getLeftBranch(), queue);
                }
                else {
                    range(rect, currNode.getLeftBranch(), queue);
                    range(rect, currNode.getRightBranch(), queue);
                }
            }
        }
    }


    public Point2D nearest(Point2D p) {
        // a nearest neighbor in the set to point p; null if the set is empty
        if (root == null) {
            return null;
        }
        else {
            return nearest(p, root, root.getKey(), 0.0, 0.0);
        }
    }

    private Point2D nearest(Point2D p, KdNode node, Point2D champ, double xClose, double yClose) {
        if (node == null) {
            return champ;
        }
        else {
            if (node.getKey().distanceTo(p) < champ.distanceTo(p)) {
                champ = node.getKey();
            }
            if (node.isV()) {
                if (p.y() > node.getKey().y()) {
                    champ = nearest(p, node.getRightBranch(), champ, xClose, yClose);
                    Point2D check = new Point2D(xClose, yClose);
                    if (xClose != 0.0 && yClose != 0.0 && check.distanceTo(p) < champ
                            .distanceTo(p)) {
                        champ = nearest(p, node.getLeftBranch(), champ, xClose, node.getKey().y());
                    }
                }
                else {
                    champ = nearest(p, node.getLeftBranch(), champ, xClose, yClose);
                    Point2D check = new Point2D(xClose, yClose);
                    if (xClose != 0.0 && yClose != 0.0 && check.distanceTo(p) < champ
                            .distanceTo(p)) {
                        champ = nearest(p, node.getRightBranch(), champ, xClose, node.getKey().y());
                    }
                }
            }
            else {
                if (p.x() > node.getKey().x()) {
                    champ = nearest(p, node.getRightBranch(), champ, xClose, yClose);
                    Point2D check = new Point2D(xClose, yClose);
                    if (xClose != 0.0 && yClose != 0.0 && check.distanceTo(p) < champ
                            .distanceTo(p)) {
                        champ = nearest(p, node.getLeftBranch(), champ, xClose, node.getKey().y());
                    }
                }
                else {
                    champ = nearest(p, node.getLeftBranch(), champ, xClose, yClose);
                    Point2D check = new Point2D(xClose, yClose);
                    if (xClose != 0.0 && yClose != 0.0 && check.distanceTo(p) < champ
                            .distanceTo(p)) {
                        champ = nearest(p, node.getRightBranch(), champ, xClose, node.getKey().y());
                    }
                }
            }
            return champ;
        }
    }
}
