package com.chni.lidong.androidtestdemo.webService.model;

import java.util.List;

/**
 * Created by lidong on 2016/1/11.
 */
public class CarType {


    /**
     * recordcount : 22
     * table : [{"no":"1","id":"9","name":"奔驰","imgname":"ppxl"},{"no":"2","id":"11","name":"宝马","imgname":"baoma"},{"no":"3","id":"12","name":"保时捷","imgname":"baoshijie"},{"no":"4","id":"13","name":"奥迪","imgname":"aodi"},{"no":"5","id":"14","name":"路虎","imgname":"luhu"},{"no":"6","id":"15","name":"尼桑","imgname":"nisang"},{"no":"7","id":"16","name":"福特","imgname":"fute"},{"no":"8","id":"17","name":"丰田","imgname":"fengtian"},{"no":"9","id":"39","name":"玛莎拉蒂","imgname":"msld"},{"no":"10","id":"40","name":"克尔维特","imgname":"kewt"},{"no":"11","id":"51","name":"JEEP","imgname":"jeep"},{"no":"12","id":"53","name":"林肯","imgname":"linken"},{"no":"13","id":"73","name":"雷克萨斯","imgname":"lkss"},{"no":"14","id":"76","name":"道奇","imgname":"daoqi"},{"no":"15","id":"82","name":"凯迪拉克","imgname":"kaidilake"},{"no":"16","id":"93","name":"沃尔沃","imgname":"16kuanwoerwo"},{"no":"17","id":"95","name":"GMC","imgname":"GMC"},{"no":"18","id":"97","name":"宾利","imgname":"binli"},{"no":"19","id":"101","name":"法拉利","imgname":"falali"},{"no":"20","id":"113","name":"斯达泰克","imgname":"sidataike"},{"no":"21","id":"114","name":"大众","imgname":"dayin"},{"no":"22","id":"120","name":"乔治巴顿","imgname":"qiaozhibadu"}]
     */

    private String recordcount;
    /**
     * no : 1
     * id : 9
     * name : 奔驰
     * imgname : ppxl
     */

    private List<TableEntity> table;

    public void setRecordcount(String recordcount) {
        this.recordcount = recordcount;
    }

    public void setTable(List<TableEntity> table) {
        this.table = table;
    }

    public String getRecordcount() {
        return recordcount;
    }

    public List<TableEntity> getTable() {
        return table;
    }

    public static class TableEntity {
        private String no;
        private String id;
        private String name;
        private String imgname;

        public void setNo(String no) {
            this.no = no;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImgname(String imgname) {
            this.imgname = imgname;
        }

        public String getNo() {
            return no;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImgname() {
            return imgname;
        }
    }
}
