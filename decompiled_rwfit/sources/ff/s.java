package ff;

import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class s implements ia.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f13671a;

    public /* synthetic */ s(q qVar) {
        this.f13671a = qVar;
    }

    @Override // ia.d
    public void onSuccess(Object obj) {
        ef.i iVar = this.f13671a.f13647c;
        ((ef.b) iVar.f12629b).b(1, "dispatchOnCameraClosed");
        ((CameraView) iVar.f12630c).f11550j.post(new ef.h(iVar, 1, (byte) 0));
    }
}
