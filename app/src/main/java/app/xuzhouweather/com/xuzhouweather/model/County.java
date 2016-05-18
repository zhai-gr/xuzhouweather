package app.xuzhouweather.com.xuzhouweather.model;

/**
 * Created by Mr.Zhai on 2016/5/18.
 * 县类
 */
public class County {
    //县编号
    private int id;
    //县名
    private String countyName;
    //县代号
    private String countyCode;
    //所属市编号
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
