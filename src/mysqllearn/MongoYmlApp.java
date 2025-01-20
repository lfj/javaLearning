package mysqllearn;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mysqllearn.SqlGenerator.getStandardFields;

public class MongoYmlApp {
    public static void main(String[] args) throws ClassNotFoundException {
        Boolean dbSharding = false;
        String dbName = "x_record";
        String dbRegex = "";

        Boolean tableSharding = true;
        String tbName = "disposal_user_record_";
        String tableRegex = "^disposal_user_record_\\d+_\\d+$";
        String dtByColumn = "operateTime";
        String targetTable = "ods_audit_disposal_user_record_delta_test";
        String className = "mysqllearn.entity.audit.DisposalUserRecordMGD";
        String profile = "test";

        Map<String, Object> map = new HashMap<>();
        map.put("dt-by-column", dtByColumn);
        map.put("db-name", dbName);
        if (dbSharding) {
            map.put("db-regex", dbRegex);
            map.put("db-sharding", true);
        }
        map.put("table-name", tbName);
        if (tableSharding) {
            map.put("table-regex", tableRegex);
            map.put("table-sharding", true);
        }
        map.put("target-table", targetTable);
        List<String> fieldNameList = new ArrayList<>();
        Map<String, Object> fieldNameMap = new HashMap<>();
        Map<String, Object> fieldTypeMap = new HashMap<>();

        Class<?> clz = Class.forName(className);
        Field[] fields = clz.getDeclaredFields();
        for (Field f: fields) {
            fieldNameList.add(f.getName());
            fieldNameMap.put(f.getName(), getStandardFields(f.getName()).toLowerCase());
            fieldTypeMap.put(f.getName(), f.getType().getName());
        }
        map.put("field-name-list", fieldNameList);
        map.put("field-name-map", fieldNameMap);
        map.put("field-type-map", fieldTypeMap);

        Map<String, Object> totalMap = new HashMap<>();
        Map<String, Object> shakeMap = new HashMap<>();
        Map<String, Object> convertMap = new HashMap<>();
        Map<String, Object> tableInfoMap = new HashMap<>();

        tableInfoMap.put("\"[" + dbName + "." + tbName + "]\"", map);
        convertMap.put("table-info-map", tableInfoMap);
        shakeMap.put("msg-converter", convertMap);
        totalMap.put("shake", shakeMap);
        String fileName = "C://lfj/application-" + profile + "-"
                + tbName.replaceAll("_", "-") + ".yml";
        dumpYaml(totalMap, fileName);
    }

    public static void dumpYaml(Map map, String outPath) {
        try {
            //初始化Yaml解析器
            Yaml yaml = new Yaml();
            String result = yaml.dumpAsMap(map);
            System.out.println(result);
            File newFile = new File(outPath);
            PrintWriter writer = new PrintWriter(newFile);
            writer.print(result);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
