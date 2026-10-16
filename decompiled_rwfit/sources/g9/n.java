package g9;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.camera.view.PreviewView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.gms.internal.mlkit_vision_common.y5;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13985a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13986b;

    public /* synthetic */ n(Object obj, int i3) {
        this.f13985a = i3;
        this.f13986b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int height;
        int height2;
        Object obj = this.f13986b;
        switch (this.f13985a) {
            case 0:
                int i17 = StyledPlayerControlView.f8981a1;
                StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) obj;
                styledPlayerControlView.getClass();
                int i18 = i12 - i10;
                int i19 = i16 - i14;
                if (i11 - i3 != i15 - i13 || i18 != i19) {
                    PopupWindow popupWindow = styledPlayerControlView.f8992f0;
                    if (popupWindow.isShowing()) {
                        styledPlayerControlView.m();
                        int width = styledPlayerControlView.getWidth() - popupWindow.getWidth();
                        int i20 = styledPlayerControlView.f8996h0;
                        popupWindow.update(view, width - i20, (-popupWindow.getHeight()) - i20, -1, -1);
                        break;
                    }
                }
                break;
            case 1:
                e0 e0Var = (e0) obj;
                StyledPlayerControlView styledPlayerControlView2 = e0Var.f13925a;
                int width2 = (styledPlayerControlView2.getWidth() - styledPlayerControlView2.getPaddingLeft()) - styledPlayerControlView2.getPaddingRight();
                int height3 = (styledPlayerControlView2.getHeight() - styledPlayerControlView2.getPaddingBottom()) - styledPlayerControlView2.getPaddingTop();
                ViewGroup viewGroup = e0Var.f13927c;
                int c9 = e0.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                int paddingBottom = height - (viewGroup != null ? viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() : 0);
                int max = Math.max(c9, e0.c(e0Var.f13934k) + e0.c(e0Var.f13932i));
                ViewGroup viewGroup2 = e0Var.f13928d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                boolean z5 = width2 <= max || height3 <= (height2 * 2) + paddingBottom;
                if (e0Var.A != z5) {
                    e0Var.A = z5;
                    view.post(new a0(e0Var, 1));
                }
                boolean z6 = i11 - i3 != i15 - i13;
                if (!e0Var.A && z6) {
                    view.post(new a0(e0Var, 2));
                    break;
                }
                break;
            default:
                PreviewView.ImplementationMode implementationMode = PreviewView.f1566m;
                PreviewView previewView = (PreviewView) obj;
                if (i11 - i3 != i15 - i13 || i12 - i10 != i16 - i14) {
                    previewView.a();
                    y5.a();
                    previewView.getViewPort();
                    break;
                }
                break;
        }
    }
}
