package Data;

import java.util.ArrayList;
import java.util.List;

public class DataFile {
    private String fileName;
    private int numberOfTasks;
    private List<Task> allTasks;

    public DataFile (String fileName)
    {
        this.fileName = fileName;
        allTasks = new ArrayList<>();
    }

    public String getFileName ()
    {
        return fileName;
    }

    public int getNumberOfTasks ()
    {
        return numberOfTasks;
    }

    public void setNumberOfTasks (int numberOfTasks)
    {
        this.numberOfTasks = numberOfTasks;
    }

    public List<Task> getAllTasks ()
    {
        return allTasks;
    }
    public void setAllTasks (List<Task> t)
    {
        allTasks = t;
    }

    public Task getOneTask (int i)
    {
        return allTasks.get(i);
    }
    public void setOneTask(Task t)
    {
        allTasks.add(t);
    }

    public String toString()    //przeciążenie funkcij toString, w celu wyświetlania danych
    {
        StringBuilder haveToReturn = new StringBuilder();
        haveToReturn.append(numberOfTasks + "\n");
        for (int i = 0; i < allTasks.size(); i++)
        {
            haveToReturn.append(allTasks.get(i).toString());
        }
        return haveToReturn.toString();
    }



}
