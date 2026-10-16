package com.dh.imagepick.crop;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.dh.imagepick.crop.CropImageView;
import com.gyf.immersionbar.ImmersionBar;
import java.io.File;

/* loaded from: classes.dex */
public class ImageBaseActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImmersionBar.with(this).statusBarColorInt(Color.parseColor("#101016")).statusBarDarkFont(false, 0.2f).init();
        ImmersionBar.with(this).fitsSystemWindows(true).init();
    }

    @Override // android.app.Activity
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        b a3 = b.a();
        a3.getClass();
        a3.f7118k = (File) bundle.getSerializable("cropCacheFolder");
        a3.f7119l = (File) bundle.getSerializable("takeImageFile");
        if (bundle.getSerializable("imageLoader") != null) {
            throw new ClassCastException();
        }
        a3.f7117j = (CropImageView.Style) bundle.getSerializable("style");
        a3.f7109a = bundle.getBoolean("multiMode");
        a3.f7111c = bundle.getBoolean("crop");
        a3.f7112d = bundle.getBoolean("showCamera");
        a3.e = bundle.getBoolean("isSaveRectangle");
        a3.f7110b = bundle.getInt("selectLimit");
        a3.f7113f = bundle.getInt("outPutX");
        a3.f7114g = bundle.getInt("outPutY");
        a3.f7115h = bundle.getInt("focusWidth");
        a3.f7116i = bundle.getInt("focusHeight");
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b a3 = b.a();
        bundle.putSerializable("cropCacheFolder", a3.f7118k);
        bundle.putSerializable("takeImageFile", a3.f7119l);
        bundle.putSerializable("imageLoader", null);
        bundle.putSerializable("style", a3.f7117j);
        bundle.putBoolean("multiMode", a3.f7109a);
        bundle.putBoolean("crop", a3.f7111c);
        bundle.putBoolean("showCamera", a3.f7112d);
        bundle.putBoolean("isSaveRectangle", a3.e);
        bundle.putInt("selectLimit", a3.f7110b);
        bundle.putInt("outPutX", a3.f7113f);
        bundle.putInt("outPutY", a3.f7114g);
        bundle.putInt("focusWidth", a3.f7115h);
        bundle.putInt("focusHeight", a3.f7116i);
    }
}
