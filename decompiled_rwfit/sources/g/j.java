package g;

import android.view.View;
import android.view.animation.BaseInterpolator;
import androidx.appcompat.widget.w3;
import com.google.android.gms.internal.mlkit_vision_barcode.be;
import java.util.ArrayList;
import l1.g1;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public BaseInterpolator f13737c;

    /* renamed from: d, reason: collision with root package name */
    public be f13738d;
    public boolean e;

    /* renamed from: b, reason: collision with root package name */
    public long f13736b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final w3 f13739f = new w3(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13735a = new ArrayList();

    public final void a() {
        if (this.e) {
            ArrayList arrayList = this.f13735a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((g1) obj).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        ArrayList arrayList = this.f13735a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            g1 g1Var = (g1) obj;
            long j4 = this.f13736b;
            if (j4 >= 0) {
                g1Var.c(j4);
            }
            BaseInterpolator baseInterpolator = this.f13737c;
            if (baseInterpolator != null && (view = (View) g1Var.f15698a.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.f13738d != null) {
                g1Var.d(this.f13739f);
            }
            View view2 = (View) g1Var.f15698a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
