package com.llm.llm_knowledge.service;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Service
public class HBaseService {

    @Resource
    private Connection hbaseConnection;

    /**
     * 获取指定表的指定行、列族和列的值
     *
     * @param tableName
     * @param rowKey
     * @param family
     * @param column
     * @return Map<String, Object> 包含表名、行键和数据列表
     */
    public Object getValue(String tableName, String rowKey, String family, String column) {
        try (Table table = hbaseConnection.getTable(TableName.valueOf(tableName))) {
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(family), Bytes.toBytes(column));
            Result result = table.get(get);
            table.close();
            return resultToMap(result, tableName);
        } catch (IOException e) {
            return Map.of("error", e.getMessage());
        }
    }

    /**
     * 将 Result 转换为 Map，用于返回查询结果
     *
     * @param result    Result 对象
     * @param tableName 表名
     * @return Map 对象
     */
    private Map<String, Object> resultToMap(Result result, String tableName) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, String>> dataList = new ArrayList<>();

        for (Cell cell : result.rawCells()) {
            Map<String, String> cellMap = new LinkedHashMap<>();
            cellMap.put("family", Bytes.toString(CellUtil.cloneFamily(cell)));
            cellMap.put("column", Bytes.toString(CellUtil.cloneQualifier(cell)));
            cellMap.put("value", Bytes.toString(CellUtil.cloneValue(cell)));
            dataList.add(cellMap);
        }

        response.put("table", tableName);
        response.put("rowKey", Bytes.toString(result.getRow()));
        response.put("data", dataList);
        return response;
    }

    /**
     * 扫描指定表，返回所有行
     *
     * @param tableName
     * @return 全表数据
     */
    public Map<String, Object> scanTable(String tableName) throws IOException {
        TableName tName = TableName.valueOf(tableName);
        Table table = hbaseConnection.getTable(tName);

        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);

        List<Result> resultList = new ArrayList<>();
        for (Result result : scanner) {
            resultList.add(result);
        }

        table.close();
        return formatResultsToFlatMap(resultList, tableName);
    }

    /**
     * 将多个 Result 扁平化输出，统一格式为：
     * {
     *   "table": "tableName",
     *   "family": "familyName",
     *   "rows": [
     *     {"rowKey": "...", "col1": "...", "col2": "..."},
     *     ...
     *   ]
     * }
     */
    private Map<String, Object> formatResultsToFlatMap(List<Result> results, String tableName) {
        Map<String, Object> response = new LinkedHashMap<>();// 有序 Map
        List<Map<String, String>> rowList = new ArrayList<>();
        String familyName = "";

        for (Result result : results) {
            Map<String, String> rowMap = new LinkedHashMap<>();
            rowMap.put("rowKey", Bytes.toString(result.getRow()));

            for (Cell cell : result.rawCells()) {
                // 只记录第一个 cell 的 family（假设全表统一）
                if (familyName.isEmpty()) {
                    familyName = Bytes.toString(CellUtil.cloneFamily(cell));
                }

                String column = Bytes.toString(CellUtil.cloneQualifier(cell));
                String value = Bytes.toString(CellUtil.cloneValue(cell));
                rowMap.put(column, value);
            }

            rowList.add(rowMap);
        }
        System.out.println("tableName:" + tableName);
        response.put("table", tableName);
        response.put("family", familyName);
        response.put("rows", rowList);
        return response;
    }
}
