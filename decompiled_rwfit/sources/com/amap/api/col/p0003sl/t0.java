package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.kb;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* loaded from: classes.dex */
public class t0 implements kb.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5051a;

    /* renamed from: b, reason: collision with root package name */
    private RandomAccessFile f5052b;

    /* renamed from: c, reason: collision with root package name */
    private rb f5053c;

    /* renamed from: d, reason: collision with root package name */
    private String f5054d;
    a e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected String f5055a;

        /* renamed from: b, reason: collision with root package name */
        protected String f5056b;

        /* renamed from: c, reason: collision with root package name */
        protected String f5057c;

        /* renamed from: d, reason: collision with root package name */
        protected String f5058d;
        protected c e;

        public a(String str, String str2, String str3, String str4) {
            this.f5055a = str;
            this.f5056b = str2;
            this.f5057c = e.l(str4, ".tmp");
            this.f5058d = str4;
        }

        public String a() {
            return this.f5057c;
        }
    }

    public static class b extends b4 {

        /* renamed from: m, reason: collision with root package name */
        private final a f5059m;

        public b(a aVar) {
            this.f5059m = aVar;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            a aVar = this.f5059m;
            if (aVar != null) {
                return aVar.f5055a;
            }
            return null;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return false;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        protected String f5060a;

        /* renamed from: b, reason: collision with root package name */
        protected String f5061b;

        public c(String str, String str2) {
            this.f5060a = str;
            this.f5061b = str2;
        }
    }

    public static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }
    }

    public t0(Context context, a aVar) {
        this.f5051a = context.getApplicationContext();
        this.e = aVar;
        this.f5053c = new rb(new b(aVar));
        this.f5054d = aVar.a();
    }

    public void a() {
        rb rbVar;
        if (a1.f3562f == null || k9.a(a1.f3562f, v4.b()).f4490a == k9.e.SuccessCode) {
            try {
                c cVar = this.e.e;
                if ((cVar == null || TextUtils.isEmpty(cVar.f5060a) || TextUtils.isEmpty(cVar.f5061b) || !o4.a(this.f5051a, cVar.f5060a, cVar.f5061b, "").equalsIgnoreCase(this.e.f5056b)) && (rbVar = this.f5053c) != null) {
                    rbVar.a(this);
                }
            } catch (Throwable th2) {
                ka.a(th2, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onDownload(byte[] bArr, long j4) {
        try {
            if (this.f5052b == null) {
                File file = new File(this.f5054d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f5052b = new RandomAccessFile(file, "rw");
            }
            this.f5052b.seek(j4);
            this.f5052b.write(bArr);
        } catch (Throwable th2) {
            ka.a(th2, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onException(Throwable th2) {
        try {
            RandomAccessFile randomAccessFile = this.f5052b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th3) {
            ka.a(th3, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onFinish() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = this.f5052b;
        } catch (Throwable th2) {
            ka.a(th2, "AuthTaskDownload", "onFinish()");
        }
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th3) {
            ka.a(th3, "AuthTaskDownload", "onFinish3");
        }
        String str = this.e.f5056b;
        String b3 = e9.b(this.f5054d);
        if (b3 == null || !str.equalsIgnoreCase(b3)) {
            try {
                new File(this.f5054d).delete();
                return;
            } catch (Throwable th4) {
                ka.a(th4, "AuthTaskDownload", "onFinish");
                return;
            }
        }
        String str2 = this.e.f5058d;
        try {
            r2 r2Var = new r2();
            File file = new File(this.f5054d);
            r2Var.a(file, new File(str2), -1L, x2.b(file), null);
            c cVar = this.e.e;
            if (cVar != null && !TextUtils.isEmpty(cVar.f5060a) && !TextUtils.isEmpty(cVar.f5061b)) {
                o4.b(this.f5051a, cVar.f5060a, cVar.f5061b, b3);
            }
            new File(this.f5054d).delete();
            return;
        } catch (Throwable th5) {
            ka.a(th5, "AuthTaskDownload", "onFinish1");
            return;
        }
        ka.a(th2, "AuthTaskDownload", "onFinish()");
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onStop() {
    }
}
