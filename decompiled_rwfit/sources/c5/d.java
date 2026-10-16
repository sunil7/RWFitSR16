package c5;

import android.view.View;
import com.dh.imagepick.crop.CropImageView;
import com.dh.imagepick.crop.ImageCropActivity;
import java.io.File;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageCropActivity f3388b;

    public /* synthetic */ d(ImageCropActivity imageCropActivity, int i3) {
        this.f3387a = i3;
        this.f3388b = imageCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3387a) {
            case 0:
                ImageCropActivity imageCropActivity = this.f3388b;
                imageCropActivity.setResult(0);
                imageCropActivity.finish();
                break;
            default:
                ImageCropActivity imageCropActivity2 = this.f3388b;
                CropImageView cropImageView = imageCropActivity2.f7105y;
                com.dh.imagepick.crop.b bVar = imageCropActivity2.E;
                if (bVar.f7118k == null) {
                    bVar.f7118k = new File(imageCropActivity2.getCacheDir() + "/ImagePicker/cropTemp/");
                }
                cropImageView.h(bVar.f7118k, imageCropActivity2.B, imageCropActivity2.C, imageCropActivity2.A);
                break;
        }
    }
}
