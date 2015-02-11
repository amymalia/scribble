import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/** A simple applet that uses the Java 1.0 event handling model
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 *
 */
public class Scribble extends Applet {
  private int lastX, lastY;
  private Button clearButton;
  private Graphics g;

  /**
   * Initialize the button and the Graphics object
   */
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    g = this.getGraphics();
  }

  /**
   * Respond to mouse clicks
   * @param e the current event
   * @param x the current x coordinate
   * @param y the current y coordinate
   * @return true always
   */
  public boolean mouseDown(Event e, int x, int y) {
    lastX = x;
    lastY = y;
    return true;
  }

  /**
   * Respond to mouse drags
   * @param e the current event
   * @param x the current x coordinate
   * @param y the current y coordinate
   * @return true always
   */
  public boolean mouseDrag(Event e, int x, int y) {
    g.setColor(Color.black);
    g.drawLine(lastX, lastY, x, y);
    lastX = x;
    lastY = y;
    return true;
  }

  /**
   * Respond to key presses
   * @param e the current event
   * @param key the key pressed
   * @return true if cleared, false if not
   */
  @Override
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to Button clicks
   * @param e the current event
   * @param arg not used
   * @return true if cleared, false if not
   */
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /** Erase the scribble */
  public void clear() {
    g.setColor(this.getBackground());
    g.fillRect(0, 0, bounds().width, bounds().height);
  }
}