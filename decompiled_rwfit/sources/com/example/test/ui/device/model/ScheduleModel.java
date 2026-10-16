package com.example.test.ui.device.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ScheduleModel implements Serializable {
    private int advance;
    private int advanceIndex;
    private boolean isAdd;
    private boolean isDelete = false;
    private boolean isEdit = false;
    private int scheduleId = -1;
    private String scheduleMsg;
    private String scheduleTitle;
    private long time;

    public ScheduleModel() {
    }

    public int getAdvance() {
        return this.advance;
    }

    public int getAdvanceIndex() {
        return this.advanceIndex;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public String getScheduleMsg() {
        return this.scheduleMsg;
    }

    public String getScheduleTitle() {
        return this.scheduleTitle;
    }

    public long getTime() {
        return this.time;
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

    public void setAdd(boolean z5) {
        this.isAdd = z5;
    }

    public void setAdvance(int i3) {
        this.advance = i3;
    }

    public void setAdvanceIndex(int i3) {
        this.advanceIndex = i3;
    }

    public void setDelete(boolean z5) {
        this.isDelete = z5;
    }

    public void setEdit(boolean z5) {
        this.isEdit = z5;
    }

    public void setScheduleId(int i3) {
        this.scheduleId = i3;
    }

    public void setScheduleMsg(String str) {
        this.scheduleMsg = str;
    }

    public void setScheduleTitle(String str) {
        this.scheduleTitle = str;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public ScheduleModel(boolean z5) {
        this.isAdd = z5;
    }
}
