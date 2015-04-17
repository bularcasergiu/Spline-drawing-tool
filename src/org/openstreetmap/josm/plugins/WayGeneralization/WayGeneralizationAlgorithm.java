/**
 * 
 */
package org.openstreetmap.josm.plugins.WayGeneralization;

//import static org.openstreetmap.josm.plugins.contourmerge.util.Assert.checkArgNotNull;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JPanel;

import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.command.AddCommand;
import org.openstreetmap.josm.command.AddPrimitivesCommand;
import org.openstreetmap.josm.command.ChangeCommand;
import org.openstreetmap.josm.command.Command;
import org.openstreetmap.josm.command.DeleteCommand;
import org.openstreetmap.josm.command.SequenceCommand;
import org.openstreetmap.josm.data.Bounds;
import org.openstreetmap.josm.data.coor.LatLon;
import org.openstreetmap.josm.data.osm.DataSet;
import org.openstreetmap.josm.data.osm.Node;
import org.openstreetmap.josm.data.osm.Way;
import org.openstreetmap.josm.gui.MapView;
import org.openstreetmap.josm.gui.layer.MapViewPaintable;
//import org.openstreetmap.josm.plugins.contourmerge.ContourMergeModel;
//import org.openstreetmap.josm.plugins.contourmerge.ContourMergePlugin;
//import org.openstreetmap.josm.plugins.contourmerge.WaySlice;
import org.openstreetmap.josm.tools.Geometry;

/**
 * <p><strong>ContourMergeView</strong> renders the {@link ContourMergeModel} for the 
 * currently active data layer.</p>
 *
 */
public class WayGeneralizationAlgorithm extends JPanel{
	public static List<Command> cmm=new ArrayList<>();
	
	public  DataSet getDataSet()
	  {
	    return Main.main.getCurrentDataSet();
	  }
	
	public DataSet dataset = getDataSet();
	public Collection<Way> way = dataset.getSelectedWays();
	
	  /**
	   * add selection parameters in an List<way>
	   * 
	   * @return List<Way>
	   */
//	  public  List<Way> ListingWay(){
//			List<Way> waylist=new ArrayList<>();
//		    for (Way w : way){
//		    	waylist.add(w);
//			}
//		    return waylist;
//	  }
//	  public List<Way> waylist=ListingWay();
//	  
//	  /**
//	   * 
//	   */
//	  public List<Point> readPointsOnWayList(List<Way> waylist){
//		  List<Point> wpoints=new ArrayList<>();
//		  for(Way w:waylist){
//			  double[][] pct=new double[w.getNodes().size()][2];
//			  for(int i=0;i<w.getNodes().size();i++){
//				  pct[i][0]=w.getNode(i).getCoor().lat();
//				  pct[i][1]=w.getNode(i).getCoor().lon();
//			  }
//			  for(int i=0;i<pct.length;i++){
//				 Point point=new Point(pct[i][0], pct[i][1]);
//				 wpoints.add(point);
//			  }
//		  }
//		return wpoints;  
//	  }
//	  public List<Point> wpoints=readPointsOnWayList(waylist);
//	  
//	  /**
//	   * add first selection parameters in an List<way>
//	   * 
//	   * @return List<Way>
//	   */
//	  public  List<Way> getWay4(){
//		  List<Way> waylist=new ArrayList<>();
//		  List<Way> way4=new LinkedList<>();
//		  Way[] way3 = new Way[2] ;
//		  int c=0;
//		    for (Way w : way){
//		    	waylist.add(w);
//		    	way3[c]=w;
//				 c++;
//			  }
//		    way4.add(way3[0]);
//		    System.out.println("way4"+way4);
//		    return way4;
//	  }
//	  public List<Way> way4=getWay4();
//	  
//	  /**
//	   * add second selection parameters in an List<way>
//	   * 
//	   * @return List<Way>
//	   */
//	  public List<Way> getWay5(){
//		  List<Way> waylist=new ArrayList<>();
//		  List<Way> way5=new LinkedList<>();
//		  Way[] way3 = new Way[2] ;
//		  int c=0;
//		    for (Way w : way){
//		    	waylist.add(w);
//		    	way3[c]=w;
//				 c++;
//			  }
//		    way5.add(way3[1]);
//		    System.out.println("way5"+way5);
//		    return way5;
//	  }
//	  public List<Way> way5=getWay5();
//	  
//	  
//	  
//	  /**
//	   * 
//	   */
//	  public List<Point> readPointsOnWay4(List<Way> way4){
//		  List<Point> w4points=new ArrayList<>();
//		  for(Way w:way4){
//			  double[][] pct=new double[w.getNodes().size()][2];
//			  for(int i=0;i<w.getNodes().size();i++){
//				  pct[i][0]=w.getNode(i).getCoor().lat();
//				  pct[i][1]=w.getNode(i).getCoor().lon();
//			  }
//			  for(int i=0;i<pct.length;i++){
//				 Point point=new Point(pct[i][0], pct[i][1]);
//				 w4points.add(point);
//			  }
//		  }
//		return w4points;  
//	  }
//	  public List<Point> w4points=readPointsOnWay4(way4);
//	  
//	  public List<Point> readPointsOnWay5(List<Way> way5){
//		  List<Point> w5points=new ArrayList<>();
//		  for(Way w:way5){
//			  double[][] pct=new double[w.getNodes().size()][2];
//			  for(int i=0;i<w.getNodes().size();i++){
//				  pct[i][0]=w.getNode(i).getCoor().lat();
//				  pct[i][1]=w.getNode(i).getCoor().lon();
//			  }
//			  for(int i=0;i<pct.length;i++){
//				 Point point=new Point(pct[i][0], pct[i][1]);
//				 w5points.add(point);
//			  }
//		  }
//		return w5points;  
//	  }
//	  public List<Point> w5points=readPointsOnWay5(way5);
	  
