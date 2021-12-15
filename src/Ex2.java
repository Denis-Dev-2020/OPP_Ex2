package Our_Proj;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
import api.NodeData;
import com.google.gson.Gson;
import org.w3c.dom.Node;
import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class is the main class for Our_Proj.Ex2 - your implementation will be tested using this class.
 */

public class Ex2 {
    /**
     * This static function will be used to test your implementation
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    //here we checking with obj graph initing
    public static DirectedWeightedGraph getGrapg(String json_file) {
        //obj to json
        //json to obj
        DirectedWeightedGraph ans = new _DirectedWeightedGraph();
        // ****** Add your code here ******
        return ans;
    }

    /**
     * This static function will be used to test your implementation
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraphAlgorithms ans = new _DirectedWeighedGraphAlgorithms();
        // ****** Add your code here ******

        // ********************************
        return ans;
    }

    /**
     * This static function will run your GUI using the json fime.
     *
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);

        // ****** Add your code here ******
        //
        // ********************************
    }

    private class TestTest {
        String name;
        String age;

        public TestTest(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestTest{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        GUI testGUI = new GUI();



    }
}
