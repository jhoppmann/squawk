package de.jhoppmann.squawk.gwt.widgets;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * This class provides a way to handle pressed escape keys.
 *
 * @author jhoppmann
 * @since 0.0.1
 */
public abstract class ClosablePopUp extends PopupPanel {


	/**
	 * Calls {@link #handleEscape} when the escape key was pressed. Implementing subclasses should
	 * call the super method when overriding this method so the escape handling is not lost.
	 *
	 * @param event The browser event captured
	 */
	@Override
	protected void onPreviewNativeEvent(Event.NativePreviewEvent event) {
		if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ESCAPE) {
			handleEscape();
		}
	}

	/**
	 * This method is called when escape was pressed
	 */
	public abstract void handleEscape();
}
