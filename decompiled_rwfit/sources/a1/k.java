package a1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.core.content.UnusedAppRestrictionsBackportService;
import androidx.room.MultiInstanceInvalidationService;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class k extends Binder implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7b;

    public k(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        this.f7b = unusedAppRestrictionsBackportService;
        attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i3 = this.f6a;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) {
        z0.a aVar;
        switch (this.f6a) {
            case 0:
                if (i3 >= 1 && i3 <= 16777215) {
                    parcel.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                }
                if (i3 == 1598968902) {
                    parcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                    return true;
                }
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i10);
                }
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    aVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof z0.a)) {
                        z0.a aVar2 = new z0.a();
                        aVar2.f20182a = readStrongBinder;
                        aVar = aVar2;
                    } else {
                        aVar = (z0.a) queryLocalInterface;
                    }
                }
                if (aVar == null) {
                    return true;
                }
                ((UnusedAppRestrictionsBackportService) this.f7b).a();
                return true;
            case 1:
                if (i3 == 1598968902) {
                    parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                    return true;
                }
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        throw new AssertionError();
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        throw new AssertionError();
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
                        throw new AssertionError();
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                        }
                        throw new AssertionError();
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                        }
                        throw new AssertionError();
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        throw new AssertionError();
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readInt();
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readInt();
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readInt();
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readInt();
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (((WeakReference) this.f7b).get() == null) {
                            return true;
                        }
                        throw new ClassCastException();
                    default:
                        return super.onTransact(i3, parcel, parcel2, i10);
                }
            default:
                b2.b bVar = null;
                if (i3 == 1) {
                    parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                        if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof b2.b)) {
                            bVar = new b2.b();
                            bVar.f3094a = readStrongBinder2;
                        } else {
                            bVar = (b2.b) queryLocalInterface2;
                        }
                    }
                    String readString = parcel.readString();
                    int i11 = 0;
                    if (readString != null) {
                        synchronized (((MultiInstanceInvalidationService) this.f7b).f2820c) {
                            try {
                                MultiInstanceInvalidationService multiInstanceInvalidationService = (MultiInstanceInvalidationService) this.f7b;
                                int i12 = multiInstanceInvalidationService.f2818a + 1;
                                multiInstanceInvalidationService.f2818a = i12;
                                if (multiInstanceInvalidationService.f2820c.register(bVar, Integer.valueOf(i12))) {
                                    ((MultiInstanceInvalidationService) this.f7b).f2819b.put(Integer.valueOf(i12), readString);
                                    i11 = i12;
                                } else {
                                    MultiInstanceInvalidationService multiInstanceInvalidationService2 = (MultiInstanceInvalidationService) this.f7b;
                                    multiInstanceInvalidationService2.f2818a--;
                                }
                            } finally {
                            }
                        }
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(i11);
                    return true;
                }
                if (i3 == 2) {
                    parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                        if (queryLocalInterface3 == null || !(queryLocalInterface3 instanceof b2.b)) {
                            bVar = new b2.b();
                            bVar.f3094a = readStrongBinder3;
                        } else {
                            bVar = (b2.b) queryLocalInterface3;
                        }
                    }
                    int readInt = parcel.readInt();
                    synchronized (((MultiInstanceInvalidationService) this.f7b).f2820c) {
                        ((MultiInstanceInvalidationService) this.f7b).f2820c.unregister(bVar);
                        ((MultiInstanceInvalidationService) this.f7b).f2819b.remove(Integer.valueOf(readInt));
                    }
                    parcel2.writeNoException();
                    return true;
                }
                if (i3 != 3) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i10);
                    }
                    parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                    return true;
                }
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int readInt2 = parcel.readInt();
                String[] createStringArray = parcel.createStringArray();
                synchronized (((MultiInstanceInvalidationService) this.f7b).f2820c) {
                    try {
                        String str = (String) ((MultiInstanceInvalidationService) this.f7b).f2819b.get(Integer.valueOf(readInt2));
                        if (str == null) {
                            Log.w("ROOM", "Remote invalidation client ID not registered");
                            return true;
                        }
                        int beginBroadcast = ((MultiInstanceInvalidationService) this.f7b).f2820c.beginBroadcast();
                        for (int i13 = 0; i13 < beginBroadcast; i13++) {
                            try {
                                Integer num = (Integer) ((MultiInstanceInvalidationService) this.f7b).f2820c.getBroadcastCookie(i13);
                                int intValue = num.intValue();
                                String str2 = (String) ((MultiInstanceInvalidationService) this.f7b).f2819b.get(num);
                                if (readInt2 != intValue && str.equals(str2)) {
                                    try {
                                        ((b2.b) ((MultiInstanceInvalidationService) this.f7b).f2820c.getBroadcastItem(i13)).g(createStringArray);
                                    } catch (RemoteException e) {
                                        Log.w("ROOM", "Error invoking a remote callback", e);
                                    }
                                }
                            } finally {
                                ((MultiInstanceInvalidationService) this.f7b).f2820c.finishBroadcast();
                            }
                        }
                        return true;
                    } finally {
                    }
                }
        }
    }

    public k(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f7b = multiInstanceInvalidationService;
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    public k() {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.f7b = new WeakReference(null);
    }
}
