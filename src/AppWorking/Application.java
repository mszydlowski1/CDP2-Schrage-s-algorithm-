package AppWorking;
import Data.DataFile;
import Logic.WorkingWithDataFile;
import Logic.WorkingWithTasks;

public class Application {

    public static void main(String[] args)
    {
        DataFile newDataFile = new DataFile("dataFiles/JACK1.DAT");
        WorkingWithDataFile.readTasks(newDataFile);    //Przypisanie zadań do listy zadań
        System.out.println("Zadania przed posortowaniem:" + "\n");
        System.out.println(newDataFile);
        WorkingWithTasks.sortTasks(newDataFile);    //posortowanie zadań
        System.out.println("Zadania po posortowaniu:" + "\n");
        System.out.println(newDataFile);
        System.out.println("CMAX, to:" + "\n");
        System.out.println(WorkingWithTasks.Cmax(newDataFile));

    }
}
