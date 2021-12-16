package Our_Proj;

import api.EdgeData;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPanel extends JPanel  {

    static final int WIDTHwindow = 900;
    static final int HEIGHTwindow = 900;
    static double angle;
    static boolean DijekstraButton = false;
    static boolean TSPButton = false;
    static boolean Center = false;
    static boolean LoadGraph = false;
    static boolean SaveGraph = false;
    JButton myButtonCenter;
    JButton myButtonDijek;
    JButton myButtonTSP;
    JButton Load_Graph;
    JButton Save_Graph;
    _DirectedWeightedGraph _DWG = new _DirectedWeightedGraph();
    _NodeData T1 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _NodeData T2 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _NodeData T3 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _NodeData T4 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _NodeData T5 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _NodeData T6 = new _NodeData((int)(Math.random()*800)+50,(int)(Math.random()*800)+50,0);
    _DirectedWeighedGraphAlgorithms k = new _DirectedWeighedGraphAlgorithms();


    MyPanel (){
        //~~~~~~~~~~~~~~~ Buttons Initialization ~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        this.setPreferredSize(new Dimension(WIDTHwindow,HEIGHTwindow));
        myButtonCenter = new JButton("Center");
        //myButtonCenter.setLocation(10,200);
        myButtonCenter.setForeground(Color.BLACK);
        myButtonCenter.setBackground(Color.LIGHT_GRAY);
        this.add(myButtonCenter);
        myButtonDijek = new JButton("Dijekstra");
        //myButtonCenter.setLocation(10,300);
        myButtonDijek.setForeground(Color.BLACK);
        myButtonDijek.setBackground(Color.LIGHT_GRAY);
        this.add(myButtonDijek);
        myButtonTSP = new JButton("TSP");
        //myButtonCenter.setLocation(10,400);
        myButtonTSP.setForeground(Color.BLACK);
        myButtonTSP.setBackground(Color.LIGHT_GRAY);
        this.add(myButtonTSP);
        Load_Graph = new JButton("Load Graph");
        //myButtonCenter.setLocation(10,500);
        Load_Graph.setForeground(Color.BLACK);
        Load_Graph.setBackground(Color.LIGHT_GRAY);
        this.add(Load_Graph);
        Save_Graph = new JButton("Save Graph");
        //myButtonCenter.setLocation(10,600);
        Save_Graph.setForeground(Color.BLACK);
        Save_Graph.setBackground(Color.LIGHT_GRAY);
        this.add(Save_Graph);
        MyPanel.super.repaint();
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//





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






        myButtonDijek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==myButtonDijek){
                    System.out.println("Dijekstra Running ..");
                    if (DijekstraButton){
                        DijekstraButton = false;
                        MyPanel.super.repaint();
                    }else{
                        DijekstraButton = true;
                        MyPanel.super.repaint();
                    }
                    MyPanel.super.repaint();
                }
            }
        });
        myButtonTSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==myButtonTSP){
                    System.out.println("TSP Running..");
                    if (TSPButton){
                        TSPButton = false;
                        MyPanel.super.repaint();
                    }else{
                        TSPButton = true;
                        MyPanel.super.repaint();
                    }
                }
            }
        });
        myButtonCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==myButtonCenter){
                    System.out.println("Center Running..");
                    if (Center){
                        Center = false;
                        MyPanel.super.repaint();
                    }else{
                        Center = true;
                        MyPanel.super.repaint();
                    }
                }
            }
        });
        Load_Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Load_Graph){
                    System.out.println("Load Running..");
                    if (LoadGraph){
                        LoadGraph = false;
                        k.load("G1.json");
                        MyPanel.super.repaint();
                        System.out.println("Center----->"+k.center()+"     Quantity"+k.getGraph().getMC());
                    }else{
                        LoadGraph = true;
                        MyPanel.super.repaint();
                    }
                }
            }
        });
        Save_Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Save_Graph){
                    System.out.println("Save Running..");
                    if (SaveGraph){
                        SaveGraph = false;
                        MyPanel.super.repaint();
                    }else{
                        SaveGraph = true;
                        MyPanel.super.repaint();
                    }
                }
            }
        });
    }


    public void paintComponent(Graphics graphicObject){

        Graphics2D g2D = (Graphics2D) graphicObject;
        g2D.setColor(Color.BLACK);
        g2D.fillRect(0,0,150,50);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Draw Base Layout ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/
        g2D.setColor(Color.decode("#604D3F"));
        g2D.drawLine(0,HEIGHTwindow/2,WIDTHwindow,HEIGHTwindow/2);
        g2D.drawLine(WIDTHwindow/2,0,WIDTHwindow/2,HEIGHTwindow);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        if (LoadGraph){
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~` DRAW EDGES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
            Iterator<EdgeData> Tempiter234 = _DWG.edgeIter();
            g2D.setColor(Color.WHITE);
            g2D.setStroke(new BasicStroke(5));

            while (Tempiter234.hasNext()){
                _EdgeData fsdjlk = new _EdgeData();
                fsdjlk = (_EdgeData) Tempiter234.next();
                //System.out.println(fsdjlk.toString());
                _NodeData tempSrc =  new _NodeData();
                tempSrc = (_NodeData) _DWG.getNode(fsdjlk.getSrc());
                _NodeData tempDest =  new _NodeData();
                tempDest = (_NodeData) _DWG.getNode(fsdjlk.getDest());
                double x1 = tempSrc.x();
                double y1 = tempSrc.y();
                double x2 = tempDest.x();
                double y2 = tempDest.y();
                double m_LinearEquation = ((int)(((tempDest.y()-tempSrc.y())/(tempDest.x()-tempSrc.x()))*1000))/-1000.0;
                int[] xPointsArrow = {(int)x2-50,(int)x2,(int)x2,(int)x2+50};
                int[] yPointsArrow = {(int)y2+50,(int)y2,(int)y2+20,(int)y2+50};
                double angle = ((int)(((Math.atan2((tempDest.y()-tempSrc.y()),(tempDest.x()-tempSrc.x()))*180)/Math.PI)*1000)/-1000);
                double LineraDistance = tempSrc.distance(tempDest);
                double tooRadian = ((int)(Math.toRadians(angle)*1000)/1000.0);

                g2D.rotate(tooRadian,x2,y2);
                g2D.setColor(Color.decode("#206FFF"));
                //g2D.fillPolygon(xPointsArrow,yPointsArrow,4);
                g2D.rotate(-tooRadian,x2,y2);

                g2D.setColor(Color.decode("#00308F"));
                g2D.drawLine((int)x1+25,(int)y1+25,(int)x2+25,(int)y2+25);
                g2D.setColor(Color.WHITE);
                g2D.setFont(new Font("Arial",Font.CENTER_BASELINE,11));

                double RandomYaxisForTitle = Math.random()*40;

                g2D.drawString(tempSrc.getKey()+"--->"+tempDest.getKey()+" " +
                        "  ("+fsdjlk.getWeight()+")",(int)((tempSrc.x()+tempDest.x())/2),(((int)((tempSrc.y()+tempDest.y())/2)-40)+(int)RandomYaxisForTitle)     );
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~` Node Draw ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`//
            Iterator<NodeData> tempIter34 = _DWG.nodeIter();
            while (tempIter34.hasNext()){
                _NodeData muysd =  new _NodeData();
                muysd = (_NodeData) tempIter34.next();
                g2D.setColor(Color.decode("#6E00FF"));
                g2D.fillOval((int) muysd.x(), (int) muysd.y(),50,50);
                g2D.setColor(Color.decode("#AB00DE"));
                g2D.setStroke(new BasicStroke(2));
                g2D.drawOval((int) muysd.x(), (int) muysd.y(),50,50);
                g2D.setColor(Color.WHITE);
                g2D.setFont(new Font("Arial",Font.BOLD,13));
                g2D.drawString("Node "+muysd.getKey(),(int) muysd.x()+3,(int) muysd.y()+30);
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        }
        if (DijekstraButton){
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Dijekstra Draw ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
            System.out.println("____________ Short Dijekstra from 2 to 5 = " +k.shortestPathDist(2, 5)+" _____________");
            java.util.List<NodeData> p = k.shortestPath(2, 5);
            //p.forEach(n-> System.out.println(n));
            for (int i = 0 ; i < p.size() ; i++){
                _NodeData dddgf =  new _NodeData();
                dddgf = (_NodeData) p.get(i);
                g2D.setColor(Color.GREEN);
                g2D.setFont(new Font("Arial",Font.BOLD,9));
                g2D.drawString("Dijekstra Path "+i, (int) dddgf.x(), (int) dddgf.y()-10);
            }
            for (int i = 0 ; i < p.size()-1 ; i++){
                _NodeData ermy =  new _NodeData();
                _NodeData ermy2 =  new _NodeData();
                ermy = (_NodeData) p.get(i);
                ermy2 = (_NodeData) p.get(i+1);
                g2D.setStroke(new BasicStroke(4));
                g2D.setColor(Color.GREEN);
                g2D.drawLine((int)ermy.x()+25,(int)ermy.y()+25,(int)ermy2.x()+25,(int)ermy2.y()+25);
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        }
        if (Center){
            System.out.println("__________________ Center Algo ____________________");
            NodeData NewCenterOfGraph = k.center();
            _NodeData muysd243 =  new _NodeData();
            muysd243 = (_NodeData) NewCenterOfGraph;
            g2D.setColor(Color.YELLOW);
            g2D.setStroke(new BasicStroke(5));
            g2D.drawOval((int) muysd243.x(), (int) muysd243.y(),50,50);
            g2D.setColor(Color.YELLOW);
            g2D.setFont(new Font("Arial",Font.BOLD,9));
            g2D.drawString("                             Center of Graph", (int) muysd243.x()-100, (int) muysd243.y()-20);
            System.out.println("____________________________________________________");
        }
        if (TSPButton){
            System.out.println("___________________________TSP________________________________");
            System.out.println(k.isConnected()+"is connected");
            g2D.setFont(new Font("Arial",Font.BOLD,10));
            g2D.setColor(Color.LIGHT_GRAY);
            g2D.drawString("EVERY NODE REACHABLE - [ "+k.isConnected()+" ]",(WIDTHwindow/2)-100,50);
            if (k.isConnected()){
                java.util.List<NodeData> p44 = new ArrayList<>();
                p44.add(T1);
                p44.add(T2);
                p44.add(T3);
                p44.add(T4);
                p44.add(T5);
                p44.add(T6);
                List<NodeData> p33 = k.tsp(p44);
                p33.forEach(n-> System.out.println(n));

                g2D.setColor(Color.LIGHT_GRAY);
                g2D.setFont(new Font("Arial",Font.CENTER_BASELINE,10));
                java.util.List<NodeData> cities321 = new ArrayList<>();
                Iterator<NodeData> tempIter32344 = _DWG.nodeIter();
                while (tempIter32344.hasNext()){
                    _NodeData muysd =  new _NodeData();
                    muysd = (_NodeData) tempIter32344.next();
                    cities321.add(muysd);
                }
                java.util.List<NodeData> ptsp = k.tsp(cities321);
                //p.forEach(n-> System.out.println(n));
                for (int i = 0 ; i < ptsp.size() ; i++){
                    _NodeData dd243dgf =  new _NodeData();
                    dd243dgf = (_NodeData) ptsp.get(i);
                    g2D.setColor(Color.CYAN);
                    g2D.setFont(new Font("Arial",Font.BOLD,9));
                    g2D.drawString("TSP Path "+i, (int) dd243dgf.x(), (int) dd243dgf.y()-10);
                }
                for (int i = 0 ; i < ptsp.size()-1 ; i++){
                    _NodeData e423rmy =  new _NodeData();
                    _NodeData er3my2 =  new _NodeData();
                    e423rmy = (_NodeData) ptsp.get(i);
                    er3my2 = (_NodeData) ptsp.get(i+1);
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(Color.magenta);
                    g2D.drawLine((int)e423rmy.x()+25,(int)e423rmy.y()+25,(int)er3my2.x()+25,(int)er3my2.y()+25);
                }

            }

            System.out.println("_______________________________________________________________");
        }
    }
}
