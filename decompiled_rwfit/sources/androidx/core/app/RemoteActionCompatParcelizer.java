package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import l2.b;
import l2.c;
import l2.d;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        d dVar = remoteActionCompat.f1908a;
        boolean z5 = true;
        if (bVar.e(1)) {
            dVar = bVar.h();
        }
        remoteActionCompat.f1908a = (IconCompat) dVar;
        CharSequence charSequence = remoteActionCompat.f1909b;
        if (bVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).e);
        }
        remoteActionCompat.f1909b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1910c;
        if (bVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).e);
        }
        remoteActionCompat.f1910c = charSequence2;
        remoteActionCompat.f1911d = (PendingIntent) bVar.g(remoteActionCompat.f1911d, 4);
        boolean z6 = remoteActionCompat.e;
        if (bVar.e(5)) {
            z6 = ((c) bVar).e.readInt() != 0;
        }
        remoteActionCompat.e = z6;
        boolean z8 = remoteActionCompat.f1912f;
        if (!bVar.e(6)) {
            z5 = z8;
        } else if (((c) bVar).e.readInt() == 0) {
            z5 = false;
        }
        remoteActionCompat.f1912f = z5;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1908a;
        bVar.i(1);
        bVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1909b;
        bVar.i(2);
        Parcel parcel = ((c) bVar).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f1910c;
        bVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        bVar.k(remoteActionCompat.f1911d, 4);
        boolean z5 = remoteActionCompat.e;
        bVar.i(5);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = remoteActionCompat.f1912f;
        bVar.i(6);
        parcel.writeInt(z6 ? 1 : 0);
    }
}
