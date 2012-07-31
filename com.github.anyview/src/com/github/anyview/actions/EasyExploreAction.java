package com.github.anyview.actions;

import org.eclipse.jface.action.IAction;
 

public class EasyExploreAction extends EasyBaseAction {

	public void runAction(IAction action) {
		try {
			String target = EasyExplorePlugin.getDefault().getTarget();
			run(action, target);
		} catch (Throwable e) {
			EasyExplorePlugin.log(e);
		}
	}
}
