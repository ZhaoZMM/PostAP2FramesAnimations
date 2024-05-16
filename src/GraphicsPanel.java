import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private BufferedImage starImg;
    private BufferedImage bBG;
    private BufferedImage dVD;
    private double stringX;
    private double starY;
    private double dVDX;
    private double dVDY;
    private boolean dVDRight;
    private boolean dVDUp;

    public GraphicsPanel() {
        stringX = 50;
        starY = 50;
        dVDX = 0;
        dVDY = 0;
        dVDRight = true;
        dVDUp = false;
        try {
            starImg = ImageIO.read(new File("src/star.png"));
            bBG = ImageIO.read(new File("src/blackBG.png"));
            dVD = ImageIO.read(new File("src/DVD.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
        stringX += 0.2;
        if (stringX > 500) {
            stringX = 0;
        }
        starY += 0.05;
        if (starY > 500) {
            starY = 0;
        }
        if (dVDRight){
            dVDX += 0.25;
            if(dVDX > 1430){
                dVDRight = false;
            }
        }else{
            dVDX -= 0.25;
            if(dVDX < 0){
                dVDRight = true;
            }
        }
        if (dVDUp){
            dVDY -= 0.25;
            if(dVDY < 0){
                dVDUp = false;
            }
        }else{
            dVDY += 0.25;
            if(dVDY > 800){
                dVDUp = true;
            }
        }
        g.drawImage(bBG,0,0,null);
        g.setColor(Color.BLUE);
        g.drawRect(50, 100, 40, 20);
        g.setColor(Color.RED);
        g.fillRect(50, 200, 40, 20);
        g.drawImage(starImg, 200, (int) starY, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 18));
        g.drawString("HELLO!", (int) stringX, 300);
        g.drawImage(dVD,(int)dVDX,(int)dVDY,null);
    }
}
