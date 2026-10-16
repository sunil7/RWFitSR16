package ha;

import android.accounts.Account;
import android.app.PendingIntent;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.github.mikephil.charting.data.Entry;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.internal.mlkit_vision_common.t;
import com.google.android.gms.signin.internal.zak;
import com.google.android.material.badge.BadgeDrawable$SavedState;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mmkv.ParcelableMMKV;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14291a;

    public /* synthetic */ d(int i3) {
        this.f14291a = i3;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f14291a) {
            case 0:
                int t8 = t.t(parcel);
                ConnectionResult connectionResult = null;
                int i3 = 0;
                zav zavVar = null;
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        i3 = t.o(parcel, readInt);
                    } else if (c9 == 2) {
                        connectionResult = (ConnectionResult) t.f(parcel, readInt, ConnectionResult.CREATOR);
                    } else if (c9 != 3) {
                        t.s(parcel, readInt);
                    } else {
                        zavVar = (zav) t.f(parcel, readInt, zav.CREATOR);
                    }
                }
                t.k(parcel, t8);
                return new zak(i3, connectionResult, zavVar);
            case 1:
                return new ColorInfo(parcel);
            case 2:
                return new ParcelImpl(parcel);
            case 3:
                int t10 = t.t(parcel);
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                Uri uri = null;
                String str5 = null;
                String str6 = null;
                ArrayList arrayList = null;
                String str7 = null;
                String str8 = null;
                long j4 = 0;
                int i10 = 0;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 1:
                            i10 = t.o(parcel, readInt2);
                            break;
                        case 2:
                            str = t.g(parcel, readInt2);
                            break;
                        case 3:
                            str2 = t.g(parcel, readInt2);
                            break;
                        case 4:
                            str3 = t.g(parcel, readInt2);
                            break;
                        case 5:
                            str4 = t.g(parcel, readInt2);
                            break;
                        case 6:
                            uri = (Uri) t.f(parcel, readInt2, Uri.CREATOR);
                            break;
                        case 7:
                            str5 = t.g(parcel, readInt2);
                            break;
                        case '\b':
                            j4 = t.p(parcel, readInt2);
                            break;
                        case '\t':
                            str6 = t.g(parcel, readInt2);
                            break;
                        case '\n':
                            arrayList = t.j(parcel, readInt2, Scope.CREATOR);
                            break;
                        case 11:
                            str7 = t.g(parcel, readInt2);
                            break;
                        case '\f':
                            str8 = t.g(parcel, readInt2);
                            break;
                        default:
                            t.s(parcel, readInt2);
                            break;
                    }
                }
                t.k(parcel, t10);
                return new GoogleSignInAccount(i10, str, str2, str3, str4, uri, str5, j4, str6, arrayList, str7, str8);
            case 4:
                int t11 = t.t(parcel);
                ArrayList arrayList2 = null;
                int i11 = 0;
                ArrayList arrayList3 = null;
                Account account = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                int i12 = 0;
                boolean z5 = false;
                boolean z6 = false;
                boolean z8 = false;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    switch ((char) readInt3) {
                        case 1:
                            i12 = t.o(parcel, readInt3);
                            break;
                        case 2:
                            arrayList3 = t.j(parcel, readInt3, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) t.f(parcel, readInt3, Account.CREATOR);
                            break;
                        case 4:
                            z5 = t.l(parcel, readInt3);
                            break;
                        case 5:
                            z6 = t.l(parcel, readInt3);
                            break;
                        case 6:
                            z8 = t.l(parcel, readInt3);
                            break;
                        case 7:
                            str9 = t.g(parcel, readInt3);
                            break;
                        case '\b':
                            str10 = t.g(parcel, readInt3);
                            break;
                        case '\t':
                            arrayList2 = t.j(parcel, readInt3, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            str11 = t.g(parcel, readInt3);
                            break;
                        default:
                            t.s(parcel, readInt3);
                            break;
                    }
                }
                t.k(parcel, t11);
                HashMap hashMap = new HashMap();
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    while (i11 < size) {
                        Object obj = arrayList2.get(i11);
                        i11++;
                        GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) obj;
                        hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.b()), googleSignInOptionsExtensionParcelable);
                    }
                }
                return new GoogleSignInOptions(i12, arrayList3, account, z5, z6, z8, str9, str10, hashMap, str11);
            case 5:
                return new BadgeDrawable$SavedState(parcel);
            case 6:
                return new DrmInitData(parcel);
            case 7:
                int t12 = t.t(parcel);
                Bundle bundle = null;
                int i13 = 0;
                int i14 = 0;
                while (parcel.dataPosition() < t12) {
                    int readInt4 = parcel.readInt();
                    char c10 = (char) readInt4;
                    if (c10 == 1) {
                        i13 = t.o(parcel, readInt4);
                    } else if (c10 == 2) {
                        i14 = t.o(parcel, readInt4);
                    } else if (c10 != 3) {
                        t.s(parcel, readInt4);
                    } else {
                        bundle = t.b(parcel, readInt4);
                    }
                }
                t.k(parcel, t12);
                return new GoogleSignInOptionsExtensionParcelable(i13, i14, bundle);
            case 8:
                String readString = parcel.readString();
                Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) creator.createFromParcel(parcel);
                ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) creator.createFromParcel(parcel);
                String readString2 = parcel.readString();
                if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                    return null;
                }
                return new ParcelableMMKV(parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString, readString2);
            case 9:
                return new BleScanInfo(parcel);
            case 10:
                return new Metadata(parcel);
            case 11:
                int t13 = t.t(parcel);
                PendingIntent pendingIntent = null;
                int i15 = 0;
                int i16 = 0;
                String str12 = null;
                while (parcel.dataPosition() < t13) {
                    int readInt5 = parcel.readInt();
                    char c11 = (char) readInt5;
                    if (c11 == 1) {
                        i15 = t.o(parcel, readInt5);
                    } else if (c11 == 2) {
                        i16 = t.o(parcel, readInt5);
                    } else if (c11 == 3) {
                        pendingIntent = (PendingIntent) t.f(parcel, readInt5, PendingIntent.CREATOR);
                    } else if (c11 != 4) {
                        t.s(parcel, readInt5);
                    } else {
                        str12 = t.g(parcel, readInt5);
                    }
                }
                t.k(parcel, t13);
                return new ConnectionResult(i15, i16, pendingIntent, str12);
            case 12:
                int t14 = t.t(parcel);
                long j10 = -1;
                int i17 = 0;
                String str13 = null;
                while (parcel.dataPosition() < t14) {
                    int readInt6 = parcel.readInt();
                    char c12 = (char) readInt6;
                    if (c12 == 1) {
                        str13 = t.g(parcel, readInt6);
                    } else if (c12 == 2) {
                        i17 = t.o(parcel, readInt6);
                    } else if (c12 != 3) {
                        t.s(parcel, readInt6);
                    } else {
                        j10 = t.p(parcel, readInt6);
                    }
                }
                t.k(parcel, t14);
                return new Feature(i17, j10, str13);
            case 13:
                int t15 = t.t(parcel);
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                String str14 = null;
                IBinder iBinder = null;
                while (parcel.dataPosition() < t15) {
                    int readInt7 = parcel.readInt();
                    switch ((char) readInt7) {
                        case 1:
                            str14 = t.g(parcel, readInt7);
                            break;
                        case 2:
                            z10 = t.l(parcel, readInt7);
                            break;
                        case 3:
                            z11 = t.l(parcel, readInt7);
                            break;
                        case 4:
                            iBinder = t.n(parcel, readInt7);
                            break;
                        case 5:
                            z12 = t.l(parcel, readInt7);
                            break;
                        case 6:
                            z13 = t.l(parcel, readInt7);
                            break;
                        default:
                            t.s(parcel, readInt7);
                            break;
                    }
                }
                t.k(parcel, t15);
                return new zzo(str14, z10, z11, iBinder, z12, z13);
            case 14:
                int t16 = t.t(parcel);
                boolean z14 = false;
                int i18 = 0;
                String str15 = null;
                int i19 = 0;
                while (parcel.dataPosition() < t16) {
                    int readInt8 = parcel.readInt();
                    char c13 = (char) readInt8;
                    if (c13 == 1) {
                        z14 = t.l(parcel, readInt8);
                    } else if (c13 == 2) {
                        str15 = t.g(parcel, readInt8);
                    } else if (c13 == 3) {
                        i19 = t.o(parcel, readInt8);
                    } else if (c13 != 4) {
                        t.s(parcel, readInt8);
                    } else {
                        i18 = t.o(parcel, readInt8);
                    }
                }
                t.k(parcel, t16);
                return new zzq(str15, i19, i18, z14);
            case 15:
                int t17 = t.t(parcel);
                boolean z15 = false;
                String str16 = null;
                IBinder iBinder2 = null;
                boolean z16 = false;
                while (parcel.dataPosition() < t17) {
                    int readInt9 = parcel.readInt();
                    char c14 = (char) readInt9;
                    if (c14 == 1) {
                        str16 = t.g(parcel, readInt9);
                    } else if (c14 == 2) {
                        iBinder2 = t.n(parcel, readInt9);
                    } else if (c14 == 3) {
                        z15 = t.l(parcel, readInt9);
                    } else if (c14 != 4) {
                        t.s(parcel, readInt9);
                    } else {
                        z16 = t.l(parcel, readInt9);
                    }
                }
                t.k(parcel, t17);
                return new zzs(str16, iBinder2, z15, z16);
            case 16:
                return new Entry(parcel);
            case 17:
                String readString3 = parcel.readString();
                readString3.getClass();
                return new AppInfoTable(parcel.readInt(), readString3);
            case 18:
                return new EventMessage(parcel);
            case 19:
                int t18 = t.t(parcel);
                int i20 = 0;
                ParcelFileDescriptor parcelFileDescriptor3 = null;
                int i21 = 0;
                while (parcel.dataPosition() < t18) {
                    int readInt10 = parcel.readInt();
                    char c15 = (char) readInt10;
                    if (c15 == 1) {
                        i20 = t.o(parcel, readInt10);
                    } else if (c15 == 2) {
                        parcelFileDescriptor3 = (ParcelFileDescriptor) t.f(parcel, readInt10, ParcelFileDescriptor.CREATOR);
                    } else if (c15 != 3) {
                        t.s(parcel, readInt10);
                    } else {
                        i21 = t.o(parcel, readInt10);
                    }
                }
                t.k(parcel, t18);
                return new BitmapTeleporter(i20, parcelFileDescriptor3, i21);
            case 20:
                int t19 = t.t(parcel);
                String[] strArr = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundle2 = null;
                int i22 = 0;
                int i23 = 0;
                while (parcel.dataPosition() < t19) {
                    int readInt11 = parcel.readInt();
                    char c16 = (char) readInt11;
                    if (c16 == 1) {
                        strArr = t.h(parcel, readInt11);
                    } else if (c16 == 2) {
                        cursorWindowArr = (CursorWindow[]) t.i(parcel, readInt11, CursorWindow.CREATOR);
                    } else if (c16 == 3) {
                        i23 = t.o(parcel, readInt11);
                    } else if (c16 == 4) {
                        bundle2 = t.b(parcel, readInt11);
                    } else if (c16 != 1000) {
                        t.s(parcel, readInt11);
                    } else {
                        i22 = t.o(parcel, readInt11);
                    }
                }
                t.k(parcel, t19);
                DataHolder dataHolder = new DataHolder(i22, strArr, cursorWindowArr, i23, bundle2);
                dataHolder.b();
                return dataHolder;
            case 21:
                return new PictureFrame(parcel);
            case 22:
                return new VorbisComment(parcel);
            case 23:
                int t20 = t.t(parcel);
                String str17 = null;
                int i24 = 0;
                while (parcel.dataPosition() < t20) {
                    int readInt12 = parcel.readInt();
                    char c17 = (char) readInt12;
                    if (c17 == 1) {
                        i24 = t.o(parcel, readInt12);
                    } else if (c17 != 2) {
                        t.s(parcel, readInt12);
                    } else {
                        str17 = t.g(parcel, readInt12);
                    }
                }
                t.k(parcel, t20);
                return new ClientIdentity(i24, str17);
            case 24:
                int t21 = t.t(parcel);
                ArrayList arrayList4 = null;
                int i25 = 0;
                while (parcel.dataPosition() < t21) {
                    int readInt13 = parcel.readInt();
                    char c18 = (char) readInt13;
                    if (c18 == 1) {
                        i25 = t.o(parcel, readInt13);
                    } else if (c18 != 2) {
                        t.s(parcel, readInt13);
                    } else {
                        arrayList4 = t.j(parcel, readInt13, MethodInvocation.CREATOR);
                    }
                }
                t.k(parcel, t21);
                return new TelemetryData(i25, arrayList4);
            case 25:
                int t22 = t.t(parcel);
                int i26 = -1;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                String str18 = null;
                String str19 = null;
                long j11 = 0;
                long j12 = 0;
                while (parcel.dataPosition() < t22) {
                    int readInt14 = parcel.readInt();
                    switch ((char) readInt14) {
                        case 1:
                            i27 = t.o(parcel, readInt14);
                            break;
                        case 2:
                            i28 = t.o(parcel, readInt14);
                            break;
                        case 3:
                            i29 = t.o(parcel, readInt14);
                            break;
                        case 4:
                            j11 = t.p(parcel, readInt14);
                            break;
                        case 5:
                            j12 = t.p(parcel, readInt14);
                            break;
                        case 6:
                            str18 = t.g(parcel, readInt14);
                            break;
                        case 7:
                            str19 = t.g(parcel, readInt14);
                            break;
                        case '\b':
                            i30 = t.o(parcel, readInt14);
                            break;
                        case '\t':
                            i26 = t.o(parcel, readInt14);
                            break;
                        default:
                            t.s(parcel, readInt14);
                            break;
                    }
                }
                t.k(parcel, t22);
                return new MethodInvocation(i27, i28, i29, j11, j12, str18, str19, i30, i26);
            case 26:
                int t23 = t.t(parcel);
                Account account2 = null;
                int i31 = 0;
                int i32 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < t23) {
                    int readInt15 = parcel.readInt();
                    char c19 = (char) readInt15;
                    if (c19 == 1) {
                        i31 = t.o(parcel, readInt15);
                    } else if (c19 == 2) {
                        account2 = (Account) t.f(parcel, readInt15, Account.CREATOR);
                    } else if (c19 == 3) {
                        i32 = t.o(parcel, readInt15);
                    } else if (c19 != 4) {
                        t.s(parcel, readInt15);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) t.f(parcel, readInt15, GoogleSignInAccount.CREATOR);
                    }
                }
                t.k(parcel, t23);
                return new zat(i31, account2, i32, googleSignInAccount);
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                int t24 = t.t(parcel);
                int i33 = 0;
                boolean z17 = false;
                boolean z18 = false;
                IBinder iBinder3 = null;
                ConnectionResult connectionResult2 = null;
                while (parcel.dataPosition() < t24) {
                    int readInt16 = parcel.readInt();
                    char c20 = (char) readInt16;
                    if (c20 == 1) {
                        i33 = t.o(parcel, readInt16);
                    } else if (c20 == 2) {
                        iBinder3 = t.n(parcel, readInt16);
                    } else if (c20 == 3) {
                        connectionResult2 = (ConnectionResult) t.f(parcel, readInt16, ConnectionResult.CREATOR);
                    } else if (c20 == 4) {
                        z17 = t.l(parcel, readInt16);
                    } else if (c20 != 5) {
                        t.s(parcel, readInt16);
                    } else {
                        z18 = t.l(parcel, readInt16);
                    }
                }
                t.k(parcel, t24);
                return new zav(i33, iBinder3, connectionResult2, z17, z18);
            case Const.ANDROID_VERSION_28 /* 28 */:
                int t25 = t.t(parcel);
                Scope[] scopeArr = null;
                int i34 = 0;
                int i35 = 0;
                int i36 = 0;
                while (parcel.dataPosition() < t25) {
                    int readInt17 = parcel.readInt();
                    char c21 = (char) readInt17;
                    if (c21 == 1) {
                        i34 = t.o(parcel, readInt17);
                    } else if (c21 == 2) {
                        i35 = t.o(parcel, readInt17);
                    } else if (c21 == 3) {
                        i36 = t.o(parcel, readInt17);
                    } else if (c21 != 4) {
                        t.s(parcel, readInt17);
                    } else {
                        scopeArr = (Scope[]) t.i(parcel, readInt17, Scope.CREATOR);
                    }
                }
                t.k(parcel, t25);
                return new zax(i34, i35, i36, scopeArr);
            default:
                int t26 = t.t(parcel);
                int i37 = 0;
                boolean z19 = false;
                boolean z20 = false;
                int i38 = 0;
                int i39 = 0;
                while (parcel.dataPosition() < t26) {
                    int readInt18 = parcel.readInt();
                    char c22 = (char) readInt18;
                    if (c22 == 1) {
                        i37 = t.o(parcel, readInt18);
                    } else if (c22 == 2) {
                        z19 = t.l(parcel, readInt18);
                    } else if (c22 == 3) {
                        z20 = t.l(parcel, readInt18);
                    } else if (c22 == 4) {
                        i38 = t.o(parcel, readInt18);
                    } else if (c22 != 5) {
                        t.s(parcel, readInt18);
                    } else {
                        i39 = t.o(parcel, readInt18);
                    }
                }
                t.k(parcel, t26);
                return new RootTelemetryConfiguration(i37, z19, z20, i38, i39);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f14291a) {
            case 0:
                return new zak[i3];
            case 1:
                return new ColorInfo[i3];
            case 2:
                return new ParcelImpl[i3];
            case 3:
                return new GoogleSignInAccount[i3];
            case 4:
                return new GoogleSignInOptions[i3];
            case 5:
                return new BadgeDrawable$SavedState[i3];
            case 6:
                return new DrmInitData[i3];
            case 7:
                return new GoogleSignInOptionsExtensionParcelable[i3];
            case 8:
                return new ParcelableMMKV[i3];
            case 9:
                return new BleScanInfo[i3];
            case 10:
                return new Metadata[i3];
            case 11:
                return new ConnectionResult[i3];
            case 12:
                return new Feature[i3];
            case 13:
                return new zzo[i3];
            case 14:
                return new zzq[i3];
            case 15:
                return new zzs[i3];
            case 16:
                return new Entry[i3];
            case 17:
                return new AppInfoTable[i3];
            case 18:
                return new EventMessage[i3];
            case 19:
                return new BitmapTeleporter[i3];
            case 20:
                return new DataHolder[i3];
            case 21:
                return new PictureFrame[i3];
            case 22:
                return new VorbisComment[i3];
            case 23:
                return new ClientIdentity[i3];
            case 24:
                return new TelemetryData[i3];
            case 25:
                return new MethodInvocation[i3];
            case 26:
                return new zat[i3];
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                return new zav[i3];
            case Const.ANDROID_VERSION_28 /* 28 */:
                return new zax[i3];
            default:
                return new RootTelemetryConfiguration[i3];
        }
    }
}
