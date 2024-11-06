package com.vstu.msgproj.webui.utils;//package com.vstu.msgProject.utils;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.security.MessageDigest;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.regex.Pattern;
//
///**
// * 需要持续积累的常见字符处理工具。
// *
// * @author maclj
// */
//public class StringUtil {
//
//    /**
//     * 根据索引查找指定分隔符之前的字符串
//     *
//     * @param value
//     * @param split
//     * @param index
//     * @return
//     */
//    public static String find(String value, String split, int index) {
//        if (value == null || split == null || index < 0) {
//            return null;
//        }
//        value = value.trim();
//        if (value.length() == 0) {
//            return null;
//        }
//        int counter = 0;
//        int slen = split.length();
//        int beginIndex = 0;
//        int endIndex = 0;
//        while ((endIndex = value.indexOf(split, beginIndex)) >= 0) {
//            if (counter++ == index) {
//                if ((endIndex - beginIndex) == 0) {
//                    return "";
//                }
//                return value.substring(beginIndex, endIndex);
//            }
//            // 过滤掉仅有分隔符，但是没有内容的情况。如连续的||
//            if ((endIndex - beginIndex) == 0) {
//                beginIndex += slen;
//                continue;
//            }
//            beginIndex += (endIndex - beginIndex);// tmp.length();
//            beginIndex += slen;
//        }
//        return null;
//    }
//
//    /**
//     * 优化拆分性能，取消正则表达式处理。
//     * 提升不大，5000w次拆分提升2s
//     *
//     * @param value
//     * @param split
//     * @return
//     */
//    public static String[] split(String value, String split) {
//        if (value == null || split == null) {
//            return null;
//        }
//        value = value.trim();
//        if (value.length() == 0) {
//            return null;
//        }
//        List<String> result = new ArrayList<String>();
//        int slen = split.length();
//        int beginIndex = 0;
//        int endIndex = 0;
//        String tmp = null;
//        while ((endIndex = value.indexOf(split, beginIndex)) >= 0) {
//            // 过滤掉仅有分隔符，但是没有内容的情况。如连续的||
//            if ((endIndex - beginIndex) == 0) {
//                beginIndex += slen;
//                continue;
//            }
//            tmp = value.substring(beginIndex, endIndex);
//            result.add(tmp);
//            beginIndex += tmp.length();
//            beginIndex += slen;
//        }
//        if (endIndex < 0) {
//            // 没有匹配上结束分隔符时，将剩下的内容全部加入。
//            tmp = value.substring(beginIndex);
//            if (tmp.length() > 0) { // 没有做trim处理，空值不会被加入，但是连续空格仍然会被加入。
//                result.add(tmp);
//            }
//        }
//        return result.toArray(new String[]{});
//    }
//
//    /**
//     * 只分隔出指定长度的数组。
//     *
//     * @param str
//     * @param plainSeperator
//     * @param len
//     * @return
//     */
//    public static List<String> fastSplitToLimit(String str, String plainSeperator, int len) {
//
//        List<String> result = new ArrayList<String>(len);
//        int pos = 0;
//        int idx = 0;
//        int inc = plainSeperator.length();
//        int size = 0;
//        while (true) {
//            idx = str.indexOf(plainSeperator, pos);
//            if (idx < 0) {
//                result.add(str.substring(pos, str.length()));
//                break;
//            }
//            // 达到分隔限制，则直接返回剩余内容
//            if (++size == len) {
//                result.add(str.substring(pos));
//                break;
//            }
//            ;
//            result.add(str.substring(pos, idx));
//            pos = idx + inc;
//
//        }
//        return result;
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str
//     * @param plainSeperator
//     * @param len
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(String str, String plainSeperator, int len) {
//        List<String> ls = new ArrayList<String>(len);
//        return fastSplit(str, plainSeperator, 0, ls);
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str
//     * @param plainSeperator
//     * @param start          开始位置
//     * @param len
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(String str, String plainSeperator, int len, int start) {
//        List<String> ls = new ArrayList<String>(len);
//        return fastSplit(str, plainSeperator, start, ls);
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str            字符串
//     * @param plainSeperator 分隔符
//     * @param start          开始位置
//     * @param result         结果，不会清空原有内容
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(final String str,
//                                         final String plainSeperator,
//                                         final int start,
//                                         final List<String> result) {
//        int pos = start;
//        int idx = 0;
//        int inc = plainSeperator.length();
//        while (true) {
//            idx = str.indexOf(plainSeperator, pos);
//            if (idx < 0) {
//                result.add(str.substring(pos, str.length()));
//                break;
//            }
//            result.add(str.substring(pos, idx));
//            pos = idx + inc;
//        }
//        return result;
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str            字符串
//     * @param len            最长长度
//     * @param plainSeperator 分隔符
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str, String plainSeperator, int len) {
//        List<String> result = new ArrayList<>();
//        return fastSplitFixedLen(str, plainSeperator, len, 0, result);
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str            字符串
//     * @param len            最长长度
//     * @param plainSeperator 分隔符
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str, String plainSeperator, int len, int start) {
//        List<String> result = new ArrayList<>();
//        return fastSplitFixedLen(str, plainSeperator, len, start, result);
//    }
//
//    /**
//     * 按一个文本（非正则表达式）分隔字符串
//     *
//     * @param str            字符串
//     * @param len            最长长度
//     * @param plainSeperator 分隔符
//     * @param result         结果，不会清空原有内容
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str,
//                                                 String plainSeperator,
//                                                 int len,
//                                                 int start,
//                                                 List<String> result) {
//        int pos = start;
//        int idx = 0;
//        int count = 1;
//        int inc = plainSeperator.length();
//        while (count < len) {
//            idx = str.indexOf(plainSeperator, pos);
//            if (idx < 0) {
//                result.add(str.substring(pos, str.length()));
//                count++;
//                pos = str.length();
//                break;
//            }
//            result.add(str.substring(pos, idx));
//            pos = idx + inc;
//            count++;
//        }
//        if (idx >= 0) {
//            result.add(str.substring(pos, str.length()));
//        }
//        return result;
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str
//     * @param ch
//     * @param len
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(String str, char ch, int len) {
//        List<String> ls = new ArrayList<String>(len);
//        return fastSplit(str, ch, 0, ls);
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str
//     * @param ch
//     * @param start
//     * @param len
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(String str, char ch, int len, int start) {
//        List<String> ls = new ArrayList<String>(len);
//        return fastSplit(str, ch, start, ls);
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str    字符串
//     * @param ch     分隔符
//     * @param result 结果，不清空原有内容
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplit(String str, char ch, int start, List<String> result) {
//        int pos = start;
//        int idx = 0;
//        while (true) {
//            idx = str.indexOf(ch, pos);
//            if (idx < 0) {
//                result.add(str.substring(pos, str.length()));
//                break;
//            }
//            result.add(str.substring(pos, idx));
//            pos = idx + 1;
//        }
//        return result;
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str 字符串
//     * @param len 最长长度
//     * @param ch  分隔符
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str, char ch, int len) {
//        List<String> result = new ArrayList<>();
//        return fastSplitFixedLen(str, ch, len, 0, result);
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str 字符串
//     * @param len 最长长度
//     * @param ch  分隔符
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str, char ch, int len, int start) {
//        List<String> result = new ArrayList<>();
//        return fastSplitFixedLen(str, ch, len, start, result);
//    }
//
//    /**
//     * 按一个字符分隔字符串
//     *
//     * @param str    字符串
//     * @param len    最长长度
//     * @param ch     分隔符
//     * @param result 结果，不清空原有内容
//     * @return
//     * @author sj
//     * @since 1.0
//     */
//    public static List<String> fastSplitFixedLen(String str, char ch, int len, int start, List<String> result) {
//        int pos = start;
//        int idx = 0;
//        int count = 1;
//        while (count < len) {
//            idx = str.indexOf(ch, pos);
//            if (idx < 0) {
//                result.add(str.substring(pos, str.length()));
//                count++;
//                pos = str.length();
//                break;
//            }
//            result.add(str.substring(pos, idx));
//            pos = idx + 1;
//            count++;
//        }
//        if (idx >= 0) {
//            result.add(str.substring(pos, str.length()));
//        }
//        return result;
//    }
//
//    /**
//     * 打印数组
//     *
//     * @param array
//     * @return
//     */
//    public static String arrayToString(String[] array) {
//        SplitValueBuilder svb = new SplitValueBuilder();
//        for (String i : array) {
//            svb.add(i);
//        }
//        return svb.build();
//    }
//
//    /**
//     * 打印数组
//     *
//     * @param array
//     * @return
//     */
//    public static String arrayToString(int[] array) {
//        SplitValueBuilder svb = new SplitValueBuilder();
//        for (int i : array) {
//            svb.add(i);
//        }
//        return svb.build();
//    }
//
//    /**
//     * 打印数组
//     *
//     * @param array
//     * @return
//     */
//    public static String arrayToString(long[] array) {
//        SplitValueBuilder svb = new SplitValueBuilder();
//        for (long i : array) {
//            svb.add(i);
//        }
//        return svb.build();
//    }
//
//    /**
//     * 打印数组
//     *
//     * @param array
//     * @return
//     */
//    public static String arrayToString(boolean[] array) {
//        SplitValueBuilder svb = new SplitValueBuilder();
//        for (boolean i : array) {
//            svb.add(i == true ? 1 : 0);
//        }
//        return svb.build();
//    }
//
//    /**
//     * 打印数组
//     *
//     * @param array
//     * @return
//     */
//    public static String arrayToString(int[] array, String split) {
//        SplitValueBuilder svb = new SplitValueBuilder(split);
//        for (int i : array) {
//            svb.add(i);
//        }
//        return svb.build();
//    }
//
//    /**
//     * 查找链表中的元素（消除越界等异常）
//     *
//     * @param list  链表
//     * @param index 链表下标
//     * @return 链表中的元素
//     */
//    public static String findListItem(List<String> list, int index) {
//        if (index < 0) {
//            return "";
//        }
//        try {
//            return list.get(index).trim();
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    /**
//     * 获取字符串的MD5值
//     *
//     * @param str
//     */
//    public static String getMd5(String str) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(str.getBytes());
//            byte b[] = md.digest();
//
//            int i;
//
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");
//                buf.append(Integer.toHexString(i));
//            }
//            return buf.toString();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static String list2String(String[] argvOrigion, String sperator) {
//        SplitValueBuilder svb = new SplitValueBuilder(sperator);
//        for(String token : argvOrigion){
//            svb.add(token);
//        }
//        return svb.build();
//    }
//
//
//    /**
//     * che_andorid替换为che_android
//     *
//     * @return java.lang.String
//     * @Author rujie.guo
//     * @Description //TODO
//     * @Date 2:33 PM 2018/12/25
//     * @Param [appKey]
//     **/
//    public static String replaceInvalidAppKey(String appkey) {
//        if (appkey.equals("che_andriod")) {
//            appkey = "che_android";
//        }
//        return appkey;
//    }
//
//    /*
//     * 非法数据替换为0
//     *
//     * @Author rujie.guo
//     * @Description //TODO
//     * @Date 3:23 PM 2018/11/27
//     * @Param [str_orignl]
//     * @return java.lang.String
//     **/
//    public static String rplcAbnmlStr(String str_orignl) {
//        String str = str_orignl.toLowerCase().trim();
//        if (str == null
//                || "".equals(str)
//                || "null".equals(str)
//                || "nil".equals(str)
//                || "unknown".equals(str)
//                || "invalid".equals(str)) {
//            return "0";
//        }
//        return str_orignl;
//    }
//
//
//    /*
//     * 非法数据替换为0
//     *
//     * @Author rujie.guo
//     * @Description //TODO
//     * @Date 3:23 PM 2018/11/27
//     * @Param [str_orignl]
//     * @return java.lang.String
//     **/
//    public static String rplcInvalidStr(String str_orignl) {
//        String str = str_orignl.toLowerCase().trim();
//        if (str == null
//                || "".equals(str)
//                || "null".equals(str)
//                || "nil".equals(str)
//                || "undefined".equals(str)) {
//            return "0";
//        }
//        return str_orignl;
//    }
//
//    /*
//     * 是否正常
//     *
//     * @Author rujie.guo
//     * @Description //TODO
//     * @Date 5:25 PM 2018/11/28
//     * @Param [s]
//     * @return boolean
//     **/
//
//    /*
//     * 判断是否在区间内
//     *
//     * @Author rujie.guo
//     * @Description //TODO
//     * @Date 6:55 PM 2018/11/28
//     * @Param [str, start, end]
//     * @return boolean
//     **/
//    public static boolean isInterval(String str, float start, float end) {
//        try {
//            float f = Float.parseFloat(str);
//            if (f >= start && f <= end) {
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return false;
//    }
//
//    /**
//     * 转码字符串
//     *
//     * @param s   输入字符串
//     * @param enc encode类型
//     * @return 转码后的字符串
//     */
//
//    public static String decode(String s, String enc) {
//        if (s == null)
//            return null;
//        String dest = s;
//        try {
//            if (s.contains("\007")) {
//                s.replace("\007", "");
//            }
//            if (s.contains("\t")) {
//                s.replace("\t", "");
//            }
//            if (s.contains("sou.autohome.com.cn")) {
//                enc = "gbk";
//            }
//            if (s.toUpperCase().contains("%0D") || s.toUpperCase().contains("%0A")) {
//                // 如果字符串里面含有换行符，直接返回 不解析
//                //0a------换行符号－－－－－－"\n"
//                //0d------回车符号－－－－－－搜索"\r"
//                return s;
//            }
//            if (s.contains("\\x")) {
//                s = s.replace("%", "%25");
//                s = s.replace("\\x", "%");
//
//            }
//            dest = URLDecoder.decode(s, enc);
//        } catch (Exception e) {
////			e.printStackTrace();
//            return dest;
//        }
//
//        return dest;
//    }
//
//
//    public static String decodeUtil(String s, String enc) {
//        if (s == null)
//            return null;
//        String d1 = decode(s, enc);
//        String d2 = decode(d1, enc);
//        if (d2.equals(d1)) {
//            return d2;
//        } else {
//            return decodeUtil(d2, enc);
//        }
//    }
//
//
//    /**
//     * 转码字符串
//     *
//     * @param s   输入字符串
//     * @param enc encode类型
//     * @return 转码后的字符串
//     */
//
//    public static String encode(String s, String enc) {
//        if (s == null)
//            return null;
//        String dest = s;
//        try {
//            if (s.toUpperCase().contains("%0D") || s.toUpperCase().contains("%0A")) {
//                // 如果字符串里面含有换行符，直接返回 不解析
//                //0a------换行符号－－－－－－"\n"
//                //0d------回车符号－－－－－－搜索"\r"
//                return s;
//            }
//            if (s.contains("\\x")) {
//                s = s.replace("%", "%25");
//                s = s.replace("\\x", "%");
//
//            }
//            dest = URLEncoder.encode(s, enc);
//        } catch (Exception e) {
////			e.printStackTrace();
//            return dest;
//        }
//
//        return dest;
//    }
//
//
//
//    public static String processNormal(String arg) {
//        Pattern p2 = Pattern.compile("%E\\w{1}%\\w{2}%\\w{2}");
//        //String tmp = arg.replace("%", "%25");
//        //String a1 = tmp.replaceAll("\\\\x", "%");
//        String tmp = arg.replaceAll("\\\\x", "%");
//        String a1 = tmp.replace("%", "%25");
//        String ptnStr = a1.toUpperCase();
//        String[] arr = p2.split(ptnStr);
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i].indexOf("%") == -1)
//                continue;
//            try {
//                return URLDecoder.decode(a1, "gbk");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            return URLDecoder.decode(a1, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return arg;
//    }
//
//    public static String newHandlDecode(String gbkStr) {
//        if (gbkStr.indexOf("%u") == -1) {
//            return processNormal(gbkStr);
//        }
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        int j = 0;
//        while (true) {
//            i = gbkStr.indexOf("%u");
//            if (i == -1) {
//                sb.append(processNormal(gbkStr.substring(j)));
//                break;
//            }
//            if (i != j)
//                sb.append(processNormal(gbkStr.substring(j, i)));
//            sb.append(proccessUtf16(gbkStr.substring(i, i + 6)));
//            gbkStr = gbkStr.replaceFirst(gbkStr.substring(i, i + 2), "||");
//            j = i + 6;
//        }
//        return sb.toString();
//    }
//
//    public static String proccessUtf16(String arg) {
//        String result = null;
//        try {
//            result = URLDecoder.decode("%" + arg.substring(2, 4) + "%" + arg.substring(4, 6), "utf-16");
//        } catch (Exception e) {
//            result = arg;
//        }
//        return result;
//    }
//
//
//    /**
//     * remove ; /
//     *
//     * @param domain domain
//     * @return pure domain
//     */
//
//    public static String trimDomain(String domain) {
//        if (domain == null)
//            return null;
//        String t = decode(domain, "utf8");
//        t = t.replace(";", "").replace("；", "").replace("/", "").replace("?", "");
//        return t;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new SplitValueBuilder("\u0001").add("a").add("b"));
//    }
//
//    /**
//     *  合并两个map 后者覆盖前者
//     * @param mp1
//     * @param mp2
//     * @return
//     */
//    public static Map<String, String> combine2Map(Map<String,String> mp1 , Map<String, String> mp2) {
//        Map<String, String> resultMap = new HashMap<String, String>();
//
//        if(mp1!=null) {
//            for (String k : mp1.keySet()) {
//                resultMap.put(k, mp1.get(k));
//            }
//        }
//        if(mp2!=null) {
//            for (String k : mp2.keySet()) {
//                resultMap.put(k, mp2.get(k));
//            }
//        }
//        return resultMap;
//    }
//
//
//    private static String stampToDate(String s) {
//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        long lt = Long.parseLong(s);
//        Date date = new Date(lt);
//        res = simpleDateFormat.format(date);
//        return res;
//    }
//}
