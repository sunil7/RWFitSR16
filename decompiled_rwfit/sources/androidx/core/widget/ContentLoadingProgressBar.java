package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1924c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final d f1925a;

    /* renamed from: b, reason: collision with root package name */
    public final d f1926b;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f1925a);
        removeCallbacks(this.f1926b);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1925a);
        removeCallbacks(this.f1926b);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.core.widget.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.core.widget.d] */
    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        final int i3 = 0;
        this.f1925a = new Runnable(this) { // from class: androidx.core.widget.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f1960b;

            {
                this.f1960b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1960b;
                switch (i3) {
                    case 0:
                        int i10 = ContentLoadingProgressBar.f1924c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i11 = ContentLoadingProgressBar.f1924c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f1926b = new Runnable(this) { // from class: androidx.core.widget.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f1960b;

            {
                this.f1960b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f1960b;
                switch (i10) {
                    case 0:
                        int i102 = ContentLoadingProgressBar.f1924c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i11 = ContentLoadingProgressBar.f1924c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
    }
}
