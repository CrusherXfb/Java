package org.example;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.lang.reflect.Array;
import java.util.*;

public class DumpUtils {

    public static void dump(Object... objects) {
        printObjects(objects, false);
    }

    public static void dd(Object... objects) {
        printObjects(objects, true);
        System.exit(0);
    }

    private static void printObjects(Object[] objects, boolean exitAfter) {
        System.out.println("===== DUMP =====");
        for (Object obj : objects) {
            if (obj == null) {
                printNull();
            } else if (obj instanceof ResultSet) {
                printResultSet((ResultSet) obj);
            } else if (obj.getClass().isArray()) {
                printArray(obj);
            } else if (obj instanceof Collection) {
                printCollection((Collection<?>) obj);
            } else if (obj instanceof Map) {
                printMap((Map<?, ?>) obj);
            } else {
                printSimpleObject(obj);
            }
            System.out.println();
        }
        System.out.println("===============");

        if (exitAfter) {
            System.exit(0);
        }
    }

    private static void printResultSet(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            int[] columnWidths = new int[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnWidths[i-1] = Math.max(metaData.getColumnName(i).length(), 15);
            }

            printLine(columnWidths);
            System.out.print("|");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf(" %-" + columnWidths[i-1] + "s |", metaData.getColumnName(i));
            }
            System.out.println();
            printLine(columnWidths);

            int rowCount = 0;
            while (rs.next()) {
                System.out.print("|");
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    String strValue = (value == null) ? "NULL" : value.toString();
                    System.out.printf(" %-" + columnWidths[i-1] + "s |", strValue);
                }
                System.out.println();
                rowCount++;
            }

            printLine(columnWidths);
            System.out.println("Total rows: " + rowCount);

        } catch (SQLException e) {
            System.out.println("Error printing ResultSet: " + e.getMessage());
        }
    }

    private static void printArray(Object array) {
        System.out.println("Array[" + Array.getLength(array) + "]:");
        for (int i = 0; i < Array.getLength(array); i++) {
            System.out.println("  [" + i + "] = " + Array.get(array, i));
        }
    }

    private static void printCollection(Collection<?> collection) {
        System.out.println(collection.getClass().getSimpleName() + "[" + collection.size() + "]:");
        int index = 0;
        for (Object item : collection) {
            System.out.println("  [" + index++ + "] = " + item);
        }
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println(map.getClass().getSimpleName() + "[" + map.size() + "]:");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " => " + entry.getValue());
        }
    }

    private static void printSimpleObject(Object obj) {
        System.out.println(obj.getClass().getName() + ": " + obj);
    }

    private static void printNull() {
        System.out.println("null");
    }

    private static void printLine(int[] columnWidths) {
        System.out.print("+");
        for (int width : columnWidths) {
            System.out.print("-".repeat(width + 2) + "+");
        }
        System.out.println();
    }

}