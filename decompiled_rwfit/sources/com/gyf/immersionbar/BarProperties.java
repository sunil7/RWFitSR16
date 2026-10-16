package com.gyf.immersionbar;

/* loaded from: classes.dex */
public class BarProperties {
    private int actionBarHeight;
    private boolean hasNavigationBar;
    private boolean landscapeLeft;
    private boolean landscapeRight;
    private int navigationBarHeight;
    private int navigationBarWidth;
    private int notchHeight;
    private boolean notchScreen;
    private boolean portrait;
    private int statusBarHeight;

    public int getActionBarHeight() {
        return this.actionBarHeight;
    }

    public int getNavigationBarHeight() {
        return this.navigationBarHeight;
    }

    public int getNavigationBarWidth() {
        return this.navigationBarWidth;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    public int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public boolean hasNavigationBar() {
        return this.hasNavigationBar;
    }

    public boolean isLandscapeLeft() {
        return this.landscapeLeft;
    }

    public boolean isLandscapeRight() {
        return this.landscapeRight;
    }

    public boolean isNotchScreen() {
        return this.notchScreen;
    }

    public boolean isPortrait() {
        return this.portrait;
    }

    public void setActionBarHeight(int i3) {
        this.actionBarHeight = i3;
    }

    public void setLandscapeLeft(boolean z5) {
        this.landscapeLeft = z5;
    }

    public void setLandscapeRight(boolean z5) {
        this.landscapeRight = z5;
    }

    public void setNavigationBar(boolean z5) {
        this.hasNavigationBar = z5;
    }

    public void setNavigationBarHeight(int i3) {
        this.navigationBarHeight = i3;
    }

    public void setNavigationBarWidth(int i3) {
        this.navigationBarWidth = i3;
    }

    public void setNotchHeight(int i3) {
        this.notchHeight = i3;
    }

    public void setNotchScreen(boolean z5) {
        this.notchScreen = z5;
    }

    public void setPortrait(boolean z5) {
        this.portrait = z5;
    }

    public void setStatusBarHeight(int i3) {
        this.statusBarHeight = i3;
    }
}
