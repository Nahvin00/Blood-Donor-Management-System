package View;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame {
   
   public BarChart_AWT( String applicationTitle , String chartTitle , String data[][]) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Event Names",            
         "Number of participants",            
         createDataset(data),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   public CategoryDataset createDataset(String data[][]) {
      final String event1 = data[0][0];        
      final String event2 = data[0][1];        
      final String event3 = data[0][2];        
      final String event4 = data[0][3];        
      final String event5 = data[0][4];             
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( Float.parseFloat(data[2][0]) , event1 , event1);        
      dataset.addValue( Float.parseFloat(data[2][1]) , event2 , event2 );        
      dataset.addValue( Float.parseFloat(data[2][2]) , event3 , event3 ); 
      if(data[2][3]!=null)
    	  dataset.addValue( Float.parseFloat(data[2][3]) , event4 , event4 );
      if(data[2][4]!=null)
    	  dataset.addValue( Float.parseFloat(data[2][4]) , event5 , event5 );
              
      
      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   String[][] data = new String[3][5];
	   BarChart_AWT chart = new BarChart_AWT("Event Attendance Statisics", 
		         "Number of participants across events", data);
		      chart.pack( );        
		      RefineryUtilities.centerFrameOnScreen( chart );        
		      chart.setVisible( true ); 
   }
}