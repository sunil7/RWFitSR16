package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.TimeDownView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class h2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12952a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeDownView f12953b;

    public h2(LinearLayout linearLayout, TimeDownView timeDownView) {
        this.f12952a = linearLayout;
        this.f12953b = timeDownView;
    }

    public static h2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_sport_start, (ViewGroup) null, false);
        int i3 = R$id.tvCountDown;
        TimeDownView timeDownView = (TimeDownView) he.a(i3, inflate);
        if (timeDownView != null) {
            return new h2((LinearLayout) inflate, timeDownView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12952a;
    }
}
