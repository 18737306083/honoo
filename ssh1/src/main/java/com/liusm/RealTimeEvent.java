package com.liusm;

import com.sun.jna.Callback;

public interface RealTimeEvent extends Callback {
        void callback(String sn, String info);
    }