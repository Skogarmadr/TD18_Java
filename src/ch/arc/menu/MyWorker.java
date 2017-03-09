package ch.arc.menu;

import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MyWorker extends SwingWorker<String, Integer>
{

    public MyWorker()
    {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void process(List<Integer> chunks)
    {
        
        System.out.println("Process - is edt " + SwingUtilities.isEventDispatchThread());
        for(Integer jInteger : chunks)
        {
            System.out.println("Process " + jInteger);
        }
    }

    @Override
    protected void done()
    {
        System.out.println("DOOOONEE");
        System.out.println("Process - is edt " + SwingUtilities.isEventDispatchThread());
    }
    
    @Override
    protected String doInBackground() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
