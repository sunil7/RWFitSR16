package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class c1 {
    public static String a(int i3) {
        ArrayList arrayList = new ArrayList();
        if ((i3 & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i3 & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i3 & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return String.join("|", arrayList);
    }
}
