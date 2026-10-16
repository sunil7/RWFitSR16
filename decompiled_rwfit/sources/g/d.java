package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f13691f;

    /* renamed from: a, reason: collision with root package name */
    public int f13692a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f13693b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f13694c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f13695d;
    public Resources e;

    public d(Context context, int i3) {
        super(context);
        this.f13692a = i3;
    }

    public final void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f13695d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f13695d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f13693b == null) {
            this.f13693b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f13693b.setTo(theme);
            }
        }
        this.f13693b.applyStyle(this.f13692a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.e == null) {
            Configuration configuration = this.f13695d;
            if (configuration != null) {
                if (f13691f == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    f13691f = configuration2;
                }
                if (!configuration.equals(f13691f)) {
                    this.e = c.a(this, this.f13695d).getResources();
                }
            }
            this.e = super.getResources();
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f13694c == null) {
            this.f13694c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f13694c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f13693b;
        if (theme != null) {
            return theme;
        }
        if (this.f13692a == 0) {
            this.f13692a = R$style.Theme_AppCompat_Light;
        }
        b();
        return this.f13693b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i3) {
        if (this.f13692a != i3) {
            this.f13692a = i3;
            b();
        }
    }
}
