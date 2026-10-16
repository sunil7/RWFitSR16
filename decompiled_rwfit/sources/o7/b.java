package o7;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: u, reason: collision with root package name */
    public final int f16802u;

    /* renamed from: v, reason: collision with root package name */
    public final int f16803v;

    /* renamed from: w, reason: collision with root package name */
    public final int f16804w;

    /* renamed from: x, reason: collision with root package name */
    public final int f16805x;

    /* renamed from: y, reason: collision with root package name */
    public final String[] f16806y;

    public b(List list) {
        super("", list);
        this.f16802u = 1;
        this.f16803v = Color.rgb(215, 215, 215);
        this.f16804w = -16777216;
        this.f16805x = 120;
        this.f16806y = new String[0];
        this.f16824t = Color.rgb(0, 0, 0);
        for (int i3 = 0; i3 < list.size(); i3++) {
            float[] o3 = ((BarEntry) list.get(i3)).o();
            if (o3 != null && o3.length > this.f16802u) {
                this.f16802u = o3.length;
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((BarEntry) list.get(i10)).o();
        }
    }

    @Override // o7.d
    public final void a(Entry entry) {
        BarEntry barEntry = (BarEntry) entry;
        if (barEntry == null || Float.isNaN(barEntry.d())) {
            return;
        }
        if (barEntry.o() == null) {
            if (barEntry.d() < this.f16822q) {
                this.f16822q = barEntry.d();
            }
            if (barEntry.d() > this.f16821p) {
                this.f16821p = barEntry.d();
            }
        } else {
            if ((-barEntry.l()) < this.f16822q) {
                this.f16822q = -barEntry.l();
            }
            if (barEntry.m() > this.f16821p) {
                this.f16821p = barEntry.m();
            }
        }
        c(barEntry);
    }

    public final boolean o() {
        return this.f16802u > 1;
    }
}
