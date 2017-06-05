

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SubTaskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SubTaskTest
{
    @Test
    public void createInstanceOfSubTask() {
        SubTask emptySubTask = new SubTask();
        
        assertTrue(emptySubTask instanceof SubTask);
        assertTrue(emptySubTask instanceof Object);
    }
    
    // US1
    @Test
    public void readDescriptionProperty() {
        SubTask emptySubTask = new SubTask();
        
        assertEquals("", emptySubTask.getDescription());
    }
    
    @Test
    public void createSubTaskWithNameAndTimeToComplete() {
        SubTask subTask = new SubTask("t1", 4);
        
        assertEquals("t1", subTask.getName());
        assertEquals(4, subTask.getTimeToComplete());
    }
    
    @Test
    public void calculateTimeToCompleteForATaskAfterSubTasks(){
        SubTask subTask1 = new SubTask("t1", 4);
        SubTask subTask2 = new SubTask("t2", 2);
        Task task = new Task();
        task.addSubTask(subTask1);
        task.addSubTask(subTask2);
        assertEquals(6,task.getTimeToComplete());
       
    }
    
}
