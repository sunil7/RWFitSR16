package com.amap.api.col.p0003sl;

import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k9 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f4387a = d.Unknow;

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f4388b = f.Unknow;

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f4389c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f4390d = "";
    private static volatile long e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile c f4391f = c.Unknow;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f4392g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f4393h = "";

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f4394i = "";

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f4395j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f4396k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f4397l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f4398m = true;

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4399a;

        public a(Context context) {
            this.f4399a = context;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            ArrayList b3 = k9.b(k9.f(this.f4399a));
            int size = b3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = b3.get(i3);
                i3++;
                k9.a(this.f4399a, ((File) obj).getName());
            }
            k9.b(this.f4399a);
        }
    }

    public static class b extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f4402c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f4403d;

        public b(boolean z5, Context context, long j4, JSONObject jSONObject) {
            this.f4400a = z5;
            this.f4401b = context;
            this.f4402c = j4;
            this.f4403d = jSONObject;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            if (this.f4400a) {
                ArrayList b3 = k9.b(k9.f(this.f4401b));
                int size = b3.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = b3.get(i3);
                    i3++;
                    k9.a(this.f4401b, ((File) obj).getName());
                }
            }
            k9.d(this.f4401b);
            k9.a(this.f4401b, this.f4403d, this.f4402c);
            boolean b10 = k9.b(this.f4401b, this.f4403d);
            if (b10) {
                k9.b(this.f4401b, k9.b(this.f4402c));
            }
            if (this.f4400a) {
                k9.b(this.f4401b);
            }
            if (b10) {
                return;
            }
            k9.a(this.f4401b, k9.b(this.f4402c));
        }
    }

    public enum c {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: a, reason: collision with root package name */
        private int f4407a;

        c(int i3) {
            this.f4407a = i3;
        }

        public final int a() {
            return this.f4407a;
        }
    }

    public enum d {
        Unknow(-1),
        NotContain(0),
        DidContain(1);


        /* renamed from: a, reason: collision with root package name */
        private int f4411a;

        d(int i3) {
            this.f4411a = i3;
        }

        public final int a() {
            return this.f4411a;
        }
    }

    public enum e {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);


        /* renamed from: a, reason: collision with root package name */
        private final int f4421a;

        e(int i3) {
            this.f4421a = i3;
        }

        public final int a() {
            return this.f4421a;
        }
    }

    public enum f {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: a, reason: collision with root package name */
        private int f4425a;

        f(int i3) {
            this.f4425a = i3;
        }

        public final int a() {
            return this.f4425a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            ra raVar = new ra();
            raVar.f4960n = context;
            raVar.f4959m = jSONObject;
            JSONObject jSONObject2 = new JSONObject(n9.c(new ib().a(raVar).f4927a));
            if (jSONObject2.has(FileDownloadModel.STATUS)) {
                return jSONObject2.getInt(FileDownloadModel.STATUS) == 1;
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context) {
        synchronized (k9.class) {
            if (context == null) {
                return;
            }
            try {
                if (!f4397l) {
                    e(context);
                    f4397l = true;
                }
                try {
                    xa.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f4387a.a()), Integer.valueOf(f4388b.a()), Long.valueOf(e), f4389c, f4390d, Integer.valueOf(f4391f.a()), Long.valueOf(f4392g), f4393h, f4394i, Long.valueOf(f4395j), Long.valueOf(f4396k)));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private static void e(Context context) {
        String str;
        try {
            str = xa.a(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = null;
        }
        if (str == null) {
            return;
        }
        String[] split = str.split(Const.STR_MART_ADD);
        if (split.length != 11) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            d dVar = d.NotContain;
            if (parseInt != 0) {
                dVar = d.DidContain;
                if (parseInt != 1) {
                    dVar = d.Unknow;
                }
            }
            f4387a = dVar;
            int parseInt2 = Integer.parseInt(split[1]);
            f fVar = f.NotShow;
            if (parseInt2 != 0) {
                fVar = f.DidShow;
                if (parseInt2 != 1) {
                    fVar = f.Unknow;
                }
            }
            f4388b = fVar;
            e = Long.parseLong(split[2]);
            f4390d = split[3];
            f4390d = split[4];
            int parseInt3 = Integer.parseInt(split[5]);
            c cVar = c.NotAgree;
            if (parseInt3 != 0) {
                cVar = c.DidAgree;
                if (parseInt3 != 1) {
                    cVar = c.Unknow;
                }
            }
            f4391f = cVar;
            f4392g = Long.parseLong(split[6]);
            f4393h = split[7];
            f4394i = split[8];
            f4395j = Long.parseLong(split[9]);
            f4396k = Long.parseLong(split[10]);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context) {
        return android.support.v4.media.session.e.l(context.getFilesDir().getAbsolutePath(), "/AMap/Privacy/Upload");
    }

    public static void a(Context context, boolean z5, boolean z6, m9 m9Var) {
        f fVar;
        d dVar;
        if (z6) {
            fVar = f.DidShow;
        } else {
            fVar = f.NotShow;
        }
        if (z5) {
            dVar = d.DidContain;
        } else {
            dVar = d.NotContain;
        }
        synchronized (k9.class) {
            if (context != null && m9Var != null) {
                try {
                    if (!f4397l) {
                        e(context);
                        f4397l = true;
                    }
                    Boolean bool = Boolean.FALSE;
                    if (fVar != f4388b) {
                        bool = Boolean.TRUE;
                        f4388b = fVar;
                    }
                    if (dVar != f4387a) {
                        bool = Boolean.TRUE;
                        f4387a = dVar;
                    }
                    if (bool.booleanValue()) {
                        f4389c = m9Var.d();
                        f4390d = m9Var.e();
                        long currentTimeMillis = System.currentTimeMillis();
                        e = currentTimeMillis;
                        f4395j = currentTimeMillis;
                        d(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j4) {
        return String.format("%d-%s", Long.valueOf(j4), "privacy.data");
    }

    public static void b(Context context) {
        try {
            ArrayList<File> b3 = b(context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload");
            int size = b3.size();
            int i3 = 0;
            while (i3 < size) {
                File file = b3.get(i3);
                i3++;
                File file2 = file;
                try {
                    String name = file2.getName();
                    if (!name.endsWith("-privacy.data")) {
                        file2.delete();
                    } else {
                        String[] split = name.split("-");
                        if (split == null && split.length != 2) {
                            file2.delete();
                        } else if (Long.parseLong(split[0]) <= 0) {
                            file2.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (b(context, new JSONObject(new String(xa.b(context, bArr))))) {
                                file2.delete();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void a(Context context, boolean z5, m9 m9Var) {
        c cVar;
        if (z5) {
            cVar = c.DidAgree;
        } else {
            cVar = c.NotAgree;
        }
        synchronized (k9.class) {
            if (context != null && m9Var != null) {
                try {
                    if (!f4397l) {
                        e(context);
                        f4397l = true;
                    }
                    if (cVar != f4391f) {
                        f4391f = cVar;
                        f4393h = m9Var.d();
                        f4394i = m9Var.e();
                        long currentTimeMillis = System.currentTimeMillis();
                        f4392g = currentTimeMillis;
                        f4395j = currentTimeMillis;
                        d(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> b(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static synchronized l9 a(Context context, m9 m9Var) {
        boolean z5;
        Context context2;
        synchronized (k9.class) {
            try {
                if (context != null && m9Var != null) {
                    if (!f4397l) {
                        e(context);
                        f4397l = true;
                    }
                    l9 l9Var = null;
                    if (f4388b != f.DidShow) {
                        if (f4388b == f.Unknow) {
                            l9Var = new l9(e.ShowUnknowCode, m9Var);
                        } else if (f4388b == f.NotShow) {
                            l9Var = new l9(e.ShowNoShowCode, m9Var);
                        }
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5 && f4387a != d.DidContain) {
                        if (f4387a == d.Unknow) {
                            l9Var = new l9(e.InfoUnknowCode, m9Var);
                        } else if (f4387a == d.NotContain) {
                            l9Var = new l9(e.InfoNotContainCode, m9Var);
                        }
                        z5 = false;
                    }
                    if (z5 && f4391f != c.DidAgree) {
                        if (f4391f == c.Unknow) {
                            l9Var = new l9(e.AgreeUnknowCode, m9Var);
                        } else if (f4391f == c.NotAgree) {
                            l9Var = new l9(e.AgreeNotAgreeCode, m9Var);
                        }
                        z5 = false;
                    }
                    if (f4396k != f4395j) {
                        long j4 = f4395j;
                        f4396k = f4395j;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("privacyInfo", f4387a.a());
                            jSONObject.put("privacyShow", f4388b.a());
                            jSONObject.put("showTime", e);
                            jSONObject.put("show2SDK", f4389c);
                            jSONObject.put("show2SDKVer", f4390d);
                            jSONObject.put("privacyAgree", f4391f.a());
                            jSONObject.put("agreeTime", f4392g);
                            jSONObject.put("agree2SDK", f4393h);
                            jSONObject.put("agree2SDKVer", f4394i);
                            context2 = context;
                            qc.d().b(new b(f4398m, context2, j4, jSONObject));
                        } catch (Throwable unused) {
                            context2 = context;
                        }
                    } else {
                        context2 = context;
                        if (f4398m) {
                            qc.d().b(new a(context2));
                        }
                    }
                    f4398m = false;
                    String e10 = b9.e(context2);
                    if (e10 == null || e10.length() <= 0) {
                        l9Var = new l9(e.InvaildUserKeyCode, m9Var);
                        Log.e(m9Var.d(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(l9Var.f4490a.a()), l9Var.f4491b));
                    }
                    if (z5) {
                        l9Var = new l9(e.SuccessCode, m9Var);
                    } else {
                        Log.e(m9Var.d(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(l9Var.f4490a.a()), l9Var.f4491b));
                    }
                    return l9Var;
                }
                return new l9(e.IllegalArgument, m9Var);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ void b(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(f(context) + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(f(context) + "/" + str);
            if (file.exists()) {
                File file2 = new File((context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void a(Context context, JSONObject jSONObject, long j4) {
        Throwable th2;
        FileOutputStream fileOutputStream;
        byte[] a3;
        try {
            a3 = xa.a(context, jSONObject.toString().getBytes());
            String b3 = b(j4);
            File file = new File(f(context) + "/" + b3);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th3) {
            th2 = th3;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(a3);
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        } catch (Throwable th5) {
            th2 = th5;
            try {
                th2.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } catch (Throwable th7) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                throw th7;
            }
        }
    }
}
