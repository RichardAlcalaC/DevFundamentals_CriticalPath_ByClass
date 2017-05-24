import java.util.Vector;

/**
 * Write a description of class Task here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Task
{
    private String name;
    private String description;
    private int timeToComplete;
    private String owner;
    
    //private Task preRequisite;
    private Vector <Task> preRequisiteTasks; 
    
    public Task() {
        description = "";
        owner = "";
        name = "";
    }
    
    public Task(String name, int timeToComplete) {
        this.name = name;
        this.timeToComplete = timeToComplete;
        preRequisiteTasks = new Vector <Task> ();
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setTimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTimeToComplete() {
        return timeToComplete;
    }
    
    public void dependsOn(Task otherTask) {
        //preRequisite = otherTask;
        preRequisiteTasks.add(otherTask);
    }
    
    public Vector getPreRequisites() {
        //return preRequisite;
        return preRequisiteTasks;
    }
    
    //Task with 2 dependents
   public int calculateTimeToComplete() {
        int time = getTimeToComplete();
        Vector preTasks=getPreRequisites();
        if (preTasks != null) {
           int maxTimePre = 0;
	       for(int i=0; i<preTasks.size(); i++){
	           int taskTime = ((Task) preTasks.elementAt(i)).getTimeToComplete();
		       if(taskTime > maxTimePre)
		           maxTimePre = taskTime;
           }
	       time = time + maxTimePre;
        }
        return time;
    }
}
