package ff;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import androidx.camera.core.impl.y0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;

/* loaded from: classes2.dex */
public final class j extends gf.e {
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f13622f;

    public /* synthetic */ j(Object obj, int i3) {
        this.e = i3;
        this.f13622f = obj;
    }

    @Override // gf.e
    public void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        int i3;
        switch (this.e) {
            case 1:
                k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                ((ia.g) this.f13622f).f14382a.j(null);
                return;
            case 2:
                uf.e eVar = (uf.e) this.f13622f;
                if (((PictureFormat) ((y0) eVar.f194a).f1528f) == PictureFormat.DNG) {
                    eVar.f19078i = new DngCreator(((n) bVar).X, totalCaptureResult);
                    DngCreator dngCreator = eVar.f19078i;
                    int i10 = ((y0) eVar.f194a).f1525b;
                    int i11 = (i10 + 360) % 360;
                    if (i11 == 0) {
                        i3 = 1;
                    } else if (i11 == 90) {
                        i3 = 6;
                    } else if (i11 == 180) {
                        i3 = 3;
                    } else {
                        if (i11 != 270) {
                            throw new IllegalArgumentException(l0.j(i10, "Invalid orientation: "));
                        }
                        i3 = 8;
                    }
                    dngCreator.setOrientation(i3);
                    Location location = (Location) ((y0) eVar.f194a).f1526c;
                    if (location != null) {
                        eVar.f19078i.setLocation(location);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // gf.e
    public void g(gf.b bVar, CaptureRequest captureRequest) {
        switch (this.e) {
            case 2:
                super.g(bVar, captureRequest);
                if (captureRequest.getTag() == 2) {
                    uf.f.f19079d.b(1, "onCaptureStarted:", "Dispatching picture shutter.");
                    ((uf.e) this.f13622f).m(false);
                    k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    break;
                }
                break;
            default:
                super.g(bVar, captureRequest);
                break;
        }
    }

    @Override // gf.e
    public void i(gf.b bVar) {
        switch (this.e) {
            case 0:
                this.f14058c = bVar;
                ((n) this.f13622f).T(((n) bVar).Z);
                n nVar = (n) bVar;
                CaptureRequest.Builder builder = nVar.Z;
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
                Boolean bool = Boolean.FALSE;
                builder.set(key, bool);
                nVar.Z.set(CaptureRequest.CONTROL_AWB_LOCK, bool);
                nVar.Y();
                k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                break;
            case 1:
            default:
                super.i(bVar);
                break;
            case 2:
                this.f14058c = bVar;
                uf.e eVar = (uf.e) this.f13622f;
                eVar.f19077h.addTarget(eVar.f19076g.getSurface());
                y0 y0Var = (y0) eVar.f194a;
                PictureFormat pictureFormat = (PictureFormat) y0Var.f1528f;
                PictureFormat pictureFormat2 = PictureFormat.JPEG;
                CaptureRequest.Builder builder2 = eVar.f19077h;
                if (pictureFormat == pictureFormat2) {
                    builder2.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(y0Var.f1525b));
                }
                builder2.setTag(2);
                try {
                    n nVar2 = (n) bVar;
                    if (nVar2.f13648d.e == CameraState.PREVIEW && !nVar2.n()) {
                        nVar2.Y.capture(builder2.build(), nVar2.i0, null);
                        break;
                    }
                } catch (CameraAccessException e) {
                    eVar.f194a = null;
                    eVar.f196c = e;
                    eVar.n();
                    k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    return;
                }
                break;
            case 3:
                uf.l lVar = (uf.l) this.f13622f;
                this.f14058c = bVar;
                try {
                    uf.p.f19101d.b(1, "ResetFlashAction:", "Reverting the flash changes.");
                    CaptureRequest.Builder builder3 = ((n) bVar).Z;
                    CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_MODE;
                    builder3.set(key2, 1);
                    CaptureRequest.Key key3 = CaptureRequest.FLASH_MODE;
                    builder3.set(key3, 0);
                    n nVar3 = (n) bVar;
                    if (nVar3.f13648d.e == CameraState.PREVIEW && !nVar3.n()) {
                        nVar3.Y.capture(builder3.build(), nVar3.i0, null);
                    }
                    builder3.set(key2, lVar.f19088n);
                    builder3.set(key3, lVar.f19089o);
                    ((n) bVar).Y();
                    break;
                } catch (CameraAccessException unused) {
                    return;
                }
        }
    }
}
