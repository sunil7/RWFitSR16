package com.dh.imagepick.preview.widgets.video;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.t;
import java.util.ArrayList;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class ExoVideoView extends TextureView {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f7177f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final eh.b f7178a;

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7179b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7180c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7181d;
    public final hc.a e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoVideoView(Context context) {
        this(context, null, 6, 0);
        e.f(context, "context");
    }

    private final a getExoSourceManager() {
        return (a) this.f7178a.getValue();
    }

    private final i9.b getLogger() {
        return (i9.b) this.f7179b.getValue();
    }

    public final void a() {
        Log.i("viewer", "video pause null " + ((Object) null));
    }

    public final void b() {
    }

    public final boolean getPrepared() {
        return this.f7181d;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("viewer", "video onAttachedToWindow null");
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("viewer", "video onDetachedFromWindow null " + ((Object) null));
        b();
    }

    public final void setPrepared(boolean z5) {
        this.f7181d = z5;
    }

    public final void setVideoRenderedCallback(b bVar) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        e.f(context, "context");
    }

    public /* synthetic */ ExoVideoView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoVideoView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e.f(context, "context");
        this.f7178a = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.video.ExoVideoView$exoSourceManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final a invoke() {
                Context context2 = context;
                a aVar = new a();
                context2.getApplicationContext();
                return aVar;
            }
        });
        this.f7179b = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.widgets.video.ExoVideoView$logger$2
            @Override // oh.a
            public final i9.b invoke() {
                i9.b bVar = new i9.b();
                new t();
                new s();
                SystemClock.elapsedRealtime();
                return bVar;
            }
        });
        this.f7180c = new ArrayList();
        this.e = new hc.a(this, 4);
    }
}
