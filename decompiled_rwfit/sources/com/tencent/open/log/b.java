package com.tencent.open.log;

import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f12044a = d.C0020d.a("yy.MM.dd.HH");

    /* renamed from: g, reason: collision with root package name */
    private File f12049g;

    /* renamed from: b, reason: collision with root package name */
    private String f12045b = "Tracer.File";

    /* renamed from: c, reason: collision with root package name */
    private int f12046c = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: d, reason: collision with root package name */
    private int f12047d = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    private int e = 4096;

    /* renamed from: f, reason: collision with root package name */
    private long f12048f = 10000;

    /* renamed from: h, reason: collision with root package name */
    private int f12050h = 10;

    /* renamed from: i, reason: collision with root package name */
    private String f12051i = ".log";

    /* renamed from: j, reason: collision with root package name */
    private long f12052j = Format.OFFSET_SAMPLE_RELATIVE;

    public b(File file, int i3, int i10, int i11, String str, long j4, int i12, String str2, long j10) {
        a(file);
        b(i3);
        a(i10);
        c(i11);
        a(str);
        b(j4);
        d(i12);
        b(str2);
        c(j10);
    }

    private String c(String str) {
        return l0.o("com.tencent.mobileqq_connectSdk.", str, ".log");
    }

    private File[] d(long j4) {
        File file;
        File b3 = b();
        String c9 = c(a(j4));
        try {
            b3 = new File(b3, c9);
        } catch (Throwable th2) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th2);
        }
        String b10 = m.b();
        if (!TextUtils.isEmpty(b10) || b10 != null) {
            try {
                File file2 = new File(b10, c.f12066o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c9);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
            return new File[]{b3, file};
        }
        file = null;
        return new File[]{b3, file};
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public File e() {
        return this.f12049g;
    }

    public int f() {
        return this.f12050h;
    }

    public static String a(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void b(int i3) {
        this.f12047d = i3;
    }

    public void b(long j4) {
        this.f12048f = j4;
    }

    public void b(String str) {
        this.f12051i = str;
    }

    public void a(String str) {
        this.f12045b = str;
    }

    public void a(int i3) {
        this.f12046c = i3;
    }

    public void a(File file) {
        this.f12049g = file;
    }

    public String c() {
        return this.f12045b;
    }

    public void c(int i3) {
        this.e = i3;
    }

    public void c(long j4) {
        this.f12052j = j4;
    }

    public int d() {
        return this.e;
    }

    public void d(int i3) {
        this.f12050h = i3;
    }
}
