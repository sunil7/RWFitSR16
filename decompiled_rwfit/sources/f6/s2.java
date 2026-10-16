package f6;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

/* loaded from: classes.dex */
public final class s2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final DrawerLayout f13299a;

    /* renamed from: b, reason: collision with root package name */
    public final de.o f13300b;

    /* renamed from: c, reason: collision with root package name */
    public final DrawerLayout f13301c;

    /* renamed from: d, reason: collision with root package name */
    public final NavigationView f13302d;

    public s2(DrawerLayout drawerLayout, de.o oVar, DrawerLayout drawerLayout2, NavigationView navigationView) {
        this.f13299a = drawerLayout;
        this.f13300b = oVar;
        this.f13301c = drawerLayout2;
        this.f13302d = navigationView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13299a;
    }
}
