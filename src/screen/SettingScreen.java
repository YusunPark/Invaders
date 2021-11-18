package screen;

import java.awt.event.KeyEvent;

import engine.Core;
import engine.Cooldown;

public class SettingScreen extends Screen {

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
    public SettingScreen(final int width, final int height, final int fps) {
        super(width, height, fps);

        this.returnCode = 1;
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

		return this.returnCode;
	}

    /**
	 * Updates the elements on screen and checks for events.
	 */
    protected final void update() {
		super.update();

        draw();
		if (this.selectionCooldown.checkFinished()
				&& this.inputDelay.checkFinished()) {
			if (inputManager.isKeyDown(KeyEvent.VK_UP)
					|| inputManager.isKeyDown(KeyEvent.VK_W)) {
				previousMenuItem();
				this.selectionCooldown.reset();
			}
			if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
					|| inputManager.isKeyDown(KeyEvent.VK_S)) {
				nextMenuItem();
				this.selectionCooldown.reset();
			}
			if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
				this.isRunning = false;
		}
    }

	// 1 5
    private void nextMenuItem() {
		if (this.returnCode == 6) {
			this.returnCode = 1;
		}	
		else if (this.returnCode == 1){
			this.returnCode = 5;
		}
		else {
			this.returnCode++;
		}
	}

	/**
	 * Shifts the focus to the previous menu item.
	 */
	private void previousMenuItem() {
		if (this.returnCode == 1) {
			this.returnCode = 6;
		}
		else if (this.returnCode == 5){
			this.returnCode = 1;
		}
		else {
			this.returnCode--;
		}
	}

    /**
	 * Draws the elements associated with the screen.
	 */
	private void draw() {
		drawManager.initDrawing(this);

		drawManager.drawTitle(this);
		drawManager.drawSetting(this, this.returnCode);

		drawManager.completeDrawing(this);
	}
}