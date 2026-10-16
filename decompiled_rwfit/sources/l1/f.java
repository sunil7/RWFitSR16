package l1;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.tencent.open.SocialConstants;

/* loaded from: classes.dex */
public final class f implements e, g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15689a = 0;

    /* renamed from: b, reason: collision with root package name */
    public ClipData f15690b;

    /* renamed from: c, reason: collision with root package name */
    public int f15691c;

    /* renamed from: d, reason: collision with root package name */
    public int f15692d;
    public Uri e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f15693f;

    public /* synthetic */ f() {
    }

    @Override // l1.g
    public ClipData a() {
        return this.f15690b;
    }

    @Override // l1.e
    public h b() {
        return new h(new f(this));
    }

    @Override // l1.g
    public int g() {
        return this.f15692d;
    }

    @Override // l1.e
    public void h(Uri uri) {
        this.e = uri;
    }

    @Override // l1.e
    public void j(int i3) {
        this.f15692d = i3;
    }

    @Override // l1.g
    public ContentInfo l() {
        return null;
    }

    @Override // l1.g
    public int m() {
        return this.f15691c;
    }

    @Override // l1.e
    public void setExtras(Bundle bundle) {
        this.f15693f = bundle;
    }

    public String toString() {
        String str;
        switch (this.f15689a) {
            case 1:
                StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
                sb2.append(this.f15690b.getDescription());
                sb2.append(", source=");
                int i3 = this.f15691c;
                sb2.append(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? String.valueOf(i3) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb2.append(", flags=");
                int i10 = this.f15692d;
                sb2.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
                Uri uri = this.e;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb2.append(str);
                return r5.a.f(sb2, this.f15693f != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public f(f fVar) {
        ClipData clipData = fVar.f15690b;
        clipData.getClass();
        this.f15690b = clipData;
        int i3 = fVar.f15691c;
        pd.c(i3, SocialConstants.PARAM_SOURCE, 0, 5);
        this.f15691c = i3;
        int i10 = fVar.f15692d;
        if ((i10 & 1) == i10) {
            this.f15692d = i10;
            this.e = fVar.e;
            this.f15693f = fVar.f15693f;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
