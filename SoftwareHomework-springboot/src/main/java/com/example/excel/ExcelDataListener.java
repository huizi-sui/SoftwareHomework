package com.example.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * excel读写监听器
 */
@Slf4j
public class ExcelDataListener implements ReadListener<ExcelPojo> {

    private ExcelDao excelDao;
    private static final int BATCH_COUNT = 100;
    // 缓存的数据
    private List<ExcelPojo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    public ExcelDataListener(ExcelDao excelDao) {
        this.excelDao = excelDao;
    }

    // 每一条数据解析都会来调用
    @Override
    public void invoke(ExcelPojo excelPojo, AnalysisContext analysisContext) {
        log.info("解析倒一条数据:{}", JSON.toJSONString(excelPojo));
        cachedDataList.add(excelPojo);
        if (cachedDataList.size() >= BATCH_COUNT) {
            // 存入数据库中
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }
    // 所有数据解析完成后，会调用
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成");
    }

    private void saveData() {
        log.info("开始存储到数据库中");
        excelDao.save(cachedDataList);
        log.info("存储完成");
    }
}
