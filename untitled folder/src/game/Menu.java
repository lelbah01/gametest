package game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {

        if(game.gameState == Game.STATE.Menu) {
            int mx = e.getX();
            int my = e.getY();
            // start button
            if (mouseOver(mx, my, 515, 260, 250, 80)) {
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

    public void tick(){

    }

    public void render(Graphics g) {

        // storing required fonts
        Font menu = new Font("courier", 1, 30);
        Font options = new Font("courier", 1, 20);

        g.setFont(menu);
        g.drawString("Menu", 605, 220);

        // draw start button
        g.setColor(Color.BLACK);
        g.fillRect(515, 260, 250, 80);

        g.setColor(Color.WHITE);
        g.setFont(options);
        g.drawString("Start", 610, 305);

    }

}