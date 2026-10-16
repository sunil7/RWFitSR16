package g9;

import android.content.Context;
import android.util.Base64;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.gc;
import com.google.android.gms.internal.mlkit_vision_barcode.hc;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class n0 extends FrameLayout implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final c f13987a;

    /* renamed from: b, reason: collision with root package name */
    public final l0 f13988b;

    /* renamed from: c, reason: collision with root package name */
    public List f13989c;

    /* renamed from: d, reason: collision with root package name */
    public d f13990d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f13991f;

    public n0(Context context) {
        super(context, null);
        this.f13989c = Collections.EMPTY_LIST;
        this.f13990d = d.f13914g;
        this.e = 0.0533f;
        this.f13991f = 0.08f;
        c cVar = new c(context);
        this.f13987a = cVar;
        l0 l0Var = new l0(context, null);
        this.f13988b = l0Var;
        l0Var.setBackgroundColor(0);
        addView(cVar);
        addView(l0Var);
    }

    @Override // g9.h0
    public final void a(List list, d dVar, float f2, float f10) {
        this.f13990d = dVar;
        this.e = f2;
        this.f13991f = f10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            d9.a aVar = (d9.a) list.get(i3);
            aVar.getClass();
            arrayList2.add(aVar);
        }
        if (!this.f13989c.isEmpty() || !arrayList2.isEmpty()) {
            this.f13989c = arrayList2;
            c();
        }
        this.f13987a.a(arrayList, dVar, f2, f10);
        invalidate();
    }

    public final String b(float f2, int i3) {
        float b3 = hc.b(i3, f2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (b3 == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(b3 / getContext().getResources().getDisplayMetrics().density)};
        int i10 = i9.g.f14378a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    public final void c() {
        String format;
        StringBuilder sb2 = new StringBuilder();
        String a3 = gc.a(this.f13990d.f13915a);
        String b3 = b(this.e, 0);
        Float valueOf = Float.valueOf(1.2f);
        d dVar = this.f13990d;
        int i3 = dVar.f13918d;
        String str = "unset";
        int i10 = dVar.e;
        if (i3 == 1) {
            Object[] objArr = {gc.a(i10)};
            int i11 = i9.g.f14378a;
            str = String.format(Locale.US, "1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", objArr);
        } else if (i3 == 2) {
            String a10 = gc.a(i10);
            int i12 = i9.g.f14378a;
            Locale locale = Locale.US;
            str = "0.1em 0.12em 0.15em ".concat(a10);
        } else if (i3 == 3) {
            String a11 = gc.a(i10);
            int i13 = i9.g.f14378a;
            Locale locale2 = Locale.US;
            str = "0.06em 0.08em 0.15em ".concat(a11);
        } else if (i3 == 4) {
            String a12 = gc.a(i10);
            int i14 = i9.g.f14378a;
            Locale locale3 = Locale.US;
            str = "-0.05em -0.05em 0.15em ".concat(a12);
        }
        Object[] objArr2 = {a3, b3, valueOf, str};
        int i15 = i9.g.f14378a;
        sb2.append(String.format(Locale.US, "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr2));
        HashMap hashMap = new HashMap();
        StringBuilder g10 = r5.a.g(r5.a.a(r5.a.a(5, "default_bg"), "default_bg"), ".", "default_bg", ",.", "default_bg");
        g10.append(" *");
        hashMap.put(g10.toString(), "background-color:" + gc.a(this.f13990d.f13916b) + Const.STR_MART_SEMICOLON);
        for (int i16 = 0; i16 < this.f13989c.size(); i16++) {
            ((d9.a) this.f13989c.get(i16)).getClass();
            float f2 = 0.0f != -3.4028235E38f ? 0.0f * 100.0f : 50.0f;
            int i17 = -100;
            if (0.0f != -3.4028235E38f) {
                format = String.format(Locale.US, "%.2f%%", Float.valueOf(0.0f * 100.0f));
                i17 = 0;
            } else {
                format = String.format(Locale.US, "%.2f%%", Float.valueOf((1.0f - this.f13991f) * 100.0f));
            }
            String format2 = 0.0f != -3.4028235E38f ? String.format(Locale.US, "%.2f%%", Float.valueOf(100.0f * 0.0f)) : "fit-content";
            String b10 = b(0.0f, 0);
            String a13 = gc.a(this.f13990d.f13917c);
            float f10 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = m.f13983a;
            String str2 = "";
            ImmutableMap.of();
            cf.a aVar = new cf.a("");
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.put(str3, (String) hashMap.get(str3));
                pc.b(str4 == null || str4.equals(hashMap.get(str3)));
            }
            Integer valueOf2 = Integer.valueOf(i16);
            Float valueOf3 = Float.valueOf(f2);
            Integer valueOf4 = Integer.valueOf(i17);
            if (0.0f != 0.0f) {
                Object[] objArr3 = {"skewX", Float.valueOf(0.0f)};
                int i18 = i9.g.f14378a;
                str2 = String.format(Locale.US, "%s(%.2fdeg)", objArr3);
            }
            sb2.append(String.format(Locale.US, "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", valueOf2, "left", valueOf3, "top", format, "width", format2, "center", "horizontal-tb", b10, a13, 0, valueOf4, str2));
            sb2.append("<span class='default_bg'>");
            sb2.append(aVar.f3465a);
            sb2.append("</span></div>");
        }
        sb2.append("</div></body></html>");
        StringBuilder sb3 = new StringBuilder("<html><head><style>");
        for (String str5 : hashMap.keySet()) {
            sb3.append(str5);
            sb3.append(Const.STR_MART_JSON_BEGIN);
            sb3.append((String) hashMap.get(str5));
            sb3.append("}");
        }
        sb3.append("</style></head>");
        sb2.insert(0, sb3.toString());
        this.f13988b.loadData(Base64.encodeToString(sb2.toString().getBytes(com.google.common.base.a.f10996a), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        if (!z5 || this.f13989c.isEmpty()) {
            return;
        }
        c();
    }
}
