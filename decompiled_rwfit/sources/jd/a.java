package jd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15403a;

    /* renamed from: b, reason: collision with root package name */
    public int f15404b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f15405c;

    public /* synthetic */ a(int i3) {
        this.f15403a = i3;
        this.f15404b = -1;
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = this.f15404b;
        if (i3 != -1) {
            byteArrayOutputStream.write(i3);
        }
        byte[] bArr = this.f15405c;
        if (bArr != null && bArr.length > 0) {
            try {
                byteArrayOutputStream.write(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        switch (this.f15403a) {
            case 1:
                return android.support.v4.media.session.e.m(new StringBuilder("BaseParameter{xmOpCode="), this.f15404b, '}');
            case 2:
                return android.support.v4.media.session.e.m(new StringBuilder("CommonResponse{xmOpCode="), this.f15404b, '}');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i3, int i10, byte[] bArr) {
        this.f15403a = i10;
        this.f15404b = i3;
        this.f15405c = bArr;
    }
}
