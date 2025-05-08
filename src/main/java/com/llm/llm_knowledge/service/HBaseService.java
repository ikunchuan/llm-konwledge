package com.llm.llm_knowledge.service;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HBaseService {

    @Resource
    private Connection hbaseConnection;

//    public void putData(String tableName, String rowKey, String family, String qualifier, String value) throws IOException {
//        Table table = hbaseConnection.getTable(TableName.valueOf(tableName));
//        Put put = new Put(Bytes.toBytes(rowKey));
//        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(value));
//        table.put(put);
//        table.close();
//    }

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
     * 扫描指定表，返回所有行
     *
     * @param tableName
     * @return 全表数据
     */
    public List<Map<String, Object>> scanTable(String tableName) throws IOException {
        List<Map<String, Object>> results = new ArrayList<>();
        TableName tName = TableName.valueOf(tableName);
        Table table = hbaseConnection.getTable(tName);

        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);

        for (Result result : scanner) {
            Map<String, Object> formattedResult = resultToMap(result, tableName);
            results.add(formattedResult);
        }
        table.close();

        return results;
    }


    /**
     * 将 Result 转换为 Map，用于返回查询结果
     *
     * @param result    Result 对象
     * @param tableName 表名
     * @return Map 对象
     */
    private Map<String, Object> resultToMap(Result result, String tableName) {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, String>> dataList = new ArrayList<>();

        for (Cell cell : result.rawCells()) {
            Map<String, String> cellMap = new HashMap<>();
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

//    public void deleteData(String tableName, String rowKey) throws IOException {
//        Table table = hbaseConnection.getTable(TableName.valueOf(tableName));
//        Delete delete = new Delete(Bytes.toBytes(rowKey));
//        table.delete(delete);
//        table.close();
//    }

}
