

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProjectTest
{
    //US0
    @Test
    public void createAnEmptyProject() {
        Project project = new Project();
        
        assertTrue(project instanceof Project);
    }
    
    //US0
    @Test
    public void createAProjectWithName() {
        Project project = new Project("My First Project");
        
        assertTrue(project instanceof Project);
        assertEquals("My First Project", project.getName());
    }
    
    //US1
    @Test
    public void calculateTimeToDeliverOfASingleTask() {
        Project project = new Project("sample");
        Task singleTask = new Task();
        singleTask.setTimeToComplete(5);
        
        project.addTask(singleTask);
        
        assertEquals(5, project.calculateTimeToDelivery());
    }
    
    //US1
    @Test
    public void calculateTimeToDeliveryOf2NonDependentTasks() {
        Project project = new Project("sample");
        
        Task firstTask = new Task("t1", 6);
        Task secondTask = new Task("t2", 3);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        
        //project.getTasks().add("another task");
        
        assertEquals(6, project.calculateTimeToDelivery());
    }
    
    //US1
    @Test
    public void calculateTimeToDeliveryOf2DependentTasks() {
        Project project = new Project("sample");
        
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 3);
        
        secondTask.dependsOn(firstTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
                
        assertEquals(8, project.calculateTimeToDelivery());
    }
    
    //Task with 2 dependents
    @Test
    public void calculateTimeToDeliveryOfOneTasksWith2DependentTasks() {
        Project project = new Project("sample");
        
        Task t1 = new Task("t1", 5);
        Task t2 = new Task("t2", 3);
        Task t3 = new Task("t2", 2);
                
        t3.dependsOn(t1);
        t3.dependsOn(t2);
        
        project.addTask(t1);
        project.addTask(t2);
        project.addTask(t3);
                
        assertEquals(7, project.calculateTimeToDelivery());
    }
    
    //Task For A Diamond Shaped
    @Test
    public void calculateTimeForADiamondShapedDependency() {
        Project project = new Project("sample");
        
        Task t1 = new Task("t1", 5);
        Task t2 = new Task("t2", 2);
        Task t3 = new Task("t3", 6);
        Task t4 = new Task("t4", 1);
                
        t2.dependsOn(t1);
        t3.dependsOn(t1);
        t4.dependsOn(t2);
        t4.dependsOn(t3);
        
        project.addTask(t1);
        project.addTask(t2);
        project.addTask(t3);
        project.addTask(t4);
                
        assertEquals(12, project.calculateTimeToDelivery());
    }
    
    //Test For Project With Odd Path
    @Test
    public void calculateTimeForProjectWithOddPath() {
        Project project = new Project("ForProjectWithOddPath");
        
        Task t0 = new Task("t1", 10);
        Task t1 = new Task("t1", 5);
        Task t2 = new Task("t2", 2);
        Task t3 = new Task("t3", 6);
        Task t4 = new Task("t4", 1);
        
        //Task t5 = new Task("t5", 99);
        
        t1.dependsOn(t0);
        t2.dependsOn(t1);
        t3.dependsOn(t1);
        t4.dependsOn(t2);
        t4.dependsOn(t3);
        
        project.addTask(t0);
        project.addTask(t1);
        project.addTask(t2);
        project.addTask(t3);
        project.addTask(t4);
        
        project.addTask(new Task("t5", 21));
        
        assertEquals(22, project.calculateTimeToDelivery());
    }
    
    //US3
    @Test
    public void modifyTaskTimeToComplete()
    {
        Project project = new Project("ForProjectWithOddPath");
        
        Task t0 = new Task("t1", 10);
        Task t1 = new Task("t1", 5);
        Task t2 = new Task("t2", 2);
        Task t3 = new Task("t3", 6);
        Task t4 = new Task("t4", 1);
        
        //Task t5 = new Task("t5", 99);
        
        t1.dependsOn(t0);
        t2.dependsOn(t1);
        t3.dependsOn(t1);
        t4.dependsOn(t2);
        t4.dependsOn(t3);
        
        project.addTask(t0);
        project.addTask(t1);
        project.addTask(t2);
        project.addTask(t3);
        project.addTask(t4);
        
        assertEquals(22, project.calculateTimeToDelivery());
        
        t2.setTimeToComplete(3);
        
        //assertEquals(23, project.calculateTimeToDelivery());
        
    }
}
