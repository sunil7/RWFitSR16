package com.example.test.ui.device.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AlarmModel implements Serializable {
    private String alarmTag;
    private boolean isAdd;
    private boolean isOpen;
    private int[] repeatModel;
    private int startHour;
    private int startMin;
    private int alarmId = -1;
    private boolean isDelete = false;
    private boolean isEdit = false;

    public AlarmModel() {
    }

    public int getAlarmId() {
        return this.alarmId;
    }

    public String getAlarmTag() {
        return this.alarmTag;
    }

    public int[] getRepeatModel() {
        return this.repeatModel;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public int getStartMin() {
        return this.startMin;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setAdd(boolean z5) {
        this.isAdd = z5;
    }

    public void setAlarmId(int i3) {
        this.alarmId = i3;
    }

    public void setAlarmTag(String str) {
        this.alarmTag = str;
    }

    public void setDelete(boolean z5) {
        this.isDelete = z5;
    }

    public void setEdit(boolean z5) {
        this.isEdit = z5;
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public void setRepeatModel(int[] iArr) {
        this.repeatModel = iArr;
    }

    public void setStartHour(int i3) {
        this.startHour = i3;
    }

    public void setStartMin(int i3) {
        this.startMin = i3;
    }

    public AlarmModel(boolean z5) {
        this.isAdd = z5;
    }
}
