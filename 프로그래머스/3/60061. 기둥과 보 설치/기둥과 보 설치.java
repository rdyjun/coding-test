import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class Solution {
    private BiConsumer<Integer, Integer>[][] workerArray = new BiConsumer[2][2];
    
    private Set<Point> pillars = new HashSet<>();
    private Set<Point> beams = new HashSet<>();
    
    public Solution() {
        this.workerArray[0][0] = this::demolishPillar;
        this.workerArray[0][1] = this::installPillar;
        this.workerArray[1][0] = this::demolishBeam;
        this.workerArray[1][1] = this::installBeam;
    }
    
    public int[][] solution(int n, int[][] build_frame) {        
        Arrays.stream(build_frame).forEach((build) -> {
            workerArray[build[2]][build[3]].accept(build[0], build[1]);
        });
            
        List<int[]> answer = getAnswerByWall();
        return sortWall(answer);
    }
    
    private List<int[]> getAnswerByWall() {
        List<int[]> answer = new ArrayList<>();
        
        for (Point pillar : this.pillars) {
            answer.add(new int[]{pillar.x, pillar.y, 0});  
        }
        
        for (Point beam : this.beams) {
            answer.add(new int[]{beam.x, beam.y, 1});
        }
        
        return answer;
    }
    
    private int[][] sortWall(List<int[]> answer) {
        return answer.stream()
            .sorted((a, b) -> Integer.compare(a[2], b[2]))
            .sorted((a, b) -> Integer.compare(a[1], b[1]))
            .sorted((a, b) -> Integer.compare(a[0], b[0]))
            .toArray(int[][]::new);
    }
    
    private void installPillar(int x, int y) {
        if (validatePillar(x, y)) {
            this.pillars.add(new Point(x, y));
        }
    }
    
    private void demolishPillar(int x, int y) {
        this.pillars.remove(new Point(x, y));
        
        boolean leftTopBeamAvailable = !this.beams.contains(new Point(x - 1, y + 1)) || validateBeam(x - 1, y + 1);
        boolean rightTopBeamAvailable = !this.beams.contains(new Point(x, y + 1)) || validateBeam(x, y + 1);
        boolean topPilarAvailable = !this.pillars.contains(new Point(x, y + 1)) || validatePillar(x, y + 1);
        
        if (!leftTopBeamAvailable || !rightTopBeamAvailable || !topPilarAvailable) {
            this.pillars.add(new Point(x, y));
        }
    }
    
    private void installBeam(int x, int y) {
        if (validateBeam(x, y)) {
            this.beams.add(new Point(x, y));
        }
    }
    
    private void demolishBeam(int x, int y) {        
        this.beams.remove(new Point(x, y));
        
        boolean leftBeamAvailable = !this.beams.contains(new Point(x - 1, y)) || validateBeam(x - 1, y);
        boolean rightBeamAvailable = !this.beams.contains(new Point(x + 1, y)) || validateBeam(x + 1, y);
        boolean leftPillarAvailable = !this.pillars.contains(new Point(x, y)) || validatePillar(x, y);
        boolean rightPillarAvailable = !this.pillars.contains(new Point(x + 1, y)) || validatePillar(x + 1, y);
        
        if (!leftBeamAvailable || !rightBeamAvailable || !leftPillarAvailable || !rightPillarAvailable) {
            this.beams.add(new Point(x, y));
        }
    }
    
    private boolean validatePillar(int x, int y) {
        boolean beamOnLeft = this.beams.contains(new Point(x - 1, y));
        boolean beamOnRight = this.beams.contains(new Point(x, y));
        boolean pillarBelow = this.pillars.contains(new Point(x, y - 1));
        
        return y == 0 || beamOnLeft || beamOnRight || pillarBelow;
    }
    
    private boolean validateBeam(int x, int y) {        
        boolean pillarBelowOnLeft = this.pillars.contains(new Point(x, y - 1));
        boolean pillarBelowOnRight = this.pillars.contains(new Point(x + 1, y - 1));
        boolean beamOnLeft = this.beams.contains(new Point(x - 1, y));
        boolean beamOnRight = this.beams.contains(new Point(x + 1, y));
        
        return pillarBelowOnLeft || pillarBelowOnRight || (beamOnLeft && beamOnRight);
    }
}

class Point {
    public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equals(Object compareObject) {
        if (compareObject == this) return true;
        if (!(compareObject instanceof Point)) return false;
        
        Point compare = (Point) compareObject;
        return this.x == compare.x && this.y == compare.y;
    }
    
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
