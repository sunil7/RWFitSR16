package a2;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.view.View;
import androidx.camera.core.impl.y0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_common.q;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f13f;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i3, Object obj4, int i10) {
        this.f9a = i10;
        this.f13f = obj;
        this.f11c = obj2;
        this.f12d = obj3;
        this.f10b = i3;
        this.e = obj4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr;
        Object obj = this.e;
        int i3 = this.f10b;
        Object obj2 = this.f13f;
        Object obj3 = this.f12d;
        Object obj4 = this.f11c;
        Object[] objArr = 0;
        int i10 = 1;
        switch (this.f9a) {
            case 0:
                m mVar = ((k) obj4).f55d;
                ((c) obj2).f15b.getClass();
                int a3 = mVar.a();
                m mVar2 = ((k) obj3).f55d;
                i.a.a().b(new x.h(this, i10, androidx.recyclerview.widget.c.a(new n(mVar, a3, mVar2, (mVar.size() - a3) - mVar.c(), (mVar2.size() - mVar2.a()) - mVar2.c())), objArr == true ? 1 : 0));
                return;
            case 1:
                for (int i11 = 0; i11 < i3; i11++) {
                    View view = (View) ((ArrayList) obj4).get(i11);
                    String str = (String) ((ArrayList) obj3).get(i11);
                    WeakHashMap weakHashMap = z0.f15748a;
                    n0.v(view, str);
                    n0.v((View) ((ArrayList) obj).get(i11), (String) ((ArrayList) obj2).get(i11));
                }
                return;
            default:
                byte[] bArr2 = (byte[]) obj4;
                if (i3 == 0) {
                    bArr = bArr2;
                } else {
                    if (i3 % 90 != 0 || i3 < 0 || i3 > 270) {
                        throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
                    }
                    wf.b bVar = (wf.b) obj3;
                    int i12 = bVar.f19627a;
                    byte[] bArr3 = new byte[bArr2.length];
                    int i13 = bVar.f19628b;
                    int i14 = i12 * i13;
                    Object[] objArr2 = i3 % 180 != 0;
                    Object[] objArr3 = i3 % SubsamplingScaleImageView.ORIENTATION_270 != 0;
                    Object[] objArr4 = i3 >= 180;
                    for (int i15 = 0; i15 < i13; i15++) {
                        int i16 = 0;
                        while (i16 < i12) {
                            int i17 = (i15 * i12) + i16;
                            int i18 = ((i15 >> 1) * i12) + i14 + (i16 & (-2));
                            int i19 = i18 + 1;
                            int i20 = objArr2 != false ? i13 : i12;
                            int i21 = objArr2 != false ? i12 : i13;
                            int i22 = objArr2 != false ? i15 : i16;
                            int i23 = objArr2 != false ? i16 : i15;
                            if (objArr3 != false) {
                                i22 = (i20 - i22) - 1;
                            }
                            if (objArr4 != false) {
                                i23 = (i21 - i23) - 1;
                            }
                            int i24 = (i23 * i20) + i22;
                            int i25 = ((i23 >> 1) * i20) + i14 + (i22 & (-2));
                            bArr3[i24] = (byte) (bArr2[i17] & 255);
                            bArr3[i25] = (byte) (bArr2[i18] & 255);
                            bArr3[i25 + 1] = (byte) (bArr2[i19] & 255);
                            i16++;
                            i10 = i10;
                        }
                    }
                    bArr = bArr3;
                }
                uf.h hVar = (uf.h) obj2;
                wf.b bVar2 = (wf.b) obj;
                YuvImage yuvImage = new YuvImage(bArr, hVar.f19080a.f19083h, bVar2.f19627a, bVar2.f19628b, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect a10 = q.a(bVar2, hVar.f19080a.f19082g);
                yuvImage.compressToJpeg(a10, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                y0 y0Var = (y0) hVar.f19080a.f194a;
                y0Var.e = byteArray;
                y0Var.f1527d = new wf.b(a10.width(), a10.height());
                uf.i iVar = hVar.f19080a;
                ((y0) iVar.f194a).f1525b = 0;
                iVar.n();
                return;
        }
    }

    public b(int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f9a = 1;
        this.f10b = i3;
        this.f11c = arrayList;
        this.f12d = arrayList2;
        this.e = arrayList3;
        this.f13f = arrayList4;
    }
}
