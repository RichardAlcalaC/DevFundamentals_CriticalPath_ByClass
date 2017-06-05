
/**
 * Write a description of class SubTask here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubTask extends Task
{
    public SubTask () {
        super();
    }
    public SubTask (String name, int time) {
        super(name, time);
    }
    @Override
    public int getTimeToComplete()
    {
        return timeToComplete;
    }
}
