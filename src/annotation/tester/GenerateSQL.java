package annotation.tester;

import annotation.meta_info.Constraints;
import annotation.meta_info.DBTable;
import annotation.meta_info.SQLComponent;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.*;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/28/16.
 */
public class GenerateSQL {
    public static void main(String[] args) throws Exception {
        String packagePath = "annotation.space";
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL resource = contextClassLoader.getResource(packagePath.replace(".", "/"));
        if (resource == null) {
            return;
        }
        if (!"file".equals(resource.getProtocol())) {
            return;
        }
        File file = new File(resource.getPath());
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        Map<String, List<String>> sqlListMap = new HashMap<>();
        for (File space : files) {
            String userSpace = "use " + space.getName() + ";";
            ArrayList<String> tableStatments = new ArrayList<>();
            sqlListMap.put(userSpace, tableStatments);
            if (space.isDirectory()) {
                File[] tables = space.listFiles();
                if (tables != null) {
                    for (File table : tables) {
                        String name = table.getName();
                        String className = name.split("\\.")[0];
                        Class<?> tableDescription = contextClassLoader.loadClass(packagePath + "." + space.getName() + "." + className);
                        DBTable tableDesc = tableDescription.getAnnotation(DBTable.class);
                        if (tableDesc != null) {
                            StringBuilder builder = new StringBuilder("CREATE TABLE " + tableDesc.name() + " (");
                            Field[] declaredFields = tableDescription.getDeclaredFields();
                            if (declaredFields != null) {
                                for (Field field : declaredFields) {
                                    Annotation[] annotations = field.getDeclaredAnnotations();
                                    if (annotations != null) {
                                        for (Annotation fieldAnno : annotations) {
                                            SQLComponent SQLComponent = null;
                                            if ((SQLComponent = fieldAnno.annotationType().getAnnotation(SQLComponent.class)) != null) {
                                                InvocationHandler invocationHandler = Proxy.getInvocationHandler(fieldAnno);
                                                Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
                                                memberValues.setAccessible(true);
                                                Map<String, Object> fieldAnnoAttrMap = (Map<String, Object>) memberValues.get(invocationHandler);
                                                if (fieldAnnoAttrMap != null) {
                                                    char[] chars = field.getName().toCharArray();
                                                    String nama = "";
                                                    for (char x : chars) {
                                                        if (x >= 'A' && x <= 'Z') {
                                                            nama += "_" + (char) (x + 32);
                                                            continue;
                                                        }
                                                        nama += x;
                                                    }
                                                    builder.append(" ").append(nama).append(" ");
                                                    builder.append(" ").append(SQLComponent.value()).append("(");
                                                    builder.append(" ").append(fieldAnnoAttrMap.get("length")).append(") ");
                                                    Constraints con = (Constraints) fieldAnnoAttrMap.get("constraints");
                                                    if (con.nullAble()) {
                                                        if (fieldAnnoAttrMap.get("defaultValue") != null) {
                                                            builder.append(" DEFAULT '" + fieldAnnoAttrMap.get("defaultValue") + "' ");
                                                        } else {
                                                            builder.append(" DEFAULT NULL ");
                                                        }
                                                    } else {
                                                        builder.append(" NOT NULL ");
                                                    }
                                                    if (con.autoIncrement()) {
                                                        builder.append(" AUTO_INCREMENT ");
                                                    }
                                                    if (con.primaryKey()) {
                                                        builder.append(" PRIMARY KEY ");
                                                    }
                                                    if (con.unique()) {
                                                        if (!con.primaryKey()) {
                                                            builder.append(" UNIQUE ");
                                                        }
                                                    }
                                                    builder.append(" ,");
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            String s = builder.toString();
                            s = s.substring(0, s.lastIndexOf(",")) + ")";
                            tableStatments.add(s);
                        }
                    }
                }
            }
        }
        Set<Map.Entry<String, List<String>>> entries = sqlListMap.entrySet();
        for (Map.Entry<String, List<String>> x : entries) {
            System.out.println(x.getKey() + "" + x.getValue().stream().reduce("", (res, str) -> res + str + ";", (str1, str2) -> str1 + str2));
        }
    }

}