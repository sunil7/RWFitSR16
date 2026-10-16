package u0;

import android.graphics.Rect;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class l implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public int f18697c;

    /* renamed from: a, reason: collision with root package name */
    public float f18695a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f18696b = 0;

    /* renamed from: d, reason: collision with root package name */
    public float f18698d = 0.0f;
    public float e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f18699f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f18700g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f18701h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f18702i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f18703j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f18704k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f18705l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f18706m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f18707n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f18708o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f18709p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashMap f18710q = new LinkedHashMap();

    public static boolean b(float f2, float f10) {
        return (Float.isNaN(f2) || Float.isNaN(f10)) ? Float.isNaN(f2) != Float.isNaN(f10) : Math.abs(f2 - f10) > 1.0E-6f;
    }

    public final void a(HashMap hashMap, int i3) {
        t0.k kVar;
        for (String str : hashMap.keySet()) {
            kVar = (t0.k) hashMap.get(str);
            str.getClass();
            switch (str) {
                case "rotationX":
                    kVar.b(Float.isNaN(this.f18699f) ? 0.0f : this.f18699f, i3);
                    break;
                case "rotationY":
                    kVar.b(Float.isNaN(this.f18700g) ? 0.0f : this.f18700g, i3);
                    break;
                case "translationX":
                    kVar.b(Float.isNaN(this.f18705l) ? 0.0f : this.f18705l, i3);
                    break;
                case "translationY":
                    kVar.b(Float.isNaN(this.f18706m) ? 0.0f : this.f18706m, i3);
                    break;
                case "translationZ":
                    kVar.b(Float.isNaN(this.f18707n) ? 0.0f : this.f18707n, i3);
                    break;
                case "progress":
                    kVar.b(Float.isNaN(this.f18709p) ? 0.0f : this.f18709p, i3);
                    break;
                case "scaleX":
                    kVar.b(Float.isNaN(this.f18701h) ? 1.0f : this.f18701h, i3);
                    break;
                case "scaleY":
                    kVar.b(Float.isNaN(this.f18702i) ? 1.0f : this.f18702i, i3);
                    break;
                case "transformPivotX":
                    kVar.b(Float.isNaN(this.f18703j) ? 0.0f : this.f18703j, i3);
                    break;
                case "transformPivotY":
                    kVar.b(Float.isNaN(this.f18704k) ? 0.0f : this.f18704k, i3);
                    break;
                case "rotation":
                    kVar.b(Float.isNaN(this.e) ? 0.0f : this.e, i3);
                    break;
                case "elevation":
                    kVar.b(Float.isNaN(this.f18698d) ? 0.0f : this.f18698d, i3);
                    break;
                case "transitionPathRotate":
                    kVar.b(Float.isNaN(this.f18708o) ? 0.0f : this.f18708o, i3);
                    break;
                case "alpha":
                    kVar.b(Float.isNaN(this.f18695a) ? 1.0f : this.f18695a, i3);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(Const.STR_MART_COMMA)[1];
                        LinkedHashMap linkedHashMap = this.f18710q;
                        if (linkedHashMap.containsKey(str2)) {
                            w0.b bVar = (w0.b) linkedHashMap.get(str2);
                            if (kVar instanceof t0.h) {
                                ((t0.h) kVar).f18448f.append(i3, bVar);
                                break;
                            } else {
                                float b3 = bVar.b();
                                String valueOf = String.valueOf(kVar);
                                StringBuilder sb2 = new StringBuilder(valueOf.length() + str.length() + 69);
                                sb2.append(str);
                                sb2.append(" ViewSpline not a CustomSet frame = ");
                                sb2.append(i3);
                                sb2.append(", value");
                                sb2.append(b3);
                                sb2.append(valueOf);
                                Log.e("MotionPaths", sb2.toString());
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", str.length() != 0 ? "UNKNOWN spline ".concat(str) : new String("UNKNOWN spline "));
                        break;
                    }
            }
        }
    }

    public final void c(Rect rect, w0.o oVar, int i3, int i10) {
        rect.width();
        rect.height();
        w0.j h4 = oVar.h(i10);
        w0.m mVar = h4.f19362c;
        int i11 = mVar.f19421c;
        this.f18696b = i11;
        int i12 = mVar.f19420b;
        this.f18697c = i12;
        this.f18695a = (i12 == 0 || i11 != 0) ? mVar.f19422d : 0.0f;
        w0.n nVar = h4.f19364f;
        boolean z5 = nVar.f19435m;
        this.f18698d = nVar.f19436n;
        this.e = nVar.f19425b;
        this.f18699f = nVar.f19426c;
        this.f18700g = nVar.f19427d;
        this.f18701h = nVar.e;
        this.f18702i = nVar.f19428f;
        this.f18703j = nVar.f19429g;
        this.f18704k = nVar.f19430h;
        this.f18705l = nVar.f19432j;
        this.f18706m = nVar.f19433k;
        this.f18707n = nVar.f19434l;
        w0.l lVar = h4.f19363d;
        p0.e.d(lVar.f19410d);
        this.f18708o = lVar.f19413h;
        this.f18709p = h4.f19362c.e;
        for (String str : h4.f19365g.keySet()) {
            w0.b bVar = (w0.b) h4.f19365g.get(str);
            bVar.getClass();
            int i13 = w0.a.f19284a[bVar.f19287c.ordinal()];
            if (i13 != 1 && i13 != 2 && i13 != 3) {
                this.f18710q.put(str, bVar);
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                }
            }
            float f2 = this.e + 90.0f;
            this.e = f2;
            if (f2 > 180.0f) {
                this.e = f2 - 360.0f;
                return;
            }
            return;
        }
        this.e -= 90.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ((l) obj).getClass();
        return Float.compare(0.0f, 0.0f);
    }
}
