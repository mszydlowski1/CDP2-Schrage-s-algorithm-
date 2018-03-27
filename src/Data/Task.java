package Data;

import java.util.Comparator;

public class Task {
    private int accessTime;
    private int operatingTime;

    public int getAccessTime()
    {
        return accessTime;
    }

    public int getOperatingTime()
    {
        return operatingTime;
    }

    public Task (int acesTime, int serviceTime)
    {
        this.accessTime = acesTime;
        this.operatingTime = serviceTime;
    }


    public String toString()    //przeciążenie funkcij toString, w celu wyświetlania danych
    {
        StringBuilder haveToReturn = new StringBuilder();
        haveToReturn.append(accessTime);
        haveToReturn.append("     ");
        haveToReturn.append(operatingTime);
        haveToReturn.append("\n");
        return haveToReturn.toString();

    }

    public static class AccessTimeComparator implements Comparator<Task> {
        public int compare(Task first, Task second)    //przeciazenie funkcij compare, interfejsu  Comparator
        {                                               //w celu porównania obiektów klasy Task
            return first.getAccessTime() - second.getAccessTime();
        }
    }
}
