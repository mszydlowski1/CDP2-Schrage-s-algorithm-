package Logic;

import Data.DataFile;
import Data.Task;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class WorkingWithDataFile {

    public static void readTasks (DataFile df)
    {
        File dataFile = new File(df.getFileName());  //tworze nowy plik o nazwie dataFile aby móc czytać dane

        try
        {
            Scanner input = new Scanner(dataFile);   //tworze obiekt Scanner o nazwie input, aby za jego pomova czyatc dane
            df.setNumberOfTasks(input.nextInt());    //czytam ilosc zadań

            for(int i = 0; i < df.getNumberOfTasks(); i++)    //petla, dzieki ktorej splikacja przeczyta dane (r - termin dostępności i p - czas obsługi zadania)
            {
                int accessTime = input.nextInt();    //aplikacja czyta termin dostepnosci
                int operatingTime = input.nextInt();    //aplikacja czyta czas obslugi zadania
                Task t = new Task (accessTime, operatingTime);    //aplikacja tworzy nowe zadania (to zczytane z pliku)
                df.setOneTask(t);    //aplikacja dodaje zadanie do listy obiektu df
            }
        } catch (FileNotFoundException ex)    //obsluga wyjatku, który polega na nie znalezieniu ppliku o nazwie zadanej przez uczytkownika
        {
            System.out.println("Plik o nazwie " + df.getFileName() +" nie zostal znaleziony.");
        }
    }
}
