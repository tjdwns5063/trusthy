package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustLog;

public interface TrustLogRepository {

    TrustLog save(TrustLog trustLog);

}
