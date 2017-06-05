
import javax.swing.JFrame;

public class DrowingWindow extends JFrame
{
    private DrowingPanel panel;
    
    DrowingWindow(String title)
    {
        super(title);
        panel = new DrowingPanel();
        
        getContentPane().add(panel);
        
    }

    public static void main (String args [])
    {
        DrowingWindow window = new DrowingWindow("Drowing Samle");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
