package org.openstreetmap.josm.plugins.WayGeneralization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.util.Pair;

import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.command.AddCommand;
import org.openstreetmap.josm.command.ChangeCommand;
import org.openstreetmap.josm.command.Command;
import org.openstreetmap.josm.command.DeleteCommand;
import org.openstreetmap.josm.data.coor.LatLon;
import org.openstreetmap.josm.data.osm.Node;
import org.openstreetmap.josm.data.osm.OsmPrimitive;
import org.openstreetmap.josm.data.osm.Way;

public class Test {
	
	 public Pair<List<Node>,Node> GetNodes(int index,Way way,Node n0,Node n, Collection<Command> cmds){
	    	
	    	List<org.openstreetmap.josm.plugins.WayGeneralization.Point> w4points =new ArrayList<>();
	        List<org.openstreetmap.josm.plugins.WayGeneralization.Point> w5points =new ArrayList<>();
	        
	        //List<NodePos> npos=new ArrayList<>();
	        List<Node> vect=new ArrayList<>();
	        List<Node> All=new ArrayList<>();
	        Way newWay = new Way();
	    	Way newWay2 = new Way();
	    	double detail=0.1;

	    	double xm=0;
	    	double ym=0;
	    	double x1=0;
	    	double y1=0;
	    	double x2=0;
	    	double y2=0;
	    	
	        double pp1x=0;
	        double pp1y=0;
	        double pp2x=0;
	        double pp2y=0;
	        
	        double pp1x4=0;
	        double pp1y4=0;
	        double pp2x4=0;
	        double pp2y4=0;
	        
	        Node n1=null;
	        
	    	//way.addNode(n);
	    	if(index <0){
	    		System.out.println("n0="+n0);
	       	 	System.out.println("n="+n);
	       	 	
	       	 
					newWay.addNode(n0);
					newWay.addNode(n);
					System.out.println("newway="+newWay);
					System.out.println("way="+way);
					
					
					pp1x=n0.getCoor().lat();
	                pp1y=n0.getCoor().lon();
	                pp2x=n.getCoor().lat();
	                pp2y=n.getCoor().lon();
	                
	                org.openstreetmap.josm.plugins.WayGeneralization.Point p1a=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp1x, pp1y);
	                org.openstreetmap.josm.plugins.WayGeneralization.Point p1b=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp2x, pp2y);
	                w4points.add(p1a);
	                w4points.add(p1b);
	                System.out.println("w4pctttt="+w4points);
	                //index++;
	    	}
	    	else if(index%2!=0)
	    	{
	    		System.out.println("n0="+n0);
	       	 	System.out.println("n="+n);
	    		//way.addNode(n);
	    		newWay.addNode(n0);
				newWay.addNode(n);
	    		Node n_1=way.getNode(way.getNodesCount() - 2);
	    		pp1x4=n_1.getCoor().lat();
	            pp1y4=n_1.getCoor().lon();
	            pp2x4=n0.getCoor().lat();
	            pp2y4=n0.getCoor().lon();
	            
	            org.openstreetmap.josm.plugins.WayGeneralization.Point p1a4=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp1x4, pp1y4);
	            org.openstreetmap.josm.plugins.WayGeneralization.Point p1b4=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp2x4, pp2y4);
	            w4points.add(p1a4);
	            w4points.add(p1b4);
	            System.out.println("w4pctttt="+w4points);
	            
	    		System.out.println("n="+n);
	    		newWay2.addNode(n0);
	    		newWay2.addNode(n);
	    		xm=n0.getCoor().lat();
	    		ym=n0.getCoor().lon();
	    		x1=n.getCoor().lat();
	    		y1=n.getCoor().lon();
	    		x2=2*xm-x1;
	    		y2=2*ym-y1;
	    		 n1=new Node(new LatLon(x2, y2));
	    		newWay2.addNode(n1);
//	    		cmds.add(new AddCommand(n0));
//	    		cmds.add(new AddCommand(n));
	    		//cmds.add(new AddCommand(n1));
	    		//cmds.add(new AddCommand(newWay2));
	    		System.out.println("n111"+n1);
	    		
	   			System.out.println("newway="+newWay);
	   			System.out.println("way="+way);

	   			
	   			System.out.println("Ellllim="+n);
	   			//way.removeNode(n);
	   			
	   			//way.removeNode(n);
	   			
	   			//cmds.add(new DeleteCommand(n));
	            pp1x=n1.getCoor().lat();
	            pp1y=n1.getCoor().lon();
	            pp2x=n.getCoor().lat();
	            pp2y=n.getCoor().lon();
	             
	            org.openstreetmap.josm.plugins.WayGeneralization.Point p1a=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp1x, pp1y);
	            org.openstreetmap.josm.plugins.WayGeneralization.Point p1b=new org.openstreetmap.josm.plugins.WayGeneralization.Point(pp2x, pp2y);
	            w5points.add(p1a);
	            w5points.add(p1b);
	            System.out.println("w5pctttt="+w5points);
	            //index++;
	    	}
	    	if(index>0){
	        	WayGeneralizationAlgorithm alg=new WayGeneralizationAlgorithm();
	        	System.out.println("w4pct="+w4points);
	        	System.out.println("w5pct="+w5points);
//	        	
//	        	for(int i=0;i<way.getNodes().size();i++){
//	        		All.add(way.getNode(i));
//	        	}
	        	
	        	vect=alg.Algorithm(w4points, w5points, detail);
//	        	Way newWayR = new Way(way);
//	        	//newSelection.add(way);
//	        	for(Node nn:vect){
//	        		All.add(All.size()-1, nn);
//	        		//newSelection.add(nn);
//  					//cmds.add(new AddCommand(nn));
//  					
//  					//way.addNode(way.getNodesCount() - 1,nn);
//  					//cmds.add(new AddCommand(way));
//  				}
//	        	newWayR.setNodes(All);
//	        	//newSelection.add(way);
//	        	//cmds.add(new DeleteCommand(newWay2));
//	        	//newWayR.setNodes(All);
//				//cmds.add(new ChangeCommand(way, newWayR));
//  			   // Main.map.repaint();
	    	}
	    	
	    	return new Pair<List<Node>,Node>(vect,n1);
	    
	    }
}
