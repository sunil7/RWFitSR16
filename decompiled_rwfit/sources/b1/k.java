package b1;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f3068a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f3069b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3070c;

    public k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f3068a = colorStateList;
        this.f3069b = configuration;
        this.f3070c = theme == null ? 0 : theme.hashCode();
    }
}
