package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class ScheduleBean {
    private int advance;
    private int advanceIndex;
    private String message;
    private int scheduleId = -1;
    private long time;
    private String title;

    public int getAdvance() {
        return this.advance;
    }

    public int getAdvanceIndex() {
        return this.advanceIndex;
    }

    public String getMessage() {
        return this.message;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdvance(int i3) {
        this.advance = i3;
    }

    public void setAdvanceIndex(int i3) {
        this.advanceIndex = i3;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setScheduleId(int i3) {
        this.scheduleId = i3;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
