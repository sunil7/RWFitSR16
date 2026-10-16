package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class e2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12824a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f12825b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f12826c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12827d;

    public e2(LinearLayout linearLayout, RelativeLayout relativeLayout, RecyclerView recyclerView, TitleView titleView) {
        this.f12824a = linearLayout;
        this.f12825b = relativeLayout;
        this.f12826c = recyclerView;
        this.f12827d = titleView;
    }

    public static e2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_sport_record, (ViewGroup) null, false);
        int i3 = R$id.iv_health_nodata;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.ll_health_nodata;
            RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
            if (relativeLayout != null) {
                i3 = R$id.sportList;
                RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
                if (recyclerView != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        return new e2((LinearLayout) inflate, relativeLayout, recyclerView, titleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12824a;
    }
}
