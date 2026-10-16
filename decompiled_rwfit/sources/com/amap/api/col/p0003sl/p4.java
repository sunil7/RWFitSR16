package com.amap.api.col.p0003sl;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class p4 {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f4809c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4810d = false;
    private static boolean e = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4811a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f4812b = 0;

    public static void a(boolean z5) {
        f4809c = z5;
    }

    public static boolean b() {
        return f4809c;
    }

    public static boolean c() {
        return f4810d;
    }

    public static boolean d() {
        return e;
    }

    public boolean e() {
        return this.f4812b >= 20;
    }

    public void f() {
        this.f4812b++;
    }

    public static void b(boolean z5) {
        f4810d = z5;
    }

    public static void c(boolean z5) {
        e = z5;
    }

    public boolean a() {
        return this.f4811a;
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i3 = -1;
                for (int i10 = (int) (width / 4.0f); i10 < (width * 3) / 4.0f; i10++) {
                    for (int i11 = (int) (height / 4.0f); i11 < (height * 3) / 4.0f; i11++) {
                        int pixel = bitmap.getPixel(i10, i11);
                        if (i3 == -1) {
                            i3 = pixel;
                        }
                        if (pixel != i3) {
                            return false;
                        }
                        if (pixel != -16777216) {
                            return false;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return true;
    }
}
