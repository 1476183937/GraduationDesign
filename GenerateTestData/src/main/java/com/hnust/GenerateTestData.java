package com.hnust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnust.entity.*;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Title:生成测试数据
 * @Author: ggh
 * @Date: 2021/4/3 22:33
 */
public class GenerateTestData {

    public static void main(String[] args) {

        if (args.length != 4){
            System.out.println("参数个数不对：开始日期(年月日) 天数 输出目录 测试数据目录");
            return;
        }

        String date = args[0];
        int days = Integer.valueOf(args[1]);
        String outputPath = args[2];
        String basePath = args[3];

        GenerateTestData generateTestData = new GenerateTestData();
        try {
            generateTestData.generateData(date,days,outputPath,basePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /*public static void main(String[] args) throws JsonProcessingException {

        LocalDateTime dateTime = LocalDateTime.of(2021, 4, 4, 20, 39);

        long milli = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
        System.out.println(System.currentTimeMillis());

        Date date = new Date(milli);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));

        Instant instant = Instant.ofEpochMilli(milli);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(localDateTime.format(f));
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        System.out.println(localDateTime1.format(f));

//        System.out.println(localDateTime.format(new DateTimeFormatter("yyyy-MM-dd HH:mm:ss")));
        LogData logData = new LogData();
        CommonLogData commonLogData = new CommonLogData();
        commonLogData.setAr("111");
        commonLogData.setBa("222");
        commonLogData.setHw("123x234");
        commonLogData.setLa("123");
        commonLogData.setUid("435234");
        commonLogData.setMid("fafas");
        commonLogData.setUrl("www.baidu.com");

        logData.setCm(commonLogData);

        Event event = new Event();
        event.setEventTime("3421321");
        event.setEventType("display");
        DisplayEvent displayEvent = new DisplayEvent();
        displayEvent.setAction(1);
        displayEvent.setArea("湖南省湘潭市");
        displayEvent.setCategory("写字楼");
        displayEvent.setHourseId("12321");
        displayEvent.setHourseName("云天房");
        displayEvent.setPlace("3");
        event.setEvent(displayEvent);

        logData.setEvent(event);
        System.out.println(logData.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(logData);
        System.out.println(json);

    }
*/


    static Random random = new Random();

    ArrayList<UserInfo> userInfos = new ArrayList<>();
    ArrayList<String> urls = new ArrayList<>();
    ArrayList<Hourse> hourses = new ArrayList<>();

    HashMap<String, String> user2SidMap = new HashMap<>();
    HashMap<String, Hourse> hourseMap = new HashMap<>();

    String sql = "SELECT id,mername,Lng,Lat FROM region LIMIT " + random.nextInt(3700) + ",1;";

    //生成日志
//    @Test
    public void generateData(String startDate,int days,String outputPath,String basePath) throws IOException, SQLException, ClassNotFoundException {

        //Class.forName("com.mysql.jdbc.Driver");
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "root");

        ObjectMapper objectMapper = new ObjectMapper();

        BufferedReader urlReader = new BufferedReader(new FileReader(basePath+"/urls.txt"));
        BufferedReader userInfoReader = new BufferedReader(new FileReader(basePath+"/userInfo.txt"));
        BufferedReader hourseReader = new BufferedReader(new FileReader(basePath+"/hourses.txt"));

        //读取出 userInfo 和 urls
        String line = "";
        while ((line = userInfoReader.readLine()) != null) {
            UserInfo userInfo = objectMapper.readValue(line, UserInfo.class);
            userInfos.add(userInfo);
        }
        userInfoReader.close();
        while ((line = urlReader.readLine()) != null) {
            //String url = objectMapper.readValue(line, String.class);
            urls.add(line);
        }
        urlReader.close();
        while ((line = hourseReader.readLine()) != null) {
            Hourse hourse = objectMapper.readValue(line, Hourse.class);
            hourseMap.put(hourse.getHourseId(), hourse);
            hourses.add(hourse);
        }
        hourseReader.close();

        String[] dateSplit = startDate.split("-");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[2]);

        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);


        //180天
//        for (int i = 0; i < 180; i++) {
        for (int i = 0; i < days; i++) {
            user2SidMap.clear();

            //加一天
            dateTime = dateTime.plusDays(1);
            //获取时间戳
            long baseTime = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            Instant instant = Instant.ofEpochMilli(baseTime);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = localDateTime.format(f);
            String path = outputPath+"/" + date + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            //totalCount 每天的日志量
//            int count = 0,totalCount = 30000+random.nextInt(20000);
            int count = 0, totalCount = 300 + random.nextInt(100);
//            int count = 0,totalCount = 10;
            while (count < totalCount) {
                int tmpCnt = random.nextInt(10);
//                int tmpCnt = random.nextInt(500);
                if (tmpCnt + count < totalCount) {
                    for (int k = 0; k < tmpCnt; k++) {
                        LogData logData = randomEvent(baseTime);
                        if (null == logData && random.nextInt(100) < 96) {
                            if (random.nextInt(20) < 1) {
                                k--;
                            }
                            continue;
                        }
                        writer.write(objectMapper.writeValueAsString(logData) + "\n");
                    }
                } else {
                    for (int j = 0; j < totalCount - count; j++) {
                        //生成一个随机事件日志
                        LogData logData = randomEvent(baseTime);
                        if (null == logData && random.nextInt(10) < 8) {
                            j--;
                            continue;
                        }
                        writer.write(objectMapper.writeValueAsString(logData) + "\n");
                    }

                }
                count += tmpCnt;
                baseTime += 3000 + random.nextInt(11400);
            }
            writer.close();

        }

    }

