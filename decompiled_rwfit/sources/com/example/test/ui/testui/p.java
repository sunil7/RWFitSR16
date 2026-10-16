package com.example.test.ui.testui;

import android.view.View;
import androidx.camera.lifecycle.LifecycleCamera;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.king.camera.scan.BaseCameraScanActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8301b;

    public /* synthetic */ p(Object obj, int i3) {
        this.f8300a = i3;
        this.f8301b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.f8301b;
        switch (this.f8300a) {
            case 0:
                TRingDeviceFragment this$0 = (TRingDeviceFragment) obj;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                eh.b bVar = this$0.f8225s;
                ((com.example.test.ui.dialog.t) bVar.getValue()).setOnDialogListener(new q(this$0, 6));
                ((com.example.test.ui.dialog.t) bVar.getValue()).show();
                break;
            case 1:
                BaseCameraScanActivity baseCameraScanActivity = (BaseCameraScanActivity) obj;
                fe.d dVar = baseCameraScanActivity.A;
                if (dVar != null) {
                    boolean a3 = dVar.a();
                    fe.d dVar2 = baseCameraScanActivity.A;
                    boolean z5 = !a3;
                    LifecycleCamera lifecycleCamera = dVar2.f13582g;
                    if (lifecycleCamera != null && lifecycleCamera.f1546c.f19853q.f1433b.g()) {
                        dVar2.f13582g.f1546c.f19852p.j(z5);
                    }
                    View view2 = baseCameraScanActivity.f11392z;
                    if (view2 != null) {
                        view2.setSelected(z5);
                        break;
                    }
                }
                break;
            case 2:
                int i3 = StyledPlayerControlView.f8981a1;
                ((StyledPlayerControlView) obj).getClass();
                break;
            case 3:
                StyledPlayerControlView styledPlayerControlView = ((g9.o) obj).e;
                styledPlayerControlView.getClass();
                styledPlayerControlView.f8989d0.f14009b[1] = styledPlayerControlView.getResources().getString(R$string.exo_track_selection_auto);
                styledPlayerControlView.f8992f0.dismiss();
                break;
            case 4:
                g9.u uVar = (g9.u) obj;
                int adapterPosition = uVar.getAdapterPosition();
                StyledPlayerControlView styledPlayerControlView2 = uVar.f14007d;
                if (adapterPosition != 0) {
                    if (adapterPosition != 1) {
                        styledPlayerControlView2.f8992f0.dismiss();
                        break;
                    } else {
                        styledPlayerControlView2.d(styledPlayerControlView2.f8999j0);
                        break;
                    }
                } else {
                    styledPlayerControlView2.d(styledPlayerControlView2.f8990e0);
                    break;
                }
            case 5:
                ((g9.o) obj).e.getClass();
                break;
            default:
                g9.e0 e0Var = (g9.e0) obj;
                e0Var.g();
                if (view.getId() != R$id.exo_overflow_show) {
                    if (view.getId() == R$id.exo_overflow_hide) {
                        e0Var.r.start();
                        break;
                    }
                } else {
                    e0Var.f13940q.start();
                    break;
                }
                break;
        }
    }
}
