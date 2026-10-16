package qf;

import android.content.Context;
import android.view.OrientationEventListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class f extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f17945a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Context context) {
        super(context, 3);
        this.f17945a = gVar;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i3) {
        g gVar = this.f17945a;
        int i10 = 0;
        if (i3 == -1) {
            int i11 = gVar.e;
            if (i11 != -1) {
                i10 = i11;
            }
        } else if (i3 < 315 && i3 >= 45) {
            if (i3 >= 45 && i3 < 135) {
                i10 = 90;
            } else if (i3 >= 135 && i3 < 225) {
                i10 = 180;
            } else if (i3 >= 225 && i3 < 315) {
                i10 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        }
        if (i10 != gVar.e) {
            gVar.e = i10;
            Object[] objArr = {"onDeviceOrientationChanged", Integer.valueOf(i10)};
            ef.i iVar = gVar.f17948c;
            ((ef.b) iVar.f12629b).b(1, objArr);
            CameraView cameraView = (CameraView) iVar.f12630c;
            int i12 = cameraView.f11554n.f17951g;
            if (cameraView.f11543b) {
                lf.b bVar = cameraView.f11555o.B;
                bVar.getClass();
                lf.b.e(i10);
                bVar.f15873d = i10;
                bVar.d();
            } else {
                int i13 = (360 - i12) % 360;
                lf.b bVar2 = cameraView.f11555o.B;
                bVar2.getClass();
                lf.b.e(i13);
                bVar2.f15873d = i13;
                bVar2.d();
            }
            cameraView.f11550j.post(new ef.h(iVar, (i10 + i12) % 360));
        }
    }
}
