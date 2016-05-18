package app.xuzhouweather.com.xuzhouweather.model;

/**
 * Created by Mr.Zhai on 2016/5/18.
 * 市类
 */
public class City {
    //市编号
    private int id;
    //市名
    private String cityName;
    //市代号
    private String cityCode;
    //所属省编号
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
