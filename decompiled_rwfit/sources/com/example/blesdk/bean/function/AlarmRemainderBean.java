package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AlarmRemainderBean extends BaseReminderBean {
    private String alarmTag;
    private int[] repeatModel;
    private boolean isDelayRemain = true;
    private int alarmId = -1;
    private boolean isDelete = false;
    private boolean isAdd = false;
    private boolean isEdit = false;

    public int getAlarmId() {
        return this.alarmId;
    }

    public String getAlarmTag() {
        return this.alarmTag;
    }

    public int[] getRepeatModel() {
        return this.repeatModel;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public boolean isDelayRemain() {
        return this.isDelayRemain;
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

    public void setAlarmId(int i3) {
        this.alarmId = i3;
    }

    public void setAlarmTag(String str) {
        this.alarmTag = str;
    }

    public void setDelayRemain(boolean z5) {
        this.isDelayRemain = z5;
    }

    public void setDelete(boolean z5) {
        this.isDelete = z5;
    }

    public void setEdit(boolean z5) {
        this.isEdit = z5;
    }

    public void setRepeatModel(int[] iArr) {
        this.repeatModel = iArr;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        StringBuilder sb2 = new StringBuilder("DrinkReminderBean{isOpen=");
        sb2.append(isOpen());
        sb2.append("startHour=");
        sb2.append(getStartHour());
        sb2.append("startMin=");
        sb2.append(getStartMin());
        sb2.append("endHour=");
        sb2.append(getEndHour());
        sb2.append("endMin=");
        sb2.append(getEndMin());
        sb2.append("alarmTag=");
        sb2.append(this.alarmTag);
        sb2.append("alarmId=");
        sb2.append(this.alarmId);
        sb2.append("isDelete=");
        sb2.append(this.isDelete);
        sb2.append("isEdit=");
        sb2.append(this.isEdit);
        sb2.append("isAdd=");
        sb2.append(this.isAdd);
        sb2.append("repeatModel=");
        sb2.append(Arrays.toString(this.repeatModel));
        sb2.append("isDelayRemain=");
        return e.o(sb2, this.isDelayRemain, '}');
    }
}
