package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class ha {

    /* renamed from: a, reason: collision with root package name */
    private static long f4270a;

    /* renamed from: b, reason: collision with root package name */
    private static Vector<m9> f4271b = new Vector<>();

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4272c = 0;

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4273a;

        public a(Context context) {
            this.f4273a = context;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            try {
                la.b(this.f4273a);
                la.d(this.f4273a);
                la.c(this.f4273a);
                ac.a(this.f4273a);
                yb.a(this.f4273a);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th2) {
                ka.a(th2, "Lg", "proL");
            }
        }
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + "/a/" + str;
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void a(Context context) {
        try {
            if (System.currentTimeMillis() - f4270a < 60000) {
                return;
            }
            f4270a = System.currentTimeMillis();
            qc.d().b(new a(context));
        } catch (Throwable th2) {
            ka.a(th2, "Lg", "proL");
        }
    }

    public static void a(m9 m9Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    if (m9Var == null) {
                        return;
                    }
                    if (f4271b.contains(m9Var)) {
                        return;
                    }
                    f4271b.add(m9Var);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static List<m9> a() {
        Vector<m9> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f4271b;
            }
            return vector;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return f4271b;
        }
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }
}
