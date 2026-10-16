package com.example.test.ui.device.activity;

import android.content.Intent;
import android.media.MediaActionSound;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.camera.core.impl.y0;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.i1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.utils.p0;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import f6.q2;
import java.io.File;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TakePhotoActivity extends XXBaseActivity<i1, q2> implements p5.a, View.OnClickListener, o5.a {
    public static final /* synthetic */ int I = 0;
    public boolean E;
    public boolean F;
    public final g0 G;
    public long H;

    public TakePhotoActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.TakePhotoActivity$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(TakePhotoActivity.this);
            }
        });
        this.E = true;
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.TakePhotoActivity$sound$2
            @Override // oh.a
            public final MediaActionSound invoke() {
                return new MediaActionSound();
            }
        });
        this.G = new g0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new i1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((q2) this.f7247z.getValue()).f13259a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_take_photo, (ViewGroup) null, false);
        int i3 = R$id.backIv;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.camera;
            CameraView cameraView = (CameraView) he.a(i3, inflate);
            if (cameraView != null) {
                i3 = R$id.takePhoto;
                LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                if (linearLayout != null) {
                    i3 = R$id.toggle_camera;
                    ImageView imageView2 = (ImageView) he.a(i3, inflate);
                    if (imageView2 != null) {
                        return new q2((ConstraintLayout) inflate, imageView, cameraView, linearLayout, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        if (this.F) {
            ((i1) I0()).getClass();
            i1.k(1);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((q2) bVar.getValue()).f13260b.setOnClickListener(this);
        ((q2) bVar.getValue()).f13262d.setOnClickListener(this);
        ((q2) bVar.getValue()).e.setOnClickListener(this);
        ((q2) bVar.getValue()).f13261c.setLifecycleOwner(this);
        Log.e("qob", "initView addCameraListener");
        ((q2) bVar.getValue()).f13261c.r.add(this.G);
        this.F = getIntent().getBooleanExtra("isFromClickIn", false);
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        if (((q2) bVar.getValue()).f13261c.getMode() == Mode.VIDEO) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Can't take HQ pictures while in VIDEO mode.", Boolean.FALSE);
            return;
        }
        if (((q2) bVar.getValue()).f13261c.f11555o.o()) {
            return;
        }
        this.H = System.currentTimeMillis();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Capturing picture...", Boolean.FALSE);
        CameraView cameraView = ((q2) bVar.getValue()).f13261c;
        y0 y0Var = new y0();
        ff.q qVar = cameraView.f11555o;
        boolean z5 = qVar.f13665w;
        qVar.f13648d.d("take picture", CameraState.BIND, new ff.p(qVar, y0Var, z5, 0));
    }

    public final void S0(String str) {
        Toast.makeText(this, R$string.str_save_success, 0).show();
        File file = new File(str);
        new p0(this, file);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.E) {
            ((i1) I0()).getClass();
            i1.k(0);
        }
        eh.b bVar = this.f7247z;
        g0 g0Var = this.G;
        if (g0Var != null) {
            ((q2) bVar.getValue()).f13261c.r.remove(g0Var);
        }
        ((q2) bVar.getValue()).f13261c.destroy();
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.backIv;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.E = true;
            onBackPressed();
            return;
        }
        int i10 = R$id.takePhoto;
        if (valueOf != null && valueOf.intValue() == i10) {
            R0();
            return;
        }
        int i11 = R$id.toggle_camera;
        if (valueOf != null && valueOf.intValue() == i11) {
            eh.b bVar = this.f7247z;
            if (((q2) bVar.getValue()).f13261c.f11555o.o()) {
                return;
            }
            ((q2) bVar.getValue()).f13261c.f11555o.getClass();
            CameraView cameraView = ((q2) bVar.getValue()).f13261c;
            int i12 = ef.f.f12621d[cameraView.f11555o.F.ordinal()];
            if (i12 == 1) {
                cameraView.setFacing(Facing.FRONT);
            } else if (i12 == 2) {
                cameraView.setFacing(Facing.BACK);
            }
            Facing facing = cameraView.f11555o.F;
            int i13 = facing == null ? -1 : h0.f7863a[facing.ordinal()];
            if (i13 == 1) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Switched to back camera!", Boolean.FALSE);
            } else {
                if (i13 != 2) {
                    return;
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Switched to front camera!", Boolean.FALSE);
            }
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
        Log.e("qob", "TakePhotoActivity onDestroy");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onTakePhotoEvent(EventBusBeans.TakePhotoEvent takePhotoEvent) {
        kotlin.jvm.internal.e.f(takePhotoEvent, "takePhotoEvent");
        Log.e("qob", "onTakePhotoEvent event " + takePhotoEvent.getEvent());
        if (takePhotoEvent.getEvent() == 0) {
            this.E = false;
            onBackPressed();
        } else if (takePhotoEvent.getEvent() == 2) {
            R0();
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        Log.e("qob", "TakePhotoActivity onMessage " + message.obj);
        S0(message.obj.toString());
    }
}
