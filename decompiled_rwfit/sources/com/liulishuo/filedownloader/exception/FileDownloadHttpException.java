package com.liulishuo.filedownloader.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FileDownloadHttpException extends IOException {
    private final int mCode;
    private final Map<String, List<String>> mRequestHeaderMap;
    private final Map<String, List<String>> mResponseHeaderMap;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FileDownloadHttpException(int r3, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5) {
        /*
            r2 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r5 = new java.lang.Object[]{r0, r4, r5}
            int r0 = ye.e.f20123a
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r1 = "response code error: %d, \n request headers: %s \n response headers: %s"
            java.lang.String r5 = java.lang.String.format(r0, r1, r5)
            r2.<init>(r5)
            r2.mCode = r3
            java.util.HashMap r3 = a(r4)
            r2.mRequestHeaderMap = r3
            java.util.HashMap r3 = a(r4)
            r2.mResponseHeaderMap = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.exception.FileDownloadHttpException.<init>(int, java.util.Map, java.util.Map):void");
    }

    public static HashMap a(Map map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
        }
        return hashMap;
    }

    public int getCode() {
        return this.mCode;
    }

    public Map<String, List<String>> getRequestHeader() {
        return this.mRequestHeaderMap;
    }

    public Map<String, List<String>> getResponseHeader() {
        return this.mResponseHeaderMap;
    }
}
