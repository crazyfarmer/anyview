package com.github.anyview.preferences;

import com.github.anyview.utils.AnyViewHelper;

public enum EPreferenceViewInfo implements IPreferenceInfo {

	WINDOW("explorer.exe /n,/e,", "cmd /C start cmd /K cd "), 
	MAC("open ","open "), 
	LINUX("nautilus ", "gnome-terminal --working-directory= "), 
	DEFAULT("shell_open_command ", "shell_open_command ");

	private String target;
	private String command;

	EPreferenceViewInfo(String target, String command) {
		this.target = target;
		this.command = command;
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public String getCommand() {
		return command;
	}

	public static EPreferenceViewInfo getCurrentViewInfo() {
		if (AnyViewHelper.isWindows()) {
			return WINDOW;
		} else if (AnyViewHelper.isMac()) {
			return MAC;
		} else if (AnyViewHelper.isUnix()) {
			return LINUX;
		}
		return DEFAULT;
	}
}
