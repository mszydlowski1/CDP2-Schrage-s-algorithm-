package Logic;

import Data.DataFile;
import Data.Task;
import Data.Task.AccessTimeComparator;
import Data.Task.DeliverTimeComparator;


import java.util.PriorityQueue;

public class WorkingWithTasks {

    public static int Cmax(DataFile df)
    {
        int t = 0;
        //int k = 0;
        Task task = new Task (0, 0, 0);
        Task l = new Task (0, 0, 0);
        int Cmax = 0;
        PriorityQueue<Task> G = new PriorityQueue<>(df.getNumberOfTasks(), new DeliverTimeComparator()); //kolejka o najwiekszym delivertime
        PriorityQueue<Task> N = new PriorityQueue<>(df.getNumberOfTasks(), new AccessTimeComparator()); //kolejka o najmniejszym accestime
        for (int i = 0; i < df.getNumberOfTasks(); i++) //wypelnienie kolejki N zadaniami z pliku
        {
            N.add(df.getOneTask(i));
        }
//////////////ALGORYTM SCHRAGE'A Z PODZIAŁEM///////////////////////////
        while (G.size() != 0 || N.size() != 0)
        { //jesli rozmiar G i N nie równa się 0 to
            while (N.size() != 0 && N.peek().getAccessTime() <= t) //jesli rozmiar N nie rowna sie 0 i AT obiektu z kolejki N jest mniejszy rowny t, to
            {
                task = N.poll();
                G.add(task); //pobierz obiekt z kolejki n i dodaj do kolejki G

                if (task.getDeliverTime() > l.getDeliverTime())
                {
                    l.setOperatingTime(t - task.getAccessTime());
                    t = task.getAccessTime();
                    if (l.getOperatingTime() > 0)
                    {
                        G.add (l);
                    }
                }
            }
            if (G.size() == 0)   //kiedy zbiór zadań uporzadkowanych jest pusty - np dopiero zaczynamy
            {
                t = N.peek().getAccessTime();   // za t przyjmujemy czas dostepnosci elementu dostepnego najszybciej
            } else    //kiedy rozmiar G nie jest 0, to
            {
                task = G.poll();   //moment wrzucenia zadania na maszyne
                l = task;
                t = t + task.getOperatingTime();  // tL = moment zakonczenia zadania, tP moment rozpoczecia zadania///////
                Cmax = Math.max(Cmax, t + task.getDeliverTime());  //CmaxL = maksymalny moment wykonania zadań
            }
        }
        return Cmax;   //zwroc czas wykonania wszystkich zadań z harmonogramu
    }
}







/*
//////////////ALGORYTM SCHRAGE'A///////////////////////////
        while (G.size() != 0 || N.size() != 0)
        { //jesli rozmiar G i N nie równa się 0 to
            while (N.size() != 0 && N.peek().getAccessTime() <= t) //jesli rozmiar N nie rowna sie 0 i AT obiektu z kolejki N jest mniejszy rowny t, to
            {
                G.add(N.poll()); //pobierz obiekt z kolejki n i dodaj do kolejki G
            }
            if (G.size() == 0) {  //kiedy rozmiar G jest 0, to
                t = N.peek().getAccessTime();   // t rowna sie AT pobrany z obiektu kolejki N
            } else {   //kiedy rozmiar G nie jest 0, to
                Task task = G.poll();   //pobierz do task obiekt z kolejki G
                k++; //zwieksz k o 1
                t = t + task.getOperatingTime();  // i t = t plus OT z obiektu task (utworonego wyzej)
                Cmax = Math.max(Cmax, t + task.getDeliverTime());  //Cmax rowna sie liczba wieksza z cmax, albo t plus DT z obiektu task
            }
        }
        return Cmax;   //zwroc cmax
    }
 */

