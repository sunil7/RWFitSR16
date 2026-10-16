package com.dh.imagepick.crop;

import c5.e;
import com.dh.imagepick.crop.CropImageView;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: o, reason: collision with root package name */
    public static b f7108o;

    /* renamed from: k, reason: collision with root package name */
    public File f7118k;

    /* renamed from: l, reason: collision with root package name */
    public File f7119l;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f7121n;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7109a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f7110b = 9;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7111c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7112d = true;
    public boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f7113f = 800;

    /* renamed from: g, reason: collision with root package name */
    public int f7114g = 800;

    /* renamed from: h, reason: collision with root package name */
    public int f7115h = 280;

    /* renamed from: i, reason: collision with root package name */
    public int f7116i = 280;

    /* renamed from: j, reason: collision with root package name */
    public CropImageView.Style f7117j = CropImageView.Style.RECTANGLE;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f7120m = new ArrayList();

    public static b a() {
        if (f7108o == null) {
            synchronized (b.class) {
                try {
                    if (f7108o == null) {
                        f7108o = new b();
                    }
                } finally {
                }
            }
        }
        return f7108o;
    }

    public void addOnImageSelectedListener(e eVar) {
        if (this.f7121n == null) {
            this.f7121n = new ArrayList();
        }
        this.f7121n.add(eVar);
    }

    public void removeOnImageSelectedListener(e eVar) {
        ArrayList arrayList = this.f7121n;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(eVar);
    }
}
