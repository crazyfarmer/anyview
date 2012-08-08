package com.github.anyview.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import com.github.anyview.Activator;

public class AnyViewPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public AnyViewPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Any View Preference Page\r\nSet the operating system commands to open an explorer and a command shell.");
	}

	public void createFieldEditors() {
		addField(new StringFieldEditor(PreferenceConstants.P_TARGET,
				"&File View", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.P_COMMAND,
				"&Command View", getFieldEditorParent()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}