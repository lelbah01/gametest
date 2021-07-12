package game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1280, HEIGHT = 725;

    private Thread thread;
    private boolean running = false;
    private final Handler handler;
    private final Menu menu;
    private final LevelLibrary levelLibrary;
    private final Level1 level1;
    private final Level2 level2;
    private final Level3 level3;

    public enum STATE {
        Menu,
        LevelLibrary,
        Level1,
        Level2,
        Level3
    }

    public STATE gameState = STATE.Menu;

    public Game(){
        handler = new Handler();

        menu = new Menu(this, handler);
        levelLibrary = new LevelLibrary(this, handler);
        level1 = new Level1(this, handler);
        level2 = new Level2(this, handler);
        level3 = new Level3(this, handler);

        this.addMouseListener(menu);
        this.addMouseListener(levelLibrary);
        this.addMouseListener(level1);
        this.addMouseListener(level2);
        this.addMouseListener(level3);

        new Window(WIDTH, HEIGHT, "Game", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta --;
            }
            if(running){
                render();
                frames ++;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        if(gameState == STATE.Menu){
            menu.tick();
        }
        else if(gameState == STATE.LevelLibrary){
            levelLibrary.tick();
        }

        else if(gameState == STATE.Level1){
            level1.tick();
        }
        else if(gameState == STATE.Level2){
            level2.tick();
        }
        else if(gameState == STATE.Level3){
            level3.tick();
        }

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if(gameState == STATE.Menu){
            menu.render(g);
        }
        else if(gameState == STATE.LevelLibrary){
            levelLibrary.render(g);
        }
        else if(gameState == STATE.Level1){
            level1.render(g);
        }
        else if(gameState == STATE.Level2){
            level2.render(g);
        }
        else if(gameState == STATE.Level3){
            level3.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
