package implementation;
//import java.util.*;
public class Edge {
    private vertex start;
    private vertex end;
    private Integer weight;
    public Edge(vertex start,vertex end,Integer inputWeight){
        this.start=start;
        this.end=end;
        this.weight=inputWeight;
    }
    public vertex getStart(){
        return this.start;
    }
    public vertex getEnd(){
        return this.end;
    }
    public Integer getWeight(){
        return this.weight;
    }
    
}

