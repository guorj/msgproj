package com.vstu.msgproj.datasource.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerate {
    private static final Random random = new Random();

    // 省份与城市及城市级别映射
    private static final List<ProvinceCityLevel> provincesAndCities = List.of(
            new ProvinceCityLevel("北京", "北京市", "一线城市"),
            new ProvinceCityLevel("上海", "上海市", "一线城市"),
            new ProvinceCityLevel("广东", "广州市", "一线城市"),
            new ProvinceCityLevel("广东", "深圳市", "一线城市"),
            new ProvinceCityLevel("广东", "佛山市", "二线城市"),
            new ProvinceCityLevel("江苏", "南京市", "二线城市"),
            new ProvinceCityLevel("江苏", "苏州市", "二线城市"),
            new ProvinceCityLevel("江苏", "无锡市", "二线城市"),
            new ProvinceCityLevel("浙江", "杭州市", "二线城市"),
            new ProvinceCityLevel("浙江", "宁波市", "二线城市"),
            new ProvinceCityLevel("浙江", "温州市", "二线城市"),
            new ProvinceCityLevel("山东", "济南市", "二线城市"),
            new ProvinceCityLevel("山东", "青岛市", "二线城市"),
            new ProvinceCityLevel("山东", "潍坊市", "三线城市"),
            new ProvinceCityLevel("河北", "石家庄市", "二线城市"),
            new ProvinceCityLevel("河北", "唐山市", "三线城市"),
            new ProvinceCityLevel("河北", "保定市", "三线城市"),
            new ProvinceCityLevel("河南", "郑州市", "二线城市"),
            new ProvinceCityLevel("河南", "洛阳市", "三线城市"),
            new ProvinceCityLevel("河南", "南阳市", "三线城市"),
            new ProvinceCityLevel("湖北", "武汉市", "二线城市"),
            new ProvinceCityLevel("湖北", "襄阳市", "三线城市"),
            new ProvinceCityLevel("湖北", "宜昌市", "三线城市"),
            new ProvinceCityLevel("湖南", "长沙市", "二线城市"),
            new ProvinceCityLevel("湖南", "株洲市", "三线城市"),
            new ProvinceCityLevel("湖南", "湘潭市", "三线城市"),
            new ProvinceCityLevel("四川", "成都市", "二线城市"),
            new ProvinceCityLevel("四川", "绵阳市", "三线城市"),
            new ProvinceCityLevel("四川", "南充市", "三线城市"),
            new ProvinceCityLevel("重庆", "重庆市", "一线城市"),
            new ProvinceCityLevel("安徽", "合肥市", "二线城市"),
            new ProvinceCityLevel("安徽", "芜湖市", "三线城市"),
            new ProvinceCityLevel("安徽", "蚌埠市", "三线城市"),
            new ProvinceCityLevel("福建", "福州市", "二线城市"),
            new ProvinceCityLevel("福建", "厦门市", "二线城市"),
            new ProvinceCityLevel("福建", "泉州市", "二线城市"),
            new ProvinceCityLevel("江西", "南昌市", "二线城市"),
            new ProvinceCityLevel("江西", "九江市", "三线城市"),
            new ProvinceCityLevel("江西", "赣州市", "三线城市"),
            new ProvinceCityLevel("辽宁", "沈阳市", "二线城市"),
            new ProvinceCityLevel("辽宁", "大连市", "二线城市"),
            new ProvinceCityLevel("辽宁", "鞍山市", "三线城市"),
            new ProvinceCityLevel("吉林", "长春市", "二线城市"),
            new ProvinceCityLevel("吉林", "吉林市", "三线城市"),
            new ProvinceCityLevel("吉林", "四平市", "三线城市"),
            new ProvinceCityLevel("黑龙江", "哈尔滨市", "二线城市"),
            new ProvinceCityLevel("黑龙江", "齐齐哈尔市", "三线城市"),
            new ProvinceCityLevel("黑龙江", "牡丹江市", "三线城市"),
            new ProvinceCityLevel("陕西", "西安市", "二线城市"),
            new ProvinceCityLevel("陕西", "宝鸡市", "三线城市"),
            new ProvinceCityLevel("陕西", "咸阳市", "三线城市"),
            new ProvinceCityLevel("甘肃", "兰州市", "二线城市"),
            new ProvinceCityLevel("甘肃", "天水市", "三线城市"),
            new ProvinceCityLevel("甘肃", "酒泉市", "三线城市"),
            new ProvinceCityLevel("青海", "西宁市", "二线城市"),
            new ProvinceCityLevel("青海", "海东市", "三线城市"),
            new ProvinceCityLevel("宁夏", "银川市", "二线城市"),
            new ProvinceCityLevel("新疆", "乌鲁木齐市", "二线城市"),
            new ProvinceCityLevel("新疆", "克拉玛依市", "三线城市"),
            new ProvinceCityLevel("内蒙古", "呼和浩特市", "二线城市"),
            new ProvinceCityLevel("内蒙古", "包头市", "三线城市"),
            new ProvinceCityLevel("广西", "南宁市", "二线城市"),
            new ProvinceCityLevel("广西", "柳州市", "三线城市"),
            new ProvinceCityLevel("广西", "桂林市", "三线城市"),
            new ProvinceCityLevel("海南", "海口市", "二线城市"),
            new ProvinceCityLevel("海南", "三亚市", "三线城市"),
            new ProvinceCityLevel("西藏", "拉萨市", "二线城市"),
            new ProvinceCityLevel("贵州", "贵阳市", "二线城市"),
            new ProvinceCityLevel("贵州", "遵义市", "三线城市"),
            new ProvinceCityLevel("云南", "昆明市", "二线城市"),
            new ProvinceCityLevel("云南", "曲靖市", "三线城市"),
            new ProvinceCityLevel("云南", "玉溪市", "三线城市"),
            new ProvinceCityLevel("云南", "昭通市", "三线城市"),
            new ProvinceCityLevel("云南", "普洱市", "三线城市"),
            new ProvinceCityLevel("云南", "临沧市", "三线城市"),
            new ProvinceCityLevel("云南", "文山州", "三线城市"),
            new ProvinceCityLevel("云南", "红河州", "三线城市"),
            new ProvinceCityLevel("云南", "西双版纳州", "三线城市"),
            new ProvinceCityLevel("云南", "大理州", "三线城市"),
            new ProvinceCityLevel("云南", "保山市", "三线城市"),
            new ProvinceCityLevel("云南", "德宏州", "三线城市"),
            new ProvinceCityLevel("云南", "怒江州", "三线城市"),
            new ProvinceCityLevel("云南", "迪庆州", "三线城市")
    );

    private static final List<String> nameList = List.of("张伟", "王芳", "李娜", "赵敏", "陈静", "刘丽", "孙强", "周磊", "吴军", "郑洋", "冯勇", "黄艳", "朱杰", "何娟", "林涛", "胡刚", "郭莉", "宋超", "谢霞", "韩辉", "唐玲", "于娟", "董强", "萧梅", "程华", "邓文", "许秀", "傅峰", "沈云", "曾平", "彭明", "吕静", "苏丽", "卢强", "蒋磊", "蔡军", "贾洋", "丁勇", "魏艳", "薛杰", "叶娟", "阎涛", "余刚", "潘莉", "杜超", "戴霞", "夏辉", "钟玲", "汪娟", "田强", "陈梅", "杨华", "高文", "林秀", "徐峰", "朱云", "周平", "王明", "李静", "赵丽", "孙强", "周磊", "吴军", "郑洋", "冯勇", "黄艳", "朱杰", "何娟", "林涛", "胡刚", "郭莉", "宋超", "谢霞", "韩辉", "唐玲", "于娟", "董强", "萧梅", "程华", "邓文", "许秀", "傅峰", "沈云", "曾平", "彭明", "吕静", "苏丽", "卢强", "蒋磊", "蔡军", "贾洋", "丁勇", "魏艳", "薛杰", "叶娟", "阎涛", "余刚", "潘莉", "杜超");
    // 汽车品牌及车系映射
    private static final List<CarBrandSeries> carBrandsAndSeries = List.of(
            new CarBrandSeries("奔驰", "奔驰C260", 0),
            new CarBrandSeries("奔驰", "奔驰E260", 0),
            new CarBrandSeries("奔驰", "奔驰S级", 0),
            new CarBrandSeries("宝马", "宝马3系", 0),
            new CarBrandSeries("宝马", "宝马5系", 0),
            new CarBrandSeries("宝马", "宝马X5", 0),
            new CarBrandSeries("奥迪", "奥迪A4L", 0),
            new CarBrandSeries("奥迪", "奥迪A6L", 0),
            new CarBrandSeries("奥迪", "奥迪Q5", 0),
            new CarBrandSeries("特斯拉", "Model S", 1),
            new CarBrandSeries("特斯拉", "Model 3", 1),
            new CarBrandSeries("特斯拉", "Model Y", 1),
            new CarBrandSeries("比亚迪", "秦Pro", 1),
            new CarBrandSeries("比亚迪", "唐DM", 1),
            new CarBrandSeries("比亚迪", "汉EV", 1),
            new CarBrandSeries("蔚来", "ES6", 1),
            new CarBrandSeries("蔚来", "ES8", 1),
            new CarBrandSeries("蔚来", "EC6", 1),
            new CarBrandSeries("小鹏", "P7", 1),
            new CarBrandSeries("小鹏", "G3", 1),
            new CarBrandSeries("理想", "ONE", 1),
            new CarBrandSeries("理想", "L9", 1),
            new CarBrandSeries("理想", "L8", 1),
            new CarBrandSeries("理想", "L7", 1),
            new CarBrandSeries("红旗", "H5", 0),
            new CarBrandSeries("红旗", "H7", 0),
            new CarBrandSeries("红旗", "HS5", 0),
            new CarBrandSeries("红旗", "HS7", 0),
            new CarBrandSeries("红旗", "E-HS9", 1),
            new CarBrandSeries("吉利", "博瑞", 0),
            new CarBrandSeries("吉利", "帝豪", 0),
            new CarBrandSeries("吉利", "星越", 0),
            new CarBrandSeries("吉利", "几何A", 1),
            new CarBrandSeries("吉利", "几何C", 1),
            new CarBrandSeries("长城", "哈弗H6", 0),
            new CarBrandSeries("长城", "WEY VV7", 0),
            new CarBrandSeries("长城", "欧拉黑猫", 1),
            new CarBrandSeries("长城", "欧拉白猫", 1),
            new CarBrandSeries("长城", "欧拉好猫", 1),
            new CarBrandSeries("长安", "CS75 PLUS", 0),
            new CarBrandSeries("长安", "UNI-T", 0),
            new CarBrandSeries("长安", "逸动DT", 0),
            new CarBrandSeries("长安", "奔奔E-Star", 1),
            new CarBrandSeries("长安", "CS55纯电版", 1),
            new CarBrandSeries("广汽传祺", "GS4", 0),
            new CarBrandSeries("广汽传祺", "GA6", 0),
            new CarBrandSeries("广汽传祺", "Aion S", 1),
            new CarBrandSeries("广汽传祺", "Aion V", 1),
            new CarBrandSeries("广汽传祺", "Aion LX", 1),
            new CarBrandSeries("上汽荣威", "RX5", 0),
            new CarBrandSeries("上汽荣威", "i5", 0),
            new CarBrandSeries("上汽荣威", "MARVEL X", 1),
            new CarBrandSeries("上汽荣威", "Ei5", 1),
            new CarBrandSeries("上汽荣威", "ERX5", 1),
            new CarBrandSeries("一汽大众", "迈腾", 0),
            new CarBrandSeries("一汽大众", "速腾", 0),
            new CarBrandSeries("一汽大众", "宝来", 0),
            new CarBrandSeries("一汽大众", "高尔夫", 0),
            new CarBrandSeries("一汽大众", "探岳", 0),
            new CarBrandSeries("广汽本田", "雅阁", 0),
            new CarBrandSeries("广汽本田", "凌派", 0),
            new CarBrandSeries("广汽本田", "缤智", 0),
            new CarBrandSeries("广汽本田", "皓影", 0),
            new CarBrandSeries("广汽本田", "VE-1", 1),
            new CarBrandSeries("东风日产", "轩逸", 0),
            new CarBrandSeries("东风日产", "天籁", 0),
            new CarBrandSeries("东风日产", "逍客", 0),
            new CarBrandSeries("东风日产", "奇骏", 0),
            new CarBrandSeries("东风日产", "轩逸·纯电", 1)
    );

    public static void main(String[] args) throws IOException {
        SplitValueBuilder svb = new SplitValueBuilder("\t");
        File file = new File("D:\\ideaProject\\msgproj\\datasource\\src\\main\\resources\\data.txt");
        file.createNewFile();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 1000; i++) {
                String userName = nameList.get(random.nextInt(nameList.size()));
                int age = random.nextInt(30) + 20; // 20-49岁
                String gender = random.nextBoolean() ? "男" : "女";
                ProvinceCityLevel provinceCity = provincesAndCities.get(random.nextInt(provincesAndCities.size()));
                String province = provinceCity.getProvince();
                String city = provinceCity.getCity();
                String cityLevel = provinceCity.getCityLevel();
                CarBrandSeries car = carBrandsAndSeries.get(random.nextInt(carBrandsAndSeries.size()));
                bf.write(svb.add(userName).add(age).add(gender).add(province).add(city).add(cityLevel).add(car.getSeries()).add(car.getBrand()).add(car.getNewEnergy()).build());
                bf.newLine();
                svb.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> genMessage() {
        SplitValueBuilder svb = new SplitValueBuilder("\t");
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String userName = nameList.get(random.nextInt(nameList.size()));
            int age = random.nextInt(30) + 20; // 20-49岁
            String gender = random.nextBoolean() ? "男" : "女";
            ProvinceCityLevel provinceCity = provincesAndCities.get(random.nextInt(provincesAndCities.size()));
            String province = provinceCity.getProvince();
            String city = provinceCity.getCity();
            String cityLevel = provinceCity.getCityLevel();
            CarBrandSeries car = carBrandsAndSeries.get(random.nextInt(carBrandsAndSeries.size()));
            messages.add(svb.add(userName).add(age).add(gender).add(province).add(city).add(cityLevel).add(car.getSeries()).add(car.getBrand()).add(car.getNewEnergy()).build());
            svb.clear();
        }
        return messages;
    }

    static class ProvinceCityLevel {
        private final String province;
        private final String city;
        private final String cityLevel;

        ProvinceCityLevel(String province, String city, String cityLevel) {
            this.province = province;
            this.city = city;
            this.cityLevel = cityLevel;
        }

        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }

        public String getCityLevel() {
            return cityLevel;
        }
    }

    static class CarBrandSeries {
        private final String brand;
        private final String series;
        private final int newEnergy;

        CarBrandSeries(String brand, String series, int newEnergy) {
            this.brand = brand;
            this.series = series;
            this.newEnergy = newEnergy;
        }

        public String getBrand() {
            return brand;
        }

        public String getSeries() {
            return series;
        }

        public int getNewEnergy() {
            return newEnergy;
        }
    }
}
