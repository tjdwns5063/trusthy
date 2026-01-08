package com.seongjki.trusthy.domain;

public enum ReportCategory {

    // 🔴 자동 제재 가능 (신뢰도 하락 / 즉시 차단 후보)
    BOT_ACTIVITY("봇 / 자동화 활동"),
    MASS_SPAM("과도한 도배 / 반복 게시"),
    ADVERTISEMENT_SPAM("광고 / 홍보 / 링크 도배"),
    PHISHING("피싱 / 사기 링크"),
    MALWARE("악성코드 / 위험 파일"),

    // 🟠 커뮤니티 질서 훼손
    ABUSIVE_LANGUAGE("욕설 / 모욕 / 비하"),
    HATE_SPEECH("혐오 표현 (인종, 성별, 장애 등)"),
    HARASSMENT("집요한 괴롭힘 / 스토킹"),
    THREATENING("협박 / 위협"),

    // 🟡 콘텐츠 품질 문제
    OFF_TOPIC("주제와 무관한 글"),
    LOW_QUALITY("의미없는 글 / 무성의한 내용"),
    MISLEADING_INFO("허위 정보 / 오정보"),

    // 🔵 법적 리스크
    ILLEGAL_CONTENT("불법 정보 / 범죄 조장"),
    COPYRIGHT_INFRINGEMENT("저작권 침해"),

    // ⚪ 기타
    ETC("기타");

    public final String title;

    ReportCategory(String title) {
        this.title = title;
    }

}