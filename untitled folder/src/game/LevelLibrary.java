package game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelLibrary extends MouseAdapter {

    private Game game;
    private Handler handler;

    public LevelLibrary(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        if(game.gameState == Game.STATE.LevelLibrary) {
            int mx = e.getX();
            int my = e.getY();

            // level1 button
            if (mouseOver(mx, my, 40, 310, 200, 120)) {
                game.gameState = Game.STATE.Level1;
            }

            // level2 button
            if (mouseOver(mx, my, 290, 310, 200, 120)) {
                game.gameState = Game.STATE.Level2;
            }

            // level3 button
            if (mouseOver(mx, my, 540, 310, 200, 120)) {
                game.gameState = Game.STATE.Level3;
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
        Font font1 = new Font("courier", 1, 55);

        // add buttons
        int y1 = 310;
        int y2 = 320;

        int x1 = 40;
        int x2 = 50;

        int level = 1;

        for(int i = 0; i < 3; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(x1, y1, 200, 120);

            g.setFont(font1);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(level), x2 + 70, y2 + 50);

            x1 += 250;
            x2 += 250;
            level++;
        }

    }

}

