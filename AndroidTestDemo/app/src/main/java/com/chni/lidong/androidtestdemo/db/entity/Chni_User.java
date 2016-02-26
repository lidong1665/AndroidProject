package com.chni.lidong.androidtestdemo.db.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/30.
 */
public class Chni_User implements Serializable{


    /**
     * retCode : 0000
     * username : lidong1665
     * mphoneNum : 23261570828
     * email : 1561281670@qq.com
     * sex : 1
     * birthday : 1991-10-06
     * nickname : 请叫我小东子
     * idnumber :
     * customerid : 0010000020290
     * asstate : 4
     * icdnumber :
     * psyhstate : 2
     * idenstate : 2
     * createuserid : 0010000002
     * docname : 左子龙
     * randomSecretKey : 181451441769327
     * result : {"code":200,"result":"{\"code\":200,\"userId\":\"0010000020290\",\"token\":\"EWTzgtClL7rQt9GTjbxozXh/wr9StErewuoMQLknxTmZuvMwClGY2CQ3eocGmc0VQr9+I4MCNJEjOW0n6h9N45QG648PXFMS\"}","httpCode":200}
     * ctypeId : 2
     * devices :
     * headImage : http://www.chmsp.com.cn/ChniWEB/UserHeadImage/001000002029000.jpg
     * ssoid : 0010000020290
     */

    private String retCode;
    private String username;
    private String mphoneNum;
    private String email;
    private String sex;
    private String birthday;
    private String nickname;
    private String idnumber;
    private String customerid;
    private String asstate;
    private String icdnumber;
    private String psyhstate;
    private String idenstate;
    private String createuserid;
    private String docname;
    private String randomSecretKey;
    /**
     * code : 200
     * result : {"code":200,"userId":"0010000020290","token":"EWTzgtClL7rQt9GTjbxozXh/wr9StErewuoMQLknxTmZuvMwClGY2CQ3eocGmc0VQr9+I4MCNJEjOW0n6h9N45QG648PXFMS"}
     * httpCode : 200
     */

    private ResultEntity result;
    private String ctypeId;
    private String devices;
    private String headImage;
    private String ssoid;

    public Chni_User(String retCode, String username, String mphoneNum, String email, String sex, String birthday, String nickname, String idnumber, String customerid, String asstate, String icdnumber, String psyhstate, String idenstate, String createuserid, String docname, String randomSecretKey, ResultEntity result, String ctypeId, String devices, String headImage, String ssoid) {
        this.retCode = retCode;
        this.username = username;
        this.mphoneNum = mphoneNum;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.nickname = nickname;
        this.idnumber = idnumber;
        this.customerid = customerid;
        this.asstate = asstate;
        this.icdnumber = icdnumber;
        this.psyhstate = psyhstate;
        this.idenstate = idenstate;
        this.createuserid = createuserid;
        this.docname = docname;
        this.randomSecretKey = randomSecretKey;
        this.result = result;
        this.ctypeId = ctypeId;
        this.devices = devices;
        this.headImage = headImage;
        this.ssoid = ssoid;
    }

    public Chni_User() {
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMphoneNum(String mphoneNum) {
        this.mphoneNum = mphoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public void setAsstate(String asstate) {
        this.asstate = asstate;
    }

    public void setIcdnumber(String icdnumber) {
        this.icdnumber = icdnumber;
    }

    public void setPsyhstate(String psyhstate) {
        this.psyhstate = psyhstate;
    }

    public void setIdenstate(String idenstate) {
        this.idenstate = idenstate;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public void setRandomSecretKey(String randomSecretKey) {
        this.randomSecretKey = randomSecretKey;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCtypeId(String ctypeId) {
        this.ctypeId = ctypeId;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getUsername() {
        return username;
    }

    public String getMphoneNum() {
        return mphoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getAsstate() {
        return asstate;
    }

    public String getIcdnumber() {
        return icdnumber;
    }

    public String getPsyhstate() {
        return psyhstate;
    }

    public String getIdenstate() {
        return idenstate;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public String getDocname() {
        return docname;
    }

    public String getRandomSecretKey() {
        return randomSecretKey;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getCtypeId() {
        return ctypeId;
    }

    public String getDevices() {
        return devices;
    }

    public String getHeadImage() {
        return headImage;
    }

    public String getSsoid() {
        return ssoid;
    }

    public static class ResultEntity {
        private int code;
        private String result;
        private int httpCode;

        public ResultEntity() {
        }

        public ResultEntity(int httpCode, int code, String result) {
            this.httpCode = httpCode;
            this.code = code;
            this.result = result;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public void setHttpCode(int httpCode) {
            this.httpCode = httpCode;
        }

        public int getCode() {
            return code;
        }

        public String getResult() {
            return result;
        }

        public int getHttpCode() {
            return httpCode;
        }
    }
}
