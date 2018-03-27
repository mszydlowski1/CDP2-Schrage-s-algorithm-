package Data;

import java.util.Comparator;

public class Task {
    private int accessTime;
    private int operatingTime;
    private int deliverTime;

    public int getAccessTime()
    {
        return accessTime;
    }

    public int getOperatingTime()
    {
        return operatingTime;
    }

    public int getDeliverTime ()
    {
        return deliverTime;
    }

    public Task (int acesTime, int serviceTime, int deliverTime)
    {
        this.accessTime = acesTime;
        this.operatingTime = serviceTime;
        this.deliverTime = deliverTime;
    }


    public String toString()    //przeciążenie funkcij toString, w celu wyświetlania danych
    {
        StringBuilder haveToReturn = new StringBuilder();
        haveToReturn.append(accessTime);
        haveToReturn.append("     ");
        haveToReturn.append(operatingTime);
        haveToReturn.append("     ");
        haveToReturn.append(deliverTime);
        haveToReturn.append("\n");
        return haveToReturn.toString();

    }


    public static class AccessTimeComparator implements Comparator<Task> {
        @Override
        public int compare(Task first, Task second)    //przeciazenie funkcij compare, interfejsu  Comparator
        {                                               //w celu porównania obiektów klasy Task (od najmniejszego AT do najwiekszego)
            int com = first.getAccessTime() - second.getAccessTime();
            return com;
        }
    }

    public static class DeliverTimeComparator implements Comparator<Task> {
        @Override
        public int compare(Task first, Task second)    //przeciazenie funkcij compare, interfejsu  Comparator
        {                                               //w celu porównania obiektów klasy Task (od najwiekszego DT do najmniejszego)
            int com = second.getDeliverTime() - first.getDeliverTime();
            return com;
        }
    }
}
