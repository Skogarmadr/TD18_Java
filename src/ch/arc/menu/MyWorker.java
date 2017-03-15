package ch.arc.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import javax.swing.SwingWorker;


public class MyWorker extends SwingWorker<Integer, Integer>
{
    String pathFolder;

    public MyWorker(String pathFolder)
    {
        this.pathFolder = pathFolder;
    }

    @Override
    protected Integer doInBackground() throws Exception
    {
        int count = 0;
        try
        {
            count = (int) (Files.find(Paths.get(pathFolder), 1, // how deep do we want to descend
                    (path, attributes) -> attributes.isDirectory())
                    .count() - 1); // '-1' because '/tmp' is also counted in
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return count;
    }
    
    
}
