package com.example.test.ui.device.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.ce;
import com.king.mlkit.vision.barcode.QRCodeCameraScanActivity;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import l1.z0;

/* loaded from: classes.dex */
public final class ScanQrFamilyActivity extends QRCodeCameraScanActivity implements a7.e, View.OnClickListener {
    public static final /* synthetic */ int C = 0;
    public final y2.f B = new y2.f(this, 9);

    @Override // a7.e
    public final void B() {
    }

    @Override // fe.e
    public final void C(fe.a result) {
        String str;
        Collection collection;
        kotlin.jvm.internal.e.f(result, "result");
        this.A.f13585j = false;
        Object obj = result.f13574a;
        kotlin.jvm.internal.e.e(obj, "getResult(...)");
        List list = (List) obj;
        if (list.size() > 0) {
            Log.e("qob", "onScanResultCallback " + ((kc.a) list.get(0)).f15602a.o());
            String o3 = ((kc.a) list.get(0)).f15602a.o();
            if (o3 == null || o3.length() == 0) {
                com.example.baselibrary.utils.d.a(R$string.str_qr_code_error);
            } else {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", "扫描到内容 ".concat(o3));
                Matcher matcher = Pattern.compile("(\\?|&){1}#{0,1}userId=[a-zA-Z0-9]*(&{1})").matcher(o3.concat(Const.STR_MART_ADD));
                if (matcher.find()) {
                    String group = matcher.group(0);
                    kotlin.jvm.internal.e.e(group, "group(...)");
                    List<String> split = new Regex("=").split(group, 0);
                    if (!split.isEmpty()) {
                        ListIterator<String> listIterator = split.listIterator(split.size());
                        while (listIterator.hasPrevious()) {
                            if (listIterator.previous().length() != 0) {
                                collection = kotlin.collections.h.t(split, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    collection = EmptyList.INSTANCE;
                    str = kotlin.text.m.r(((String[]) collection.toArray(new String[0]))[1], Const.STR_MART_ADD, "");
                } else {
                    str = null;
                }
                if (str == null) {
                    com.example.baselibrary.utils.d.a(R$string.str_qr_code_error);
                }
                if (str != null) {
                    if (Pattern.compile("\\d+").matcher(str).matches()) {
                        int parseInt = Integer.parseInt(str);
                        y2.f fVar = this.B;
                        ScanQrFamilyActivity scanQrFamilyActivity = (ScanQrFamilyActivity) fVar.f19953b;
                        if (parseInt <= 0) {
                            Toast.makeText(scanQrFamilyActivity, R$string.str_please_input_legal_friend_id, 0).show();
                        } else {
                            rg.l<HttpModel<String>> memberFriendApply = ((UserApi) c6.d.f3392c.f113a).memberFriendApply(Integer.valueOf(parseInt));
                            kotlin.jvm.internal.e.e(memberFriendApply, "memberFriendApply(...)");
                            com.example.baselibrary.utils.b.w(memberFriendApply).subscribe(new com.example.test.presenter.device.y(fVar, scanQrFamilyActivity, w0.d(), 6));
                        }
                    } else {
                        com.example.baselibrary.utils.d.a(R$string.str_family_friend_no_login);
                    }
                }
            }
            finish();
        }
    }

    @Override // com.king.mlkit.vision.barcode.BarcodeCameraScanActivity, com.king.camera.scan.BaseCameraScanActivity
    public final int H0() {
        return R$layout.activity_scan_qr_ml;
    }

    @Override // com.king.camera.scan.BaseCameraScanActivity
    public final void I0(fe.d dVar) {
        super.I0(dVar);
        je.d dVar2 = dVar.f13591p;
        if (dVar2 != null) {
            dVar2.f15423d = true;
        }
        if (dVar2 != null) {
            dVar2.e = true;
        }
        View view = this.f11392z;
        dVar.f13587l = view;
        je.b bVar = dVar.f13592q;
        if (bVar != null) {
            bVar.f15419d = view != null;
        }
    }

    @Override // com.king.mlkit.vision.barcode.BarcodeCameraScanActivity, com.king.camera.scan.BaseCameraScanActivity
    public final void J0() {
        super.J0();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_root);
        ce.a(getWindow());
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        b9.a aVar = new b9.a(6);
        WeakHashMap weakHashMap = z0.f15748a;
        l1.n0.u(relativeLayout, aVar);
        ((TextView) findViewById(R$id.scanCodeWhite)).setText(R$string.str_family_scan_qr_code);
        ((ImageView) findViewById(R$id.back)).setOnClickListener(this);
    }

    public final void L0(int i3, String str) {
        if (i3 == -1) {
            Toast.makeText(this, R$string.str_network_error, 0).show();
            return;
        }
        w0.d().getClass();
        int c9 = w0.c(i3);
        if (c9 != 0) {
            Toast.makeText(this, c9, 0).show();
        } else if (str.length() > 0) {
            com.example.baselibrary.utils.d.b(str);
        } else {
            Toast.makeText(this, R$string.str_network_error, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }
}
