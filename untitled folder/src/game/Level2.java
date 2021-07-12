package game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Level2 extends MouseAdapter {

    private Game game;
    private Handler handler;

    public Level2(Game app, Handler handler){
        this.game = app;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {

        if(game.gameState == Game.STATE.Level2) {
            int mx = e.getX();
            int my = e.getY();
            // back button
            if (mouseOver(mx, my, 1160, 20, 100, 100)) {
                game.gameState = Game.STATE.LevelLibrary;
            }
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }
        }
        return false;
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void tick() {
    }

    public void render(Graphics g) {

        // storing required fonts
        Font font = new Font("courier", 1, 70);
        Font labels = new Font("courier", 1, 15);

        // level number icon
        g.setColor(Color.BLACK);
        g.fillRect(20, 20, 100, 100);

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("2", 50, 90);

        // back button
        g.setColor(Color.BLACK);
        g.fillRect(1160, 20, 100, 100);
        g.setColor(Color.WHITE);
        g.drawString("←", 1190, 90);

    }
}

