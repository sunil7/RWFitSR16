package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class w2 {

    /* renamed from: a, reason: collision with root package name */
    private b f5223a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5224a = false;
    }

    public interface c {
    }

    public w2(s2 s2Var, z2 z2Var) {
        this.f5223a = new b(s2Var, z2Var);
    }

    public void a() {
        b bVar = this.f5223a;
        if (bVar != null) {
            z2 e = bVar.e();
            if (e != null) {
                e.a();
            }
            String f2 = bVar.f();
            String b3 = bVar.b();
            if (TextUtils.isEmpty(f2) || TextUtils.isEmpty(b3)) {
                if (bVar.d().f5224a) {
                    if (e != null) {
                        e.c();
                        return;
                    }
                    return;
                } else {
                    if (e != null) {
                        e.e();
                        return;
                    }
                    return;
                }
            }
            File file = new File(f2);
            if (!file.exists()) {
                if (bVar.d().f5224a) {
                    if (e != null) {
                        e.c();
                        return;
                    }
                    return;
                } else {
                    if (e != null) {
                        e.e();
                        return;
                    }
                    return;
                }
            }
            File file2 = new File(b3);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            v2 v2Var = new v2(e);
            try {
                if (bVar.d().f5224a && e != null) {
                    e.c();
                }
                a(file, file2, v2Var, bVar);
                if (bVar.d().f5224a) {
                    if (e != null) {
                        e.c();
                    }
                } else if (e != null) {
                    e.a(bVar.c());
                }
            } catch (Throwable unused) {
                if (bVar.d().f5224a) {
                    if (e != null) {
                        e.c();
                    }
                } else if (e != null) {
                    e.e();
                }
            }
        }
    }

    public void b() {
        b bVar = this.f5223a;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5225a;

        /* renamed from: b, reason: collision with root package name */
        private String f5226b;

        /* renamed from: c, reason: collision with root package name */
        private z2 f5227c;

        /* renamed from: d, reason: collision with root package name */
        private a f5228d = new a();
        private String e;

        public b(s2 s2Var, z2 z2Var) {
            this.f5227c = null;
            this.f5225a = s2Var.b();
            this.f5226b = s2Var.h();
            this.f5227c = z2Var;
        }

        public void a(String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public String b() {
            return this.f5226b;
        }

        public String c() {
            return this.e;
        }

        public a d() {
            return this.f5228d;
        }

        public z2 e() {
            return this.f5227c;
        }

        public String f() {
            return this.f5225a;
        }

        public void a() {
            this.f5228d.f5224a = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015d A[EDGE_INSN: B:72:0x015d->B:22:0x015d BREAK  A[LOOP:1: B:15:0x009c->B:37:0x0157], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.io.File r20, java.io.File r21, com.amap.api.col.3sl.w2.c r22, com.amap.api.col.3sl.w2.b r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.w2.a(java.io.File, java.io.File, com.amap.api.col.3sl.w2$c, com.amap.api.col.3sl.w2$b):void");
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }
}
