package c5;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.dh.imagepick.crop.CropImageView;
import com.dh.imagepick.crop.ImageCropActivity;
import com.dh.imagepick.crop.bean.ImageItem;
import java.io.File;

/* loaded from: classes.dex */
public class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3386a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Looper looper, int i3, boolean z5) {
        super(looper);
        this.f3386a = i3;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar;
        switch (this.f3386a) {
            case 0:
                File file = (File) message.obj;
                int i3 = message.what;
                if (i3 == 1001) {
                    c cVar2 = CropImageView.I;
                    if (cVar2 != null) {
                        ImageCropActivity imageCropActivity = (ImageCropActivity) cVar2;
                        imageCropActivity.D.remove(0);
                        ImageItem imageItem = new ImageItem();
                        imageItem.path = file.getAbsolutePath();
                        imageCropActivity.D.add(imageItem);
                        Intent intent = new Intent();
                        intent.putExtra("extra_result_items", imageCropActivity.D);
                        imageCropActivity.setResult(-1, intent);
                        imageCropActivity.finish();
                        break;
                    }
                } else if (i3 == 1002 && (cVar = CropImageView.I) != null) {
                    ((ImageCropActivity) cVar).getClass();
                    Log.e("cdfd", "裁剪失败");
                    break;
                }
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Looper looper, Handler.Callback callback, int i3) {
        super(looper, callback);
        this.f3386a = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Looper looper, int i3) {
        super(looper);
        this.f3386a = i3;
        switch (i3) {
            case 3:
                super(looper);
                Looper.getMainLooper();
                break;
            default:
                Looper.getMainLooper();
                break;
        }
    }
}
