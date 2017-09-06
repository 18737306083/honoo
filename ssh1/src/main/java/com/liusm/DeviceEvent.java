package com.liusm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sun.jna.Structure;

/**
 * Created by liusmchs on 2017/1/24 0024.
 */

public  class DeviceEvent extends Structure{

        private String event;
        private String sn;
        private int cmd;
        private String data;

    public static class ByReference extends DeviceEvent implements Structure.ByReference { }
    public static class ByValue extends DeviceEvent implements Structure.ByValue { }

        @Override
        public String toString(){
            return "event: "+event+", sn: "+sn+", cmd: "+cmd+", data: "+data;
        }

		public String getEvent() {
			return event;
		}

		public String getSn() {
			return sn;
		}

		public int getCmd() {
			return cmd;
		}

		public String getData() {
			return data;
		}
        
}
