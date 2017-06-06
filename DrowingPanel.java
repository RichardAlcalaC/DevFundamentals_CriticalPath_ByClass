import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrowingPanel extends JPanel
{
    public DrowingPanel()
    {
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                System.out.println(String.format("click at, %s, %s", event.getX(), event.getY()));
            }
        });
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.white);
        int w=5;
        int h=100;
        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;
        g.fillOval(xCenter-(50/2), yCenter-(50/2), 50, 50);
    }
}
