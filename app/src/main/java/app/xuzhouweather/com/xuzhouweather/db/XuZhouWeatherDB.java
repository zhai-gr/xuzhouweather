package app.xuzhouweather.com.xuzhouweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.xuzhouweather.com.xuzhouweather.model.City;
import app.xuzhouweather.com.xuzhouweather.model.County;
import app.xuzhouweather.com.xuzhouweather.model.Province;

/**
 * Created by Mr.Zhai on 2016/5/18.
 */
public class XuZhouWeatherDB {
    //数据库名
    public static final String DB_NAME = "xuzhou_weather";
    //数据库版本
    public static final int VERSION = 1;

    private static XuZhouWeatherDB xuZhouWeatherDB;

    private SQLiteDatabase db;

    //私有化构造方法
    private XuZhouWeatherDB(Context context){
        XuZhouWeatherOpenHelper dbHelper = new XuZhouWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }
    //获取XuzhouWeatherDB的实例
    public synchronized  static XuZhouWeatherDB getInstance(Context context){
        if (xuZhouWeatherDB==null){
            xuZhouWeatherDB = new XuZhouWeatherDB(context);
        }
        return xuZhouWeatherDB;
    }
    //将Province实例存储到数据库
    public void saveProvince(Province province){
        if(province!=null){
            ContentValues values = new ContentValues();
            values.put("provinve_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());;
            db.insert("Province",null,values);
        }
    }
    //从数据库读取全国所有的省份信息
    public List<Province> loadProvince(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while(cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }
    //将City实例存储到数据库
    public void saveCity(City city){
        if(city!=null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_dode",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }
    //从数据库读取某省下的所有城市
    public List<City> loadCities(int provinceId){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City",null,"province_id = ?",new String[]{String.valueOf(provinceId)},null,null,null);
        if(cursor.moveToFirst()){
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                list.add(city);
            }while(cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }

    //将County实例存储到数据库
    public void saveCounty(County county){
        if(county!=null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            values.put("city_id",county.getCityId());
            db.insert("County",null,values);
        }
    }

    //从数据库读取某城市下所有县的信息
    public List<County> loadCounties(int cityId){
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id=?",new String[]{String.valueOf(cityId)},null,null,null);
        if(cursor.moveToFirst()){
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cityId);
                list.add(county);
            }while(cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }
}
