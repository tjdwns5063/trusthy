package com.seongjki.trusthy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Community {

    private long id;

    private String name;

    private int capacity;

    private List<Member> members;

    private CommunityGrade grade;

    private static final int MIN_CAPACITY = 5;

    public Community(long id, String name, int capacity) {
        if (capacity < MIN_CAPACITY) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.members = new ArrayList<>();
        this.grade = CommunityGrade.MEDIUM;
    }

    public Community(long id, String name, int capacity, List<Member> members, CommunityGrade grade) {
        if (capacity < MIN_CAPACITY) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.members = members;
        this.grade = grade;
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


