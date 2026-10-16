package com.amap.api.col.p0003sl;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d2 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f3882a;

    /* renamed from: b, reason: collision with root package name */
    private p2 f3883b;

    public d2(Context context) {
        this.f3882a = context;
        this.f3883b = p2.b(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0316, code lost:
    
        if (r14 != null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0318, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0308, code lost:
    
        if (r14 == null) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02eb, code lost:
    
        if (r14 != null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02dd, code lost:
    
        if (r14 == null) goto L239;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x033c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.d2.a():void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(v4.b(this.f3882a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }
}
