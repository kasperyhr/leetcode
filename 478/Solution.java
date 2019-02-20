class Solution {
    Random rand;
    double rad;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        rand = new Random();
        rad = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double theta = rand.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(rand.nextDouble()) * rad;
        double[] ret = new double[2];
        ret[0] = x + r * Math.sin(theta);
        ret[1] = y + r * Math.cos(theta);
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */