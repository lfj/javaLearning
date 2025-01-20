package mysqllearn;

import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mysqllearn.SqlGenerator.getStandardFields;

public class CanalYmlApp {
    public static void main(String[] args) throws ClassNotFoundException {
        Boolean dbSharding = false;
        String dbRegex = "";
        String dbName = "op_test";

        Boolean tableSharding = false;
        String tableRegex = "";
        String tbName = "account_blacklist";

        String dtByColumn = "update_time";
        String targetTable = "ods_op_account_blacklist";
        String className = "mysqllearn.entity.op.AccountBlackList";
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
            fieldNameList.add(getStandardFields(f.getName()).toLowerCase());
            fieldNameMap.put(getStandardFields(f.getName()).toLowerCase(), getStandardFields(f.getName()).toLowerCase());
            fieldTypeMap.put(getStandardFields(f.getName()).toLowerCase(), f.getType().getName());
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
        /* Export data to a YAML file. */
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
