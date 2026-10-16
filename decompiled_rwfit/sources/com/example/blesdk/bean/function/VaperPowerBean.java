package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class VaperPowerBean extends BaseReminderBean {
    private int powerLevel = 1;
    private int[] vaperPowerLevel;
    private int vaperPowerLevelNum;
    private int vaperPowerType;

    public int getPowerLevel() {
        return this.powerLevel;
    }

    public int[] getVaperPowerLevel() {
        return this.vaperPowerLevel;
    }

    public int getVaperPowerLevelNum() {
        return this.vaperPowerLevelNum;
    }

    public int getVaperPowerType() {
        return this.vaperPowerType;
    }

    public void setPowerLevel(int i3) {
        this.powerLevel = i3;
    }

    public void setVaperPowerLevel(int[] iArr) {
        this.vaperPowerLevel = iArr;
    }

    public void setVaperPowerLevelNum(int i3) {
        this.vaperPowerLevelNum = i3;
    }

    public void setVaperPowerType(int i3) {
        this.vaperPowerType = i3;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return "VaperPowerBean{powerLevel=" + this.powerLevel + " vaperPowerType=" + this.vaperPowerType + " vaperPowerLevelNum=" + this.vaperPowerLevelNum + " vaperPowerLevel=" + this.vaperPowerLevel + '}';
    }
}
