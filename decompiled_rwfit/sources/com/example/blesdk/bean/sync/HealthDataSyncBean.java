package com.example.blesdk.bean.sync;

import com.example.baselibrary.utils.b;
import java.util.List;

/* loaded from: classes.dex */
public class HealthDataSyncBean {
    private List<BoPartData> boPartData;
    private List<BpPartData> bpPartData;
    private List<BreathPartData> breathPartData;
    private int dataType;
    private List<HrPartData> hrPartData;
    private MuslimCountItemBean muslimCountPartData;
    private List<PressurePartData> pressurePartData;
    private List<JLStepSyncBean> stepJLPartData;
    private List<StepPartData> stepPartData;
    private List<TempPartData> tempPartData;

    public List<BoPartData> getBoPartData() {
        return this.boPartData;
    }

    public List<BpPartData> getBpPartData() {
        return this.bpPartData;
    }

    public List<BreathPartData> getBreathPartData() {
        return this.breathPartData;
    }

    public int getDataType() {
        return this.dataType;
    }

    public List<HrPartData> getHrPartData() {
        return this.hrPartData;
    }

    public MuslimCountItemBean getMuslimCountPartData() {
        return this.muslimCountPartData;
    }

    public List<PressurePartData> getPressurePartData() {
        return this.pressurePartData;
    }

    public List<JLStepSyncBean> getStepJLPartData() {
        return this.stepJLPartData;
    }

    public List<StepPartData> getStepPartData() {
        return this.stepPartData;
    }

    public List<TempPartData> getTempPartData() {
        return this.tempPartData;
    }

    public void setBoPartData(List<BoPartData> list) {
        this.boPartData = list;
    }

    public void setBpPartData(List<BpPartData> list) {
        this.bpPartData = list;
    }

    public void setBreathPartData(List<BreathPartData> list) {
        this.breathPartData = list;
    }

    public void setDataType(int i3) {
        this.dataType = i3;
    }

    public void setHrPartData(List<HrPartData> list) {
        this.hrPartData = list;
    }

    public void setMuslimCountPartData(MuslimCountItemBean muslimCountItemBean) {
        this.muslimCountPartData = muslimCountItemBean;
    }

    public void setPressurePartData(List<PressurePartData> list) {
        this.pressurePartData = list;
    }

    public void setStepJLPartData(List<JLStepSyncBean> list) {
        this.stepJLPartData = list;
    }

    public void setStepPartData(List<StepPartData> list) {
        this.stepPartData = list;
    }

    public void setTempPartData(List<TempPartData> list) {
        this.tempPartData = list;
    }

    public String toString() {
        return "HealthDataSyncBean{dataType=" + this.dataType + ", stepPartData=" + b.z(this.stepPartData) + ", hrPartData=" + b.z(this.hrPartData) + ", bpPartData=" + b.z(this.bpPartData) + ", boPartData=" + b.z(this.boPartData) + ", tempPartData=" + b.z(this.tempPartData) + ", breathPartData=" + b.z(this.breathPartData) + '}';
    }
}
