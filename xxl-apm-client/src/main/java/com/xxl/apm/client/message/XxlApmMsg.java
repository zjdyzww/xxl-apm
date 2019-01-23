package com.xxl.apm.client.message;

import com.xxl.apm.client.XxlApm;
import com.xxl.rpc.util.IpUtil;

import java.io.Serializable;

/**
 * xxl-apm msg
 *
 * @author xuxueli 2018-12-29 16:53:25
 */
public abstract class XxlApmMsg implements Serializable {
    private static final long serialVersionUID = 42L;

    private String parentMsgId;
    private String msgId;

    private String appname;
    private String ip;
    //private String instanceid;    // todo, support Single machine multiple applications
    private String hostname;
    private long addtime;


    public String getParentMsgId() {
        return parentMsgId;
    }

    public void setParentMsgId(String parentMsgId) {
        this.parentMsgId = parentMsgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public long getAddtime() {
        return addtime;
    }

    public void setAddtime(long addtime) {
        this.addtime = addtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }


    // tool
    public void complete(){
        this.parentMsgId = XxlApm.getParentMsgId();
        this.msgId = XxlApm.generateMsgId();

        this.appname = XxlApm.getAppname();
        this.ip = IpUtil.getIp();
        this.hostname = IpUtil.getLocalAddress().getHostName();
        this.addtime = System.currentTimeMillis();
    }

}
