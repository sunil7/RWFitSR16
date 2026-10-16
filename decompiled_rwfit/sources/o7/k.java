package o7;

import android.graphics.Color;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends d {
    public boolean A;
    public LineDataSet$Mode B;
    public ArrayList C;
    public final int D;
    public float E;
    public final float F;
    public float G;
    public p7.c H;
    public boolean I;
    public final boolean J;

    /* renamed from: u, reason: collision with root package name */
    public boolean f16834u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f16835v;

    /* renamed from: w, reason: collision with root package name */
    public float f16836w;

    /* renamed from: x, reason: collision with root package name */
    public int f16837x;

    /* renamed from: y, reason: collision with root package name */
    public int f16838y;

    /* renamed from: z, reason: collision with root package name */
    public float f16839z;

    public k(List list) {
        super("DataSet 1", list);
        this.f16834u = true;
        this.f16835v = true;
        this.f16836w = 0.5f;
        this.f16836w = v7.h.c(0.5f);
        this.f16837x = Color.rgb(140, 234, 255);
        this.f16838y = 85;
        this.f16839z = 2.5f;
        this.A = false;
        this.B = LineDataSet$Mode.LINEAR;
        this.C = null;
        this.D = -1;
        this.E = 8.0f;
        this.F = 4.0f;
        this.G = 0.2f;
        this.H = new n9.e(17);
        this.I = true;
        this.J = true;
        ArrayList arrayList = new ArrayList();
        this.C = arrayList;
        arrayList.clear();
        this.C.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }
}
