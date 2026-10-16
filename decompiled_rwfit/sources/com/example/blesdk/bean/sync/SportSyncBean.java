package com.example.blesdk.bean.sync;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class SportSyncBean {
    private List<SportItemBean> items;
    private List<SportResultBean> resultItems;

    public List<SportItemBean> getItems() {
        return this.items;
    }

    public List<SportResultBean> getResultItems() {
        return this.resultItems;
    }

    public void setItems(List<SportItemBean> list) {
        this.items = list;
    }

    public void setResultItems(List<SportResultBean> list) {
        this.resultItems = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SportSyncBean{items=");
        sb2.append(this.items);
        sb2.append(", resultItems=");
        return l0.r(sb2, this.resultItems, '}');
    }
}
