package com.example.blesdk.bean;

/* loaded from: classes.dex */
public class BleSendBean {
    public volatile int gattWriteFinish = 0;
    public volatile int receivedFECmd = 0;
    public byte sendMsgId;
    public byte[] willSendData;
}
