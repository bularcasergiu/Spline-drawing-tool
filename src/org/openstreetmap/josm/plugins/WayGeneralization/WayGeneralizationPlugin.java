package org.openstreetmap.josm.plugins.WayGeneralization;

import java.awt.Dialog;
import java.util.ArrayList;

import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.data.osm.DataSet;
import org.openstreetmap.josm.data.osm.Node;
import org.openstreetmap.josm.data.osm.Relation;
import org.openstreetmap.josm.gui.IconToggleButton;
import org.openstreetmap.josm.gui.MainMenu;
import org.openstreetmap.josm.gui.MapFrame;
import org.openstreetmap.josm.gui.dialogs.ToggleDialog;
import org.openstreetmap.josm.gui.preferences.PreferenceSetting;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
//import org.openstreetmap.josm.plugins.contourmerge.ContourMergeMode;
//import org.openstreetmap.josm.plugins.contourmerge.ContourMergeModelManager;
//import org.openstreetmap.josm.plugins.contourmerge.ContourMergeView;
//import org.openstreetmap.josm.plugins.ContourOverlappingMerge.ContourOverlappingAction;
import org.openstreetmap.josm.plugins.turnrestrictions.preferences.PreferenceEditor;



/**
 * <strong>ContourMergePlugin</strong> is the main class for the <tt>contourmerge</tt> 
 * plugin.
 */
public class WayGeneralizationPlugin extends Plugin{
	private final ArrayList<Relation> turnrestrictions = new ArrayList<Relation>();
	//public Dialog ToggleDialog;
	//private AreasAction exportAction;
	
    public WayGeneralizationPlugin(PluginInformation info) {
        super(info);
        //WayGeneralizationAction plg= new WayGeneralizationAction();
        //MainMenu.add(Main.main.menu.moreToolsMenu, new MergeOverlapAction());
        //System.out.println(getPluginDir());
    }
    
    /**
     * Called when the JOSM map frame is created or destroyed. 
     */
    @Override
    
    public void mapFrameInitialized(MapFrame oldFrame, MapFrame newFrame) {             
        if (oldFrame == null && newFrame != null) { // map frame added
        	
        	Main.map.addMapMode(new IconToggleButton(new WayGeneralizationAction(Main.map)));
//            WayGeneralizationAction.staticNode = new Node();
//            DataSet _dataSet = Main.map.mapView.getEditLayer().data;
//            _dataSet.addPrimitive(WayGeneralizationAction.staticNode);
//            System.out.println("ADDED NODE " + WayGeneralizationAction.staticNode);
			//sss=new AreasSelector(mapFrame);
        	
            //TurnRestrictionsListDialog dialog  = new TurnRestrictionsListDialog();
            //add the dialog
            //newFrame.addToggleDialog(dialog);
            //CreateOrEditTurnRestrictionAction.getInstance();
        }
    }

    @Override
    public PreferenceSetting getPreferenceSetting() {
        return new PreferenceEditor();
    }

}