    public LogData randomEvent(long baseTime) throws SQLException, ClassNotFoundException {

        LogData logData = new LogData();
        CommonLogData commonLogData = new CommonLogData();
        AbstratEvent event1 = null;
        Event event = null;
        int randomIdx = random.nextInt(userInfos.size());
        UserInfo userInfo = userInfos.get(randomIdx);
        String sid = "";
        if (user2SidMap.containsKey(userInfo.getUid())){
            //
            if (random.nextInt(10)>3){
                //不新建sessionid
                sid = user2SidMap.get(userInfo.getUid());
            }else{
                //新建sessionid
                String uuid = UUID.randomUUID().toString();
                sid = uuid.substring(6, 9) + uuid.substring(7, 10) + uuid.substring(20, 24);
                user2SidMap.put(userInfo.getUid(),sid);
            }

        }else{
            String uuid = UUID.randomUUID().toString();
            sid = uuid.substring(6, 9) + uuid.substring(7, 10) + uuid.substring(20, 24);
            user2SidMap.put(userInfo.getUid(),sid);
        }

        commonLogData.setMid((458768 + random.nextInt(43214141)) + "");
        commonLogData.setSessionid(sid);
        commonLogData.setUid(userInfo.getUid());
        commonLogData.setSr((random.nextInt(5) + 1) + "");
        commonLogData.setOs(userInfo.getOs().get(random.nextInt(userInfo.getOs().size())));
        commonLogData.setAr(userInfo.getArea());
        commonLogData.setMd(userInfo.getMds().get(random.nextInt(userInfo.getMds().size())));
        commonLogData.setBa(userInfo.getBas().get(random.nextInt(userInfo.getBas().size())));
        commonLogData.setHw(userInfo.getHeightXwidth().get(random.nextInt(userInfo.getHeightXwidth().size())));
        commonLogData.setT(baseTime + "");
        commonLogData.setNetwork(userInfo.getNetwork().get(random.nextInt(userInfo.getNetwork().size())));
        commonLogData.setLn(userInfo.getLng());
        commonLogData.setLa(userInfo.getLat());
        String url = urls.get(random.nextInt(urls.size()));
        commonLogData.setUrl(url);

        if (url.contains("/index")) {
            //访问首页事件
            event = indexEventGenerete(baseTime);
        }
        if (url.contains("/ad")) {
            //广告事件
            event = adEventGenerete(baseTime);
        }
        if (url.contains("appointment")) {
            //预约事件
            UserInfo agentUser = userInfos.get(random.nextInt(userInfos.size()));
            event = appointmentEventGenerate(userInfo, agentUser, baseTime);
        }
        if (url.contains("comment")) {
            event = commentEventGenerate(userInfo, baseTime);
        }
        if (url.contains("deal")) {
            //成交事件
            UserInfo agentUser = userInfos.get(random.nextInt(userInfos.size()));
            event = dealEventGenerate(userInfo, agentUser, baseTime);
        }
        if (url.contains("detail")) {
            //访问详情页事件
            event = detailEventGenerate(url, baseTime);
        }

        if (url.contains("display")) {
            //列表页点击事件
            event = displayEventGenerate(url, baseTime);
        }

        if (url.contains("favorites")) {
            //收藏事件
            event = favoritesEventGenerate(userInfo, baseTime);
        }
        if (url.contains("loading")) {
            //列表页事件
            event = loadingEventGenerate(baseTime);
        }
        if (url.contains("praise")) {
            //点赞事件
            event = praiseEventGenerate(userInfo, baseTime);
        }
        if (url.contains("search")) {
            //搜索事件
            event = searchEventGenerate(userInfo, baseTime, url);
        }
        if (url.contains("look")) {
            UserInfo lookUser = userInfos.get(random.nextInt(userInfos.size()));
            event = lookEventGenerate(userInfo, lookUser, baseTime, url);
        }

        if (url.contains("list")) {
            event = loadingEventGenerate(baseTime);
        }
        logData.setCm(commonLogData);
        logData.setEvent(event);

        return logData;
    }


