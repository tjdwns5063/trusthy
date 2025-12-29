package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustLog;

import java.util.ArrayList;
import java.util.List;

public class TrustLogTestRepository implements TrustLogRepository {

    private List<TrustLog> logs = new ArrayList<>();

    @Override
    public TrustLog save(TrustLog trustLog) {
        logs.add(trustLog);

        return trustLog;
    }
}
