package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class StepServerBean {
    private StepServerDailyBean daily;
    private List<StepServerItemBean> details;

    public StepServerDailyBean getDaily() {
        return this.daily;
    }

    public List<StepServerItemBean> getDetails() {
        return this.details;
    }

    public void setDaily(StepServerDailyBean stepServerDailyBean) {
        this.daily = stepServerDailyBean;
    }

    public void setDetails(List<StepServerItemBean> list) {
        this.details = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepServerBean{daily=");
        sb2.append(this.daily);
        sb2.append(", details=");
        return l0.r(sb2, this.details, '}');
    }
}
