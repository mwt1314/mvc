package cn.dgkj.util;

import lombok.Data;

/**
 * @author mawt
 * @description 省市区
 * @date 2019/11/15
 */
public class ProvinceResp {

    private int code;

    private String msg;

    private Province[] data;

    public static class Province {

        private String label;

        private String value;

        private Province[] children;

        private String parent;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Province[] getChildren() {
            return children;
        }

        public void setChildren(Province[] children) {
            this.children = children;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Province[] getData() {
        return data;
    }

    public void setData(Province[] data) {
        this.data = data;
    }
}
