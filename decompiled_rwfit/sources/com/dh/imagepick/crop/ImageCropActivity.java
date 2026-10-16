package com.dh.imagepick.crop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import c5.c;
import c5.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.dh.imagepick.R;
import com.dh.imagepick.crop.bean.ImageItem;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ImageCropActivity extends ImageBaseActivity implements c {
    public boolean A;
    public int B;
    public int C;
    public ArrayList D;
    public b E;

    /* renamed from: y, reason: collision with root package name */
    public CropImageView f7105y;

    /* renamed from: z, reason: collision with root package name */
    public Bitmap f7106z;

    @Override // com.dh.imagepick.crop.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_crop);
        this.E = b.a();
        ((ImageView) findViewById(R.id.backImageView)).setOnClickListener(new d(this, 0));
        ((ImageView) findViewById(R.id.confirmBtn)).setOnClickListener(new d(this, 1));
        CropImageView cropImageView = (CropImageView) findViewById(R.id.cv_crop_image);
        this.f7105y = cropImageView;
        cropImageView.setOnBitmapSaveCompleteListener(this);
        b bVar = this.E;
        this.B = bVar.f7113f;
        this.C = bVar.f7114g;
        this.A = bVar.e;
        ArrayList arrayList = bVar.f7120m;
        this.D = arrayList;
        int i3 = 0;
        String str = ((ImageItem) arrayList.get(0)).path;
        this.f7105y.setFocusStyle(this.E.f7117j);
        this.f7105y.setFocusWidth(this.E.f7115h);
        this.f7105y.setFocusHeight(this.E.f7116i);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        options.inSampleSize = (i13 > i11 || i12 > i10) ? i12 > i13 ? i12 / i10 : i13 / i11 : 1;
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        this.f7106z = decodeFile;
        CropImageView cropImageView2 = this.f7105y;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i3 = 180;
            } else if (attributeInt == 6) {
                i3 = 90;
            } else if (attributeInt == 8) {
                i3 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cropImageView2.getClass();
        cropImageView2.setImageBitmap(CropImageView.g(i3, decodeFile));
        this.f7105y.setMinWidth(this.f7106z.getWidth() / 8);
        this.f7105y.setMinHeight(this.f7106z.getHeight() / 8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f7105y.setOnBitmapSaveCompleteListener(null);
        Bitmap bitmap = this.f7106z;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f7106z.recycle();
        this.f7106z = null;
    }
}
