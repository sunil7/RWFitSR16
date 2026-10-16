package com.example.test.ui.device.model;

import com.example.blesdk.bean.function.DialInfoBean;
import java.util.List;

/* loaded from: classes.dex */
public class DialInfoModel extends DeviceInfoModel {
    private DialInfoBean dialInfoBean;
    private List<DialModel> dialModels;

    public DialInfoModel(int i3, int i10) {
        super(i3, i10);
    }

    public DialInfoBean getDialInfoBean() {
        return this.dialInfoBean;
    }

    public List<DialModel> getDialModels() {
        return this.dialModels;
    }

    public void setDialInfoBean(DialInfoBean dialInfoBean) {
        this.dialInfoBean = dialInfoBean;
    }

    public void setDialModels(List<DialModel> list) {
        this.dialModels = list;
    }

    public String toString() {
        return "DialInfoModel{dialModels=" + this.dialModels + ", dialInfoBean=" + this.dialInfoBean + '}';
    }
}
