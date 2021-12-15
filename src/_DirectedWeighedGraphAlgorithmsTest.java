package Our_Proj;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _DirectedWeighedGraphAlgorithmsTest {

    @org.junit.jupiter.api.Test
    void isConnected() {
        DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
        NodeData T0 = new _NodeData(0);
        NodeData T1 = new _NodeData(1);
        NodeData T2 = new _NodeData(2);
        NodeData T3 = new _NodeData(3);
        _DWG.addNode(T0);
        _DWG.addNode(T1);
        _DWG.addNode(T2);
        _DWG.addNode(T3);
        _DWG.connect(0,1,1);
        _DWG.connect(1,2,1);
        _DWG.connect(2,0,1);
        _DWG.connect(0,3,1);
        _DWG.connect(3,2,1);
        DirectedWeightedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();
        k.init(_DWG);
        assertTrue(k.isConnected());



        DirectedWeightedGraph _DWG2 = new _DirectedWeightedGraph();
        NodeData T02 = new _NodeData(0);
        NodeData T12 = new _NodeData(1);
        NodeData T22 = new _NodeData(2);
        NodeData T32 = new _NodeData(3);
        _DWG2.addNode(T02);
        _DWG2.addNode(T12);
        _DWG2.addNode(T22);
        _DWG2.addNode(T32);
        _DWG2.connect(0,1,1);
        _DWG2.connect(1,2,1);
        _DWG2.connect(0,3,1);
        _DWG2.connect(3,2,1);
        DirectedWeightedGraphAlgorithms k234 = new _DirectedWeighedGraphAlgorithms();
        k234.init(_DWG2);
        assertFalse(k234.isConnected());
    }

    @org.junit.jupiter.api.Test
    void shortestPathDist() {

        DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
        DirectedWeightedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();
        k.init(_DWG);

        NodeData T1 = new _NodeData(1);
        NodeData T2 = new _NodeData(2);
        NodeData T3 = new _NodeData(3);
        NodeData T4 = new _NodeData(4);
        NodeData T5 = new _NodeData(5);
        NodeData T6 = new _NodeData(6);

        _DWG.addNode(T1);
        _DWG.addNode(T2);
        _DWG.addNode(T3);
        _DWG.addNode(T4);
        _DWG.addNode(T5);
        _DWG.addNode(T6);

        _DWG.connect(T1.getKey(), T2.getKey(), 7);
        _DWG.connect(T1.getKey(), T3.getKey(), 9);
        _DWG.connect(T1.getKey(), T6.getKey(), 14);

        _DWG.connect(T2.getKey(), T3.getKey(), 10);
        _DWG.connect(T2.getKey(), T4.getKey(), 15);

        _DWG.connect(T3.getKey(), T6.getKey(), 2);
        _DWG.connect(T3.getKey(), T4.getKey(), 11);
        _DWG.connect(T4.getKey(), T5.getKey(), 6);
        _DWG.connect(T6.getKey(), T5.getKey(), 9);
        double res = k.shortestPathDist(1, 4);
        assertEquals(res, 20.0);





    }

    @org.junit.jupiter.api.Test
    void shortestPath() {

        DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
        DirectedWeightedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();
        k.init(_DWG);

        NodeData T1 = new _NodeData(1);
        NodeData T2 = new _NodeData(2);
        NodeData T3 = new _NodeData(3);
        NodeData T4 = new _NodeData(4);
        NodeData T5 = new _NodeData(5);
        NodeData T6 = new _NodeData(6);

        _DWG.addNode(T1);
        _DWG.addNode(T2);
        _DWG.addNode(T3);
        _DWG.addNode(T4);
        _DWG.addNode(T5);
        _DWG.addNode(T6);

        _DWG.connect(T1.getKey(), T2.getKey(), 7);
        _DWG.connect(T1.getKey(), T3.getKey(), 9);
        _DWG.connect(T1.getKey(), T6.getKey(), 14);

        _DWG.connect(T2.getKey(), T3.getKey(), 10);
        _DWG.connect(T2.getKey(), T4.getKey(), 15);

        _DWG.connect(T3.getKey(), T6.getKey(), 2);
        _DWG.connect(T3.getKey(), T4.getKey(), 11);
        _DWG.connect(T4.getKey(), T5.getKey(), 6);
        _DWG.connect(T6.getKey(), T5.getKey(), 9);
        List<NodeData> p = k.shortestPath(1, 4);
        int[] arr = {1,3,4};
        int i =0;
        for(NodeData n: p) {
            //assertEquals(n.getTag(), checkTag[i]);
            assertEquals(n.getKey(), arr[i]);
            i++;
        }

    }

    @org.junit.jupiter.api.Test
    void center() {
        _DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
        _NodeData T1 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T2 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T3 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T4 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T5 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T6 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _DirectedWeighedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();
        T1.setId(1);
        T2.setId(2);
        T3.setId(3);
        T4.setId(4);
        T5.setId(5);
        T6.setId(6);
        _DWG.addNode(T1);
        _DWG.addNode(T2);
        _DWG.addNode(T3);
        _DWG.addNode(T4);
        _DWG.addNode(T5);
        _DWG.addNode(T6);
        _DWG.connect(T1.getKey(), T3.getKey(), 9);
        _DWG.connect(T1.getKey(), T6.getKey(), 14);
        _DWG.connect(T2.getKey(), T3.getKey(), 10);
        _DWG.connect(T2.getKey(), T4.getKey(), 15);
        _DWG.connect(T3.getKey(), T6.getKey(), 2);
        _DWG.connect(T3.getKey(), T4.getKey(), 11);
        _DWG.connect(T4.getKey(), T5.getKey(), 6);
        _DWG.connect(T6.getKey(), T5.getKey(), 9);
        k.init(_DWG);
        assertEquals(k.center().getKey(),4);


        DirectedWeightedGraph _DWG2 = new _DirectedWeightedGraph();
        NodeData T02 = new _NodeData(0);
        NodeData T12 = new _NodeData(1);
        NodeData T22 = new _NodeData(2);
        NodeData T32 = new _NodeData(3);
        _DWG2.addNode(T02);
        _DWG2.addNode(T12);
        _DWG2.addNode(T22);
        _DWG2.addNode(T32);
        _DWG2.connect(0,1,1);
        _DWG2.connect(1,2,1);
        _DWG2.connect(2,0,10);
        _DWG2.connect(0,3,1);
        _DWG2.connect(3,2,1);
        DirectedWeightedGraphAlgorithms k35 = new _DirectedWeighedGraphAlgorithms();
        k35.init(_DWG2);
        assertEquals(k35.center().getKey(),1);
    }

    @org.junit.jupiter.api.Test
    void tsp() {
        _DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
        _NodeData T1 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T2 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T3 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T4 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T5 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _NodeData T6 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
        _DirectedWeighedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();
        T1.setId(1);
        T2.setId(2);
        T3.setId(3);
        T4.setId(4);
        T5.setId(5);
        T6.setId(6);
        _DWG.addNode(T1);
        _DWG.addNode(T2);
        _DWG.addNode(T3);
        _DWG.addNode(T4);
        _DWG.addNode(T5);
        _DWG.addNode(T6);
        _DWG.connect(T1.getKey(), T3.getKey(), 9);
        _DWG.connect(T1.getKey(), T6.getKey(), 14);
        _DWG.connect(T2.getKey(), T3.getKey(), 10);
        _DWG.connect(T2.getKey(), T4.getKey(), 15);
        _DWG.connect(T3.getKey(), T6.getKey(), 2);
        _DWG.connect(T3.getKey(), T4.getKey(), 11);
        _DWG.connect(T4.getKey(), T5.getKey(), 6);
        _DWG.connect(T6.getKey(), T5.getKey(), 9);
        _DWG.connect(T5.getKey(), T6.getKey(), 9);
        _DWG.connect(T5.getKey(), T4.getKey(), 9);
        _DWG.connect(T4.getKey(), T2.getKey(), 9);
        _DWG.connect(T2.getKey(), T1.getKey(), 9);
        _DWG.connect(T6.getKey(), T3.getKey(), 9);
        k.init(_DWG);
        List<NodeData> CityList = new ArrayList<>();
        CityList.add(T1);
        CityList.add(T2);
        CityList.add(T3);
        CityList.add(T4);
        CityList.add(T5);
        CityList.add(T6);
        List<NodeData> testList = new ArrayList<>();
        testList.add(T1);
        testList.add(T3);
        testList.add(T6);
        testList.add(T5);
        testList.add(T4);
        testList.add(T2);
        List<NodeData> testResult1 = new ArrayList<>();
        testResult1 = k.tsp(CityList);
        assertEquals(testResult1,testList);

    }
}