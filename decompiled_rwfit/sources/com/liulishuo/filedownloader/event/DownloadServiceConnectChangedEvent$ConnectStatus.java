package com.liulishuo.filedownloader.event;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DownloadServiceConnectChangedEvent$ConnectStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadServiceConnectChangedEvent$ConnectStatus[] f11464a;
    public static final DownloadServiceConnectChangedEvent$ConnectStatus connected;
    public static final DownloadServiceConnectChangedEvent$ConnectStatus disconnected;
    public static final DownloadServiceConnectChangedEvent$ConnectStatus lost;

    static {
        DownloadServiceConnectChangedEvent$ConnectStatus downloadServiceConnectChangedEvent$ConnectStatus = new DownloadServiceConnectChangedEvent$ConnectStatus("connected", 0);
        connected = downloadServiceConnectChangedEvent$ConnectStatus;
        DownloadServiceConnectChangedEvent$ConnectStatus downloadServiceConnectChangedEvent$ConnectStatus2 = new DownloadServiceConnectChangedEvent$ConnectStatus("disconnected", 1);
        disconnected = downloadServiceConnectChangedEvent$ConnectStatus2;
        DownloadServiceConnectChangedEvent$ConnectStatus downloadServiceConnectChangedEvent$ConnectStatus3 = new DownloadServiceConnectChangedEvent$ConnectStatus("lost", 2);
        lost = downloadServiceConnectChangedEvent$ConnectStatus3;
        f11464a = new DownloadServiceConnectChangedEvent$ConnectStatus[]{downloadServiceConnectChangedEvent$ConnectStatus, downloadServiceConnectChangedEvent$ConnectStatus2, downloadServiceConnectChangedEvent$ConnectStatus3};
    }

    public static DownloadServiceConnectChangedEvent$ConnectStatus valueOf(String str) {
        return (DownloadServiceConnectChangedEvent$ConnectStatus) Enum.valueOf(DownloadServiceConnectChangedEvent$ConnectStatus.class, str);
    }

    public static DownloadServiceConnectChangedEvent$ConnectStatus[] values() {
        return (DownloadServiceConnectChangedEvent$ConnectStatus[]) f11464a.clone();
    }
}