    //生成访问首页事件
    public Event indexEventGenerete(long time) {

        Event event = new Event();
        event.setEventType("index");
        event.setEventTime(time + "");
        return event;
    }

    //生成广告事件
    public Event adEventGenerete(long time) {

        Event event = new Event();
        event.setEventType("ad");
        event.setEventTime(time + "");

        AdEvent adEvent = new AdEvent();
        adEvent.setEntry((random.nextInt(4) + 1) + "");
        adEvent.setAction(random.nextInt(3) + "");
        adEvent.setContent((random.nextInt(3) + 1) + "");
        adEvent.setDetail("200");
        adEvent.setSource((random.nextInt(5) + 1) + "");
        adEvent.setBehavior((random.nextInt(2) + 1) + "");
        event.setEvent(adEvent);
        return event;
    }

    //生成预约事件
    public Event appointmentEventGenerate(UserInfo userInfo, UserInfo agentUser, long time) {

        Event event = new Event();
        event.setEventType("appointment");
        event.setEventTime(time + "");

        AppointmentEvent appointmentEvent = new AppointmentEvent();
        Hourse hourse = hourses.get(random.nextInt(hourses.size()));

        appointmentEvent.setId((12638 + random.nextInt(12638767)) + "");
        appointmentEvent.setAgentUserId(agentUser.getUid());
        appointmentEvent.setUserId(userInfo.getUid());
        appointmentEvent.setHourseId(hourse.getHourseId());
        appointmentEvent.setHourseName(hourse.getHourseName());
        appointmentEvent.setAppointmentTime(time + "");
        appointmentEvent.setCategory(hourse.getCategory());
        appointmentEvent.setArea(hourse.getArea());
        appointmentEvent.setHourseType((1 + random.nextInt(4)) + "");

        event.setEvent(appointmentEvent);
        return event;
    }

    //生成评论事件
    public Event commentEventGenerate(UserInfo userInfo, long time) {
        Event event = new Event();
        event.setEventType("comment");
        event.setEventTime(time + "");
        CommentEvent commentEvent = new CommentEvent();

        commentEvent.setCommentId((72387 + random.nextInt(789793232)) + "");
        commentEvent.setCommentedId((72387 + random.nextInt(789793232)) + "");
        commentEvent.setUserId(userInfo.getUid());
        commentEvent.setP_commentId(random.nextInt(2) + "");
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            content.append(letters[random.nextInt(letters.length)]);
        }
        commentEvent.setContent(content.toString());
        commentEvent.setAddTime(time + "");
        event.setEvent(commentEvent);

