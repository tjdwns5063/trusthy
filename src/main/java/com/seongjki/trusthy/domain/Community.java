package com.seongjki.trusthy.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Community {

    private Long id;

    private String name;

    private int capacity;

    private List<Member> members;

    private CommunityGrade grade;

    private static final int MIN_CAPACITY = 5;

    public Community(String name, int capacity) {
        if (capacity < MIN_CAPACITY) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.capacity = capacity;
        this.members = new ArrayList<>();
        this.grade = CommunityGrade.MEDIUM;
    }

    public boolean isExceedCapacity() {
        return members.size() >= capacity;
    }

    public enum CommunityGrade {
        HIGH,
        MEDIUM,
        LOW,
    }

    public void enter(Member member, CommunityPolicy policy) {
        policy.validateEnter(this, member);

        members.add(member);
    }

    public boolean contains(Member member) {
        return members.contains(member);
    }

    public boolean hasNickname(Member member) {
        return members.stream()
                .anyMatch(m -> m.hasSameNickname(member));
    }

    public int getSize() {
        return members.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return id == community.id && capacity == community.capacity && Objects.equals(name, community.name) &&  grade == community.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, grade);
    }

}


