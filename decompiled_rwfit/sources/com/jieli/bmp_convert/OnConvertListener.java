package com.jieli.bmp_convert;

/* loaded from: classes.dex */
public interface OnConvertListener {
    void onStart(String str);

    void onStop(ConvertResult convertResult, String str);

    @Deprecated
    void onStop(boolean z5, String str);
}
