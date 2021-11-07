package screen;

import java.awt.event.KeyEvent;

import engine.Core;
import engine.Cooldown;

public class PauseScreen extends Screen {

    /** Milliseconds between changes in user selection. */
	private static final int SELECTION_TIME = 200;
	
	/** Time between changes in user selection. */
	private Cooldown selectionCooldown;

    /**
	 * Constructor, establishes the properties of the screen.
	 * 
	 * @param width
	 *            Screen width.
	 * @param height
	 *            Screen height.
	 * @param fps
	 *            Frames per second, frame rate at which the game is run.
	 */
    public PauseScreen(final int width, final int height, final int fps) {
        super(width, height, fps);
		this.returnCode = 2;
		this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
		this.selectionCooldown.reset();
    }

    /**
	 * Starts the action.
	 * 
	 * @return Next screen code.
	 */
    public final int run() {
		super.run();
		draw();
		return this.returnCode;
	}

    /**
	 * Updates the elements on screen and checks for events.
	 */
    protected final void update() {
		super.update();
    }

    /**
	 * Draws the elements associated with the screen.
	 */
	private void draw() {
		drawManager.initDrawing(this);

		drawManager.drawTitle(this);
		drawManager.drawPause(this, this.returnCode);

		drawManager.completeDrawing(this);
	}
}
