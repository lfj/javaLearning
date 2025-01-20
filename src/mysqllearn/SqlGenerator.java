package mysqllearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);
    //-1小写,1大写
    public static final int format = -1;
    /**
     * 用来存储Java等属性类型与sql中属性类型的对照
     * </br>
     * 例如：java.lang.Integer 对应 integer
     */
    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        java.math.BigDecimal b = new java.math.BigDecimal(12);
        b.toString();
        Double d = 22.9605963D;

        map.put("boolean", "smallint");
        map.put("int", "int");
        map.put("short", "int");
        map.put("long", "bigint");
        map.put("float", "float");
        map.put("double", "double");
        map.put("char", "string");
        map.put("java.lang.String", "string");
        map.put("java.lang.Integer", "int");
        map.put("java.lang.Boolean", "smallint");
        map.put("java.lang.Long", "bigint");
        map.put("java.math.BigInteger", "bigint");
        map.put("java.lang.Float", "float");
        map.put("java.lang.Double", "double");
        map.put("java.sql.Date", "string");
        map.put("java.sql.Timestamp", "TIMESTAMP");
        map.put("java.util.Date", "string");
        map.put("java.util.List", "string");
        map.put("java.time.LocalDateTime", "Date");
        sqlConstruction();
    }

    private static void sqlConstruction() {
        String className = "DisposalUserRecordMGD";
        String targetClassName = "ods_audit_disposal_user_record_delta";

        //实体类所在的package在磁盘上的绝对路径
        String packageName = "C:\\sohuWork\\workspace\\selfLearn\\JavaLearning\\src\\mysqllearn\\entity\\op";
        //生成sql的文件夹
        String filePath = "C:\\lfj";
        //项目中实体类的路径
        String prefix = "mysqllearn.entity.audit";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = new ArrayList<>();//getAllClasses(packageName);
        list.add(className);
        for (String str : list) {
            className = prefix + "." + str;
            String sql = generateSql(targetClassName, className, filePath);
            sqls.append(sql);
            System.out.println("sql=" + sql);
        }

        //StringToSql(sqls.toString(), filePath + ".sql");
    }

    /**
     * 根据实体类生成建表语句
     *
     * @param className 全类名
     * @param filePath  磁盘路径
     * @return
     */
    public static String generateSql(String tableName, String className, String filePath) {
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            for (int i=0; i<fields.length; i++) {
                Field f = fields[i];
                System.out.println(f.getType().getName());
                String typeName = f.getType().getName();
                if (f.getName().equals("serialVersionUID")) {
                    continue;
                }
                column.append(" \n `" + getStandardFields(f.getName()) + "`" + " " + map.get(typeName));
                if (i != (fields.length - 1)) {
                    column.append(",");
                }
            }
            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `" + tableName + "`; ")
                    .append(" \n CREATE external TABLE `" + tableName + "`  (")
                    .append(column)
                    .append(" \n ) PARTITIONED BY (                                                  \n" +
                            "   `dt` string COMMENT '')                                         \n" +
                            " ROW FORMAT SERDE                                                  \n" +
                            "   'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'            \n" +
                            " WITH SERDEPROPERTIES (                                            \n" +
                            "   'field.delim'='\\u0001',                                         \n" +
                            "   'serialization.format'='\\u0001')                                \n" +
                            " STORED AS INPUTFORMAT                                             \n" +
                            "   'org.apache.hadoop.mapred.TextInputFormat'                      \n" +
                            " OUTPUTFORMAT                                                      \n" +
                            "   'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'\n");
            sql.append("LOCATION                                                          \n" +
                    "   'hdfs://dc1/user/msnscrd/hive/warehouse/msnscrd/" + tableName + "'");
            return sql.toString();
        } catch (ClassNotFoundException e) {
            logger.info("该类未找到！");
            return null;
        }

    }

    /**
     * 转换为标准等sql字段 例如 adminUser → admin_user
     *
     * @param str 转换为字符串的字段名
     * @return
     */
    public static String getStandardFields(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i != 0 && (c >= 'A' && c <= 'Z')) {
                sb.append("_");
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 获取包下面等所有实体类名称，类似于获取 XXX.java
     *
     * @param packageName 全类名
     * @return
     */
    public static List<String> getAllClasses(String packageName) {
        List<String> classList = new ArrayList();
        String className = "";
        File f = new File(packageName);
        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            // 遍历实体类下面等所有.java文件 获取其类名
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        } else {
            logger.info("包路径未找到！");
            return null;
        }
    }

    /**
     * 将生成等String字符串 写进sql文件
     *
     * @param str  String字符串
     * @param path sql文件路径路径
     */
    public static void StringToSql(String str, String path) {
        if (format < 0) {
            str = str.toLowerCase();
        } else {
            str = str.toUpperCase();
        }
        System.out.println(str);
        byte[] sourceByte = str.getBytes();
        FileOutputStream os = null;
        if (null != sourceByte) {
            try {
                //文件路径（路径+文件名）
                File file = new File(path);
                //文件不存在则创建文件，先创建目录
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                //文件输出流用于将数据写入文件
                os = new FileOutputStream(file);
                os.write(sourceByte);
                os.flush();
                System.out.println("生成成功!!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭文件输出流
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

