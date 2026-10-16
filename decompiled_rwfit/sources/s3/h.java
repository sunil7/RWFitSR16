package s3;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.e1;
import com.contrarywind.view.WheelView;
import java.text.SimpleDateFormat;
import java.util.List;
import n.m0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: q, reason: collision with root package name */
    public static final SimpleDateFormat f18189q = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f18190a;

    /* renamed from: b, reason: collision with root package name */
    public WheelView f18191b;

    /* renamed from: c, reason: collision with root package name */
    public WheelView f18192c;

    /* renamed from: d, reason: collision with root package name */
    public WheelView f18193d;
    public WheelView e;

    /* renamed from: f, reason: collision with root package name */
    public WheelView f18194f;

    /* renamed from: g, reason: collision with root package name */
    public WheelView f18195g;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f18196h;

    /* renamed from: i, reason: collision with root package name */
    public int f18197i;

    /* renamed from: j, reason: collision with root package name */
    public int f18198j;

    /* renamed from: k, reason: collision with root package name */
    public int f18199k;

    /* renamed from: l, reason: collision with root package name */
    public int f18200l;

    /* renamed from: m, reason: collision with root package name */
    public int f18201m;

    /* renamed from: n, reason: collision with root package name */
    public int f18202n;

    /* renamed from: o, reason: collision with root package name */
    public int f18203o;

    /* renamed from: p, reason: collision with root package name */
    public m0 f18204p;

    public static void a(h hVar, int i3, int i10, int i11, int i12, List list, List list2) {
        int currentItem = hVar.f18193d.getCurrentItem();
        if (list.contains(String.valueOf(i10))) {
            if (i12 > 31) {
                i12 = 31;
            }
            hVar.f18193d.setAdapter(new e1(i11, i12, 4));
        } else if (list2.contains(String.valueOf(i10))) {
            if (i12 > 30) {
                i12 = 30;
            }
            hVar.f18193d.setAdapter(new e1(i11, i12, 4));
        } else if ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) {
            if (i12 > 28) {
                i12 = 28;
            }
            hVar.f18193d.setAdapter(new e1(i11, i12, 4));
        } else {
            if (i12 > 29) {
                i12 = 29;
            }
            hVar.f18193d.setAdapter(new e1(i11, i12, 4));
        }
        if (currentItem > hVar.f18193d.getAdapter().z() - 1) {
            hVar.f18193d.setCurrentItem(hVar.f18193d.getAdapter().z() - 1);
        }
    }

    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f18203o == this.f18197i) {
            int currentItem = this.f18192c.getCurrentItem();
            int i3 = this.f18199k;
            if (currentItem + i3 == i3) {
                sb2.append(this.f18191b.getCurrentItem() + this.f18197i);
                sb2.append("-");
                sb2.append(this.f18192c.getCurrentItem() + this.f18199k);
                sb2.append("-");
                sb2.append(this.f18193d.getCurrentItem() + this.f18201m);
                sb2.append(" ");
                sb2.append(this.e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f18194f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f18195g.getCurrentItem());
            } else {
                sb2.append(this.f18191b.getCurrentItem() + this.f18197i);
                sb2.append("-");
                sb2.append(this.f18192c.getCurrentItem() + this.f18199k);
                sb2.append("-");
                sb2.append(this.f18193d.getCurrentItem() + 1);
                sb2.append(" ");
                sb2.append(this.e.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f18194f.getCurrentItem());
                sb2.append(":");
                sb2.append(this.f18195g.getCurrentItem());
            }
        } else {
            sb2.append(this.f18191b.getCurrentItem() + this.f18197i);
            sb2.append("-");
            sb2.append(this.f18192c.getCurrentItem() + 1);
            sb2.append("-");
            sb2.append(this.f18193d.getCurrentItem() + 1);
            sb2.append(" ");
            sb2.append(this.e.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f18194f.getCurrentItem());
            sb2.append(":");
            sb2.append(this.f18195g.getCurrentItem());
        }
        return sb2.toString();
    }

    public final void c(WheelView wheelView) {
        if (this.f18204p != null) {
            wheelView.setOnItemSelectedListener(new mc.g(this, 15));
        }
    }
}
