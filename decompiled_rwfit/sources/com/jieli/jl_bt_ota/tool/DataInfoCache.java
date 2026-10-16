package com.jieli.jl_bt_ota.tool;

import java.util.ArrayList;
import ud.a;

/* loaded from: classes.dex */
public class DataInfoCache extends ArrayList<a> {
    public a getDataInfo(vd.a aVar) {
        int size = size();
        int i3 = 0;
        while (i3 < size) {
            a aVar2 = get(i3);
            i3++;
            a aVar3 = aVar2;
            vd.a aVar4 = aVar3.f19050c;
            if (aVar4.f19220c == aVar.f19220c && aVar4.f19222f == aVar.f19222f) {
                return aVar3;
            }
        }
        return null;
    }
}
