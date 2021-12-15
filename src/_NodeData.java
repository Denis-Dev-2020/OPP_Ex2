package Our_Proj;

import api.GeoLocation;
import api.NodeData;

//import api.Our_Proj._EdgeData;
//must hold at list 20 edges 10 inner 10 outer
public  class _NodeData implements NodeData,GeoLocation,Comparable<_NodeData> {
    private static int n_caunt;
    private int key;
    private String info = "";
    private int Tag_;
    private double Weight_ = 0.0;
    private double x;
    private double y;
    private double z;
    int prev;

//HashMap is O(1)
    public _NodeData() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        Tag_ = 0;
    }

    public _NodeData(double x, double y, double z) {
        this.x = x;
        this.y= y;
        this.z = z;
        Tag_ = 0;

    }
    public _NodeData(_NodeData o){
        this.x = o.x;
        this.y = o.y;
        this.z = o.z;
        Tag_ = 0;
    }


    public _NodeData(int key)
    {
        this.key = key;
    }
    //key == id
    @Override
    public String toString() {
        String s = "------ Node #"+this.key+" ------\n" +
                "   - Coord (x,y,z) = ( "+x()+" , "+y()+" , "+z()+")\n" +
                "   - Info = "+this.info + "   -Wight  "+getWeight()+"\n";
        return s;
    }
    public void setId(int id){
        this.key = id;
    }
    @Override
    public int getKey() {
        return this.key;
    }
    @Override
    public double x() {
        return this.x;
    }
    @Override
    public double y() {
        return this.y;
    }
    @Override
    public double z() {
        return this.z;
    }
    @Override
    public String getInfo() {
        return this.info;
    }
    @Override
    public void setInfo(String s) {
        this.info = s;
    }
    @Override
    public int getTag() {
        return this.Tag_;
    }
    @Override
    public void setTag(int t) {
        this.Tag_ = t;
    }
    @Override
    //if this this null then null
    public GeoLocation getLocation() {
        //Point a = this.coord;
        GeoLocation b = this; //the interface will take fields and functions that needed
        return b;
    }
    @Override
    public void setLocation(GeoLocation p) {
        this.x = p.x();
        this.y = p.y();
        this.z = p.z();
    }
    @Override
    public double distance(GeoLocation g) {
        double s1s = Math.sqrt (Math.pow (g.x()-g.y(),2) + Math.pow (this.x-this.y,2));
        double s2s = Math.sqrt (Math.pow (g.z()-g.x(),2) + Math.pow (this.z-this.x,2));
        double s3s = Math.sqrt (Math.pow (g.z()-g.y(),2) + Math.pow (this.z-this.y,2));
        return (s1s+s2s+s3s)/3;
    }
    @Override
    public double getWeight() {
        return this.Weight_;
    }
    @Override
    public void setWeight(double w) {
        this.Weight_ = w;
    }

    @Override
    //comparing NodeData with _NodeData its fine
    //but compareTo Only_NodeData should know
    //we working with NodeData in graph a lot
    public int compareTo(_NodeData o) {

        int ans = 0;
        if (this.getWeight()-o.getWeight()>0){
            ans=1;

        }
        else if (this.getWeight() - o.getWeight()<0){
             ans= -1;
        }
        //they equal
        return ans;


    }
}
