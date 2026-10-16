package u8;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.internal.mlkit_vision_common.t;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.model.FileDownloadTaskAtom;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19011a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f19011a) {
            case 0:
                return new SpliceNullCommand();
            case 1:
                return new SpliceScheduleCommand(parcel);
            case 2:
                return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
            case 3:
                return new DownloadRequest(parcel);
            case 4:
                return new StreamKey(parcel);
            case 5:
                int t8 = t.t(parcel);
                int i3 = 0;
                String str = null;
                int i10 = 0;
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        i3 = t.o(parcel, readInt);
                    } else if (c9 == 2) {
                        str = t.g(parcel, readInt);
                    } else if (c9 != 3) {
                        t.s(parcel, readInt);
                    } else {
                        i10 = t.o(parcel, readInt);
                    }
                }
                t.k(parcel, t8);
                return new FavaDiagnosticsEntity(i3, str, i10);
            case 6:
                return new FileDownloadHeader(parcel);
            case 7:
                return new FileDownloadModel(parcel);
            case 8:
                return new FileDownloadTaskAtom(parcel);
            case 9:
                return new Requirements(parcel.readInt());
            case 10:
                int t10 = t.t(parcel);
                StringToIntConverter stringToIntConverter = null;
                int i11 = 0;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 1) {
                        i11 = t.o(parcel, readInt2);
                    } else if (c10 != 2) {
                        t.s(parcel, readInt2);
                    } else {
                        stringToIntConverter = (StringToIntConverter) t.f(parcel, readInt2, StringToIntConverter.CREATOR);
                    }
                }
                t.k(parcel, t10);
                return new zaa(i11, stringToIntConverter);
            case 11:
                int t11 = t.t(parcel);
                ArrayList arrayList = null;
                int i12 = 0;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    char c11 = (char) readInt3;
                    if (c11 == 1) {
                        i12 = t.o(parcel, readInt3);
                    } else if (c11 != 2) {
                        t.s(parcel, readInt3);
                    } else {
                        arrayList = t.j(parcel, readInt3, zac.CREATOR);
                    }
                }
                t.k(parcel, t11);
                return new StringToIntConverter(i12, arrayList);
            case 12:
                int t12 = t.t(parcel);
                int i13 = 0;
                String str2 = null;
                int i14 = 0;
                while (parcel.dataPosition() < t12) {
                    int readInt4 = parcel.readInt();
                    char c12 = (char) readInt4;
                    if (c12 == 1) {
                        i13 = t.o(parcel, readInt4);
                    } else if (c12 == 2) {
                        str2 = t.g(parcel, readInt4);
                    } else if (c12 != 3) {
                        t.s(parcel, readInt4);
                    } else {
                        i14 = t.o(parcel, readInt4);
                    }
                }
                t.k(parcel, t12);
                return new zac(i13, str2, i14);
            case 13:
                return new TrackGroup(parcel);
            case 14:
                return new TrackGroupArray(parcel);
            case 15:
                int t13 = t.t(parcel);
                String str3 = null;
                int i15 = 0;
                FastJsonResponse$Field fastJsonResponse$Field = null;
                while (parcel.dataPosition() < t13) {
                    int readInt5 = parcel.readInt();
                    char c13 = (char) readInt5;
                    if (c13 == 1) {
                        i15 = t.o(parcel, readInt5);
                    } else if (c13 == 2) {
                        str3 = t.g(parcel, readInt5);
                    } else if (c13 != 3) {
                        t.s(parcel, readInt5);
                    } else {
                        fastJsonResponse$Field = (FastJsonResponse$Field) t.f(parcel, readInt5, FastJsonResponse$Field.CREATOR);
                    }
                }
                t.k(parcel, t13);
                return new zam(i15, str3, fastJsonResponse$Field);
            case 16:
                int t14 = t.t(parcel);
                ArrayList arrayList2 = null;
                int i16 = 0;
                String str4 = null;
                while (parcel.dataPosition() < t14) {
                    int readInt6 = parcel.readInt();
                    char c14 = (char) readInt6;
                    if (c14 == 1) {
                        i16 = t.o(parcel, readInt6);
                    } else if (c14 == 2) {
                        arrayList2 = t.j(parcel, readInt6, zal.CREATOR);
                    } else if (c14 != 3) {
                        t.s(parcel, readInt6);
                    } else {
                        str4 = t.g(parcel, readInt6);
                    }
                }
                t.k(parcel, t14);
                return new zan(i16, str4, arrayList2);
            case 17:
                int t15 = t.t(parcel);
                String str5 = null;
                int i17 = 0;
                ArrayList arrayList3 = null;
                while (parcel.dataPosition() < t15) {
                    int readInt7 = parcel.readInt();
                    char c15 = (char) readInt7;
                    if (c15 == 1) {
                        i17 = t.o(parcel, readInt7);
                    } else if (c15 == 2) {
                        str5 = t.g(parcel, readInt7);
                    } else if (c15 != 3) {
                        t.s(parcel, readInt7);
                    } else {
                        arrayList3 = t.j(parcel, readInt7, zam.CREATOR);
                    }
                }
                t.k(parcel, t15);
                return new zal(i17, str5, arrayList3);
            default:
                int t16 = t.t(parcel);
                int i18 = 0;
                Parcel parcel2 = null;
                zan zanVar = null;
                while (parcel.dataPosition() < t16) {
                    int readInt8 = parcel.readInt();
                    char c16 = (char) readInt8;
                    if (c16 == 1) {
                        i18 = t.o(parcel, readInt8);
                    } else if (c16 == 2) {
                        int r = t.r(parcel, readInt8);
                        int dataPosition = parcel.dataPosition();
                        if (r == 0) {
                            parcel2 = null;
                        } else {
                            Parcel obtain = Parcel.obtain();
                            obtain.appendFrom(parcel, dataPosition, r);
                            parcel.setDataPosition(dataPosition + r);
                            parcel2 = obtain;
                        }
                    } else if (c16 != 3) {
                        t.s(parcel, readInt8);
                    } else {
                        zanVar = (zan) t.f(parcel, readInt8, zan.CREATOR);
                    }
                }
                t.k(parcel, t16);
                return new SafeParcelResponse(i18, parcel2, zanVar);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f19011a) {
            case 0:
                return new SpliceNullCommand[i3];
            case 1:
                return new SpliceScheduleCommand[i3];
            case 2:
                return new TimeSignalCommand[i3];
            case 3:
                return new DownloadRequest[i3];
            case 4:
                return new StreamKey[i3];
            case 5:
                return new FavaDiagnosticsEntity[i3];
            case 6:
                return new FileDownloadHeader[i3];
            case 7:
                return new FileDownloadModel[i3];
            case 8:
                return new FileDownloadTaskAtom[i3];
            case 9:
                return new Requirements[i3];
            case 10:
                return new zaa[i3];
            case 11:
                return new StringToIntConverter[i3];
            case 12:
                return new zac[i3];
            case 13:
                return new TrackGroup[i3];
            case 14:
                return new TrackGroupArray[i3];
            case 15:
                return new zam[i3];
            case 16:
                return new zan[i3];
            case 17:
                return new zal[i3];
            default:
                return new SafeParcelResponse[i3];
        }
    }
}
