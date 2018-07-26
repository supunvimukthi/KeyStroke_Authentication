package bm_keystroke;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Listener implements KeyListener{
    ArrayList<Long> TPressed;
    ArrayList<Long> TReleased;
    ArrayList<String> pressedKeys;
    ArrayList<String> releasedKeys;
    
    public Listener() {
        TPressed = new ArrayList();
        TReleased = new ArrayList();
        pressedKeys = new ArrayList();
        releasedKeys = new ArrayList();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.print("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        TPressed.add(System.currentTimeMillis());
        pressedKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        TReleased.add(System.currentTimeMillis());
        releasedKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    
    public Integer[] getPressedDif() {
        Integer[] temp = new Integer[TPressed.size() - 1];
        for(int i = 1; i < TPressed.size(); i++) {
            temp[i - 1] = (int) (TPressed.get(i) - TPressed.get(i - 1));
        }
        return temp;
    }
    
    public String getPressedKeys() {
        String temp = "";
        for(int i = 0; i < pressedKeys.size() - 1; i++) {
            temp = temp + pressedKeys.get(i) + " ";
        }
        temp = temp + pressedKeys.get(pressedKeys.size() - 1);
        return temp;
    }
        
    public Integer[] getPressedTime() {
        Integer[] temp = new Integer[TPressed.size()];
        for(int i = 0; i < TPressed.size(); i++) {
            temp[i] = (int) (TPressed.get(i) - TReleased.get(i));
        }
        return temp;
    }
    public void clear() {
        TPressed.clear();
        TReleased.clear();
        pressedKeys.clear();
        releasedKeys.clear();
    }
}
