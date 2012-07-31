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
		setDescription("A demonstration of a preference page implementation");
	}

	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH,
				"&Directory preference:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN,
				"&An example of a boolean preference", getFieldEditorParent()));

		addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE,
				"An example of a multiple-choice preference", 1,
				new String[][] { { "&Choice 1", "choice1" },
						{ "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.P_STRING,
				"A &text preference:", getFieldEditorParent()));
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