package app.xuzhouweather.com.xuzhouweather.model;

/**
 * Created by Mr.Zhai on 2016/5/18.
 * 省类
 */
public class Province {
    //编号
    private int id;
    //省名
    private String provinceName;
    //省代号
    private String provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
