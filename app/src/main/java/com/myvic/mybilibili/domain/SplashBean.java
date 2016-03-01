package com.myvic.mybilibili.domain;

import java.util.List;

/**
 * Created by MyVic on 2016/2/28.
 */
public class SplashBean {

    /**
     * code : 0
     * version : 1456638541
     * data : [{"id":3900064,"animate":1,"duration":2,"start_time":1456574400,"end_time":1456642740,"image":"http://i0.hdslb.com/group1/M00/3D/BA/oYYBAFbQLTSAQtR2AAn9y3qYYlM832.jpg","key":"6bd93d475ef9e25441f55b60adbe7674","times":10,"type":0},{"id":3900101,"animate":1,"duration":2,"start_time":1456642800,"end_time":1456675140,"image":"http://i0.hdslb.com/group1/M00/4F/F4/oYYBAFbSiPaAWqkgABO461HzjF8314.jpg","key":"42df3010cdc54a0fe662ad7d5e609329","times":10,"type":1}]
     */

    private int code;
    private int version;
    /**
     * id : 3900064
     * animate : 1
     * duration : 2
     * start_time : 1456574400
     * end_time : 1456642740
     * image : http://i0.hdslb.com/group1/M00/3D/BA/oYYBAFbQLTSAQtR2AAn9y3qYYlM832.jpg
     * key : 6bd93d475ef9e25441f55b60adbe7674
     * times : 10
     * type : 0
     */

    private List<DataEntity> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public int getVersion() {
        return version;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private int id;
        private int animate;
        private int duration;
        private int start_time;
        private int end_time;
        private String image;
        private String key;
        private int times;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setAnimate(int animate) {
            this.animate = animate;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public int getAnimate() {
            return animate;
        }

        public int getDuration() {
            return duration;
        }

        public int getStart_time() {
            return start_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public String getImage() {
            return image;
        }

        public String getKey() {
            return key;
        }

        public int getTimes() {
            return times;
        }

        public int getType() {
            return type;
        }
    }
}
