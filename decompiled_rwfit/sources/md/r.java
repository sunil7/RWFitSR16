package md;

import android.text.TextUtils;
import com.example.test.ui.device.activity.f0;
import com.haibin.calendarview.Calendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public Class Q;
    public Class R;
    public String S;
    public Class T;
    public Class U;
    public String V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public int f16042a;

    /* renamed from: a0, reason: collision with root package name */
    public int f16043a0;

    /* renamed from: b, reason: collision with root package name */
    public int f16044b;

    /* renamed from: b0, reason: collision with root package name */
    public int f16045b0;

    /* renamed from: c, reason: collision with root package name */
    public int f16046c;

    /* renamed from: c0, reason: collision with root package name */
    public int f16047c0;

    /* renamed from: d, reason: collision with root package name */
    public int f16048d;

    /* renamed from: d0, reason: collision with root package name */
    public int f16049d0;
    public int e;

    /* renamed from: e0, reason: collision with root package name */
    public int f16050e0;

    /* renamed from: f, reason: collision with root package name */
    public int f16051f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f16052f0;

    /* renamed from: g, reason: collision with root package name */
    public int f16053g;

    /* renamed from: g0, reason: collision with root package name */
    public int f16054g0;

    /* renamed from: h, reason: collision with root package name */
    public int f16055h;

    /* renamed from: h0, reason: collision with root package name */
    public Calendar f16056h0;

    /* renamed from: i, reason: collision with root package name */
    public int f16057i;
    public boolean i0;

    /* renamed from: j, reason: collision with root package name */
    public int f16058j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f16059j0;

    /* renamed from: k, reason: collision with root package name */
    public int f16060k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f16061k0;

    /* renamed from: l, reason: collision with root package name */
    public int f16062l;

    /* renamed from: l0, reason: collision with root package name */
    public int f16063l0;

    /* renamed from: m, reason: collision with root package name */
    public int f16064m;

    /* renamed from: m0, reason: collision with root package name */
    public Map f16065m0;

    /* renamed from: n, reason: collision with root package name */
    public int f16066n;

    /* renamed from: n0, reason: collision with root package name */
    public k f16067n0;

    /* renamed from: o, reason: collision with root package name */
    public int f16068o;

    /* renamed from: o0, reason: collision with root package name */
    public f0 f16069o0;

    /* renamed from: p, reason: collision with root package name */
    public int f16070p;

    /* renamed from: p0, reason: collision with root package name */
    public m f16071p0;

    /* renamed from: q, reason: collision with root package name */
    public int f16072q;

    /* renamed from: q0, reason: collision with root package name */
    public Calendar f16073q0;
    public int r;

    /* renamed from: r0, reason: collision with root package name */
    public Calendar f16074r0;

    /* renamed from: s, reason: collision with root package name */
    public int f16075s;

    /* renamed from: s0, reason: collision with root package name */
    public HashMap f16076s0;

    /* renamed from: t, reason: collision with root package name */
    public int f16077t;

    /* renamed from: t0, reason: collision with root package name */
    public int f16078t0;

    /* renamed from: u, reason: collision with root package name */
    public int f16079u;

    /* renamed from: u0, reason: collision with root package name */
    public Calendar f16080u0;

    /* renamed from: v, reason: collision with root package name */
    public int f16081v;

    /* renamed from: v0, reason: collision with root package name */
    public Calendar f16082v0;

    /* renamed from: w, reason: collision with root package name */
    public int f16083w;

    /* renamed from: w0, reason: collision with root package name */
    public int f16084w0;

    /* renamed from: x, reason: collision with root package name */
    public int f16085x;

    /* renamed from: x0, reason: collision with root package name */
    public int f16086x0;

    /* renamed from: y, reason: collision with root package name */
    public int f16087y;

    /* renamed from: z, reason: collision with root package name */
    public int f16088z;

    public final void a(ArrayList arrayList) {
        Map map = this.f16065m0;
        if (map == null || map.size() == 0) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Calendar calendar = (Calendar) obj;
            if (this.f16065m0.containsKey(calendar.toString())) {
                Calendar calendar2 = (Calendar) this.f16065m0.get(calendar.toString());
                if (calendar2 != null) {
                    calendar.setScheme(TextUtils.isEmpty(calendar2.getScheme()) ? this.V : calendar2.getScheme());
                    calendar.setSchemeColor(calendar2.getSchemeColor());
                    calendar.setSchemes(calendar2.getSchemes());
                }
            } else {
                calendar.setScheme("");
                calendar.setSchemeColor(0);
                calendar.setSchemes(null);
            }
        }
    }

    public final Calendar b() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.f16056h0.getYear());
        calendar.setWeek(this.f16056h0.getWeek());
        calendar.setMonth(this.f16056h0.getMonth());
        calendar.setDay(this.f16056h0.getDay());
        calendar.setCurrentDay(true);
        s.c(calendar);
        return calendar;
    }

    public final Calendar c() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.X);
        calendar.setMonth(this.Z);
        calendar.setDay(this.f16045b0);
        calendar.setCurrentDay(calendar.equals(this.f16056h0));
        s.c(calendar);
        return calendar;
    }

    public final Calendar d() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.W);
        calendar.setMonth(this.Y);
        calendar.setDay(this.f16043a0);
        calendar.setCurrentDay(calendar.equals(this.f16056h0));
        s.c(calendar);
        return calendar;
    }

    public final void e(Calendar calendar) {
        Map map = this.f16065m0;
        if (map == null || map.size() == 0) {
            return;
        }
        String calendar2 = calendar.toString();
        if (this.f16065m0.containsKey(calendar2)) {
            calendar.mergeScheme((Calendar) this.f16065m0.get(calendar2), this.V);
        }
    }

    public final void f() {
        Map map = this.f16065m0;
        if (map == null || map.size() <= 0) {
            this.f16073q0.clearScheme();
            return;
        }
        String calendar = this.f16073q0.toString();
        if (this.f16065m0.containsKey(calendar)) {
            this.f16073q0.mergeScheme((Calendar) this.f16065m0.get(calendar), this.V);
        }
    }
}
