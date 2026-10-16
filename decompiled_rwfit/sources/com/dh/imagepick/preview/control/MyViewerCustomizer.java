package com.dh.imagepick.preview.control;

import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.z1;
import ch.f;
import com.dh.imagepick.R;
import com.dh.imagepick.preview.widgets.video.ExoVideoView;
import com.google.android.gms.internal.mlkit_vision_barcode.oc;
import i5.a;
import j5.g;
import java.util.concurrent.TimeUnit;
import k5.e;
import rg.l;
import tg.b;
import tg.d;

/* loaded from: classes.dex */
public final class MyViewerCustomizer implements r, g {

    /* renamed from: a, reason: collision with root package name */
    public a f7134a;

    /* renamed from: b, reason: collision with root package name */
    public e f7135b;

    /* renamed from: c, reason: collision with root package name */
    public View f7136c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f7137d;

    @d0(Lifecycle$Event.ON_DESTROY)
    private final void onDestroy() {
        ExoVideoView exoVideoView;
        e eVar = this.f7135b;
        if (eVar != null && (exoVideoView = (ExoVideoView) oc.a(eVar, R.id.videoView)) != null) {
            exoVideoView.b();
        }
        a aVar = this.f7134a;
        if (aVar != null) {
            aVar.dispose();
        }
        this.f7134a = null;
    }

    @d0(Lifecycle$Event.ON_PAUSE)
    private final void onPause() {
        ExoVideoView exoVideoView;
        e eVar = this.f7135b;
        if (eVar == null || (exoVideoView = (ExoVideoView) oc.a(eVar, R.id.videoView)) == null) {
            return;
        }
        exoVideoView.a();
    }

    @d0(Lifecycle$Event.ON_RESUME)
    private final void onResume() {
        e eVar = this.f7135b;
        if (eVar == null || ((ExoVideoView) oc.a(eVar, R.id.videoView)) == null) {
            return;
        }
        int i3 = ExoVideoView.f7177f;
    }

    @Override // j5.g
    public final void a(z1 z1Var, int i3) {
        s b3;
        TextView textView = this.f7137d;
        if (textView != null) {
            textView.setText(String.valueOf(i3));
        }
        a aVar = this.f7134a;
        if (aVar != null) {
            aVar.dispose();
        }
        e eVar = this.f7135b;
        if (eVar != null && ((ExoVideoView) oc.a(eVar, R.id.videoView)) != null) {
            Log.i("viewer", "video reset null " + ((Object) null));
        }
        if (z1Var instanceof e) {
            ExoVideoView exoVideoView = (ExoVideoView) oc.a(z1Var, R.id.videoView);
            a aVar2 = new a(exoVideoView, z1Var, (exoVideoView == null || (b3 = com.dh.imagepick.preview.utils.a.b(exoVideoView)) == null) ? null : b3.getLifecycle());
            l<Long> timer = l.timer(250 + 50, TimeUnit.MILLISECONDS);
            d dVar = b.f18629a;
            if (dVar == null) {
                throw new NullPointerException("scheduler == null");
            }
            timer.observeOn(dVar).subscribeOn(f.f3505b).subscribe(aVar2);
            this.f7134a = aVar2;
            this.f7135b = (e) z1Var;
        }
    }

    @Override // com.dh.imagepick.preview.d
    public final void e(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
    }

    @Override // com.dh.imagepick.preview.d
    public final void g(z1 viewHolder, View view) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator alpha2;
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        View a3 = oc.a(viewHolder, R.id.customizeDecor);
        if (a3 != null && (animate2 = a3.animate()) != null && (duration2 = animate2.setDuration(200L)) != null && (alpha2 = duration2.alpha(0.0f)) != null) {
            alpha2.start();
        }
        View view2 = this.f7136c;
        if (view2 != null && (animate = view2.animate()) != null && (duration = animate.setDuration(200L)) != null && (alpha = duration.alpha(0.0f)) != null) {
            alpha.start();
        }
        a aVar = this.f7134a;
        if (aVar != null) {
            aVar.dispose();
        }
        this.f7134a = null;
        this.f7135b = null;
        this.f7136c = null;
        this.f7137d = null;
    }

    @Override // com.dh.imagepick.preview.d
    public final void i(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
    }
}
