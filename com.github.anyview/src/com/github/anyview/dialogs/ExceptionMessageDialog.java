/**
 *  author:crazyfarmer.cn@gmail.com 
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.anyview.dialogs;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

public class ExceptionMessageDialog extends MessageDialog {

	private Throwable ex;

	public ExceptionMessageDialog(Shell parentShell, String dialogTitle,
			Image dialogTitleImage, String dialogMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex, Throwable ex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
				dialogImageType, dialogButtonLabels, defaultIndex);
		this.ex = ex;
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		String exceptionString = stringWriter.toString();

		ExpandableComposite errorComposite = new ExpandableComposite(parent,
				ExpandableComposite.COMPACT);
		errorComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				false, true, 1, 1));
		errorComposite.setText("log"); //$NON-NLS-1$
		errorComposite.addExpansionListener(new IExpansionListener() {

			public void expansionStateChanged(ExpansionEvent e) {
				int delta = 300;
				if (!e.getState()) {
					delta = -delta;
				}
				Point shellSize = getShell().getSize();
				Point newSize = new Point(shellSize.x, shellSize.y + delta);
				getShell().setSize(newSize);
			}

			public void expansionStateChanging(ExpansionEvent e) {
			}

		});

		Text text = new Text(errorComposite, SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);
		text.setText(exceptionString);
		text.setEditable(false);
		errorComposite.setClient(text);

		return errorComposite;
	}

	public static boolean openConfirm(Shell parent, String title,
			String message, Throwable ex) {
		MessageDialog dialog = new ExceptionMessageDialog(parent, title, null,
				message, QUESTION, new String[] { Messages.ExceptionMessageDialog_OK, "Cancel" }, 0, ex); //$NON-NLS-1$ //$NON-NLS-2$
		return dialog.open() == 0;
	}

	public static void openError(Shell parent, String title, String message,
			Throwable ex) {
		MessageDialog dialog = new ExceptionMessageDialog(parent, title, null,
				message, ERROR, new String[] { Messages.ExceptionMessageDialog_OK }, 0, ex); //$NON-NLS-1$
		dialog.open();
		return;
	}

	public static void openInformation(Shell parent, String title,
			String message, Throwable ex) {
		MessageDialog dialog = new ExceptionMessageDialog(parent, title, null,
				message, INFORMATION, new String[] { Messages.ExceptionMessageDialog_OK }, 0, ex); //$NON-NLS-1$
		dialog.open();
		return;
	}

	public static boolean openQuestion(Shell parent, String title,
			String message, Throwable ex) {
		MessageDialog dialog = new ExceptionMessageDialog(parent, title, null,
				message, QUESTION, new String[] {
						Messages.ExceptionMessageDialog_OK,
						Messages.ExceptionMessageDialog_NO }, 0, ex);
		return dialog.open() == 0;
	}

	public static void openWarning(Shell parent, String title, String message,
			Throwable ex) {
		MessageDialog dialog = new ExceptionMessageDialog(parent, title, null,
				message, WARNING, new String[] { Messages.ExceptionMessageDialog_OK }, 0, ex); //$NON-NLS-1$
		dialog.open();
		return;
	}

}
