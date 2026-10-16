package com.example.test.presenter.mine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.example.database.table.User;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.mine.activity.MyQrCodeActivity;
import com.example.test.ui.mine.model.PersonalQrCodeBean;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.z9;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import f6.x0;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class l extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.mine.MyQrCodePresenter$getQrCode$1
            {
                super(1);
            }

            @Override // oh.l
            public final Bitmap invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                Bitmap a3 = z9.a(FontStyle.WEIGHT_SEMI_BOLD, FontStyle.WEIGHT_SEMI_BOLD, l0.n("https://www.ruiwo168.com/app/download.html?userId=", d5 != null ? d5.getUserId() : null), ErrorCorrectionLevel.H.name());
                MyQrCodeActivity myQrCodeActivity = (MyQrCodeActivity) ((h7.g) l.this.f7255a);
                myQrCodeActivity.getClass();
                Bitmap decodeResource = BitmapFactory.decodeResource(myQrCodeActivity.getResources(), R$mipmap.ic_logo);
                if (a3 == null) {
                    return null;
                }
                if (decodeResource == null) {
                    return a3;
                }
                int height = a3.getHeight();
                int width = a3.getWidth();
                int height2 = decodeResource.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(a3, 0.0f, 0.0f, (Paint) null);
                canvas.scale((height * 0.3f) / decodeResource.getWidth(), (width * 0.3f) / height2, width / 2, height / 2);
                canvas.drawBitmap(decodeResource, r3 - (r5 / 2), r2 - (height2 / 2), (Paint) null);
                return createBitmap;
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.MyQrCodePresenter$getQrCode$2
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
                    MyQrCodeActivity myQrCodeActivity = (MyQrCodeActivity) ((h7.g) l.this.f7255a);
                    myQrCodeActivity.getClass();
                    ((x0) myQrCodeActivity.f7247z.getValue()).f13439f.setImageBitmap(bitmap);
                }
            }
        });
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.mine.MyQrCodePresenter$getUserShareData$1
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x014c  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x014f  */
            @Override // oh.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final com.example.test.ui.mine.model.PersonalQrCodeBean invoke(java.lang.String r8) {
                /*
                    Method dump skipped, instructions count: 341
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.mine.MyQrCodePresenter$getUserShareData$1.invoke(java.lang.String):com.example.test.ui.mine.model.PersonalQrCodeBean");
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.MyQrCodePresenter$getUserShareData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PersonalQrCodeBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(PersonalQrCodeBean it) {
                User d5;
                User d8;
                kotlin.jvm.internal.e.f(it, "it");
                MyQrCodeActivity myQrCodeActivity = (MyQrCodeActivity) ((h7.g) l.this.f7255a);
                myQrCodeActivity.getClass();
                ImageView imageView = ((x0) myQrCodeActivity.f7247z.getValue()).f13436b;
                int i3 = R$mipmap.ic_avatar;
                String userAvatar = it.getUserAvatar();
                if (userAvatar == null) {
                    userAvatar = "";
                }
                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(myQrCodeActivity).n(userAvatar).o(true)).d(z3.h.f20239b)).i(i3), i3)).x(imageView);
                TextView textView = ((x0) myQrCodeActivity.f7247z.getValue()).f13443j;
                String nickName = it.getNickName();
                textView.setText((nickName == null || nickName.length() == 0) ? myQrCodeActivity.getString(R$string.str_unset) : it.getNickName());
                String str = "";
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                String str2 = null;
                if (((kVar == null || (d8 = kVar.d()) == null) ? null : d8.getUserId()) != null) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null && (d5 = kVar2.d()) != null) {
                        str2 = d5.getUserId();
                    }
                    String valueOf = String.valueOf(str2);
                    str = !Pattern.compile("\\d+").matcher(valueOf).matches() ? "" : "ID:".concat(valueOf);
                }
                ((x0) myQrCodeActivity.f7247z.getValue()).f13442i.setText(str);
                android.support.v4.media.session.e.A(new Object[]{Integer.valueOf(it.getStep()), myQrCodeActivity.getString(R$string.str_unit_step)}, 2, "%d%s", ((x0) myQrCodeActivity.f7247z.getValue()).f13441h);
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (it.getCal() * 10)) / 10.0f)}, 1, "%.1fKCAL", ((x0) myQrCodeActivity.f7247z.getValue()).f13437c);
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (it.getDistance() * 100)) / 100.0f), it.getUnit()}, 2, "%.2f%s", ((x0) myQrCodeActivity.f7247z.getValue()).e);
            }
        });
    }
}
