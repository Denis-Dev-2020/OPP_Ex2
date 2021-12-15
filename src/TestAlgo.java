package Our_Proj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class  Graph {
    //who are the neighbers each index is id
    //0 > 1,3
    //3 > 2
    //2 > 0
    //1 > 2
    List<List<Integer>> graph; //represent how many neiber it has
    boolean visited[];
    int nodes;

    Graph(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;
        //to each theres is potential list it has no size
        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }

    }

    //adding the neighbor where its going
    public void addEdge(int a, int b) { //where its going
        graph.get(a).add(b);
    }


    public boolean ifDirectedGraphStrongConnected() {
        //here is going to be iterator
        for (int i = 0; i <nodes ; i++) {
            dfs(i); //nemale true array
            for (int j = 0; j < nodes ; j++) {
                if(visited[j]==false){
                    return false;

                }
            }
            Arrays.fill(visited,false); //all of them be false

        }
        return true; //all of them strongly connected
    }

    private void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()){
            //pop first element
            Integer node = stack.pop(); //will get the first element
            //lets get neigbors or where it can go
            List<Integer> neighbors = graph.get(node);
            //now for each neighbors we check
            //if this element wasnt visited
            for (Integer neighbour:neighbors) {
                            if(!visited[neighbour]){
                                stack.push(neighbour);
                                visited[neighbour] = true;
                                //0 > 1, 3  [0] true
                                //check for 1 not visited [0,1] true
                                //check for 3 not visited [0,1,f,3] true
                                //pop 3 check its neighbers 3>2
                                //is 2 not visited no then [0 ,1,2,3] true
                                //2>0 0 zero is visite then

                            }
            }

        }


        
    }
}




class GraphProblems {
    public static void main(String[] args) {

        int nodes = 4;
        Graph a = new Graph(nodes);
        a.addEdge(0, 1); //0>1
        a.addEdge(1, 2); //1>2
        a.addEdge(2, 0); //2>0
        a.addEdge(0, 3); //0>3
        a.addEdge(3, 2); //3>2
        System.out.println(a.ifDirectedGraphStrongConnected());


    }
}