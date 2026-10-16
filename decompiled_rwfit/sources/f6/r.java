package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes.dex */
public final class r implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13267a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13268b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRecyclerView f13269c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13270d;

    public r(ConstraintLayout constraintLayout, ImageView imageView, SwipeRecyclerView swipeRecyclerView, TitleView titleView) {
        this.f13267a = constraintLayout;
        this.f13268b = imageView;
        this.f13269c = swipeRecyclerView;
        this.f13270d = titleView;
    }

    public static r a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_contact, (ViewGroup) null, false);
        int i3 = R$id.addIv;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.contactList;
            SwipeRecyclerView swipeRecyclerView = (SwipeRecyclerView) he.a(i3, inflate);
            if (swipeRecyclerView != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new r((ConstraintLayout) inflate, imageView, swipeRecyclerView, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f13267a;
    }
}
