package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class g2 {

    /* renamed from: a, reason: collision with root package name */
    private Context f4168a;

    public g2(Context context) {
        this.f4168a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (com.amap.api.col.p0003sl.x2.a(r7) == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(com.amap.api.col.p0003sl.z1 r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto Lb2
            java.lang.String r1 = r10.getPinyin()
            android.content.Context r2 = r9.f4168a
            java.lang.String r3 = "vmap/"
            boolean r2 = r9.a(r1, r2, r3)
            java.lang.String r3 = "quanguogaiyaotu"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L19
            java.lang.String r1 = "quanguo"
        L19:
            android.content.Context r3 = r9.f4168a
            java.lang.String r4 = "map/"
            boolean r1 = r9.a(r1, r3, r4)
            r3 = 1
            if (r1 != 0) goto L29
            if (r2 == 0) goto L27
            goto L29
        L27:
            r1 = r0
            goto L2a
        L29:
            r1 = r3
        L2a:
            java.lang.String r2 = r10.getUrl()
            java.lang.String r2 = com.amap.api.col.p0003sl.x2.b(r2)
            android.content.Context r5 = r9.f4168a
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L3b
            goto L90
        L3b:
            java.lang.String r6 = com.amap.api.col.p0003sl.v4.c(r5)
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            r8.<init>()     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            r8.append(r6)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            r8.append(r4)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            r8.append(r2)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            r7.<init>(r8)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            boolean r8 = r7.exists()     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            if (r8 == 0) goto L67
            boolean r7 = com.amap.api.col.p0003sl.x2.a(r7)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L65
            if (r7 != 0) goto L67
            goto L90
        L63:
            r2 = move-exception
            goto L89
        L65:
            r2 = move-exception
            goto L8d
        L67:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            r7.<init>()     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            r7.append(r6)     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            r7.append(r4)     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            java.lang.String r4 = r7.toString()     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            com.amap.api.col.p0003sl.x2.a(r4)     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            com.amap.api.col.p0003sl.x2.a(r2, r5)     // Catch: java.lang.Exception -> L7d java.io.IOException -> L7f
            goto L94
        L7d:
            r2 = move-exception
            goto L81
        L7f:
            r2 = move-exception
            goto L85
        L81:
            r2.printStackTrace()
            goto L90
        L85:
            r2.printStackTrace()
            goto L90
        L89:
            r2.printStackTrace()
            goto L90
        L8d:
            r2.printStackTrace()
        L90:
            if (r1 == 0) goto L93
            goto L94
        L93:
            r3 = r0
        L94:
            if (r3 == 0) goto La7
            com.amap.api.col.3sl.d3 r1 = r10.f5534v
            r1.c()
            boolean r1 = r10.f5538z
            if (r1 == 0) goto La4
            com.amap.api.col.3sl.d3 r1 = r10.f5534v
            r1.d()
        La4:
            r10.f5538z = r0
            return r3
        La7:
            com.amap.api.col.3sl.d3 r1 = r10.f5534v
            com.amap.api.col.3sl.d3 r10 = r10.f5533u
            int r10 = r10.e()
            r1.a(r10)
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.g2.a(com.amap.api.col.3sl.z1):boolean");
    }

    public void b(z1 z1Var) {
        a(z1Var);
    }

    private boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b3 = v4.b(context);
        try {
            File file = new File(b3 + str2 + str + ".dat");
            if (file.exists()) {
                if (!x2.a(file)) {
                    return false;
                }
            }
            try {
                x2.a(b3 + str2);
                x2.a(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }
}
