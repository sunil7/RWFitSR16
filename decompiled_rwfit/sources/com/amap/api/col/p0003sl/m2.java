package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

@ua(tableName = "update_item_file")
/* loaded from: classes.dex */
class m2 {

    /* renamed from: a, reason: collision with root package name */
    @va(fieldName = Const.STR_FILE, fieldType = 6)
    private String f4531a;

    public m2() {
        this.f4531a = "";
    }

    public String a() {
        return this.f4531a;
    }

    public static String a(String str) {
        return l0.o("mAdcode='", str, "'");
    }

    public m2(String str, String str2) {
        this.f4531a = str2;
    }
}