        return event;
    }

    //生成公共日志部分
    public CommonLogData commonLogDataGenerate() {

        return null;
    }

    //生成成交事件
    public Event dealEventGenerate(UserInfo userInfo, UserInfo agentUser, long time) {
        Event event = new Event();
        event.setEventType("deal");
        event.setEventTime(time + "");

        DealEvent dealEvent = new DealEvent();
        dealEvent.setId((72387 + random.nextInt(789793232)) + "");
        dealEvent.setAgentUserId(agentUser.getUid());
        dealEvent.setUserId(userInfo.getUid());
        Hourse hourse = hourses.get(random.nextInt(hourses.size()));
        dealEvent.setHourseId(hourse.getHourseId());
        dealEvent.setHourseName(hourse.getHourseName());
        dealEvent.setDealTime(time + "");
        dealEvent.setCategory(hourse.getCategory());
        dealEvent.setArea(hourse.getArea());
        dealEvent.setPrice(hourse.getPrice());
        dealEvent.setHourseType(hourse.getHourseType());

        event.setEvent(dealEvent);

        return event;
    }

    //生成详情页事件
    public Event detailEventGenerate(String url, long time) {
        Event event = new Event();
        event.setEventType("newsdetail");
        event.setEventTime(time + "");

        DetailEvent detailEvent = new DetailEvent();

        String[] split = url.split("/");
        Hourse hourse = hourseMap.get(split[split.length - 1]);

        detailEvent.setEntry((1 + random.nextInt(3)) + "");
        detailEvent.setAction((1 + random.nextInt(3)) + "");
        detailEvent.setHouseId(hourse.getHourseId());
        detailEvent.setHourseName(hourse.getHourseName());
        detailEvent.setNewsStaytime(random.nextInt(5) + "");
        detailEvent.setLoadingTime((1 + random.nextInt(4)) + "");
        detailEvent.setCategory(hourse.getCategory());
        detailEvent.setArea(hourse.getArea());
        detailEvent.setHourseType((1 + random.nextInt(4)) + "");

        event.setEvent(detailEvent);

        return event;
    }

    //生成列表页的物品点击事件
    public Event displayEventGenerate(String url, long time) {

        Event event = new Event();
        event.setEventType("display");
        event.setEventTime(time + "");

        DisplayEvent displayEvent = new DisplayEvent();

        String[] split = url.split("hourseId=");
        if (split.length >= 2) {
            displayEvent.setHourseId(split[1]);
        }

        Hourse hourse = hourseMap.get(split[1]);
        displayEvent.setAction((1 + random.nextInt(2)));
        displayEvent.setHourseId(hourse.getHourseId());
        displayEvent.setHourseName(hourse.getHourseName());
        displayEvent.setPlace(random.nextInt(20) + "");
        displayEvent.setCategory(hourse.getCategory());
        displayEvent.setArea(hourse.getArea());
        displayEvent.setHourseType((1 + random.nextInt(4)) + "");

        event.setEvent(displayEvent);

        return event;
    }

    //生成收藏事件
    public Event favoritesEventGenerate(UserInfo userInfo, long time) {
        Event event = new Event();
        event.setEventType("favorites");
        event.setEventTime(time + "");

        FavoritesEvent favoritesEvent = new FavoritesEvent();
        Hourse hourse = hourses.get(random.nextInt(hourses.size()));

        favoritesEvent.setId((72387 + random.nextInt(789793232)) + "");
        favoritesEvent.setUserId(userInfo.getUid());
        favoritesEvent.setHourseId(hourse.getHourseId());
        favoritesEvent.setHourseName(hourse.getHourseName());
        favoritesEvent.setArea(hourse.getArea());
        favoritesEvent.setCategory(hourse.getCategory());
        favoritesEvent.setAddTime(time + "");

        event.setEvent(favoritesEvent);

        return event;
    }

    //生成列表页事件
    public Event loadingEventGenerate(long time) {
        Event event = new Event();
        event.setEventType("loading");
        event.setEventTime(time + "");

        LoadingEvent loadingEvent = new LoadingEvent();

        loadingEvent.setAction((1 + random.nextInt(2)));
        loadingEvent.setLoadingTime(time + "");
        loadingEvent.setLoadingWay((1 + random.nextInt(2)) + "");
        loadingEvent.setType((1 + random.nextInt(3)) + "");
        loadingEvent.setResultCount(20 + "");

        event.setEvent(loadingEvent);
        return event;
    }

    //生成点赞事件
    public Event praiseEventGenerate(UserInfo userInfo, long time) {
        Event event = new Event();
        event.setEventType("praise");
        event.setEventTime(time + "");

        PraiseEvent praiseEvent = new PraiseEvent();

        praiseEvent.setId((72387 + random.nextInt(789793232)) + "");
        praiseEvent.setUserId(userInfo.getUid());
        praiseEvent.setTargetId((72387 + random.nextInt(789793232)) + "");
        praiseEvent.setType((1 + random.nextInt(2)) + "");
        praiseEvent.setAddTime(time + "");
        event.setEvent(praiseEvent);

        return event;
    }

    //生成搜索事件
    public Event searchEventGenerate(UserInfo userInfo, long time, String url) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "root");


        Event event = new Event();
        event.setEventType("search");
        event.setEventTime(time + "");

        SearchEvent searchEvent = new SearchEvent();
        StringBuffer word = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            word.append(letters[random.nextInt(letters.length)]);
        }

        String[] split = url.split("word=");
        if (split.length >= 2) {
            searchEvent.setSearchWord(split[1]);
        }

        if (random.nextInt(10) < 7) {
            searchEvent.setUserId(userInfo.getUid());
        }
        searchEvent.setTime(time + "");

        if (random.nextInt(10) < 6) {
            //加过滤条件
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String mername = rs.getString("mername");
                if (mername.split(",").length >= 3) {
                    String id = rs.getString("id");
                    String[] split1 = mername.split(",");
                    String area = id + "," + split1[1] + "," + split1[2];
                    searchEvent.setFilterArea(area);
                    searchEvent.setFilterPrice(prices[random.nextInt(prices.length)]);
                    searchEvent.setFilterHourseType((1 + random.nextInt(4)) + "");
                    searchEvent.setFilterCategory(categories[random.nextInt(categories.length)]);

                }
                event.setEvent(searchEvent);
                conn.close();
                return event;
            }
        }
        //不加过滤条件
        searchEvent.setFilterArea("all");
        searchEvent.setFilterCategory("all");
        searchEvent.setFilterHourseType("all");
        searchEvent.setFilterPrice("all");

        event.setEvent(searchEvent);
        conn.close();
        return event;
    }

    //生成带看事件
    public Event lookEventGenerate(UserInfo userInfo, UserInfo lookUser, long time, String url) {

        Event event = new Event();

        event.setEventTime(time + "");
        event.setEventType("look");

        LookEvent lookEvent = new LookEvent();
        Hourse hourse = hourses.get(random.nextInt(hourses.size()));
        lookEvent.setAgentUserId(lookUser.getUid());
        lookEvent.setUserId(userInfo.getUid());
        lookEvent.setHourseId(hourse.getHourseId());
        lookEvent.setHourseName(hourse.getHourseName());
        lookEvent.setCategory(hourse.getCategory());
        lookEvent.setArea(hourse.getArea());
        lookEvent.setHourseType(hourse.getHourseType());
        lookEvent.setLookTime((time + 100000) + "");

        event.setEvent(lookEvent);
        return event;
    }


    //生成用户信息 3
    @Test
    public void generateUserInfo() throws IOException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "root");


        ObjectMapper objectMapper = new ObjectMapper();
        BufferedWriter writer = new BufferedWriter(new FileWriter("userInfo.txt"));

        HashSet<Integer> uidSet = new HashSet<>();

        for (int i = 0; i < 6000; i++) {
            UserInfo userInfo = new UserInfo();
            int uid = 10000 + random.nextInt(1100000);
            while (uidSet.contains(uid)) {
                uid = 10000 + random.nextInt(1100000);
            }
            int age = 20 + random.nextInt(30);
            uidSet.add(uid);
            StringBuffer phone = new StringBuffer();
            int tmp = random.nextInt(10);
            if (tmp < 3) {
                phone.append(152);
            } else if (tmp < 6) {
                phone.append(182);
            } else if (tmp < 8) {
                phone.append(177);
            } else {
                phone.append(155);
            }

            for (int k = 0; k < 8; k++) {
                phone.append(random.nextInt(9));
            }

            StringBuffer userName = new StringBuffer();

            for (int k = 0; k < 2; k++) {
                userName.append(letters[random.nextInt(letters.length)]);
            }
            ArrayList<String> mdsList = new ArrayList<>();
            ArrayList<String> heightXwidth = new ArrayList<>();
            ArrayList<String> os = new ArrayList<>();
            ArrayList<String> network = new ArrayList<>();
            ArrayList<String> basList = new ArrayList<>();
            mdsList.add(mds[random.nextInt(mds.length)]);
            mdsList.add(mds[random.nextInt(mds.length)]);
            mdsList.add(mds[random.nextInt(mds.length)]);

            heightXwidth.add(heightXwidths[random.nextInt(heightXwidths.length)]);
            heightXwidth.add(heightXwidths[random.nextInt(heightXwidths.length)]);
            heightXwidth.add(heightXwidths[random.nextInt(heightXwidths.length)]);

            os.add(androidEditions[random.nextInt(androidEditions.length)]);
            os.add(androidEditions[random.nextInt(androidEditions.length)]);
            os.add(androidEditions[random.nextInt(androidEditions.length)]);

            network.add("移动");
            network.add("联通");
            network.add("电信");
            network.add("WIFI");

            basList.add(bas[random.nextInt(bas.length)]);
            basList.add(bas[random.nextInt(bas.length)]);
            basList.add(bas[random.nextInt(bas.length)]);

            userInfo.setUserName(userName.toString());
            userInfo.setPhoneNum(phone.toString());
            userInfo.setAge(age);
            userInfo.setSex(random.nextInt(2));
            userInfo.setUid(uid + "");
            userInfo.setMds(mdsList);
            userInfo.setHeightXwidth(heightXwidth);
            userInfo.setOs(os);
            userInfo.setNetwork(network);
            userInfo.setBas(basList);
            String sql = "SELECT id,mername,Lng,Lat FROM region LIMIT " + random.nextInt(3700) + ",1;";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String[] split = rs.getString("mername").split(",");
                if (split.length > 3) {
                    userInfo.setArea(rs.getString("id")+","+split[1] + "," + split[2]);
                } else {
                    continue;
                }
                userInfo.setLng(rs.getString("Lng"));
                userInfo.setLat(rs.getString("Lat"));
            }
            rs.close();

            writer.write(objectMapper.writeValueAsString(userInfo) + "\n");
        }

        conn.close();
        writer.close();
    }

    //生成url 2
    @Test
    public void generateUrl() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("urls.txt"));

        ObjectMapper objectMapper = new ObjectMapper();
        BufferedReader hourseReader = new BufferedReader(new FileReader("hourses.txt"));
        ArrayList<String> hourseIds = new ArrayList<>();

        String line = "";
        while ((line = hourseReader.readLine()) != null) {
            Hourse hourse = objectMapper.readValue(line, Hourse.class);
            hourseIds.add(hourse.getHourseId());
        }
        hourseReader.close();

        Random random = new Random();
        //index、detail、list、search、display、ad、comment、favorites、praise、appointment、look、report、deal
        for (int i = 0; i < 4000; i++) {
            int tmp = random.nextInt(1650);
            String url = "https://www.baidu.com/";
            if (tmp < 200) {
                url = url + "index";
            } else if (tmp < 450) {
                url = url + "detail/" + hourseIds.get(random.nextInt(hourseIds.size()));
            } else if (tmp < 550) {
                url = url + "list";
            } else if (tmp < 700) {
                url = url + "search?word=" + letters[random.nextInt(letters.length)];
            } else if (tmp < 900) {
                url += "display?hourseId=" + hourseIds.get(random.nextInt(hourseIds.size()));
            } else if (tmp < 950) {
                url += "ad/";
            } else if (tmp < 1050) {
                url += "comment/";
            } else if (tmp < 1150) {
                url += "favorites/";
            } else if (tmp < 1250) {
                url += "praise/";
            } else if (tmp < 1350) {
                url += "appointment";
            } else if (tmp < 1450) {
                url += "look/";
            } else if (tmp < 1550) {
                url += "report/";
            } else {
                url += "deal/";
            }

            writer.write(url + "\n");
        }

        writer.close();

    }


    //生成房屋信息 1
    @Test
    public void generateHourse() throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("hourses.txt"));
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "root");

        ObjectMapper objectMapper = new ObjectMapper();

        HashSet<Integer> hourseIdSet = new HashSet<>();

        for (int i = 0; i < 2000; i++) {
            Hourse hourse = new Hourse();
            int hourseId = 10000 + random.nextInt(1100000);
            while (hourseIdSet.contains(hourseId)) {
                hourseId = 10000 + random.nextInt(1100000);
            }
            hourseIdSet.add(hourseId);

            StringBuffer hourseName = new StringBuffer();

            for (int k = 0; k < 2; k++) {
                hourseName.append(letters[random.nextInt(letters.length)]);
            }

            String sql = "SELECT id,mername,Lng,Lat FROM region LIMIT " + random.nextInt(3700) + ",1;";
            String sql2 = "SELECT id,mername,Lng,Lat FROM region WHERE mername LIKE '%海南%' LIMIT " + random.nextInt(25) + ",1;";

//            ResultSet rs = null;
            if (random.nextInt(10) < 7) {
                PreparedStatement statement = conn.prepareStatement(sql2);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    String[] split = rs.getString("mername").split(",");
                    if (split.length > 3) {
                        hourse.setArea(rs.getString("id")+","+split[1] + "," + split[2]);
                    } else {
                        i--;
                        continue;
                    }
                    hourse.setLng(rs.getString("Lng"));
                    hourse.setLat(rs.getString("Lat"));

                }
                rs.close();
            } else {
                PreparedStatement statement2 = conn.prepareStatement(sql);
                ResultSet rs = statement2.executeQuery();
                if (rs.next()) {
                    String[] split = rs.getString("mername").split(",");
                    if (split.length > 3) {
                        hourse.setArea(split[1] + "," + split[2]);
                    } else {
                        i--;
                        continue;
                    }
                    hourse.setLng(rs.getString("Lng"));
                    hourse.setLat(rs.getString("Lat"));
                }
                rs.close();
            }


            StringBuffer category = new StringBuffer();
            for (int k = 0; k < 1 + random.nextInt(categories.length / 2); k++) {
                category.append(categories[random.nextInt(categories.length)]).append(",");
            }


            hourse.setHourseId(hourseId + "");
            hourse.setHourseName(hourseName.toString());
            hourse.setCategory(category.substring(0, category.length() - 1));
            hourse.setPrice((5000 + random.nextInt(1000000)) + "");
            hourse.setHourseType((1 + random.nextInt(4)) + "");

            writer.write(objectMapper.writeValueAsString(hourse) + "\n");
        }

        conn.close();
        writer.close();

    }


    //价格区间
    String[] prices = {"all", "0~7000", "7001~10000", "10001~15000", "15001~20000", "20001~25000", "25001~30000", "30001~35000", "35001~40000", "40000+"};

    String[] categories = {"住宅", "公寓", "别墅", "写字楼", "洋房", "SOHO", "LOFT", "商住", "叠拼别墅"};

    String[] letters = {"今天", "我读了", "《滴水穿石》", "这篇", "文章", "文章", "主要", "写了", "作者",
            "游历", "安徽", "广德太极洞", "看到", "滴水穿石", "景象后的感受", "文章", "还列举了", "许多",
            "古今中外", "名人", "的故事", "说明", "滴水穿石", "的意义", "大自然", "中的", "滴水穿石",
            "绝非", "一日之功", "确实能给人启示", "从而", "升华了", "文章主题", "读完这篇", "文章后",
            "我深有", "感触", "这石头中", "的小洞", "竟是", "被那小小的", "水滴滴穿的", "水滴靠着",
            "持之以恒", "目标专一", "精神", "用自己", "微小的力量", "击穿了", "强大的顽石",
            "这种", "坚韧不拔的精神", "值得点赞", "读书", "让我想到了", "中外的", "一些名人名家",
            "例如", "我国", "著名的画家", "齐白石", "他画画", "成功是", "持之以恒", "几十年如一日",
            "不间断的创作", "练习而努力", "得到的", "他画的鱼", "虾", "蟹等", "各种水墨画", "造型",
            "鲜明", "色彩", "对比", "强烈", "每幅画", "都是", "芳千古", "名作", "就是", "美国", "著名的",
            "大发明家", "爱迪生", "一生", "创造了", "一千", "多项", "发明", "他也曾", "历经过",
            "无数次失败", "实验", "不忘初心", "持之以恒", "努力实践", "不怕", "失败", "就算", "失败了",
            "也决不", "放弃", "最终", "为人类", "做出了", "伟大", "贡献", "留下", "一千多", "伟大的",
            "发明", "创造", "读完", "滴水", "穿石", "这篇文章", "我", "领悟", "无论", "做什么", "事",
            "只要", "我们", "目标", "专一", "不怕", "失败", "坚持", "不懈", "地", "努力", "奋斗", "是有",
            "希望", "想实现", "自己", "理想", "溢满", "阳光", "午后", "我", "坐在", "带着", "自然清新",
            "木椅上", "看着", "一本", "精美", "杂志", "一篇", "特别的", "文章", "吸引了", "我", "你是",
            "大大", "世界", "里的", "小小女孩", "好长的", "名字", "我想象", "故事的内容", "慢慢读",
            "起来", "故事", "发生在", "一个普通", "中学门口", "因为", "学生", "放学晚", "大多",
            "迫不及待", "想回去", "明明", "是红灯", "却也", "抢着", "跑了", "过去", "大多", "司机",
            "很不满", "但也只好", "等等", "终于", "又等到", "绿灯", "没有", "孩子", "过马路", "汽车",
            "心急火燎", "地赶着", "往前冲", "但在一", "刹那", "一个", "瘦弱的", "女孩", "跑过去", "救了",
            "一只猫", "被撞倒了", "一个男孩子", "救了她", "故事", "就是", "这么开始", "女孩", "醒来后",
            "寻找男孩", "那个", "男孩子", "知道后", "加入了", "保护动物", "的社团", "但", "他爸爸",
            "却是", "狗肉店", "的老板", "这令", "他", "十分", "不满", "他有", "一种不安", "的感觉",
            "真相", "有一天", "终于揭开", "男孩", "难堪地", "跑回家", "心里", "很对不起", "那个",
            "女孩", "当深夜里", "着火了", "火焰灼烧", "着狗狗", "呜咽声", "让男孩", "鼓起勇气",
            "冲进", "火海", "救了狗狗", "事后", "男孩", "和女孩", "致力于", "保护动物", "救了",
            "很多", "濒临", "灭绝", "生命"};

    //渠道
    String[] sources = {"1", "2", "3", "4", "5"};
    //android 版本号
    String[] androidEditions = {"11.0", "10.0", "9.0", "8.0", "8.1", "7.1.2", "6.0.1", "5.1.1", "4.4.4", "4.3", "4.0.4", "3.2", "2.3.7",
            "2.2", "2.1"};
    //屏幕宽高
    String[] heightXwidths = {"1125x2436", "1242x2208", "750x1334", "640x1136", "480x854",
            "1080x1920", "1440x2560", "720x1280", "1080x1920", "1080x1920", "1080x1920",
            "1080x1920", "1440x2560", "1440x2560", "1440x2960", "1440x2960",
            "1440x2560", "1440x2560", "1080x1920", "1440x2560", "1440x2560",
            "1080x1920", "1080x1920", "1440x2560"};

    //所有手机品牌
    String[] bas = {"oppo", "魅族", "iphone", "samsung", "小米", "锤子", "小辣椒", "华为", "酷派", "步步高", "诺基亚", "vivo", "redmi", "中兴", "联想"};

    String[] mds = {"R9 PLUS", "R9 S PLUS", "R7", "P9", "P8lite", "Mate7", "Mate8", "Mates", "Note4", "Note5", "S4", "S5", "A5", "A6", "他、荣耀3C", "X3", "X3L", "X5", "X5Pro", "X6max", "MX3", "MX4", "note", "mete1", "V187", "F303", "S5.1", "GN152", "Y51", "Y35"};

}
