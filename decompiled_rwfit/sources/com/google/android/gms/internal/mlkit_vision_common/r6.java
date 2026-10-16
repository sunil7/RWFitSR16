package com.google.android.gms.internal.mlkit_vision_common;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class r6 {
    public static void a(StringBuilder sb2, HashMap hashMap) {
        sb2.append(Const.STR_MART_JSON_BEGIN);
        boolean z5 = true;
        for (String str : hashMap.keySet()) {
            if (!z5) {
                sb2.append(Const.STR_MART_COMMA);
            }
            String str2 = (String) hashMap.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
            z5 = false;
        }
        sb2.append("}");
    }
}
