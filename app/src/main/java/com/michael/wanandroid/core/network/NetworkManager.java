package com.michael.wanandroid.core.network;

public class NetworkManager {

    private NetworkManager() {
    }

    public static NetworkManager getInstance() {
        return Holder.instance;
    }

    public static final class Holder {
        public static final NetworkManager instance = new NetworkManager();
    }





}
