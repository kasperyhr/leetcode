/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    HashSet<String> s;
    int x;
    int y;
    Robot r;
    public void cleanRoom(Robot robot) {
        if(robot == null)
            return;
        s = new HashSet<String>();
        r = robot;
        x = 0;
        y = 0;
        cleanCurrent();
    }
    
    private void cleanCurrent(){
        String str = String.format("%d %d", x, y);
        if(!s.contains(str)){
            r.clean();
            s.add(str);
            move();
        }
    }
    
    private void move(){
        // System.out.println(String.format("%d %d", x, y));
        moveLeft();
        moveRight();
        moveUp();
        moveDown();        
    }
    
    private void moveLeft(){
        r.turnLeft();
        boolean movable = r.move();
        r.turnRight();
        if(movable){
            x--;
            cleanCurrent();
            r.turnRight();
            r.move();
            x++;
            r.turnLeft();
        }
    }
    
    private void moveRight(){
        r.turnRight();
        boolean movable = r.move();
        r.turnLeft();
        if(movable){
            x++;
            cleanCurrent();
            r.turnLeft();
            r.move();
            x--;
            r.turnRight();
        }
    }
    
    private void moveUp(){
        boolean movable = r.move();
        if(movable){
            y++;
            cleanCurrent();
            r.turnRight();
            r.turnRight();
            r.move();
            y--;
            r.turnLeft();
            r.turnLeft();
        }
    }
    
    private void moveDown(){
        r.turnLeft();
        r.turnLeft();
        boolean movable = r.move();
        r.turnRight();
        r.turnRight();
        if(movable){
            y--;
            cleanCurrent();
            r.move();
            y++;
        }
    }
    
}

class Cell{
    int x;
    int y;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object cell){
        Cell c = (Cell) cell;
        return (c.x == x && c.y == y);
    }
    
    @Override
    public String toString(){
        return String.format("x: %d, y: %d\n", x, y);
    }
}