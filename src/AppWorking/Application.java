package AppWorking;
import Data.DataFile;
import Logic.WorkingWithDataFile;
import Logic.WorkingWithTasks;

public class Application {

    public static void main(String[] args)
    {
        DataFile newDataFile = new DataFile("dataFiles/SCHRAGE2.DAT");  //WCZYTANIE PLIKU
        WorkingWithDataFile.readTasks(newDataFile);    //Przypisanie zadań do listy zadań
        System.out.println(newDataFile);               //WYSWIETLENIE WCZYTANEGO PLIKU
        System.out.println(WorkingWithTasks.Cmax(newDataFile));  //obliczenie i wyswietlenie CMAX
    }
}
