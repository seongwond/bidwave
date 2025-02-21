package com.bidwave.service;

import com.bidwave.dao.TestItemDao;
import com.bidwave.dto.TestItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestItemService {
    private final TestItemDao testItemDao;

    @Autowired
    public TestItemService(TestItemDao testItemDao) {
        this.testItemDao = testItemDao;
    }

    public List<TestItem> getAllItems() {
        return testItemDao.getAllItems();
    }
}
