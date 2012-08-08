package com.github.anyview.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.github.anyview.dialogs.messages"; //$NON-NLS-1$
	public static String ExceptionMessageDialog_NO;
	public static String ExceptionMessageDialog_OK;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
