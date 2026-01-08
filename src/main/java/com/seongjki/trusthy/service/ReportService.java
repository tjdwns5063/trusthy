package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.*;
import com.seongjki.trusthy.domain.event.ReportAcceptedEvent;
import com.seongjki.trusthy.dto.ReportRequest;
import com.seongjki.trusthy.dto.ReportResponse;
import com.seongjki.trusthy.dto.ReportResultResponse;
import com.seongjki.trusthy.persistence.*;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReportService {

    private final Clock clock;

    private final MemberRepository memberRepository;

    private final ReportRepository reportRepository;

    private final PostRepository postRepository;

    private final CommunityRepository communityRepository;

    private final ReportResultLogRepository reportResultLogRepository;

    private final ApplicationEventPublisher publisher;

    public ReportService(Clock clock, MemberRepository memberRepository, ReportRepository reportRepository,
                         PostRepository postRepository, CommunityRepository communityRepository,
                         ReportResultLogRepository reportResultLogRepository, ApplicationEventPublisher publisher
    ) {
        this.clock = clock;
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
        this.communityRepository = communityRepository;
        this.reportResultLogRepository = reportResultLogRepository;
        this.publisher = publisher;
    }

    public ReportResponse report(ReportRequest reportRequest) {
        Community community = communityRepository.find(reportRequest.communityId()).orElseThrow();
        Member sender = memberRepository.find(reportRequest.senderId()).orElseThrow();
        Post reportedPost = postRepository.findById(reportRequest.reportedPostId()).orElseThrow();
        Member reportedMember = memberRepository.find(reportedPost.getCreatorId()).orElseThrow();

        Report report = reportRepository.save(new Report(
                UUID.randomUUID(),
                reportRequest.category(),
                reportRequest.content(),
                community.getId(),
                sender.getId(),
                reportedMember.getId(),
                reportedPost.getId(),
                LocalDateTime.now(clock)
        ));

        return new ReportResponse(report.getId(),
                report.getCategory().title,
                report.getContent(),
                report.getCommunityId(),
                report.getSenderId(),
                report.getTargetId(),
                report.getTargetPostId(),
                report.getCreatedAt(),
                report.getStatus().name()
        );
    }

}
