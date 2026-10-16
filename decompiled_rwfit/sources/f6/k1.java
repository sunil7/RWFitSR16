package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.RadarView;
import com.google.android.material.navigation.NavigationView;

/* loaded from: classes.dex */
public final class k1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final DrawerLayout f13048a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f13049b;

    /* renamed from: c, reason: collision with root package name */
    public final DrawerLayout f13050c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f13051d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f13052f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f13053g;

    /* renamed from: h, reason: collision with root package name */
    public final View f13054h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f13055i;

    /* renamed from: j, reason: collision with root package name */
    public final NavigationView f13056j;

    /* renamed from: k, reason: collision with root package name */
    public final RadarView f13057k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f13058l;

    public k1(DrawerLayout drawerLayout, RecyclerView recyclerView, DrawerLayout drawerLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, ImageView imageView5, NavigationView navigationView, RadarView radarView, TextView textView) {
        this.f13048a = drawerLayout;
        this.f13049b = recyclerView;
        this.f13050c = drawerLayout2;
        this.f13051d = imageView;
        this.e = imageView2;
        this.f13052f = imageView3;
        this.f13053g = imageView4;
        this.f13054h = view;
        this.f13055i = imageView5;
        this.f13056j = navigationView;
        this.f13057k = radarView;
        this.f13058l = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13048a;
    }
}
