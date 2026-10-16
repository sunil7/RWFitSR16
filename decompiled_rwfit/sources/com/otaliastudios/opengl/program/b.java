package com.otaliastudios.opengl.program;

import android.graphics.RectF;
import androidx.recyclerview.widget.e1;
import com.google.android.gms.internal.mlkit_vision_barcode.f1;
import com.google.android.gms.internal.mlkit_vision_common.s6;
import java.nio.FloatBuffer;
import o2.m;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public boolean f11624b;

    /* renamed from: d, reason: collision with root package name */
    public final e1 f11626d;
    public FloatBuffer e;

    /* renamed from: f, reason: collision with root package name */
    public final e1 f11627f;

    /* renamed from: g, reason: collision with root package name */
    public final e1 f11628g;

    /* renamed from: h, reason: collision with root package name */
    public final e1 f11629h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f11630i;

    /* renamed from: j, reason: collision with root package name */
    public int f11631j;

    /* renamed from: k, reason: collision with root package name */
    public yf.a f11632k;

    /* renamed from: a, reason: collision with root package name */
    public final m[] f11623a = new m[0];

    /* renamed from: c, reason: collision with root package name */
    public float[] f11625c = s6.a(xf.a.f19823a);

    public b(int i3) {
        GlProgramLocation$Type glProgramLocation$Type = GlProgramLocation$Type.UNIFORM;
        this.f11626d = new e1(i3, glProgramLocation$Type, "uTexMatrix");
        this.e = f1.a(8);
        GlProgramLocation$Type glProgramLocation$Type2 = GlProgramLocation$Type.ATTRIB;
        this.f11627f = new e1(i3, glProgramLocation$Type2, "aTextureCoord");
        this.f11628g = new e1(i3, glProgramLocation$Type2, "aPosition");
        this.f11629h = new e1(i3, glProgramLocation$Type, "uMVPMatrix");
        this.f11630i = new RectF();
        this.f11631j = -1;
    }
}