	  /**
	   * 
	   */
	  public List<Node> Algorithm(List<Point> w4points,List<Point> w5points, double detail){
		  //double detail = 0.025;
		  if ( detail > 1 || detail < 0 ){

				throw new IllegalStateException("");

			}
		  List<Point> controls=new ArrayList<>();
		  controls.add(w4points.get(0));
		  controls.add(w5points.get(0));
		  controls.add(w4points.get(1));
		  controls.add(w5points.get(1));
		  List<Point> renderingPoints = new ArrayList<Point>();

			List<Point> controlPoints = new ArrayList<Point>();

			//generate the end and control points

			for ( int i = 1; i < controls.size() - 1; i+=2 ){

				controlPoints.add(center(controls.get(i-1), controls.get(i)));

				controlPoints.add(controls.get(i));

				controlPoints.add(controls.get(i+1));

				if ( i+2 < controls.size() - 1 ){

					controlPoints.add(center(controls.get(i+1), controls.get(i+2)));

				}

			}

			//Generate the detailed points. 

			Point a0, a1, a2, a3;

			for ( int i = 0; i < controlPoints.size() - 2; i+=4 ){

				a0 = controls.get(i);

				a1 = controls.get(i+1);

				a2 = controlPoints.get(i+2);

				if ( i + 3 > controlPoints.size() - 1 ){

					//quad

					for ( double j = 0; j < 1; j += detail){

						renderingPoints.add(quadBezier(a0,a1,a2,j));

					}

				}else{

					//cubic

					a3 = controlPoints.get(i+3);

					for ( double j = 0; j < 1; j += detail){

						renderingPoints.add(cubicBezier(a0,a1,a2,a3,j));

					}

				}

			}

			

			//List<Point> points = new ArrayList<>(renderingPoints.size());
			//renderingPoints.add(w4.getNode(w4.getNodes().size()-1));
			List<LatLon> rendLatList=new ArrayList<>();
			for(int i=0;i<renderingPoints.size();i++){
				System.out.println("punctele sunt:"+renderingPoints.get(i));
				LatLon rendLatLon=new LatLon(renderingPoints.get(i).x,renderingPoints.get(i).y);
				rendLatList.add(rendLatLon);
			}
			
			List<Node> rendNodeList=new ArrayList<>();
			for(int i=0;i<rendLatList.size();i++){
				Node renderingNodes=new Node(rendLatList.get(i));
				rendNodeList.add(renderingNodes);
			}
			System.out.println("RendNodes="+rendNodeList);
			//dataset.addPrimitive(rendNodeList.get(1));
//			for(Node n:rendNodeList){
//				if(!dataset.containsNode(n)){
//					System.out.println("nnnnnnnn="+n);
//					cmm.add(new AddCommand(n));
//				}
//			}
			
//		
//			Way newWayR = new Way(way4);
//			newWayR.setNodes(rendNodeList);
			
			//cmm.add(new ChangeCommand(way4, newWayR));
			
//			Main.main.undoRedo.add(new SequenceCommand("crrr", cmm));
//		    Main.map.repaint();
			return rendNodeList;
	  }
	  
	  /**

	   * A cubic bezier method to calculate the point at t along the Bezier Curve give

	   * the parameter points.

	   * @param a0

	   * @param a1

	   * @param a2

	   * @param a3

	   * @param t A value between 0 and 1, inclusive. 

	   * @return

	   */

	  public static Point cubicBezier(Point a0, Point a1, Point a2, Point a3, double t){

	  	return new Point(

	  			cubicBezierPoint(a0.x, a1.x, a2.x, a3.x, t), 

	  			cubicBezierPoint(a0.y, a1.y, a2.y, a3.y, t)); 

	  			//cubicBezierPoint(p1.z, p2.z, p3.z, p4.z, t));

	  }



	  /**

	   * A quadratic Bezier method to calculate the point at t along the Bezier Curve give

	   * the parameter points.

	   * @param p1

	   * @param p2

	   * @param p3

	   * @param t A value between 0 and 1, inclusive. 

	   * @return

	   */

	  public static Point quadBezier(Point p1, Point p2, Point p3, double t){
		  

	  	return new Point(

	  			quadBezierPoint(p1.x, p2.x, p3.x, t), 

	  			quadBezierPoint(p1.y, p2.y, p3.y, t) 

	  			//quadBezierPoint(p1.z, p2.z, p3.z, t)
	  			);

	  }

	  /**

	   * The cubic Bezier equation. 

	   * @param a0

	   * @param a1

	   * @param a2

	   * @param a3

	   * @param t

	   * @return

	   */

	  private static double cubicBezierPoint(double a0, double a1, double a2, double a3, double t){

	  	return Math.pow(1-t, 3) * a0 + 3* Math.pow(1-t, 2) * t * a1 + 3*(1-t) * Math.pow(t, 2) * a2 + Math.pow(t, 3) * a3;

	  }



	  /**

	   * The quadratic Bezier equation,

	   * @param a0

	   * @param a1

	   * @param a2

	   * @param t

	   * @return

	   */

	  private static double quadBezierPoint(double a0, double a1, double a2, double t){

	  	return Math.pow(1-t, 2) * a0 + 2* (1-t) * t * a1 + Math.pow(t, 2) * a2;

	  }



	  /**

	   * Calculates the center point between the two parameter points.

	   * @param p1

	   * @param p2

	   * @return

	   */

	  public static Point center(Point p1, Point p2){

	  	return new Point(

	  			(p1.x + p2.x) / 2, 

	  			(p1.y + p2.y) / 2

	  			//(p1.z + p2.z) / 2

	  			);
	  }
}
