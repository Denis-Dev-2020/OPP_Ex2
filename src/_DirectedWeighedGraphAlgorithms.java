package Our_Proj;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
import api.NodeData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class _DirectedWeighedGraphAlgorithms implements DirectedWeightedGraphAlgorithms {

    static _DirectedWeightedGraph g = new _DirectedWeightedGraph();
    static ArrayList<int[]>PathsList = new ArrayList<>();
    static Double Big_Number = Double.POSITIVE_INFINITY;
    static ArrayList<NodeData> DikstraPath = new ArrayList<>();
    @Override
    //inits graph here
    public void init(DirectedWeightedGraph g) {
        this.g = (_DirectedWeightedGraph) g;
        this.g.g = ((_DirectedWeightedGraph) g).g;
        this.g.e = ((_DirectedWeightedGraph) g).e;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return g;
    }
    //need to do copy constructor
    @Override
    /**computes deep copy of this graph**/
    public DirectedWeightedGraph copy() {
        _DirectedWeightedGraph g1 = new _DirectedWeightedGraph(this.g);
        return g1;
    }
    //we checking from each to each node if visited
    private void DFS(int key) {
        Stack<NodeData> s = new Stack<NodeData>();
        NodeData t = this.g.getNode(key);
        s.push(t);
        t.setTag(1); //each and evrynode if visited
        while (!s.isEmpty()) {
            t = s.pop();
            Iterator<EdgeData> e = this.g.edgeIter(t.getKey());
            while (e.hasNext()) {
                EdgeData ed = e.next();
                //checking on neiighobs
                if (this.g.getNode(ed.getDest()).getTag() != 1) {//check if  visited
                    this.g.getNode(ed.getDest()).setTag(1);//set as visited
                    s.push(this.g.getNode(ed.getDest()));
                }
            }
        }
    }


    @Override
    public boolean isConnected() {
        /**dfs for each node**/
       if (this.g == null)
           return true;
       if (this.g.edgeSize() == 0 || this.g.nodeSize() == 1)
           return true;
       if (this.g.nodeSize() > this.g.edgeSize() + 1)
           return false;
       Iterator<NodeData> e = this.g.nodeIter(); //running on vertesis
       while (e.hasNext()) {
           NodeData t = e.next();
           DFS(t.getKey());
           Iterator<NodeData> i = this.g.nodeIter();
           while (i.hasNext()) {
               t = i.next();
               if (t.getTag() != 1) { //check if not visited,if there is one vertex like that return false
                   return false;
               }
             t.setTag(0);
           }
       }
       return true;
    }
    @Override
    public double shortestPathDist(int src, int dest) {
         //first node is 0 all other is ininity
        PriorityQueue<_NodeData> q = new PriorityQueue<_NodeData>();
        //java uses fibonnaci heap
        Iterator<NodeData> k = g.nodeIter();
        while (k.hasNext()) {
            NodeData t = k.next();
            t.setWeight(Big_Number);
            t.setInfo("white");
            q.add((_NodeData) (t)); //adding the nodes with inf and white tags
        }
        g.getNode(src).setWeight(0);
        DikstraPath.add(g.getNode(src));
        while (!q.isEmpty()){
            //extract mimium weight
            _NodeData u = q.remove(); //getting first Node
            //need to put it back to _NodeData
            Iterator<EdgeData> e = g.edgeIter(u.getKey());
            while (e.hasNext()){
                EdgeData ed = e.next();
                //we getting pointers
                //prev its u
                _NodeData next = (_NodeData) g.getNode(ed.getDest());
                //iam asking for neighbors
                if(next.getInfo()!="red"){
                    //weight that we checkin on
                    double t = u.getWeight() + ed.getWeight();
                    if(next.getWeight()>t){ //cheaper path
                        next.setWeight(t); //weigh
                        next.prev = u.getKey();
                        q.remove(u);
                         q.add(next);
                    }
                }
                u.setInfo("red"); //visited
            }
        }
        return g.getNode(dest).getWeight();
    }
    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        double set_Dijekstra = shortestPathDist(src,dest); //we need bettween 2 point
        //theres is Dijekstra that going to help us
        Iterator<EdgeData> p = g.edgeIter(dest);
        LinkedList<NodeData> res = new LinkedList<>();
        List<NodeData> res2 = new ArrayList<>();
       // res = DikstraPath;
        //int t = dest;
        _NodeData curr = (_NodeData)g.getNode(dest);
        res.addFirst(curr);
        int pred = curr.prev;
       while (curr.getKey()!=src){
           int k = curr.prev;
           curr =  (_NodeData) g.getNode(k);
           res.addFirst(curr);
        }
        return res;
    }

    public void resetWeightAfterDijekstra () {
        Iterator<NodeData> ite111 = g.nodeIter();
        while (ite111.hasNext()){
            ite111.next().setWeight(0);
        }
    }


    @Override
    public NodeData center() {
        Iterator<NodeData> ite111 = g.nodeIter();
        double NimbusMaximus = -1;
        double NimbusMinimus = Integer.MAX_VALUE;
        resetWeightAfterDijekstra();
        List<Double> ecentricity = new ArrayList<>();
        List<Integer> firstVertexList = new ArrayList<>();
        List<Integer> secondVertexList = new ArrayList<>();
        double ecentricityMinimum = Integer.MAX_VALUE;
        int dummy1 = 0;
        int dummy2 = 0;
        while (ite111.hasNext()){
            resetWeightAfterDijekstra();
            Iterator<NodeData> ite222 = g.nodeIter();
            int temp = ite111.next().getKey();
            while (ite222.hasNext()){
                int temp2 = ite222.next().getKey();
                double ActuallDistance = shortestPathDist(temp,temp2);
                if ((temp!=temp2)&&((ActuallDistance>0)&&(ActuallDistance<Integer.MAX_VALUE))){
                    if (ActuallDistance>NimbusMaximus){
                        NimbusMaximus = ActuallDistance;
                        dummy1 = temp;
                        dummy2 = temp2;
                    }
                    //System.out.println("("+temp+","+temp2+")    =  "+ActuallDistance);
                    ActuallDistance = 0;
                }
            }
            if (NimbusMaximus>0){
                //System.out.println("******************"+NimbusMaximus);
                ecentricity.add(NimbusMaximus);
                firstVertexList.add(dummy1);
                secondVertexList.add(dummy2);
                NimbusMaximus = -1;
            }
        }
        //System.out.print("\n\n[");
        for(int i = 0 ; i < ecentricity.size() ; i++){
            if (ecentricity.get(i)<ecentricityMinimum){
                ecentricityMinimum = ecentricity.get(i);
                dummy1 = firstVertexList.get(i);
                dummy2 = secondVertexList.get(i);
            }
            //System.out.print(ecentricity.get(i)+",");
        }
        //System.out.print("]");
        System.out.println("\n\n("+dummy1+","+dummy2+")   "+ecentricityMinimum);
        return g.getNode(dummy1);
    }




















    public static void getPermutations(int[] array){
        helper(array, 0);
    }
    private static void helper(int[] array, int pos){
        if(pos >= array.length - 1){
            int[] tempFinalarr = new int[array.length];
            for(int i = 0; i < array.length - 1; i++){
                tempFinalarr[i] = array[i];
                if (isThereEdgeConnecting(array[i],array[i+1])==0){
                    break;
                }
            }
            if(array.length > 0)
                tempFinalarr[array.length - 1] = array[array.length - 1];
            if (TraverseOnArrayToCheckIfPathExists_RtrnZeroIfNoPath(tempFinalarr)!=0){
                PathsList.add(tempFinalarr);
                return;
            }
        }
        for(int i = pos; i < array.length; i++){
            int t = array[pos];
            array[pos] = array[i];
            array[i] = t;
            helper(array, pos+1);
            t = array[pos];
            array[pos] = array[i];
            array[i] = t;
        }
    }
    public static double isThereEdgeConnecting(int src, int dest) {
        if (g.e.size()!=0){
            if (g.e.get(src).get(dest)!=null){
                return g.e.get(src).get(dest).getWeight();
            }
        }
        return 0;
    }
    public static double TraverseOnArrayToCheckIfPathExists_RtrnZeroIfNoPath(int a[]){
        double TotalDistance = 0;
        for (int i = 1 ; i < a.length ; i++){
            if (isThereEdgeConnecting(a[i-1],a[i])>0){
                TotalDistance = TotalDistance + isThereEdgeConnecting(a[i-1],a[i]);
            }else{
                return 0;
            }
        }
        return TotalDistance;
    }
    @Override
    public List<NodeData> tsp(List<NodeData> cities) {

            ArrayList<NodeData> ReturnPath = new ArrayList<>();
            //~~~~~~~~~~~~ LIST OF CITIES TO PRIMITIVE INT ARRAY OF VERTICES ~~~~~~~~~~~//
            int[] arrOfKeys = new int[cities.size()];
            for(int i = 0; i < cities.size(); i++) {
                if (cities.get(i) != null) {
                    arrOfKeys[i] = cities.get(i).getKey();
                }
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
            getPermutations(arrOfKeys);
            if (PathsList.size()>0){
                int [] ShortestPath = new int[PathsList.get(0).length];
                double ShortestPathLength = Integer.MAX_VALUE;
                for ( int iii = 0;  iii < PathsList.size() ; iii++){
                    if (TraverseOnArrayToCheckIfPathExists_RtrnZeroIfNoPath(PathsList.get(iii))<ShortestPathLength){
                        ShortestPathLength = TraverseOnArrayToCheckIfPathExists_RtrnZeroIfNoPath(PathsList.get(iii));
                        ShortestPath = PathsList.get(iii);
                    }
                }
                for (int j = 0 ; j < ShortestPath.length ; j++){
                    ReturnPath.add(g.g.get(ShortestPath[j]));
                }
                return ReturnPath;
            }

        return null;
    }

    @Override
    public boolean save(String file) {
        //saves this graph to json file
        JSONObject json = new JSONObject();
        JSONArray Nodes = new JSONArray();
        JSONArray Edges = new JSONArray();
        // Iterator<NodeData> i = this.g.nodeIter();
        for (Iterator<NodeData> i = this.g.nodeIter(); i.hasNext(); ) {
            _NodeData v = (_NodeData) i.next();
            JSONObject jnode = new JSONObject();
            jnode.put("pos", v.getLocation2());
            jnode.put("id", v.getKey());
            Nodes.add(jnode);

        }
        //Iterator<EdgeData> j = this.g.edgeIter();
        for (Iterator<EdgeData> j = this.g.edgeIter(); j.hasNext(); ) {

            _EdgeData edge = (_EdgeData) j.next();
            JSONObject jedge = new JSONObject();
            jedge.put("src", edge.getSrc());
            jedge.put("w", edge.getWeight());
            jedge.put("dest", edge.getDest());
            Edges.add(jedge);
        }

        json.put("Edges", Edges);
        json.put("Nodes", Nodes);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(json.toJSONString());
            fw.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean load(String file) {
        //loading json file to graph obj
        {
            try {
                this.g = new _DirectedWeightedGraph();
                Object o = new JSONParser().parse(new FileReader(file));
                JSONObject jsonObject = (JSONObject) o;
                JSONArray nodes = (JSONArray) jsonObject.get("Nodes");
                Iterator i = nodes.iterator();
                while (i.hasNext()) {
                    HashMap<String, Object> objectHashMap = (HashMap<String, Object>) i.next();
                    //  HashMap<String, Object> objectHashMap = (HashMap<String, Object>) i.next();
                    // GeoLocationClass location = new GeoLocationClass((String) objectHashMap.get("pos"));

                    _NodeData n = new _NodeData(Integer.parseInt(String.valueOf(objectHashMap.get("id"))));
                    String s=(String) objectHashMap.get("pos");
                    String[] s1 =s.split(",");
                    n.setLocation(Double.parseDouble(s1[0]),Double.parseDouble(s1[1]),Double.parseDouble(s1[2]));

                    this.g.addNode(n);
                }
                JSONArray edges = (JSONArray) jsonObject.get("Edges");

                for (Iterator<HashMap> j = edges.iterator(); j.hasNext(); ) {
                    HashMap<String, Object> objectHashMap2 = (HashMap<String, Object>) j.next();
                    int src = (int) (long) objectHashMap2.get("src");
                    int dest = (int) (long) objectHashMap2.get("dest");
                    double weight = (double) objectHashMap2.get("w");
                    this.g.connect(src, dest, weight);
                }
                //loads json to this graph
                init(g);
            } catch (ParseException | IOException e) {
                return false;
            }
        }

        //System.out.println("true");
        return true;
    }
}



