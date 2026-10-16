package com.example.test.presenter.device;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.example.blesdk.bean.function.QrCodeBean;
import com.example.database.db.QrCodeImpl;
import com.example.database.table.DataQrCode;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.QrCodeDetailActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.z9;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class b1 extends d {

    /* renamed from: b, reason: collision with root package name */
    public final String f7412b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7413c;

    public b1(QrCodeDetailActivity qrCodeDetailActivity) {
        super(qrCodeDetailActivity);
        this.f7412b = "QrCodeDetailPresenter";
        this.f7413c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$qrCodeCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final a1 invoke() {
                return new a1(b1.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        a1 a1Var = (a1) this.f7413c.getValue();
        if (a1Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(a1Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == a1Var) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l(int i3) {
        com.example.baselibrary.preseneter.b.j(Integer.valueOf(i3), new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$clearQrCode$1
            public final Integer invoke(int i10) {
                User d5;
                Devices c9;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null && (d5 = kVar.d()) != null) {
                    QrCodeImpl qrCodeImpl = QrCodeImpl.INSTANCE;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    String macAddress = (kVar2 == null || (c9 = kVar2.c()) == null) ? null : c9.getMacAddress();
                    if (macAddress == null) {
                        macAddress = "";
                    }
                    DataQrCode qrCode = qrCodeImpl.getQrCode(userId, macAddress, i10);
                    if (qrCode != null) {
                        qrCodeImpl.delQrCode(qrCode);
                    }
                }
                return 1;
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$clearQrCode$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return eh.g.f12633a;
            }

            public final void invoke(int i10) {
                ((QrCodeDetailActivity) ((f7.v) b1.this.f7255a)).S0();
            }
        });
    }

    public final void m(final String str) {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$getQrCode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final Bitmap invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                return z9.a(500, 500, str, ErrorCorrectionLevel.H.name());
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$getQrCode$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Bitmap) obj);
                return eh.g.f12633a;
            }

            public final void invoke(Bitmap bitmap) {
                if (bitmap != null) {
                    QrCodeDetailActivity qrCodeDetailActivity = (QrCodeDetailActivity) ((f7.v) b1.this.f7255a);
                    qrCodeDetailActivity.getClass();
                    ((f6.f1) qrCodeDetailActivity.f7247z.getValue()).e.setImageBitmap(bitmap);
                }
            }
        });
    }

    public final void n(int i3) {
        com.example.baselibrary.preseneter.b.j(Integer.valueOf(i3), new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$initQrCode$1
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final QrCodeBean invoke(int i10) {
                User d5;
                Devices c9;
                QrCodeBean qrCodeBean = new QrCodeBean();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null && (d5 = kVar.d()) != null) {
                    QrCodeImpl qrCodeImpl = QrCodeImpl.INSTANCE;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    String macAddress = (kVar2 == null || (c9 = kVar2.c()) == null) ? null : c9.getMacAddress();
                    if (macAddress == null) {
                        macAddress = "";
                    }
                    DataQrCode qrCode = qrCodeImpl.getQrCode(userId, macAddress, i10);
                    if (qrCode != null) {
                        Integer qrCodeType = qrCode.getQrCodeType();
                        kotlin.jvm.internal.e.e(qrCodeType, "getQrCodeType(...)");
                        qrCodeBean.setAppType(qrCodeType.intValue());
                        qrCodeBean.setName(qrCode.getQrCodeTitle());
                        qrCodeBean.setContent(qrCode.getQrCodeContent());
                    }
                }
                return qrCodeBean;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$initQrCode$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((QrCodeBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(QrCodeBean it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (it.getAppType() == -1) {
                    ((QrCodeDetailActivity) ((f7.v) b1.this.f7255a)).S0();
                    return;
                }
                QrCodeDetailActivity qrCodeDetailActivity = (QrCodeDetailActivity) ((f7.v) b1.this.f7255a);
                qrCodeDetailActivity.getClass();
                qrCodeDetailActivity.R0().setAppType(it.getAppType());
                qrCodeDetailActivity.R0().setContent(it.getContent());
                qrCodeDetailActivity.R0().setName(it.getName());
                b1 b1Var = (b1) qrCodeDetailActivity.I0();
                String content = it.getContent();
                kotlin.jvm.internal.e.e(content, "getContent(...)");
                b1Var.m(content);
                ((f6.f1) qrCodeDetailActivity.f7247z.getValue()).f12851d.setText(it.getName());
            }
        });
    }

    public final void o(final String str) {
        ((XXBaseActivity) ((f7.v) this.f7255a)).V();
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$parseQrCode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final String invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                String path = str;
                kotlin.jvm.internal.e.f(path, "path");
                EnumMap enumMap = u3.a.f18875a;
                String a3 = u3.a.a(com.google.android.gms.internal.mlkit_vision_common.c0.e(path));
                if (a3 == null) {
                    a3 = "";
                }
                if (a3.length() != 0) {
                    return a3;
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                QrCodeDetailActivity qrCodeDetailActivity = (QrCodeDetailActivity) ((f7.v) this.f7255a);
                qrCodeDetailActivity.getClass();
                int j4 = com.example.baselibrary.utils.b.j(qrCodeDetailActivity);
                QrCodeDetailActivity qrCodeDetailActivity2 = (QrCodeDetailActivity) ((f7.v) this.f7255a);
                qrCodeDetailActivity2.getClass();
                WindowManager windowManager = (WindowManager) qrCodeDetailActivity2.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i3 = displayMetrics.heightPixels;
                if (width >= j4 || height >= i3) {
                    if (width > j4) {
                        height = (height * j4) / width;
                        width = j4;
                    }
                    if (height > i3) {
                        width = (width * i3) / height;
                    } else {
                        i3 = height;
                    }
                } else {
                    float f2 = (j4 * 1.0f) / width;
                    float f10 = (i3 * 1.0f) / height;
                    if (f2 > f10) {
                        f2 = f10;
                    }
                    int i10 = (int) f2;
                    width *= i10;
                    i3 = height * i10;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, width, i3, false);
                int width2 = createScaledBitmap.getWidth();
                int height2 = createScaledBitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(width / width2, i3 / height2);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, 0, 0, width2, height2, matrix, true);
                String a10 = u3.a.a(createBitmap);
                if (a10 == null) {
                    a10 = "";
                }
                if (a10.length() != 0) {
                    return a10;
                }
                QrCodeDetailActivity qrCodeDetailActivity3 = (QrCodeDetailActivity) ((f7.v) this.f7255a);
                qrCodeDetailActivity3.getClass();
                File file = new File(android.support.v4.media.session.e.j(qrCodeDetailActivity3.getFilesDir(), "/cache"));
                if (!file.exists()) {
                    file.mkdir();
                }
                String path2 = file.getAbsolutePath() + "/img_" + System.currentTimeMillis() + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(path2);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (byteArrayOutputStream.toByteArray().length > 1048576) {
                    byteArrayOutputStream.reset();
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                kotlin.jvm.internal.e.f(path2, "path");
                EnumMap enumMap2 = u3.a.f18875a;
                String a11 = u3.a.a(com.google.android.gms.internal.mlkit_vision_common.c0.e(path2));
                return a11 == null ? "" : a11;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$parseQrCode$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                ((XXBaseActivity) ((f7.v) b1.this.f7255a)).b0();
                if (it.length() == 0) {
                    ((QrCodeDetailActivity) ((f7.v) b1.this.f7255a)).w0(R$string.str_qr_code_error);
                    return;
                }
                if (y5.b.n(it).length > 256) {
                    ((QrCodeDetailActivity) ((f7.v) b1.this.f7255a)).w0(R$string.str_qrcode_length_out_limit);
                    return;
                }
                QrCodeDetailActivity qrCodeDetailActivity = (QrCodeDetailActivity) ((f7.v) b1.this.f7255a);
                qrCodeDetailActivity.getClass();
                qrCodeDetailActivity.R0().setContent(it);
                ((b1) qrCodeDetailActivity.I0()).m(it);
                ((b1) qrCodeDetailActivity.I0()).p(qrCodeDetailActivity.R0());
            }
        });
    }

    public final void p(QrCodeBean qrCodeBean) {
        kotlin.jvm.internal.e.f(qrCodeBean, "qrCodeBean");
        com.example.baselibrary.preseneter.b.j(qrCodeBean, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$saveQrCodeDB$1
            @Override // oh.l
            public final Long invoke(QrCodeBean it) {
                User d5;
                Devices c9;
                kotlin.jvm.internal.e.f(it, "it");
                DataQrCode dataQrCode = new DataQrCode();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                String str = null;
                dataQrCode.setMac((kVar == null || (c9 = kVar.c()) == null) ? null : c9.getMacAddress());
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null && (d5 = kVar2.d()) != null) {
                    str = d5.getUserId();
                }
                dataQrCode.setUserId(str);
                dataQrCode.setQrCodeContent(it.getContent());
                dataQrCode.setQrCodeTitle(it.getName());
                dataQrCode.setQrCodeType(Integer.valueOf(it.getAppType()));
                return Long.valueOf(QrCodeImpl.INSTANCE.saveQrCode(dataQrCode));
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.QrCodeDetailPresenter$saveQrCodeDB$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, b1.this.f7412b, com.google.android.gms.internal.mlkit_vision_barcode.l0.l(j4, "保存二维码信息 "));
            }
        });
    }
}
