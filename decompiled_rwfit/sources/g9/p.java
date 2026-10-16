package g9;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class p implements com.google.android.exoplayer2.o, i0, View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f13996a;

    public p(StyledPlayerControlView styledPlayerControlView) {
        this.f13996a = styledPlayerControlView;
    }

    @Override // g9.i0
    public final void a(long j4) {
        StyledPlayerControlView styledPlayerControlView = this.f13996a;
        styledPlayerControlView.O = true;
        TextView textView = styledPlayerControlView.f9004n;
        if (textView != null) {
            textView.setText(i9.g.d(styledPlayerControlView.f9006p, styledPlayerControlView.f9007q, j4));
        }
        styledPlayerControlView.f8983a0.f();
    }

    @Override // g9.i0
    public final void b(long j4, boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f13996a;
        styledPlayerControlView.O = false;
        styledPlayerControlView.f8983a0.g();
    }

    @Override // g9.i0
    public final void c(long j4) {
        StyledPlayerControlView styledPlayerControlView = this.f13996a;
        TextView textView = styledPlayerControlView.f9004n;
        if (textView != null) {
            textView.setText(i9.g.d(styledPlayerControlView.f9006p, styledPlayerControlView.f9007q, j4));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13996a.getClass();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        StyledPlayerControlView styledPlayerControlView = this.f13996a;
        if (styledPlayerControlView.f8994g0) {
            styledPlayerControlView.f8983a0.g();
        }
    }
}
