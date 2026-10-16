package s3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.appcompat.widget.f2;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$layout;
import com.example.baselibrary.R$style;
import pe.o;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18165a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f18166b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f18167c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f18168d;
    public q3.a e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18169f;

    /* renamed from: g, reason: collision with root package name */
    public Animation f18170g;

    /* renamed from: h, reason: collision with root package name */
    public Animation f18171h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18172i;

    /* renamed from: j, reason: collision with root package name */
    public Dialog f18173j;

    /* renamed from: k, reason: collision with root package name */
    public final a f18174k = new a(this);

    /* renamed from: l, reason: collision with root package name */
    public final f2 f18175l = new f2(this, 1);

    public c(Context context) {
        this.f18165a = context;
    }

    public final void a() {
        if (c()) {
            Dialog dialog = this.f18173j;
            if (dialog != null) {
                dialog.dismiss();
                return;
            }
            return;
        }
        if (this.f18169f) {
            return;
        }
        this.e.r.post(new o(this, 5));
        this.f18169f = true;
    }

    public final void b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        Context context = this.f18165a;
        LayoutInflater from = LayoutInflater.from(context);
        if (!c()) {
            q3.a aVar = this.e;
            if (aVar.r == null) {
                aVar.r = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            }
            ViewGroup viewGroup = (ViewGroup) from.inflate(R$layout.layout_basepickerview, this.e.r, false);
            this.f18167c = viewGroup;
            viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.e.getClass();
            ViewGroup viewGroup2 = (ViewGroup) this.f18167c.findViewById(R$id.content_container);
            this.f18166b = viewGroup2;
            viewGroup2.setLayoutParams(layoutParams);
            return;
        }
        ViewGroup viewGroup3 = (ViewGroup) from.inflate(R$layout.layout_basepickerview, (ViewGroup) null, false);
        this.f18168d = viewGroup3;
        viewGroup3.setBackgroundColor(0);
        ViewGroup viewGroup4 = (ViewGroup) this.f18168d.findViewById(R$id.content_container);
        this.f18166b = viewGroup4;
        layoutParams.leftMargin = 30;
        layoutParams.rightMargin = 30;
        viewGroup4.setLayoutParams(layoutParams);
        if (this.f18168d != null) {
            Dialog dialog = new Dialog(context, R$style.custom_dialog2);
            this.f18173j = dialog;
            this.e.getClass();
            dialog.setCancelable(true);
            this.f18173j.setContentView(this.f18168d);
            Window window = this.f18173j.getWindow();
            if (window != null) {
                window.setWindowAnimations(R$style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f18173j.setOnDismissListener(new b(this));
        }
        this.f18168d.setOnClickListener(new androidx.appcompat.app.c(this, 11));
        ViewGroup viewGroup5 = c() ? this.f18168d : this.f18167c;
        viewGroup5.setFocusable(true);
        viewGroup5.setFocusableInTouchMode(true);
        viewGroup5.setOnKeyListener(this.f18174k);
    }

    public abstract boolean c();

    public final void d() {
        if (c()) {
            Dialog dialog = this.f18173j;
            if (dialog != null) {
                dialog.show();
                return;
            }
            return;
        }
        if (!c() && (this.f18167c.getParent() != null || this.f18172i)) {
            return;
        }
        this.f18172i = true;
        this.e.r.addView(this.f18167c);
        this.f18167c.requestFocus();
    }
}
