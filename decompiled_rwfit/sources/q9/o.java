package q9;

import android.accounts.Account;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.ble.scan.ScanFilter;
import com.example.blesdk.ble.scan.ScanResult;
import com.example.blesdk.ble.scan.ScanSettings;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public final class o implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17832a;

    public /* synthetic */ o(int i3) {
        this.f17832a = i3;
    }

    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(getServiceRequest.f9100a);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.f9101b);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.f9102c);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, getServiceRequest.f9103d);
        com.google.android.gms.internal.mlkit_vision_common.u.c(parcel, 5, getServiceRequest.e);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 6, getServiceRequest.f9104f, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.a(parcel, 7, getServiceRequest.f9105g);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 8, getServiceRequest.f9106h, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 10, getServiceRequest.f9107i, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 11, getServiceRequest.f9108j, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f9109k ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f9110l);
        boolean z5 = getServiceRequest.f9111m;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 14, 4);
        parcel.writeInt(z5 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 15, getServiceRequest.b());
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f17832a) {
            case 0:
                int t8 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i3 = 0;
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    if (((char) readInt) != 1) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt);
                    } else {
                        i3 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t8);
                return new zzak(i3);
            case 1:
                return new BinderWrapper(parcel);
            case 2:
                int t10 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                Bundle bundle = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int i10 = 0;
                Feature[] featureArr = null;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    char c9 = (char) readInt2;
                    if (c9 == 1) {
                        bundle = com.google.android.gms.internal.mlkit_vision_common.t.b(parcel, readInt2);
                    } else if (c9 == 2) {
                        featureArr = (Feature[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt2, Feature.CREATOR);
                    } else if (c9 == 3) {
                        i10 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt2);
                    } else if (c9 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt2);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt2, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t10);
                zzk zzkVar = new zzk();
                zzkVar.f9139a = bundle;
                zzkVar.f9140b = featureArr;
                zzkVar.f9141c = i10;
                zzkVar.f9142d = connectionTelemetryConfiguration;
                return zzkVar;
            case 3:
                int t11 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArr = null;
                int[] iArr2 = null;
                boolean z5 = false;
                boolean z6 = false;
                int i11 = 0;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    switch ((char) readInt3) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt3, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            z5 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt3);
                            break;
                        case 3:
                            z6 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt3);
                            break;
                        case 4:
                            iArr = com.google.android.gms.internal.mlkit_vision_common.t.e(parcel, readInt3);
                            break;
                        case 5:
                            i11 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt3);
                            break;
                        case 6:
                            iArr2 = com.google.android.gms.internal.mlkit_vision_common.t.e(parcel, readInt3);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt3);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t11);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z5, z6, iArr, i11, iArr2);
            case 4:
                int t12 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                Scope[] scopeArr = GetServiceRequest.f9098n;
                Bundle bundle2 = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.f9099o;
                Feature[] featureArr3 = featureArr2;
                String str = null;
                IBinder iBinder = null;
                Account account = null;
                String str2 = null;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                boolean z8 = false;
                int i15 = 0;
                boolean z10 = false;
                while (parcel.dataPosition() < t12) {
                    int readInt4 = parcel.readInt();
                    switch ((char) readInt4) {
                        case 1:
                            i12 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt4);
                            break;
                        case 2:
                            i13 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt4);
                            break;
                        case 3:
                            i14 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt4);
                            break;
                        case 4:
                            str = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt4);
                            break;
                        case 5:
                            iBinder = com.google.android.gms.internal.mlkit_vision_common.t.n(parcel, readInt4);
                            break;
                        case 6:
                            scopeArr = (Scope[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt4, Scope.CREATOR);
                            break;
                        case 7:
                            bundle2 = com.google.android.gms.internal.mlkit_vision_common.t.b(parcel, readInt4);
                            break;
                        case '\b':
                            account = (Account) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt4, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt4);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt4, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) com.google.android.gms.internal.mlkit_vision_common.t.i(parcel, readInt4, Feature.CREATOR);
                            break;
                        case '\f':
                            z8 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt4);
                            break;
                        case '\r':
                            i15 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt4);
                            break;
                        case 14:
                            z10 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt4);
                            break;
                        case 15:
                            str2 = com.google.android.gms.internal.mlkit_vision_common.t.g(parcel, readInt4);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t12);
                return new GetServiceRequest(i12, i13, i14, str, iBinder, scopeArr, bundle2, account, featureArr2, featureArr3, z8, i15, z10, str2);
            case 5:
                return new IcyHeaders(parcel);
            case 6:
                return new IcyInfo(parcel);
            case 7:
                return new ApicFrame(parcel);
            case 8:
                return new BinaryFrame(parcel);
            case 9:
                return new ChapterFrame(parcel);
            case 10:
                return new ChapterTocFrame(parcel);
            case 11:
                return new CommentFrame(parcel);
            case 12:
                return new GeobFrame(parcel);
            case 13:
                return new InternalFrame(parcel);
            case 14:
                return new MlltFrame(parcel);
            case 15:
                return new PrivFrame(parcel);
            case 16:
                return new TextInformationFrame(parcel);
            case 17:
                return new UrlLinkFrame(parcel);
            case 18:
                k9.g gVar = new k9.g(1);
                if (parcel.readInt() == 1) {
                    gVar.f15549b = parcel.readString();
                }
                if (parcel.readInt() == 1) {
                    String readString = parcel.readString();
                    if (readString != null && !BluetoothAdapter.checkBluetoothAddress(readString)) {
                        throw new IllegalArgumentException("invalid device address ".concat(readString));
                    }
                    gVar.f15550c = readString;
                }
                if (parcel.readInt() == 1) {
                    ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                    gVar.f15551d = parcelUuid;
                    gVar.e = null;
                    if (parcel.readInt() == 1) {
                        ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                        if (parcelUuid2 != null && parcelUuid == null) {
                            throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
                        }
                        gVar.f15551d = parcelUuid;
                        gVar.e = parcelUuid2;
                    }
                }
                if (parcel.readInt() == 1) {
                    ParcelUuid parcelUuid3 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                    if (parcel.readInt() == 1) {
                        byte[] bArr = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr);
                        if (parcel.readInt() != 0) {
                            byte[] bArr2 = new byte[parcel.readInt()];
                            parcel.readByteArray(bArr2);
                            gVar.c(parcelUuid3, bArr, bArr2);
                        } else {
                            if (parcelUuid3 == null) {
                                throw new IllegalArgumentException("serviceDataUuid is null!");
                            }
                            gVar.f15552f = parcelUuid3;
                            gVar.f15553g = bArr;
                            gVar.f15554h = null;
                        }
                    }
                }
                int readInt5 = parcel.readInt();
                if (parcel.readInt() == 1) {
                    byte[] bArr3 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr3);
                    if (parcel.readInt() != 0) {
                        byte[] bArr4 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr4);
                        gVar.b(readInt5, bArr3, bArr4);
                    } else {
                        if (readInt5 < 0) {
                            throw new IllegalArgumentException("invalid manufacture id");
                        }
                        gVar.f15548a = readInt5;
                        gVar.f15555i = bArr3;
                        gVar.f15556j = null;
                    }
                }
                return new ScanFilter((String) gVar.f15549b, (String) gVar.f15550c, (ParcelUuid) gVar.f15551d, (ParcelUuid) gVar.e, (ParcelUuid) gVar.f15552f, (byte[]) gVar.f15553g, (byte[]) gVar.f15554h, gVar.f15548a, (byte[]) gVar.f15555i, (byte[]) gVar.f15556j);
            case 19:
                return new ScanResult(parcel);
            case 20:
                return new ScanSettings(parcel);
            case 21:
                return new MdtaMetadataEntry(parcel);
            case 22:
                return new MotionPhotoMetadata(parcel);
            case 23:
                return new SmtaMetadataEntry(parcel);
            case 24:
                int t13 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                boolean z11 = false;
                int i16 = 0;
                while (parcel.dataPosition() < t13) {
                    int readInt6 = parcel.readInt();
                    char c10 = (char) readInt6;
                    if (c10 == 1) {
                        z11 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt6);
                    } else if (c10 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt6);
                    } else {
                        i16 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt6);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t13);
                return new ModuleAvailabilityResponse(z11, i16);
            case 25:
                int t14 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < t14) {
                    int readInt7 = parcel.readInt();
                    if (((char) readInt7) != 1) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt7);
                    } else {
                        pendingIntent = (PendingIntent) com.google.android.gms.internal.mlkit_vision_common.t.f(parcel, readInt7, PendingIntent.CREATOR);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t14);
                return new ModuleInstallIntentResponse(pendingIntent);
            case 26:
                int t15 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i17 = 0;
                boolean z12 = false;
                while (parcel.dataPosition() < t15) {
                    int readInt8 = parcel.readInt();
                    char c11 = (char) readInt8;
                    if (c11 == 1) {
                        i17 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt8);
                    } else if (c11 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt8);
                    } else {
                        z12 = com.google.android.gms.internal.mlkit_vision_common.t.l(parcel, readInt8);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t15);
                return new ModuleInstallResponse(i17, z12);
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                int t16 = com.google.android.gms.internal.mlkit_vision_common.t.t(parcel);
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                Long l3 = null;
                Long l5 = null;
                while (parcel.dataPosition() < t16) {
                    int readInt9 = parcel.readInt();
                    char c12 = (char) readInt9;
                    if (c12 == 1) {
                        i18 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    } else if (c12 == 2) {
                        i19 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    } else if (c12 == 3) {
                        l3 = com.google.android.gms.internal.mlkit_vision_common.t.q(parcel, readInt9);
                    } else if (c12 == 4) {
                        l5 = com.google.android.gms.internal.mlkit_vision_common.t.q(parcel, readInt9);
                    } else if (c12 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.t.s(parcel, readInt9);
                    } else {
                        i20 = com.google.android.gms.internal.mlkit_vision_common.t.o(parcel, readInt9);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.t.k(parcel, t16);
                return new ModuleInstallStatusUpdate(i18, i19, l3, l5, i20);
            case Const.ANDROID_VERSION_28 /* 28 */:
                return new PrivateCommand(parcel);
            default:
                return new SpliceInsertCommand(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f17832a) {
            case 0:
                return new zzak[i3];
            case 1:
                return new BinderWrapper[i3];
            case 2:
                return new zzk[i3];
            case 3:
                return new ConnectionTelemetryConfiguration[i3];
            case 4:
                return new GetServiceRequest[i3];
            case 5:
                return new IcyHeaders[i3];
            case 6:
                return new IcyInfo[i3];
            case 7:
                return new ApicFrame[i3];
            case 8:
                return new BinaryFrame[i3];
            case 9:
                return new ChapterFrame[i3];
            case 10:
                return new ChapterTocFrame[i3];
            case 11:
                return new CommentFrame[i3];
            case 12:
                return new GeobFrame[i3];
            case 13:
                return new InternalFrame[i3];
            case 14:
                return new MlltFrame[i3];
            case 15:
                return new PrivFrame[i3];
            case 16:
                return new TextInformationFrame[i3];
            case 17:
                return new UrlLinkFrame[i3];
            case 18:
                return new ScanFilter[i3];
            case 19:
                return new ScanResult[i3];
            case 20:
                return new ScanSettings[i3];
            case 21:
                return new MdtaMetadataEntry[i3];
            case 22:
                return new MotionPhotoMetadata[i3];
            case 23:
                return new SmtaMetadataEntry[i3];
            case 24:
                return new ModuleAvailabilityResponse[i3];
            case 25:
                return new ModuleInstallIntentResponse[i3];
            case 26:
                return new ModuleInstallResponse[i3];
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                return new ModuleInstallStatusUpdate[i3];
            case Const.ANDROID_VERSION_28 /* 28 */:
                return new PrivateCommand[i3];
            default:
                return new SpliceInsertCommand[i3];
        }
    }
}
