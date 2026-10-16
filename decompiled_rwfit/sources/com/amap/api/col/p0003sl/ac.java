package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    static boolean f3620a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f3621b;

    public static synchronized void b(List<zb> list, Context context) {
        synchronized (ac.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        qc.d().b(new a(context, 2, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(boolean z5, int i3) {
        synchronized (ac.class) {
            f3620a = z5;
            f3621b = Math.max(0, i3);
        }
    }

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        private Context f3622a;

        /* renamed from: b, reason: collision with root package name */
        private zb f3623b;

        /* renamed from: c, reason: collision with root package name */
        private int f3624c;

        /* renamed from: d, reason: collision with root package name */
        private List<zb> f3625d;

        public a(Context context, int i3) {
            this.f3622a = context;
            this.f3624c = i3;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            zb zbVar;
            byte[] bArr;
            ByteArrayOutputStream byteArrayOutputStream;
            int i3 = this.f3624c;
            if (i3 == 1) {
                try {
                    if (this.f3622a != null && this.f3623b != null) {
                        synchronized (ac.class) {
                            try {
                                Context context = this.f3622a;
                                if (context != null && (zbVar = this.f3623b) != null) {
                                    ac.a(context, zbVar.a());
                                    return;
                                }
                                return;
                            } finally {
                            }
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    ka.a(th2, "stm", "as");
                    return;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (i3 != 2) {
                if (i3 == 3) {
                    try {
                        if (this.f3622a == null) {
                            return;
                        }
                        ub a3 = vb.a((WeakReference<ub>) null);
                        Context context2 = this.f3622a;
                        int i10 = ha.f4272c;
                        vb.a(context2, a3, "e", 1000, 307200, "2");
                        if (a3.f5155g == null) {
                            a3.f5155g = new bc(new fc(this.f3622a, new cc(new gc(new ic()))));
                        }
                        a3.f5156h = 3600000;
                        if (TextUtils.isEmpty(a3.f5157i)) {
                            a3.f5157i = "cKey";
                        }
                        if (a3.f5154f == null) {
                            Context context3 = this.f3622a;
                            a3.f5154f = new mc(context3, a3.f5156h, a3.f5157i, new jc(30, a3.f5150a, new kc(context3, ac.f3620a, 20480, 20480, "staticUpdate", ac.f3621b * 1024)));
                        }
                        vb.a(a3);
                        return;
                    } catch (Throwable th3) {
                        ka.a(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (ac.class) {
                    try {
                        if (this.f3625d != null && this.f3622a != null) {
                            try {
                                bArr = new byte[0];
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                            try {
                                for (zb zbVar2 : this.f3625d) {
                                    if (zbVar2 != null) {
                                        byteArrayOutputStream.write(zbVar2.a());
                                    }
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    ka.a(th, "stm", "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    ac.a(this.f3622a, bArr);
                                } finally {
                                }
                            }
                            ac.a(this.f3622a, bArr);
                        }
                    } catch (Throwable th7) {
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                ka.a(th8, "stm", "apb");
            }
        }

        public a(Context context, int i3, List<zb> list) {
            this(context, i3);
            this.f3625d = list;
        }

        public a(Context context, int i3, zb zbVar) {
            this(context, i3);
            this.f3623b = zbVar;
        }
    }

    public static synchronized void a(zb zbVar, Context context) {
        synchronized (ac.class) {
            qc.d().b(new a(context, 1, zbVar));
        }
    }

    public static synchronized void a(List<zb> list, Context context) {
        synchronized (ac.class) {
            try {
                List<zb> b3 = lb.b();
                if (b3 != null && b3.size() > 0) {
                    list.addAll(b3);
                }
            } catch (Throwable unused) {
            }
            b(list, context);
        }
    }

    public static void a(Context context) {
        qc.d().b(new a(context, 3));
    }

    public static void a(Context context, byte[] bArr) throws IOException {
        ub a3 = vb.a((WeakReference<ub>) null);
        a3.f5150a = ha.a(context, "e");
        a3.f5153d = 1000;
        a3.f5151b = 307200;
        a3.f5152c = "2";
        if (a3.e == null) {
            a3.e = new ya();
        }
        try {
            vb.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, a3);
        } catch (Throwable th2) {
            ka.a(th2, "stm", "wts");
        }
    }
}
