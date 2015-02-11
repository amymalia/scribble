import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Color;

/**
 * A simple applet that uses the Java 1.0 event handling model.
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */
public class Scribble extends Applet {
  // Remembers last mouse coordinates
  private int lastX, lastY;
  Button clearButton;
  Graphics graphic;

  /**
   * Initialize the button and the Graphics object.
   */
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    graphic = this.getGraphics();
  }

  /**
   * Respond to mouse clicks.
   * @param event the current event
   * @param x the x coordinate
   * @param y the y coordinate
   * @return boolean  true when succeeds
   */
  public boolean downMouse(Event event, int lastX, int lastY) {
    this.lastX = lastX;
    this.lastY = lastY;
    return true;
  }

  /**
   * Respond to mouse drags.
   * @param event the current event
   * @param x the x coordinate
   * @param y the y coordinate
   * @return boolean  true when succeeds
   */
  public boolean dragMouse(Event event, int lastX, int lastY) {
    graphic.setColor(Color.black);
    graphic.drawLine(this.lastX, this.lastY, lastX, lastY);
    this.lastX = lastX;
    this.lastY = lastY;
    return true;
  }

  /**
   * Respond to key presses.
   * @param event the current event
   * @param key the key pressed
   * @return boolean  true when succeeds
   */
  public boolean keyCheck(Event event, int key) {
    if ((event.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to Button clicks.
   * @param event the current event
   * @param arg required for method
   */
  public boolean buttonRespond(Event event, Object arg) {
    if (event.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Erase the scribble.
   */
  public void clear() {
    graphic.setColor(this.getBackground());
    graphic.fillRect(0, 0, bounds().width, bounds().height);
  }
}